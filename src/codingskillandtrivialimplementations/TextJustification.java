package codingskillandtrivialimplementations;
import java.util.*;
/**
 * use a queue to queue one line. use a counter to count words with its own blank (at least 1).
 * @author Xuechao
 *
 */
public class TextJustification {
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ret = new ArrayList<String>();
        Queue<String> q = new LinkedList<>();
        
        if (words.length == 0 ) {
            return ret;
        }
        
        int lineCounter = 0;
        for (int i = 0; i <= words.length;) {
            String word = i == words.length? null : words[i];
            if (word == null || word.length() +  lineCounter > maxWidth) { // one more space
                //deal with last line, add last line 
                //and prepare this word for a new line
                StringBuilder sb = new StringBuilder();
                if (word == null) {
                    int extraSpace = maxWidth - (lineCounter - 1) ;
                    while (!q.isEmpty()) {
                        sb.append(q.poll());
                        if (!q.isEmpty()) {
                            sb.append(" ");
                        }
                    }
                    while (extraSpace > 0) {
                        sb.append(" ");
                        extraSpace--;
                    }
                    ret.add(sb.toString());
                    break;
                }
                int evenSpace = q.size() == 1? maxWidth - (lineCounter - 1) : ( maxWidth - (lineCounter - 1) )/(q.size() - 1) + 1;
                int extraSpace = q.size() == 1? evenSpace : ( maxWidth - (lineCounter - 1) )%(q.size()-1);
                
                StringBuilder spaces = new StringBuilder();
                while (evenSpace > 0) {
                    spaces.append(" ");
                    evenSpace --;
                }
                
                while (!q.isEmpty() ) {
                    sb.append(q.poll());
                    if (!q.isEmpty() || (q.isEmpty() && extraSpace != 0)) {
                        sb.append(spaces);
                    }
                    
                    if (extraSpace > 0 && !q.isEmpty()) {
                        sb.append(" ");
                        extraSpace--;
                    }
                }
                
                ret.add(sb.toString());
                lineCounter = 0;
      
            } else {
                q.offer (word);
                lineCounter += (word.length() + 1);
                i++;
            }
        }
        
        return ret;
    }
	
	public static void main (String[] args) {
		String[] words = {""};
		List<String> ret = fullJustify (words, 2);
		for (String s : ret) {
			System.out.println(s);
		}
	}
}
