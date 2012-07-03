import java.util.concurrent.TimeUnit;

import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Akka;
import service.Master;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.util.Duration;

public class Global extends GlobalSettings {

	@Override
	public void onStart(Application arg0) {
//		Datastore ds = MongoConnectionFactory.getInstance().getDs();
		Logger.info("Global object.onStart()");
/*
 * 		ActorRef master = Akka.system().actorOf(new Props(Master.class));
	
		Akka.system().scheduler().schedule(
				Duration.create(0, TimeUnit.MILLISECONDS),
				Duration.create(10, TimeUnit.SECONDS),
				master,
				"tick");
		
*/	}

	@Override
	public void onStop(Application arg0) {

	}

}
