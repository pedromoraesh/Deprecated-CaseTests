package br.ufms.facom.model;

public class Enumm extends Entity {
	
	private String modifier;
	private int containerID;
	
	public int getId() {
		return super.getId();
	}
	public void setId(int id) {
		super.setId(id);
	}
	public String getName() {
		return super.getName();
	}
	public void setName(String name) {
		super.setName(name);
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public int getContainerID() {
		return containerID;
	}
	public void setContainerID(int containerID) {
		this.containerID = containerID;
	}
	
}
