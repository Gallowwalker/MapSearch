package map;

import main.Main;

public interface ISearch {
	
	public Graph GRAPH = Main.getUserInterface().getGraph();
	
	public boolean hasPath(String startNode, String endNode);
	
}
