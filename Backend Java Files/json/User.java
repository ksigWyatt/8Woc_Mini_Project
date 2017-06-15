package com.mykong.json;

import java.util.List;

public class User {

	private String name;
	private int age;
	private List<String> messages;

	public void setName(String newName){
		this.name = newName;
	}
	
	public void setAge(int newAge){
		this.age = newAge;
	}
	
	public void setMessages(List<String> newMessages){
		this.messages = newMessages;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public List<String> getMessages(){
		return this.messages;
	}
}
