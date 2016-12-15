package lcArraysLinkedListsStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * The gray code is a binary numeral system where two successive values differ 
 * in only one bit.Given a non-negative integer n representing the total number 
 * of bits in the code, print the sequence of gray code. A gray code sequence 
 * must begin with 0.
 * @author Xuechao
 *
 */
public class GrayCode {
	/**
	 * Solution:
	 * i = 1, 01
	 * 
	 * i = 2,
	 * 0110
	 * 00 01 11 10
	 * 
	 * i = 3,
	 * 00 01 11 10 10 11 01 00
	 * 000 001 011 010 110 111 101 100
	 * 
	 * Every time symmetric it, and first half add 0, last half add 1.
	 * Notice the only duplicate neighour is the middle one. They are same yet one of them
	 * was added 1, while another was added 0.(namely no operation at all)
	 */
	
	// n >> 1, n/2
	// 1 >> n, ?
	// 1 << n, 2^n
	// n << 1, n*2
	
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for(int j = 0; j < n; j++){
        	int highestBit = 1 << j;
        	for(int i = result.size()-1; i >= 0; i --){
        		result.add(highestBit|result.get(i));
        	}
        }
        return result;
    }
	
}
