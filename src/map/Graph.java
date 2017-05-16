package map;

import java.util.HashMap;
import javax.swing.JFrame;

import main.Main;

public class Graph {
	
	private HashMap<String, Node> map = new HashMap<String, Node>();
	
	public boolean addNode(Node mapNode, boolean override) {
		if (map.containsKey(mapNode.getNodeName())) { //mapNode == null
			return true;
		} else {
			map.put(mapNode.getNodeName(), mapNode);
			return false;
		}
	}
	
	public void addOneWayLink(String startNode, String endNode, byte linkType, double pathLength) {
		if (map.containsKey(startNode) && map.containsKey(endNode)) {
			Link link = new Link(map.get(endNode), linkType, pathLength);
			map.get(startNode).getLinks().add(link);
		} else {
			Main.getUserInterface().getDialogProcessor().showErrorDialog("Missing nodes.");
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
