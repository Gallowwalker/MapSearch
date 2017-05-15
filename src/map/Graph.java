package map;

import java.util.HashMap;
import javax.swing.JFrame;

import main.Main;

public class Graph {
	
	private HashMap<String, Node> map = new HashMap<String, Node>();
	
	public void addNode(Node mapNode) {
		if (mapNode == null) {
			Object[] dialogOptionButtons = {"Ok"};
			Main.getUserInterface().getDialogProcessor().showErrorDialog(new JFrame(), "Error", "Node is null.", dialogOptionButtons);
		} else {
			map.put(mapNode.getNodeName(), mapNode);
		}
	}
	
	public void addOneWayLink(String startNode, String endNode, byte linkType, double pathLength) {
		if (map.containsKey(startNode) && map.containsKey(endNode)) {
			Link link = new Link(map.get(endNode), linkType, pathLength);
			map.get(startNode).getLinks().add(link);
		} else {
			Object[] dialogOptionButtons = {"Ok"};
			Main.getUserInterface().getDialogProcessor().showErrorDialog(new JFrame(), "Error", "Missing nodes.", dialogOptionButtons);
		}
	}
	
	public void addTwoWayLink(String startNode, String endNode, byte linkType, double length) {
		addOneWayLink(startNode, endNode, linkType, length);
		addOneWayLink(endNode, startNode, linkType, length);
	}
	
	public void resetAll() {
		for (Node mapNode : map.values()) {
			mapNode.reset();
		}
	}
	
	public boolean containsNode(String nodeName) {
		return map.containsKey(nodeName);
	}
	
	public Node getNode(String nodeName) {
		return map.get(nodeName);
	}
	
}
