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

	public ConsumerMain() throws Exception {
		final String name = "SCOTTConsumer_" + Long.toString(System.nanoTime());
		SmoolKP.setKPName(name);
		// -------------connect to SIB---------------------------------------------
		SmoolKP.connect("sib1", "smool.tecnalia.com", 80);

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
					try (Socket socket = new Socket("localhost", 4445)) {
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
		while (true) {
			try {
				new ConsumerMain();
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