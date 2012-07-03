package service;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/* 
 * A singleton class to return an instance of MongoDB DataSource
 */
public class MongoConnectionFactory {

	private static final MongoConnectionFactory INSTANCE = new MongoConnectionFactory();
	
	private static Datastore ds;
	public static final String dbName = "testDB";
	
	public MongoConnectionFactory() {
		try {
		    Morphia morphia = new Morphia();
		    Mongo mongo = new Mongo("127.0.0.1",27017);
		    ds = morphia.createDatastore(mongo, "tweetoo");
		    ds.ensureIndexes();
		    ds.ensureCaps();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static MongoConnectionFactory getInstance() {
		return INSTANCE;
	}
	
	public Datastore getDs(){
		return ds;
	}
}
