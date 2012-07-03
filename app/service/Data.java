package service;

import java.util.Map;

public class Data {

	String id;
	String name;
	Map<String, String> records;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getRecords() {
		return records;
	}
	public void setRecords(Map<String, String> records) {
		this.records = records;
	}
	
	@Override
	public String toString() {
		return "Data [id=" + id + ", name=" + name + ", records=" + records
				+ "]";
	}
	
	
}
