package hu.bme.mit.mobilegen.iostestgenerator;

import java.util.ArrayList;

public class ParsedBPMNNodeTask extends ParsedBPMNNode {

	private String name2;		// attribute
		
	private String incoming;	// child
	private String outgoing;	// child

	private String type;
	
	private String KIFval;
	private String AccVal;
	
	public ParsedBPMNNodeTask(String nodeName, String textContent) {
		super(nodeName, textContent);
	}

	// Getters and Setters
	public String getIncoming() {
		return incoming;
	}

	public void setIncoming(String incoming) {
		this.incoming = incoming;
	}

	public String getOutgoing() {
		return outgoing;
	}

	public void setOutgoing(String outgoing) {
		this.outgoing = outgoing;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	public String getName2() {
		return name2;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getKIFval() {
		return KIFval;
	}

	public void setKIFval(String kIFval) {
		KIFval = kIFval;
	}

	public String getAccVal() {
		return AccVal;
	}

	public void setAccVal(String accVal) {
		AccVal = accVal;
	}
}
