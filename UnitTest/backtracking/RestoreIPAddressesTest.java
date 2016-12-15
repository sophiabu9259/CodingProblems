package backtracking;

import java.util.List;

import org.junit.Test;

public class RestoreIPAddressesTest {
	
	RestoreIPAddresses myRA = new RestoreIPAddresses();

	@Test
	public void testRestoreIPAddress() {
		String s = "010010";
		List<String> ret = myRA.restoreIPAddress(s);
		for (String e : ret) {
			System.out.println(e);
		}
	}

}
