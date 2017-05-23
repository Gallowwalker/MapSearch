package map;

public class Link {
	
	/**
	 * Link properties.
	 */
	private Node relatedNode = null;
	private byte linkType = 0;
	private double linkLength = 0.0d;
	
	/**
	 * Sets the parameters of the link.
	 * @param relatedNode The node the link is pointing to.
	 * @param linkType The link type - Highway(0), First class(1) or Second class(2).
	 * @param linkLength How long is the link.
	 */
	public Link(Node relatedNode, byte linkType, double linkLength) {
		this.relatedNode = relatedNode;
		this.linkType = linkType;
		this.linkLength = linkLength;
	}
	
	/**
	 * Sets the node the link is pointing to.
	 * @param relatedNode The node the link is pointing to.
	 */
	public void setRelatedNode(Node relatedNode) {
		this.relatedNode = relatedNode;
	}
	
	/**
	 * Return the node the link is pointing to.
	 * @return Node
	 */
	public Node getRelatedNode() {
		return this.relatedNode;
	}
	
	/**
	 * Sets the link type.
	 * @param linkType The link type - Highway(0), First class(1) or Second class(2).
	 */
	public void setLinkType(byte linkType) {
		this.linkType = linkType;
	}
	
	/**
	 * Return the link type.
	 * @return Link type.
	 */
	public byte getLinkType() {
		return this.linkType;
	}
	
	/**
	 * Sets the link length.
	 * @param linkLength How long is the link.
	 */
	public void setLinkLength(double linkLength) {
		this.linkLength = linkLength;
	}
	
	/**
	 * Return the link length.
	 * @return Link length.
	 */
	public double getLinkLength() {
		return this.linkLength;
	}
	
}
