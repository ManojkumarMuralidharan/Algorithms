package interactionbeats.interview.algorithms.familytree;

import java.util.LinkedList;

public class Person {
	String firstname;
	String lastname;
	LinkedList<Person> Children;
	public Person(String firstname,String lastname) {
		// TODO Auto-generated constructor stub
		this.firstname=firstname;
		this.lastname=lastname;
		this.Children=new LinkedList<Person>();
		
	}
	public void addChildren(Person child){
		this.Children.add(child);
	}
	
}
