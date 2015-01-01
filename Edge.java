public class Edge {

	private char destination;
	private int weight;

	public Edge(char destination, int weight) {
		this.destination = destination;
		this.weight = weight;
	}	

	public void setDestination(char destination) {
		this.destination = destination;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public char getDestination() {
		return destination;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "<" + destination + "," + weight + ">";
	}
 
}
