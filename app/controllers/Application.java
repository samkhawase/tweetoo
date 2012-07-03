package controllers;

import models.Group;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import service.MongoConnectionFactory;
import service.RenderTweetResults;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.mapping.Mapper;
import com.google.code.morphia.query.UpdateOperations;

public class Application extends Controller {

	public static Result index() throws Exception {

		Logger.info("attempting to call renderTweet");
		RenderTweetResults.getResult();
		return ok("Ok.");
		
/*		Datastore ds = MongoConnectionFactory.getInstance().getDs();

		Logger.info("ds connected");
		Group me = new Group();
		me.groupName = "test group";
		ds.save(me);
		Group e3 = ds.find(Group.class).get();
		UpdateOperations<Group> ops = ds.createUpdateOperations(Group.class)
				.set("groupName", "hello world");

		ds.update(
				ds.createQuery(Group.class).field(Mapper.ID_KEY).equal(e3.id),
				ops);
		String result = "";
		for (Group me2 : ds.find(Group.class)) {
			System.out.println(me2.groupName);
			result = me2.groupName;
		}
		return ok(result);
*/
	}

}