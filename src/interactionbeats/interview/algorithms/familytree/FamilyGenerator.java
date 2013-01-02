package interactionbeats.interview.algorithms.familytree;

import java.util.ArrayList;

public class FamilyGenerator {
	ArrayList<Person> generation_Queue;
	
	public FamilyGenerator() {
		// TODO Auto-generated constructor stub
		generation_Queue= new ArrayList<Person>();
	}
	
	/* Intializes the BFS queue */
	public void InitializeQueue(Person root){
		if(root==null){
			return;
		}else{
			generation_Queue.add(root);
			generation_Queue.add(new Person("dummy", "dummy"));
			
			
		}
		
	}
	/* Family Tree Info generator */
	public void StartGenerator(Person root){
		InitializeQueue(root);
		printGenerationLevel();
	}
	
	/* Performs the BFS traversal */
	public void printGenerationLevel(){
		int generationLevel=1;
		System.out.println("Generation 0:");
		while(generation_Queue.size()>0){
			Person head=generation_Queue.get(0);
			
			
			
			if(head.firstname.equals(new String("dummy"))&&head.lastname.equals(new String("dummy"))){
				if(generation_Queue.size()==1){
					break;
				}
				generation_Queue.remove(0);
				generation_Queue.add(new Person("dummy","dummy"));
				System.out.println("Generation "+generationLevel+":");
				generationLevel++;
				
			}else{
				Person current=generation_Queue.remove(0);
				System.out.println(current.firstname);
				for(Person children: current.Children){
					
					generation_Queue.add(children);
				}
				
				
			}
		}
		
	}

}
