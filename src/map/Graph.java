package map;

import java.util.HashMap;

public class Graph {
	
	private HashMap<String, Node> map = new HashMap<String, Node>();
	
	public void addNode(Node node) {
		if (node == null) {
			System.out.println("Node is null.");
		} else {
			map.put(node.name, node);
		}
	}
	
	public void oneWayLink(String start, String end) {
		if (map.containsKey(start) && map.containsKey(end)) {
			map.get(start).links.add(map.get(end));
		} else {
			System.out.println("Missing Nodes.");
		}
	}
	
	public void oneWayLink(String start, String end, double length) {
		if (map.containsKey(start) && map.containsKey(end)) {
			Link link = new Link(map.get(end), length);
			map.get(start).listLinks.add(link);
		} else {
			System.out.println("Missing Nodes.");
		}
	}
	
	public void twoWayLink(String start, String end) {
		oneWayLink(start, end);
		oneWayLink(end, start);
	}
	
	public void twoWayLink(String start, String end, double length) {
		oneWayLink(start, end, length);
		oneWayLink(end, start, length);
	}
	
	public void resetAll() {
		for (Node node : map.values()) {
			node.reset();
		}
	}
	
	public boolean containsNode(String name) {
		return map.containsKey(name);
	}
	
	public Node getNode(String name) {
		return map.get(name);
	}
	
}
