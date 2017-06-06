package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextArea;

import javafx.scene.control.TextArea;
import main.Main;
import processors.DialogProcessor;

public class GraphUtil {
	
	private static Graph graph = Main.getUserInterface().getGraph();
	private static DialogProcessor dialog = Main.getUserInterface().getDialogProcessor();
	private static double finalPathLength = 0.0d;
	private static double finalCost = 0.0d;
	
	public static void setFinalPathLength(double length) {
		finalPathLength = length;
	}
	
	public static double getFinalPathLength() {
		return finalPathLength;
	}
	
	public static void setFinalCost(double cost) {
		finalCost = cost;
	}
	
	public static double getFinalCost() {
		return finalCost;
	}
	
	public static void printMap() {
		for (Node mapNode : graph.getMap().values()) {
			System.out.println("#" + mapNode.getNodeName() + "," + mapNode.getNodeWeight() + "," + mapNode.getX() + "," + mapNode.getY() + "#");
			for (Link nodeLink : mapNode.getLinks()) {
				System.out.println("$" + mapNode.getNodeName() + "," + nodeLink.getRelatedNode().getNodeName() + "," + nodeLink.getLinkLength() + "," + nodeLink.getLinkType() + "$");
			}
		}
	}
	
	public static void loadMap(File file) {
		//check if file format is correct .txt or file exists
		List<String> nodeProperties = new ArrayList<>();
		List<String> linkProperties = new ArrayList<>();
		try {
			Scanner fileReader = new Scanner(file, "UTF-8");
			String fileLine = null;
			while (fileReader.hasNextLine()) {
				fileLine = fileReader.nextLine();
					if (fileLine.startsWith("#")) {
						fileLine = fileLine.substring(1, fileLine.length()-1);
						nodeProperties = Arrays.asList(fileLine.split(","));
						if (nodeProperties.size() > 1) {
							graph.addNode(new Node(nodeProperties.get(0), Double.parseDouble(nodeProperties.get(1)), Integer.parseInt(nodeProperties.get(2)), Integer.parseInt(nodeProperties.get(3))));
						} else {
							graph.addNode(new Node(nodeProperties.get(0)));
						}
					}	
			}
			fileReader.close();
			fileReader = new Scanner(file, "UTF-8");
			while (fileReader.hasNextLine()) {
				fileLine = fileReader.nextLine();
				if (fileLine.startsWith("$")) {
					fileLine = fileLine.substring(1, fileLine.length()-1);
					linkProperties = Arrays.asList(fileLine.split(","));
					if (linkProperties.size() > 3) {
						graph.addOneWayLink(linkProperties.get(0), linkProperties.get(1), Byte.parseByte(linkProperties.get(3)), Double.parseDouble(linkProperties.get(2)));
					} else {
						graph.addOneWayLink(linkProperties.get(0), linkProperties.get(1), Byte.parseByte(linkProperties.get(2)), 0);
					}
				}
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveMap(File file) {
		if (!graph.getMap().isEmpty()) {
			try {
				PrintStream fileWriter = new PrintStream(file);
				
				HashMap<String, Node> map = graph.getMap();
				for (Node mapNode : graph.getMap().values()) {
					fileWriter.println("#" + mapNode.getNodeName() + "," + mapNode.getNodeWeight() + "," + mapNode.getX() + "," + mapNode.getY() + "#");
					for (Link nodeLink : mapNode.getLinks()) {
						fileWriter.println("$" + mapNode.getNodeName() + "," + nodeLink.getRelatedNode().getNodeName() + "," + nodeLink.getLinkLength() + "," + nodeLink.getLinkType() + "$");
					}
				}
				
				fileWriter.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			dialog.showErrorDialog("Can't save file. The map is empty.");
		}
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
				dialog.showErrorDialog("Something went wrong when calculating the path cost.");
				break;
		}
		
		return cost;
	}
	
	public static ArrayList<Node> sortQueueByWeight(ArrayList<Node> queue, Node node) {
		boolean isNotAdded = true;
		for (int i = 0; i < queue.size(); i++) {
			if (node.getNodeWeight() < queue.get(i).getNodeWeight()) {
				queue.add(i, node);
				isNotAdded = false;
				break;
			}
		}
		if (isNotAdded) {
			queue.add(node);
		}
		return queue;
	}
	
	public static void calculateDistance(Node startNode, Node endNode) {
		double result = Math.sqrt(Math.pow(startNode.getX() - endNode.getX(), 2) + Math.pow(startNode.getY() - endNode.getY(), 2));
		startNode.setNodeWeight(result);
	}
	
	public static void printPath(Node startNode, Node endNode, JTextArea textArea) {
		if (!(endNode.getNodeName() == startNode.getNodeName())) {
			textArea.append(endNode.getNodeName() + " <- ");
			
			//end node | parent node 
			for (Link link : endNode.getParentNode().getLinks()) {
				if (link.getRelatedNode() == endNode) {
					finalPathLength += link.getLinkLength();
				}
			}
			
			finalCost += startNode.getCost() + endNode.getCost();
			//finalCost = endNode.getCost();
			//finalPathLength = endNode.getDistance();
			printPath(startNode, endNode.getParentNode(), textArea);
		} else {
			textArea.append(startNode.getNodeName() + " |" + "\n");
			return;
		}
	}
	
	public static void printNodeInfo(Node node, JTextArea textArea) {
		
		String parentName = null;
		double length = 0.0d;
		byte type = 0;
		if (node.getParentNode() == null) {
			parentName = "No parent";
		} else {
			parentName = node.getParentNode().getNodeName();
			for (Link link : node.getParentNode().getLinks()) {
				if (link.getRelatedNode() == node) {
					length = link.getLinkLength();
					type = link.getLinkType();
				}
			}
		}
		String typeName = "";
		switch (type) {
		case 0: typeName = "Highway(0)";
		break;
		case 1: typeName = "First Class(1)";
		break;
		case 2: typeName = "Second Class(2)";
		break;
		}
		
		textArea.append("Current node: " + node.getNodeName() + ", Length: " + length + "km. Type: " + typeName + " , Cost: " + node.getCost() + "lv. , Parent node: " + parentName + "\n");
	}
	
	public static void setParentCost(Node parentNode, Link link) {
		//double newCost = 0.0d;
		double newCost = parentNode.getDistance() + link.getLinkLength();
		if (parentNode != null) {
			 newCost = parentNode.getCost() + calculatePathCost(link.getLinkType(), link.getLinkLength());
		}
		
		Node relatedNode = link.getRelatedNode();
		if (relatedNode.getParentNode() == null || relatedNode.getCost() > newCost) {
			relatedNode.setParentNode(parentNode);
			relatedNode.setCost(newCost);
		}
	}
	
	public static void setParentCostAndPrice(Node parentNode, Link link) {
		double newDistance = parentNode.getDistance() + link.getLinkLength() + parentNode.getNodeWeight();
		double newCost = parentNode.getCost() + calculatePathCost(link.getLinkType(), link.getLinkLength());
		Node rNode = link.getRelatedNode();
		if (rNode.getParentNode() == null || rNode.getDistance() > newDistance) {
			
			rNode.setDistance(newDistance);
			rNode.setParentNode(parentNode);
			rNode.setCost(newCost);
		}
	}
	
	public static void setParentByPrice(Node parentNode, Link link) {
		double newDistance = parentNode.getDistance() + link.getLinkLength() + parentNode.getNodeWeight();
		double newCost = parentNode.getCost() + calculatePathCost(link.getLinkType(), link.getLinkLength());
		Node rNode = link.getRelatedNode();
		if (rNode.getParentNode() == null || rNode.getCost() > newCost) {
			
			rNode.setDistance(newDistance);
			rNode.setParentNode(parentNode);
			rNode.setCost(newCost);
		}
	}
	
	public static void printDistanceAndPrice(Graph graph, String end, JTextArea textArea) {
		textArea.append("Path length: " + (graph.getNode(end).getDistance()) + "km.\n");
		textArea.append("Final cost: " + graph.getNode(end).getCost() + "lv.");
	}
	
	public static void printPath(Node stopNode, Node goalNode, ArrayList<String> path) {
		if (!(goalNode.getNodeName() == stopNode.getNodeName())) {
			path.add(goalNode.getNodeName());
			printPath(stopNode, goalNode.getParentNode(), path);
		} else {
			path.add(stopNode.getNodeName());
			return;
		}
	}

}
