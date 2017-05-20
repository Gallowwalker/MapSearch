package map;

import java.util.ArrayList;
import java.util.List;

public class Node implements INode {
	
	private String nodeName = null;
	private double nodeWeight = 0.0d;
	private int x = 0, y = 0;
	private List<Link> links = new ArrayList<>();
	private boolean tested = false;
	private boolean expanded = false;
	//private Node parentNode = null;
	
	public Node(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public Node(String nodeName, double nodeWeight, int x, int y) {
		this.nodeName = nodeName;
		this.nodeWeight = nodeWeight;
		this.x = x;
		this.y = y;
	}

	@Override
	public void reset() {
		this.nodeWeight = 0.0d;
		this.tested = false;
		this.expanded = false;
		//this.parentNode = null;
	}
	
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public String getNodeName() {
		return this.nodeName;
	}
	
	public void setNodeWeight(double nodeWeight) {
		this.nodeWeight = nodeWeight;
	}
	
	public double getNodeWeight() {
		return this.nodeWeight;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}
	
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public List<Link> getLinks() {
		return this.links;
	}
	
	public void setTested(boolean tested) {
		this.tested = tested;
	}
	
	public boolean isTested() {
		return this.tested;
	}
	
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	
	public boolean isExpanded() {
		return this.expanded;
	}
	/*
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	
	public Node getParentNode() {
		return this.parentNode;
	}
	*/
}
