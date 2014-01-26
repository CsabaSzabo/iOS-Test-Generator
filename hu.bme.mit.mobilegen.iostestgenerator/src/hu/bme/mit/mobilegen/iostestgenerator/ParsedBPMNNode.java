package hu.bme.mit.mobilegen.iostestgenerator;

import java.util.ArrayList;

public class ParsedBPMNNode {
	protected String name;
	protected String value;
	private String id;
	
	protected ArrayList<ParsedBPMNAttribute> attributes;
	protected ArrayList<ParsedBPMNNode> childNodes;
		
	public ParsedBPMNNode(String nodeName, String textContent) {
		attributes = new ArrayList<ParsedBPMNAttribute>();
		childNodes = new ArrayList<ParsedBPMNNode>();
		this.name = nodeName;
		this.value = textContent;
	}

	public void addAttribute(ParsedBPMNAttribute attribute) {
		attributes.add(attribute);
	}

	public void addChild(ParsedBPMNNode child) {
		childNodes.add(child);
	}

	/* Getters, Setters */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ArrayList<ParsedBPMNAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<ParsedBPMNAttribute> attributes) {
		this.attributes = attributes;
	}

	public ArrayList<ParsedBPMNNode> getChildNodes() {
		return childNodes;
	}

	public void setChildNodes(ArrayList<ParsedBPMNNode> nodes) {
		this.childNodes = nodes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
