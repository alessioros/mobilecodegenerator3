package app_extensions;

import java.util.ArrayList;

public class Entity {
	
	private String name;
	private ArrayList<Relationship> entityRelationships;
	private ArrayList<Attribute> entityAttributes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Relationship> getEntityRelationships() {
		return entityRelationships;
	}
	public void setEntityRelationships(ArrayList<Relationship> entityRelationships) {
		this.entityRelationships = entityRelationships;
	}
	public ArrayList<Attribute> getEntityAttributes() {
		return entityAttributes;
	}
	public void setEntityAttributes(ArrayList<Attribute> entityAttributes) {
		this.entityAttributes = entityAttributes;
	}
}
