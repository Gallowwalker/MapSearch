package map;

import javax.swing.JFrame;

import main.Main;

public class GraphUtil {
	
	public static void importMap() {
		
	}
	
	public static void saveMap() {
		
	}
	
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
			case 2:
				return 0.0d;
			default:
				/*DialogProcessor dialogProcessor = new DialogProcessor();
				Object[] dialogOptionButtons = {"Ok"};
				dialogProcessor.showErrorDialog(new JFrame(), "Error", "Something went wrong when calculating the path cost.", dialogOptionButtons);
				*/
				Main.getUserInterface().getDialogProcessor().showErrorDialog("Something went wrong when calculating the path cost.");
				break;
		}
		
		return cost;
	}

}
