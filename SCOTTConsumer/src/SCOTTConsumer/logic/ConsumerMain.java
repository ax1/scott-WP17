package SCOTTConsumer.logic;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Observer;

import org.smool.kpi.model.exception.KPIModelException;

import SCOTTConsumer.api.Consumer;
import SCOTTConsumer.api.PresenceSensorSubscription;
import SCOTTConsumer.api.SmoolKP;
import SCOTTConsumer.model.smoolcore.impl.PresenceSensor;

public class ConsumerMain {

	public ConsumerMain(String sib, String addr, int port) throws Exception {
		final String name = "SCOTTConsumer_" + Long.toString(System.nanoTime());
		SmoolKP.setKPName(name);
		// -------------connect to SIB---------------------------------------------
		SmoolKP.connect(sib, addr, port);

		// --------------add custom observer to subscription-------
		Observer observer = (o, concept) -> {
			try {
				// ---ARF TEMPORARY----
				// SmoolKP.lastTimestamp = System.currentTimeMillis();
				// ---END TEMPORARY---
				PresenceSensor sensor = (PresenceSensor) concept;
				System.out.println(sensor.getDeviceID() + " ->  harvester " + sensor.getPresence().getDataID() + " at "
						+ (new Date()).toString());
				String harvesterID = sensor.getPresence().getDataID();
				boolean match = harvesterID.matches("\\d+");
				if (match) {
					try (Socket socket = new Socket("127.0.0.1", 4445)) {
						System.out.println("Consumer: sending harvesterID to local socket. " + harvesterID);
						OutputStream output = socket.getOutputStream();
						output.write(harvesterID.getBytes());
					} catch (Exception e) {
						throw e;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		Consumer consumer = SmoolKP.getConsumer();
		consumer.subscribeToPresenceSensor(new PresenceSensorSubscription(observer), null);
		// Thread.sleep(Long.MAX_VALUE);
		SmoolKP.watchdog();
	}

	public static void main(String[] args) throws Exception {
//		Logger.setDebugging(true);
//		Logger.setDebugLevel(4);

		String sib = args.length > 0 ? args[0] : "sib1";
		String addr = args.length > 1 ? args[1] : "smool.tecnalia.com";
		int port = args.length > 2 ? Integer.valueOf(args[2]) : 80;

		while (true) {
			try {
				new ConsumerMain(sib, addr, port);
			} catch (KPIModelException | IOException e) {
				e.printStackTrace();
				Thread.sleep(10000);
				System.out.println("RECONNECTING");
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}