package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
	
	private HashMap<String, Node> map = new HashMap<String, Node>();
	
	public Graph () {
		/*map.put("A", new Node("A", 14.8, 7, 8));
		map.put("B", new Node("B", 14.8, 7, 8));
		/*map.put("C", new Node("C", 14.8, 7, 8));
		map.put("D", new Node("D", 14.8, 7, 8));*/
	}
	
	/**
	 * Checks if the node exists in the map and return true to indicate it. Else adds the node to the map and return false to indicate
	 * that no node already exists.
	 * @param mapNode The node that would be added to the map.
	 * @return true or false
	 */
	public boolean addNode(Node mapNode) {
		if (map.containsKey(mapNode.getNodeName())) {
			return true;
		} else {
			map.put(mapNode.getNodeName(), mapNode);
			return false;
		}
	}
	
	/**
	 * Checks if the node exists, removes it and return false to indicate it. Else return true if there is no such node.
	 * @param mapNode The node that would be removed from the map.
	 * @return true or false
	 */
	public boolean removeNode(Node mapNode) {
		if (map.containsKey(mapNode.getNodeName())) {
			map.remove(mapNode.getNodeName());
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Checks if the starting and the destination node exists in the map, creates link between them and return false to indicate
	 * that no link exists already. Else returns true if there is a link.
	 * @param startNode The node the link is starting from.
	 * @param endNode The node the link is pointing to.
	 * @param linkType The link type - Highway(0), First class(1) or Second class(2).
	 * @param linkLength How long is the link.
	 * @return true or false
	 */
	
	public boolean addOneWayLink(String startNode, String endNode, byte linkType, double linkLength) {
		if (map.containsKey(startNode) && map.containsKey(endNode)) {
			Link link = new Link(map.get(endNode), linkType, linkLength);
			map.get(startNode).getLinks().add(link);
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Creates bidirectional link between the two nodes and returns true if link already exists.
	 * @param startNode The node the link is starting from.
	 * @param endNode The node the link is pointing to.
	 * @param linkType The link type - Highway(0), First class(1) or Second class(2).
	 * @param linkLength How long is the link.
	 * @return true or false
	 */
	public boolean addTwoWayLink(String startNode, String endNode, byte linkType, double linkLength) {
		boolean linkTest1 = addOneWayLink(startNode, endNode, linkType, linkLength);
		boolean linkTest2 = addOneWayLink(endNode, startNode, linkType, linkLength);
		if (linkTest1 || linkTest2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if the starting and the destination node exists in the map, deletes the link between them and return true to indicate
	 * that link is removed or false if not. Else returns false if one or both nodes doesn't exist.
	 * @param startNode The node the link is starting from.
	 * @param endNode endNode The node the link is pointing to.
	 * @return true or false
	 */
	public boolean removeOneWayLink(String startNode, String endNode) {
		if (map.containsKey(startNode) && map.containsKey(endNode)) {
			boolean isRemoved = false;
			List<Link> startNodeLinks = new ArrayList<>();
			startNodeLinks = map.get(startNode).getLinks();
			
			Link startSelectedLink = null;
			Node startDestinationNode = null;
			
			for (int i = 0; i < startNodeLinks.size(); i++) {
				startSelectedLink = startNodeLinks.get(i);
				startDestinationNode = startSelectedLink.getRelatedNode();
				if (startDestinationNode == map.get(endNode)) {
					startNodeLinks.remove(i);
					//startNodeLinks.remove(selectedLink);
					isRemoved = true;
					break;
				}
			}
			return isRemoved;
		} else {
			return false;
		}
	}
	
	/**
	 * Deletes bidirectional link between the two nodes and returns true if link is removed.
	 * @param startNode The node the link is starting from.
	 * @param endNode endNode The node the link is pointing to.
	 * @return true or false
	 */
	public boolean removeTwoWayLink(String startNode, String endNode) {
		boolean linkTest1 = removeOneWayLink(startNode, endNode);
		boolean linkTest2 = removeOneWayLink(endNode, startNode);
		if (linkTest1 && linkTest2) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Loops through all nodes in the map and reset their properties to the default values.
	 */
	public void resetAll() {
		for (Node mapNode : map.values()) {
			mapNode.reset();
		}
	}
	
	/**
	 * Checks if node exists in the map. 
	 * @param nodeName The node name used for key to access the node value.
	 * @return true or false
	 */
	public boolean containsNode(String nodeName) {
		return map.containsKey(nodeName);
	}
	
	/**
	 * Returns node from the map.
	 * @param nodeName The node name used for key to access the node value.
	 * @return node.
	 */
	public Node getNode(String nodeName) {
		return map.get(nodeName);
	}
	
	/**
	 * Sets the whole map.
	 * @param map The map.
	 */
	public void setMap(HashMap<String, Node> map) {
		this.map = map;
	}
	
	/**
	 *	
	 * @return the whole map.
	 */
	public HashMap<String, Node> getMap() {
		return this.map;
	}
	
}
