package simpletests;


import org.junit.Test;

public class testRegex {

	@Test
	public void test() {
		System.out.println("print: ");
	}
	
	@Test
	public void test_split() {
		String test = "a/b/c//d";
		for (String e : test.split("/")) {
			System.out.println(e);
		}
	}

}
