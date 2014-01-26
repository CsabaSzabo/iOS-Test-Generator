package hu.bme.mit.mobilegen.iostestgenerator;

import java.util.ArrayList;

public class ParsedBPMNNodeExclusiveGateway extends ParsedBPMNNode {

	private String name2;					// attribute
	private String gatewayDirection;		// attribute
	
	private ArrayList<String> incomings;	// childs
	private String outgoing;				// child
	
	public ParsedBPMNNodeExclusiveGateway(String nodeName, String textContent) {
		super(nodeName, textContent);
		incomings = new ArrayList<String>();
	}
	
	public void addIncoming(String outgoing) {
		incomings.add(outgoing);
	}
	
	public String getIncoming(int index) {
		return incomings.get(index);
	}
	
	// Getters and Setters
	public String getGatewayDirection() {
		return gatewayDirection;
	}

	public void setGatewayDirection(String gatewayDirection) {
		this.gatewayDirection = gatewayDirection;
	}

	public ArrayList<String> getIncomings() {
		return incomings;
	}

	public void setIncomings(ArrayList<String> incomings) {
		this.incomings = incomings;
	}

	public String getOutgoing() {
		return outgoing;
	}

	public void setOutgoing(String outgoing) {
		this.outgoing = outgoing;
	}

	public void setName2(String nodeValue) {
		this.name2 = name2;
	}
	
	public String getName2() {
		return name2;
	}
}
