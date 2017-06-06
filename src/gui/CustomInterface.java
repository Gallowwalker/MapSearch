package gui;

import java.util.HashMap;

import main.Main;
import map.Graph;
import map.Node;
import processors.DialogProcessor;

public abstract class CustomInterface {
	
	/**
	 * Component dimensions.
	 */
	protected static final int BUTTON_WIDTH = 100, BUTTON_HEIGHT = 28;
	protected static final int TEXT_FIELD_WIDTH = 129, TEXT_FIELD_HEIGHT = 23;
	protected static final int LABEL_WIDTH = 63, LABEL_HEIGHT = 23;
	protected static final int COMBO_BOX_WIDTH = TEXT_FIELD_WIDTH, COMBO_BOX_HEIGHT = TEXT_FIELD_HEIGHT;
	
	protected HashMap<String, Node> map = Main.getUserInterface().getGraph().getMap();
	protected DialogProcessor dialog = Main.getUserInterface().getDialogProcessor();
	protected Graph graph = Main.getUserInterface().getGraph();
	
	protected void initialize() {
		//Implement in successor classes
	}
	
	protected void validate() {
		//Implement in successor classes
	}
	
	protected boolean isInteger(String value) {
	    try {
	        Integer.parseInt(value);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	protected boolean isDouble(String value) {
	    try {
	        Double.parseDouble(value);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
}
