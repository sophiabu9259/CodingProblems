package lcArraysLinkedListsStrings;

public class Candy {
	/**
	 * There are N children standing in a line. Each child is assigned a rating value.
	 * You are giving candies to these children subjected to the following requirements:
	 * 	- Each child must have at least one candy.
	 * 	- Children with a higher rating get more candies than their neighbors.
	 * What is the minimum candies you must give?
	 */
	public int candy(int[] ratings){
		 /**
		  * Every node should only compare to its neighbors, and only need to be 1 over his 
		  * neighbor even rating is over by 10. So from left to right, make all nodes satisfy
		  * one more than his left neighbor if the neighbor rating is lower. And right to left
		  * to make them satisfy one more than right neighbor.
		  */
		int len = ratings.length;
		int[] candies = new int[len];
		candies[0] = 1; //Each child must have at least one.
		
		for (int i = 1; i < len; i++){
			if(ratings[i] > ratings[i-1])
				candies[i] = candies[i-1]+1;
			else candies[i] = 1;
		}
		
		for (int i = len-2; i >= 0; i--){
			if(ratings[i] > ratings[i+1]){
				candies[i] = Integer.max(candies[i],candies[i+1]+1);
			}
		}
		
		int result = 0;
		for(int i:candies)
			result += i;
		return result;
	}
}
