package lcArraysLinkedListsStrings;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        /**From back to the start add 1, if over 10 then minus 10 and activate the carrier
		* Notice if the most significant number is 9, reorder the array.
		*/
		
		//Check input
		int[] result = {};
		if(digits.length == 0) return result;
		//For loop to get the add1 result for each element
		int carrier = 1;
		for(int i = digits.length-1; i >= 0; i--){
			digits[i] += carrier; //only first loop should add one, other loops we not sure
			if(digits[i]>=10){
				digits[i] -= 10;
				carrier = 1;
			} else carrier = 0; // remember to flush the carrier in case there is no add 1
		}
		
		if(carrier == 1){
			result = new int[digits.length+1];
			for(int i = 0; i < digits.length; i++){
				result[i+1] = digits[i];
			}
			result[0] = 1;
		} else result = digits;
		
		return result;
    }
}
