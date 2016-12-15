package lcArraysLinkedListsStrings;

public class GasStattion {
	/**
	 * There are N gas stations along a circular route, 
	 * where the amount of gas at station i is gas[i].
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel 
	 * from station i to its next station (i+1). You begin the journey 
	 * with an empty tank at one of the gas stations.
	 * Return the starting gas station's index if you can travel around the circuit once, 
	 * otherwise return -1
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         * Passing a node indicates this node has positive effect on gas sum.
         * So failing to reach a node from some starting node, 
         * all the nodes between would fail, for the starting node would carry
         * most remaining gas. Also to fill this gap, left possible nodes has to remain more
         * than this gap. Thus total has be positive.
         */
		//length check
		if(gas.length != cost.length) return -1;
		if(gas.length == 0) return -1;
		int remaining = 0, sum = 0, firstPossible = 0;
		for (int i = 0; i < gas.length; i++){
			remaining += gas[i] - cost[i];
			sum += gas[i] - cost[i];
			if(remaining < 0) {
				remaining = 0;
				firstPossible = i+1;
			}
		}
		if (sum >= 0) return firstPossible;
		else return -1;
    }
}
