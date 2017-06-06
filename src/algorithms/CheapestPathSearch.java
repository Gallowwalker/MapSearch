package algorithms;

import java.util.ArrayList;

import javax.swing.JTextArea;

import map.GraphUtil;
import map.ISearch;
import map.Link;
import map.Node;

public class CheapestPathSearch implements ISearch{

private JTextArea textArea = null;
	
	public CheapestPathSearch(JTextArea txtrTextarea) {
		this.textArea = txtrTextarea;
	}

	@Override
	public boolean hasPath(String startNode, String endNode) {
		if (!GRAPH.containsNode(startNode) || !GRAPH.containsNode(endNode)) {
			return false;
		}

		GRAPH.resetAll();

		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(GRAPH.getNode(startNode));

		Node temp = null;

		while (!queue.isEmpty()) {
			temp = queue.get(0);
			GraphUtil.printNodeInfo(temp, textArea);
			queue.remove(0);
			temp.setTested(true);

			if (!temp.isExpanded()) {
				for (Link link : temp.getLinks()) {
					// if (!link.getRelatedNode().isTested()) {
					//GraphUtil.setParentCost(temp, link);
					//GraphUtil.setParentCostAndPrice(temp, link);
					GraphUtil.setParentByPrice(temp, link);
					queue.add(link.getRelatedNode());
					 //}
				}
				temp.setExpanded(true);
			}
		}

		if (GRAPH.getNode(endNode).getParentNode() != null) {
			textArea.append("\nPath exists: \n");
			
			/*ArrayList<String> path = new ArrayList<>();
			GraphUtil.printPath(GRAPH.getNode(startNode), GRAPH.getNode(endNode), path);

			for (String name : path) {
				textArea.append(name + " <- ");
			}
			textArea.append(" |" + "\n");
			*/
			
			GraphUtil.printPath(GRAPH.getNode(startNode), GRAPH.getNode(endNode), textArea);
			textArea.append("Path length: " + GraphUtil.getFinalPathLength() + "km.\n");
			textArea.append("Final cost: " + GraphUtil.getFinalCost() + "lv.");
			//GraphUtil.printDistanceAndPrice(GRAPH, endNode, textArea);
			
			GraphUtil.setFinalPathLength(0);
			GraphUtil.setFinalCost(0);
			return true;
		} else {
			return false;
		}
	}

}
