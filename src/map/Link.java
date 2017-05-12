package map;

public class Link {
	
	private Node relatedNode = null;
	private byte linkType = 0;
	private double linkLength = 0.0d;
	
	public Link(Node relatedNode, byte linkType, double linkLength) {
		this.relatedNode = relatedNode;
		this.linkType = linkType;
		this.linkLength = linkLength;
	}
	
	public void setRelatedNode(Node relatedNode) {
		this.relatedNode = relatedNode;
	}
	
	public Node getRelatedNode() {
		return this.relatedNode;
	}
	
	public void setLinkType(byte linkType) {
		this.linkType = linkType;
	}
	
	public byte getLinkType() {
		return this.linkType;
	}
	
	public void setLinkLength(double linkLength) {
		this.linkLength = linkLength;
	}
	
	public double getLinkLength() {
		return this.linkLength;
	}
	
}
