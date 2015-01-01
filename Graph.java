import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.lang.StringBuilder;
import java.util.LinkedList;


public class Graph {

	private Map<Character, Set<Edge>> graph;

	public Graph() {
		graph = new HashMap<Character, Set<Edge>>();
	}

	public void addEdge(char source, char destination, int weight) {
		if (!graph.containsKey(source)) {
			graph.put(source, new HashSet<Edge>());
		}
		graph.get(source).add(new Edge(destination, weight));
	}

	public void removeEdge(char source, char destination) {
		if (graph.containsKey(source)) {
			Set<Edge> edges = graph.get(source);
			Iterator<Edge> it = edges.iterator();

			while (it.hasNext()) {
				Edge curr = it.next();
				if (curr.getDestination() == destination) {
					edges.remove(curr);
					break;
				}
			}
		}
	}

	/*
		Returns -1 if no route is found which is used 
		to print "NO SUCH ROUTE" for the test case.
	*/
	public int distanceOfRoute(String route) {
		int distance = 0;
		boolean found = false;
		for (int i = 0; i < route.length() - 1; i++) {
			for (Edge e : graph.get(route.charAt(i))) {
				if (e.getDestination() == route.charAt(i+1)) {
					found = true;
					distance += e.getWeight();
					break;
				}
			}
			if (!found) {
				return -1;
			} else {
				found = false;
			}
		}
		return distance;
	}

	/*
		This is a generic function, not just for 'C' to 'C' with 
		at most "3" junctions.

		This function can be used for any 'source' and 'destination' with
		any number of atMost.

		If source is the same as destination like the test case, we start the
		count from -1 because of the first vertix that is removed from the 
		queue will equal the destination which is also the source.

		In other cases the count is 0.
	*/
	public int atMostJunctions(char source, char destination, int atMost) {
		LinkedList<Character> vertices = new LinkedList<Character>();
		LinkedList<Integer> steps = new LinkedList<Integer>();
		int count = 0;
		if (source == destination) count = -1;

		vertices.add(source);
		steps.add(0);

		while (!vertices.isEmpty() && steps.peek() <= atMost) {
			char currVertex = vertices.remove();
			int currSteps = steps.remove();

			if (currVertex == destination) count++;

			for (Edge e : graph.get(currVertex)) {
				vertices.add(e.getDestination());
				steps.add(currSteps + 1);
			}
		}
		return count;
	}

	/*
		Same logic as before except now only increase count when 
		the number of steps is exactly as "k".
	*/
	public int exactlyKJunctions(char source, char destination, int k) {
		LinkedList<Character> vertices = new LinkedList<Character>();
		LinkedList<Integer> steps = new LinkedList<Integer>();
		int count = 0;
		if (source == destination) count = -1;

		vertices.add(source);
		steps.add(0);

		while (!vertices.isEmpty() && steps.peek() <= k) {
			char currVertex = vertices.remove();
			int currSteps = steps.remove();

			if (currVertex == destination && currSteps == k) count++;

			for (Edge e : graph.get(currVertex)) {
				vertices.add(e.getDestination());
				steps.add(currSteps + 1);
			}
		}
		return count;
	}

	/*
		Assuming there is a path between source and destination,
		function will return lenth of shortest path.
	*/
	public int shortestPath(char source, char destination) {
		LinkedList<Character> queue = new LinkedList<Character>();
		LinkedList<Integer> distance = new LinkedList<Integer>();

		if (source == destination) {
			for (Edge e : graph.get(source)) {
				queue.add(e.getDestination());
				distance.add(e.getWeight());
			}
		} else {
			queue.add(source);
			distance.add(0);
		}
		
		int currentMin = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			char currVertex = queue.remove();
			int currDistance = distance.remove();

			if (currVertex == destination) {
				currentMin = Math.min(currentMin, currDistance);
			} 

			for (Edge e : graph.get(currVertex)) {
				if (currDistance + e.getWeight() < currentMin) {
					queue.add(e.getDestination());
					distance.add(currDistance + e.getWeight());	
				}
			}
		}
		return currentMin;
	}

	/*
		Same logic as when calculating shortest path but now just count
		how many times the destination is visited while distance is less
		than "k".
	*/
	public int differentRoutesLessThanK(char source, char destination, int k) {
		LinkedList<Character> queue = new LinkedList<Character>();
		LinkedList<Integer> distance = new LinkedList<Integer>();

		if (source == destination) {
			for (Edge e : graph.get(source)) {
				queue.add(e.getDestination());
				distance.add(e.getWeight());
			}
		} else {
			queue.add(source);
			distance.add(0);
		}
		
		int count = 0;
		while (!queue.isEmpty()) {
			char currVertex = queue.remove();
			int currDistance = distance.remove();

			if (currVertex == destination && currDistance < k) {
				count++;
			} 

			for (Edge e : graph.get(currVertex)) {
				if (currDistance + e.getWeight() < k) {
					queue.add(e.getDestination());
					distance.add(currDistance + e.getWeight());	
				}
			}
		}
		return count;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (char vertex : graph.keySet()) {
			sb.append(vertex + " " + graph.get(vertex));
			sb.append('\n');
		}
		return sb.toString();
	}

}
