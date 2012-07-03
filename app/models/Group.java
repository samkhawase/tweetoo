package models;

import com.google.code.morphia.annotations.*;

import org.bson.types.ObjectId;

@Entity
public class Group {

	@Id
	public ObjectId id;
	public String groupName;
}