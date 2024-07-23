package com.wipro.model;

import java.io.Serializable;

	public class CustomObject implements Serializable {
	    private static final long serialVersionUID = 1L; // Serial version UID

	    private String name;
	    private int age;

	    public CustomObject(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    @Override
	    public String toString() {
	        return "CustomObject{" +
	                "name='" + name + '\'' +
	                ", age=" + age +
	                '}';
	    }
	}

