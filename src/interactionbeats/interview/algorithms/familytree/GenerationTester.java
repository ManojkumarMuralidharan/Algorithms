package interactionbeats.interview.algorithms.familytree;

public class GenerationTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person g1=new Person("Jim", "kim");
		g1.addChildren(new Person("Martha","gilbert"));
		g1.addChildren(new Person("Joe","gilbert"));
		g1.Children.get(0).addChildren(new Person("Sally", "timoth"));
		g1.Children.get(0).addChildren(new Person("Andrew", "timoth"));
		g1.Children.get(0).addChildren(new Person("Stewart", "timoth"));
		
		g1.Children.get(1).addChildren(new Person("Kimmel", "timoth"));
		g1.Children.get(1).addChildren(new Person("Walsh", "timoth"));
		g1.Children.get(0).Children.get(0).addChildren(new Person("Peter","retro"));
		
		g1.Children.get(0).Children.get(0).Children.get(0).addChildren(new Person("Chris", "griffin"));
		g1.Children.get(0).Children.get(0).Children.get(0).addChildren(new Person("Stewe", "griffin"));
		g1.Children.get(0).Children.get(0).Children.get(0).addChildren(new Person("Meg", "griffin"));
		
		FamilyGenerator generator=new FamilyGenerator();
		generator.StartGenerator(g1);
		
	}

}
