package word_xxxx_series;

import java.util.HashMap;
import java.util.Map;

public class WordPattern{
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        if (pattern == null || str == null) return pattern == str;
        String[] words = pattern.split (" ");
        char[] arr = str.toCharArray();
        for (int i = 0; i < words.length; ++i) {
            if (!map.containsKey(arr[i])) {
                map.put (arr[i], words[i]);
            }
            
            if (! map.get (arr[i]).equals (words[i]) ) {
                return false;
            }
        }
        
        return true;
    }
}
