package lcArraysLinkedListsStrings;

public class StringToInteger {
	public int stringToInteger (String input) {
		if (input == null) {
			return 0;
		}
		char[] inputArray = input.trim().toCharArray();
		int sign = 1;
		int index = 0;
		if (inputArray.length > 0) {
			sign = inputArray[0] == '-'? -1:1;
			index = inputArray[0] == '+' || inputArray[0] == '-' ? 1:0;
		}
		
		int base = 0;
		 while (index < inputArray.length && Character.isDigit(inputArray[index])) {
			int newDigit = inputArray[index] - '0';
			if (sign == 1) {
				boolean baseLargerThanMax = Integer.MAX_VALUE/10 < base;
				boolean baseLessThanMaxButnewDigitTooLarge = Integer.MAX_VALUE/10 == base && newDigit > Integer.MAX_VALUE - Integer.MAX_VALUE/10 * 10;
				if (baseLargerThanMax || baseLessThanMaxButnewDigitTooLarge) {
					return Integer.MAX_VALUE;
				}
			} else {
				boolean NegbaseLargerThanMax = Integer.MAX_VALUE/10 < base;
				boolean NegbaseLessThanMaxButnewDigitTooLarge = Integer.MAX_VALUE/10 == base && newDigit > Integer.MIN_VALUE/10 * 10 - Integer.MIN_VALUE;
				if (NegbaseLargerThanMax || NegbaseLessThanMaxButnewDigitTooLarge) {
					return Integer.MIN_VALUE;
				}
			}	
			base = base * 10 + (inputArray[index] - '0');	
			index++;
		}	
		return base * sign;	
	}
}
