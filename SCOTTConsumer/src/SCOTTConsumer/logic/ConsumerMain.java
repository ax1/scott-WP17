package SCOTTConsumer.logic;

import java.io.IOException;
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
			PresenceSensor sensor = (PresenceSensor) concept;
			System.out.println(sensor.getDeviceID() + " ->  harvester " + sensor.getPresence().getDataID());
		};

		Consumer consumer = SmoolKP.getConsumer();
		consumer.subscribeToPresenceSensor(new PresenceSensorSubscription(observer), null);
		Thread.sleep(Long.MAX_VALUE);
	}

	public static void main(String[] args) throws Exception {
		// Logger.setDebugging(true);
		// Logger.setDebugLevel(4);
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