package hu.bme.mit.mobilegen.iostestgenerator;

public class ParsedBPMNNodeEndEvent extends ParsedBPMNNode {
	
	private String incoming;
	
	public ParsedBPMNNodeEndEvent(String nodeName, String textContent) {
		super(nodeName, textContent);
	}

	public String getIncoming() {
		return incoming;
	}

	public void setIncoming(String incoming) {
		this.incoming = incoming;
	}
	
}
