package lcArraysLinkedListsStrings;

import static org.junit.Assert.*;
import lcArraysLinkedListsStrings.GasStattion;

import org.junit.Test;

public class GasStationTest {

	@Test
	public void test() {
		GasStattion myGS = new GasStattion();
		int[] gas = {1,2,3,4};
		int[] cost = {3,3,2,1};
		assertEquals(2,myGS.canCompleteCircuit(gas, cost));
	}

}
