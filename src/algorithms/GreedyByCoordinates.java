package algorithms;

import java.util.ArrayList;

import javax.swing.JTextArea;

import main.Main;
import map.Graph;
import map.GraphUtil;
import map.ISearch;
import map.Link;
import map.Node;

public class GreedyByCoordinates implements ISearch {
	
	private JTextArea textArea = null;
	
	public GreedyByCoordinates(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	@Override
	public boolean hasPath(String startNode, String endNode) {
		
		if (!GRAPH.containsNode(startNode) || !GRAPH.containsNode(endNode)) {
			return false;
		}
		
		GRAPH.resetAll(); // or in constructor
		
		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(GRAPH.getNode(startNode));
		
		Node temp = null;
		
		while (!queue.isEmpty()) {
			
			temp = queue.get(0);
			
			GraphUtil.printNodeInfo(temp, textArea);
			
			if (temp.getNodeName().equalsIgnoreCase(endNode)) {

				textArea.append("\nPath exists: \n");
				GraphUtil.printPath(GRAPH.getNode(startNode), GRAPH.getNode(endNode), textArea);
				textArea.append("Path length: " + GraphUtil.getFinalPathLength() + "km.\n");
				textArea.append("Final cost: " + GraphUtil.getFinalCost() + "lv.");
				
				GraphUtil.setFinalPathLength(0);
				GraphUtil.setFinalCost(0);
				
				return true;
			}
			
			queue.remove(0);
			temp.setTested(true);
			
			if (!temp.isExpanded()) {
				
				for (Link link : temp.getLinks()) {
					
					//if (!link.getRelatedNode().isTested() && !queue.contains(link.getRelatedNode())) {
						GraphUtil.setParentCost(temp, link);
						GraphUtil.calculateDistance(link.getRelatedNode(), GRAPH.getNode(endNode));
						GraphUtil.sortQueueByWeight(queue, link.getRelatedNode());
					//}
				}
				
				temp.setExpanded(true);
			}

		}
		
		return false;
	}

}
