package bfs;
import java.util.*;

public class EvaluateDivision_399_M {
	 class Solution {
		 /**
		  * 1.Avoid loops when bfs or dfs. Use a set to record visits.
		  * 2.remember to build double direction links.
		  * @param equations
		  * @param values
		  * @param queries
		  * @return
		  */
	    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
	        Map<String, Node> totalMap = new HashMap<>();
	        
	        for (int i = 0; i < equations.length; ++i) {
	            String p = equations[i][0];
	            String q = equations[i][1];
	            Node pp = find (totalMap, p);
	            Node qq = find (totalMap, q);
	            
	            pp.addChild(qq, values[i]);
	        }
	        
	        double[] answer = new double[queries.length];
	        
	        for (int i = 0; i < queries.length; ++i) {
	            
	            double temp = query (totalMap, queries[i][0], queries[i][1]);
	            
	            answer[i] = temp;
	        }
	        
	        return answer;
	    }
	    
	    double query (Map<String, Node> map, String p, String q) {
	        if (!map.containsKey(p) || !map.containsKey(q)) return -1.0;
	        Node root = map.get(p);
	        
	        double[] ret = new double[1];
	        ret[0] = - 1.0;
	        Set<String> visited = new HashSet<String>();
	        dfs (root, q, 1.0, ret, visited);
	        return ret[0];
	    }
	    
	    void dfs (Node root, String target, double factor, double[] ret, Set<String> visited) {
	        for (Node c : root.children.keySet()) {
	            if (visited.contains(c.name)) continue;
	            visited.add(c.name);
	            if (c.name.equals(target)) {
	                ret[0] = factor * root.children.get(c);
	            }
	            if (c != root) {
	                dfs(c, target, factor * root.children.get(c), ret, visited);
	            }
	        }
	    }
	    
	    Node find (Map<String, Node> map, String key) {
	        if (!map.containsKey(key)) {
	            map.put(key, new Node(key));
	        }
	        
	        return map.get(key);
	    }
	    
	    class Node {
	        Map<Node, Double> children;
	        String name;
	        
	        Node (String name) {
	            this.name = name;
	            children = new HashMap<>();
	            children.put (this, 1.0);
	        }
	        
	        void addChild (Node child, double value) {
	            children.put (child, value);
	            child.children.put (this, 1/value);
	        }
	    }
	}
}
