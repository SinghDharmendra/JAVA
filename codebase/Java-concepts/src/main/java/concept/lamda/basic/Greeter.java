package concept.lamda.basic;

/**
 * 
 * @author Dharmendra Singh
 * Lamda expressions are basically for providing support for functional programming in java
 * Before Java 8 Everything has to be object i.e we need to pass a object holding some behaviour.
 * with Lamda expression we can pass behaviour itself rather then passing the object 
 * Return type of lamda expression is an function interface
 * Functional interface :An interface with only one abstract method
 *
 */
public class Greeter {
	private void greet(Greeting greeting) {
		greeting.perform();

	}
	public static void main(String[] args) {
		Greeting lamdaExp=()->System.out.println("Hello World");
		Greeter greeter=new Greeter();
		greeter.greet(lamdaExp);
	}
	
}
