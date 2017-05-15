package map;

public class GraphUtil {
	
	public static double calculatePathCost(byte linkType, double linkLength) {
		double cost = 0.0d;
		
		switch (linkType) {
			case 0:
				cost += 3;
				if (linkLength > 10) {
					linkLength -=10;
				}
				cost += linkLength * 0.5d;
				break;
			case 1:
				linkLength -= 5;
				linkLength /= 10;
				if (linkLength != Math.round(linkLength)) {
					linkLength += 1;
					linkLength = Math.floor(linkLength);
				}
				cost = linkLength * 2.0d;
				break;
			case 2: return 0.0d;
			default: System.out.println("error"); // implement error dialog 
				break;
		}
		
		return cost;
	}

}
