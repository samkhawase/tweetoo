package models;

import java.util.Date;
import org.bson.types.ObjectId;
import play.data.format.Formats;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class JobPosting {

	@Id
	public ObjectId id;

	public Long tweetId;

	public String screenName;

	public String location;

	public String text;

	@Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date postedDate;

	
}
