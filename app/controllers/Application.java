package controllers;

import models.MainScreen;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

	public static Result index() throws Exception {

//		Logger.info("attempting to call renderTweet");
//		RenderTweetResults.getResult();
		return ok(index.render(form(MainScreen.class)));
		
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
	
	public static Result getResults(){
		Form<MainScreen> mainForm = form(MainScreen.class).bindFromRequest();
		
		if(mainForm.hasErrors()){
			return badRequest(index.render(mainForm));
		} else {
			MainScreen data = mainForm.get();
			return ok(
					"placeholder text, result.scala.html is coming up"
					);
		}
	}

}