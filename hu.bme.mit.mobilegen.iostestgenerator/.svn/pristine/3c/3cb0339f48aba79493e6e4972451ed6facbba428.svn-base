package hu.bme.mit.mobilegen.iostestgenerator;

import java.util.ArrayList;

public class ParsedBPMNNodeInclusiveGateway extends ParsedBPMNNode {

	private String name2;					// attribute
	private String gatewayDirection;		// attribute
	
	private String incoming;				// child
	private ArrayList<String> outgoings;	// childs
	
	public int generatedTestsNumber = 0;	// ezt akkor novelem amikor generalaskor mar jartam itt, az a lenyeg hogy amikor legeloszor ennek a GateWay-nel jartok, akkor generalom le a tobbi tesztet, amugy nem
	
	public ParsedBPMNNodeInclusiveGateway(String nodeName, String textContent) {
		super(nodeName, textContent);
		outgoings = new ArrayList<String>();
	}
	
	public void addOutgoing(String outgoing) {
		outgoings.add(outgoing);
	}
	
	public String getOutgoing(int index) {
		return outgoings.get(index);
	}
	
	// Getters and Setters
	public String getGatewayDirection() {
		return gatewayDirection;
	}

	public void setGatewayDirection(String gatewayDirection) {
		this.gatewayDirection = gatewayDirection;
	}

	public String getIncoming() {
		return incoming;
	}

	public void setIncoming(String incoming) {
		this.incoming = incoming;
	}

	public ArrayList<String> getOutgoings() {
		return outgoings;
	}

	public void setOutgoings(ArrayList<String> outgoings) {
		this.outgoings = outgoings;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	public String getName2() {
		return name2;
	}
	
}
