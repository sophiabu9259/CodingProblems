package SeriesProblems;

public class EditDistanceSeries {
	public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;
        //now we guarantee input Strings are valid and len diff = 1 or 0
        //substitution
        if (s.length() == t.length()) {
            boolean found = false;
            for (int i = 0; i < s.length(); ++i) {
                if (!found) {
                    if (s.charAt(i) != t.charAt(i)) {
                        found = true;
                    }
                } else {
                    if (s.charAt(i) != t.charAt(i)) {
                        return false;
                    }
                }
            }
            return found;
        } else { //insertion or deletion
            String longer = s.length() > t.length()? s : t;
            String shorter = longer == s? t : s;
            boolean found = false;
            for (int i = 0; i < shorter.length(); ++i) {
                if (shorter.charAt(i) != longer.charAt(i) && found == false) {
                    found = true;
                } 
                
                if (found && shorter.charAt(i) != longer.charAt(i+1)) return false;
            }
            
        }
        
        return true;
    }
}
