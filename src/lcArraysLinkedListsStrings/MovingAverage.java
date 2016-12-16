package lcArraysLinkedListsStrings;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Also you can use an array as queue. remember pointer  = (pointer + 1) % len
 * @author xuechao
 *
 */
public class MovingAverage {
    
    Queue<Integer> q;
    int size;
    double cur;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.size = size;
        this.cur = 0.;
    }
    
    public double next(int val) {
        this.q.offer(val);
        this.cur += val;
        if (q.size() > this.size) this.cur -= q.poll();
        return this.cur/this.q.size();
    }
}