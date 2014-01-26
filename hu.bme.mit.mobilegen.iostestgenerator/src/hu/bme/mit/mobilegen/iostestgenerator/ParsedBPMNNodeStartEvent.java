package hu.bme.mit.mobilegen.iostestgenerator;

public class ParsedBPMNNodeStartEvent extends ParsedBPMNNode {
	
	private String outgoing;
	
	public ParsedBPMNNodeStartEvent(String nodeName, String textContent) {
		super(nodeName, textContent);
	}

	// Getters and Setters
	public String getOutgoing() {
		return outgoing;
	}

	public void setOutgoing(String outgoing) {
		this.outgoing = outgoing;
	}
	
}
