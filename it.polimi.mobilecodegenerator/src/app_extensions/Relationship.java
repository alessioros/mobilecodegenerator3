package app_extensions;

public class Relationship {
	
	private String name;
	private String destination;
	
	public Relationship(String name, String destination){
		this.name = name;
		this.destination = destination;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDestination(){
		return this.destination;
	}
	
	public void setDestination(String destination){
		this.destination = destination;
	}
}
