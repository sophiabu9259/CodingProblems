package lcArraysLinkedListsStrings;

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
        if (haystack == null) {
        	return -1;
        }
        
        if (needle == null) {
        	return -1;
        }
        
        if (needle.length() > haystack.length()) {
        	return -1;
        }
        
        if (needle.length() == 0 && haystack.length() == 0) {
        	return 0;
        }
        
        for (int i = 0; i < haystack.length(); i++) {
        	int m = i;
        	
        	//match substring
        	for (int j = 0; j < needle.length(); j++) {
        		if (haystack.charAt(m) != needle.charAt(j)) {
        			break;
        		}
        		
        		if (j == needle.length()-1) {
        			return i;
        		}
        		
        		m++;
        		if (m >= haystack.length()) {
        			return -1;
        		}
        	}
        }
        
        return -1;
    }
}
