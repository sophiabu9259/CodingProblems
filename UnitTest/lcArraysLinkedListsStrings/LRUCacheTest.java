package lcArraysLinkedListsStrings;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lcArraysLinkedListsStrings.LRUCache;

public class LRUCacheTest {
	
	LRUCache myCache = new LRUCache(10);

	@Test
	public void test1() {
		
		myCache.set(1, 1);
		assertEquals ("Fisrt set First Get",1,myCache.get(1));
	}
	
	@Test
	public void test2() {
		myCache.set(1, 2);
		assertEquals ("Updated 1 to 2",2,myCache.get(1));
	}
	
	@Test
	public void test3() {
		for (int i = 2; i <= 11 ; i++) {
			myCache.set(i, i);
		}
		
		myCache.get(2);
		assertEquals ("Inserted 11, latest 2",2,myCache.get(2));
		assertEquals ("1 deleted",-1,myCache.get(1));
		
	}
	

}
