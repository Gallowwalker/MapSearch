package map;

public class GraphUtil {
	
	public static double calculatePathCost(byte linkType, double linkLength) {
		double cost = 0.0d;
		
		switch (linkType) {
			case 0:
				break;
			case 1:
				break;
			case 2: return 0.0d;
			default: System.out.println("error"); // implement error dialog 
				break;
		}
		
		return cost;
	}

}
