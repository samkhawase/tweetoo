package models;

import play.data.validation.Constraints.Required;

public class MainScreen {
	
	@Required public String what;
	
	@Required public String where;
	
}
