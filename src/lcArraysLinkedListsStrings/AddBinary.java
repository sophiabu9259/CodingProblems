package lcArraysLinkedListsStrings;

/**
 * Use builder and append. Then reverse all. Thus avoid hard problem of adding new char when carrier == 1 at the head part.
 * @author Xuechao
 *
 */
public class AddBinary {
	public String addBinary (String a, String b) {
		if (a == null || b == null) {
			return a == null ? b : a;
		}
		
		char[] arrayA = a.toCharArray();
		char[] arrayB = b.toCharArray();
		StringBuilder myStrBuilder = new StringBuilder();
		int len = Math.max(arrayA.length, arrayB.length);
		int index = 0;
		int carrier = 0;
		
		while ( index < len ) {
			int m = 0;
			int n = 0;
			
			if ( index < arrayA.length) {
				m = arrayA[arrayA.length-1-index]-'0';
			} 
			
			if ( index < arrayB.length) {
				n = arrayB[arrayB.length-1-index]-'0';
			}
			
			myStrBuilder.append ( (m + n + carrier) %2 );
			carrier = ( m + n + carrier )/2;
			
			index ++;
		}
		
		if ( carrier == 1 ) {
			myStrBuilder.append(1);
		}
		
		return myStrBuilder.reverse().toString();
	}
}
