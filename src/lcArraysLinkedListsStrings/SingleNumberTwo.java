package lcArraysLinkedListsStrings;

public class SingleNumberTwo {
	/**
	 * Given an array of integers, every element appears three times except for one. Find that single one. 
	 */
	public int singleNumberTwo(int[] nums) {
	
		
	int one = 0;
	int two = 0;
	int mask = 0;
	
	for (int i:nums){
		two |= (one & i);  // one & i will return the bits where both one and i shares,
						   // indicating at this time, i has showed twice. So use |= to
						   // save those bits to two.
		one ^= i;		   // After one & i, if this is the second time i shows up, in one's bits,
		                   // all i's bits will be flushed to 0 by ^=, and all i's bits have been saved to 
		                   // two. If this is the first time, one won't have i's bits, so two will save nothing, and
		                   // one's bits will save i's bits. If this is third time, both one and two will record
		                   // i's bits.
		mask = ~(one & two); // bits shared by one and two will be flushed by '&= 0'. If i showed once or twice, 
		                     // mask bit will be i. 
		one &= mask;       //Flush all bits which has showed 3 times.
		two &= mask;       //Flush all bits which has showed 3 times.
	}
		
	return one;
	}
}
