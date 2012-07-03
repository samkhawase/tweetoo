package service;

import org.joda.time.DateTime;

import play.Logger;
import akka.actor.UntypedActor;

public class Master extends UntypedActor{

	@Override
	public void onReceive(Object arg0) throws Exception {
		Logger.info("master tick: "+ DateTime.now());
	}

	
}
