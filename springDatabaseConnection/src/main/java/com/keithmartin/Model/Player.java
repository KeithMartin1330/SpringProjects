package com.keithmartin.Model;

public class Player {
	private String name;
	private String dateOfBirth;
	private String position;
	
	public Player(String name,String dateOfBirth,String position) {
		this.name=name;
		
		this.dateOfBirth=dateOfBirth;
		this.position=position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", position=" + position + "]";
	}
	

}
