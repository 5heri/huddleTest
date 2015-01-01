public class SatNavSystem {

	private Graph g;

	public SatNavSystem(String[] data) {
		g = new Graph();
		createGraph(data);
	}

	public int routeDistance(String route) {
		int distance = g.distanceOfRoute(route);
		if (distance == -1) {
			System.out.print(("NO SUCH ROUTE "));
		}
		return distance;
	}

	public int atMostJunctions(char source, char destination, int atMost) {
		return g.atMostJunctions(source, destination, atMost);
	}	

	public int exactlyKJunctions(char source, char destination, int k) {
		return g.exactlyKJunctions(source, destination, k);
	}

	public int lengthOfShortestRoute(char source, char destination) {
		return g.shortestPath(source, destination);
	}

	public int differentRoutesLessThanK(char source, char destination, int k) {
		return g.differentRoutesLessThanK(source, destination, k);
	}

	/*
		Assuming data is always provided in format:
		char[0] = source
		char[1] = destination
		char[2] = weight
	*/
	private void createGraph(String[] data) {
		for (String s : data) {
			g.addEdge(s.charAt(0), s.charAt(1), 
				Character.getNumericValue(s.charAt(2)));
		}
	}

	/*
		Can be used at any time to display the current graph being used 
		within the Sat Nav System.
	*/
	public void display() {
		System.out.println(g);
	}
}
