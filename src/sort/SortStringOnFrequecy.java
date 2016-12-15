package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStringOnFrequecy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test1 = "tree";
		String test2 = "aaccaa";
		String test3 = "Bibwbabkbkbsbwbole||||||";
		
		System.out.println(frequencySort(test1));
		System.out.println(frequencySort(test2));
		System.out.println(frequencySort(test3));
		
	}
	
	public static String frequencySort(String s) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 128; ++i) {
            char ch = (char) i;
            list.add(new Node(ch));
        }
        
        StringBuilder ret = new StringBuilder();
        
        for (char e : s.toCharArray()) {
            int index = (int) e;
            list.get(index).num++;
        }
        
        Collections.sort (list, new Comparator<Node>() {
           public int compare (Node o1, Node o2) {
               return o2.num - o1.num;
           } 
        });
        
        for (Node e : list) {
            for (int i = 0; i < e.num; ++i) {
                ret.append(e.ch);
            }
        }
        
        return ret.toString();
        
        
    }
    
    static class Node {
        char ch;
        int num;
        
        Node (char ch) {
            this.ch = ch;
            this.num = 0;
        }
    }

}
