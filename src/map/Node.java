package map;

import java.util.ArrayList;
import java.util.List;

public class Node implements INode {
	
	/**
	 * Node properties.
	 */
	private String nodeName = null;
	private double nodeWeight = 0.0d;
	private int x = 0, y = 0;
	private List<Link> links = new ArrayList<>();
	private boolean tested = false;
	private boolean expanded = false;
	private Node parentNode = null;
	private double distance = 0.0d;
	private double cost = 0.0d;
	private int depth = 0;
	
	/**
	 * Sets the parameters of the node.
	 * @param nodeName The name of the node.
	 */
	public Node(String nodeName) {
		this.nodeName = nodeName;
		this.parentNode = null;
	}
	
	public Node(String nodeName, double nodeWeight) {
		this.nodeName = nodeName;
		this.nodeWeight = nodeWeight;
		this.parentNode = null;
	}
	
	public Node(String nodeName, int x, int y) {
		this.nodeName = nodeName;
		this.x = x;
		this.y = y;
		this.parentNode = null;
	}
	
	/**
	 * Sets the parameters of the node.
	 * @param nodeName The name of the node.
	 * @param nodeWeight The weight of the node.
	 * @param x Coordinate X of the node.
	 * @param y Coordinate Y of the node.
	 */
	public Node(String nodeName, double nodeWeight, int x, int y) {
		this.nodeName = nodeName;
		this.nodeWeight = nodeWeight;
		this.x = x;
		this.y = y;
		this.parentNode = null;
	}
	
	/**
	 * Resets the node flags and properties to their default values.
	 */
	@Override
	public void reset() {
		this.nodeWeight = 0.0d;
		this.tested = false;
		this.expanded = false;
		this.parentNode = null;
		this.depth = 0;
		this.cost = 0.0d;
	}
	
	/**
	 * Sets the node name.
	 * @param nodeName The name of the node.
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	/**
	 * Return the node name.
	 * @return Node name.
	 */
	public String getNodeName() {
		return this.nodeName;
	}
	
	/**
	 * Sets the node weight.
	 * @param nodeWeight The weight of the node.
	 */
	public void setNodeWeight(double nodeWeight) {
		this.nodeWeight = nodeWeight;
	}
	
	/**
	 * Return the node weight.
	 * @return Node weight.
	 */
	public double getNodeWeight() {
		return this.nodeWeight;
	}
	
	/**
	 * Sets the node coordinate X.
	 * @param x Coordinate X of the node.
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Return the node coordinate X.
	 * @return Coordinate X.
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Sets the node coordinate Y.
	 * @param y Coordinate Y of the node.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Return the node coordinate Y.
	 * @return Coordinate Y.
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Sets all node links.
	 * @param links The node links.
	 */
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	/**
	 * Return all node links.
	 * @return Node links.
	 */
	public List<Link> getLinks() {
		return this.links;
	}
	
	/**
	 * Sets the tested flag state.
	 * @param tested The tested flag.
	 */
	public void setTested(boolean tested) {
		this.tested = tested;
	}
	
	/**
	 * Return the tested flag state.
	 * @return Tested flag.
	 */
	public boolean isTested() {
		return this.tested;
	}
	
	/**
	 * Sets the expanded flag state.
	 * @param expanded The expanded flag.
	 */
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	
	/**
	 * Return the expanded flag state.
	 * @return Expanded flag.
	 */
	public boolean isExpanded() {
		return this.expanded;
	}
	
	/**
	 * Sets the parent node of the current node.
	 * @param parentNode The parent node.
	 */
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	
	/**
	 * Return the parent node of the current node.
	 * @return Parent node.
	 */
	public Node getParentNode() {
		return this.parentNode;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
}
