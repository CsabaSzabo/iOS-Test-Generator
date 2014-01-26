package hu.bme.mit.mobilegen.iostestgenerator;

public class ParsedBPMNAttribute {
	
	private String name;
	private String value;
	
	public ParsedBPMNAttribute(String nodeName, String nodeValue) {
		this.name = nodeName;
		this.value = nodeValue;
	}

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
	
	

}
