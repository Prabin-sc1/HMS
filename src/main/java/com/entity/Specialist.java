package com.entity;

public class Specialist {
	private int id;
	private String specName;
	
	public Specialist() {
		
	}
	
	public Specialist(int id, String specName) {
		super();
		this.id = id;
		this.specName = specName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

}
