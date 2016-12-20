package basicstructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * back to start reconstruct. remember the breaking criteria is one node's heap is null or one node has no heap.
 * @author xuechao
 *
 */
public class ReconstructItinerary {
	public List<String> reconstruct (String[][] tickets) {
		//valid tickets
		Map<String, PriorityQueue<String>> graph = new HashMap<>();
		for (String[] ticket : tickets) {
			String start = ticket[0];
			String dest = ticket[1];

			if (!graph.containsKey(start)) {
				graph.put (start, new PriorityQueue<String>());
			}

			graph.get(start).offer (dest);
		}

		List<String> res = new ArrayList<>();
		backtracking (graph, "JFK", res);
		return res;
	}

	private void backtracking (Map<String, PriorityQueue<String>> graph, String node, List<String> res) {
		while (graph.containsKey(node) && !graph.get(node).isEmpty()) {
			String temp = graph.get(node).poll();
			backtracking (graph, temp, res);
		}
		res.add(0, node);
	}
}
