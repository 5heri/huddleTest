public class Main {

	/*
		The test data is used by the SatNavSystem class to create a graph.
		The test data should be in the correct format as indicated in the spec.

		All test cases can be run by using the following commands:

		javac *.java
		java Main

		The actual outputs are found using functions in the SatNavSystem class.
		None of the values returned are hardcoded. 
	*/
	public static void main(String[] args) {
		String[] testData = {"AB5", "BC4","CD7","DC8",
								"DE6","AD5", "CE2", "EB3", "AE7"};

		SatNavSystem sns = new SatNavSystem(testData);
		//sns.display();

		/*
			TEST CASES
		*/

		// 1	
		System.out.print("Test case 1: ");
		System.out.print("Expected output 9. Actual output ");
		System.out.println(sns.routeDistance("ABC"));

		// 2
		System.out.print("Test case 2: ");
		System.out.print("Expected output 5. Actual output ");
		System.out.println(sns.routeDistance("AD"));

		// 3
		System.out.print("Test case 3: ");
		System.out.print("Expected output 13. Actual output ");
		System.out.println(sns.routeDistance("ADC"));

		// 4
		System.out.print("Test case 4: ");
		System.out.print("Expected output 21. Actual output ");
		System.out.println(sns.routeDistance("AEBCD"));

		// 5 
		/* 
			Will return -1 because of no route logic,
			can be made to only return "NO SUCH ROUTE" but 
		 	I feel returning -1 is better because then it is easier
		 	to handle this case. 
			One might throw an exception.
		*/
		System.out.print("Test case 5: ");    
		System.out.print("Expected output NO SUCH ROUTE. Actual output "); 
		System.out.println(sns.routeDistance("AED"));

		// 6
		System.out.print("Test case 6: ");
		System.out.print("Expected output 2. Actual output ");
		System.out.println(sns.atMostJunctions('C', 'C', 3));

		// 7
		System.out.print("Test case 7: ");
		System.out.print("Expected output 3. Actual output ");
		System.out.println(sns.exactlyKJunctions('A', 'C', 4));

		// 8 
		System.out.print("Test case 8: ");
		System.out.print("Expected output 9. Actual output ");
		System.out.println(sns.lengthOfShortestRoute('A', 'C'));

		// 9
		System.out.print("Test case 9: ");
		System.out.print("Expected output 9. Actual output ");
		System.out.println(sns.lengthOfShortestRoute('B', 'B'));

		// 10
		System.out.print("Test case 10: ");
		System.out.print("Expected output 9. Actual output ");
		System.out.println(sns.differentRoutesLessThanK('C', 'C', 30));

	}	
}
