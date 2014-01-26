package hu.bme.mit.mobilegen.iostestgenerator;

public class ParsedBPMNNodeSequenceFlow extends ParsedBPMNNode {
	
	private String name2;
	private String sourceRef;
	private String targetRef;
	
	public ParsedBPMNNodeSequenceFlow(String nodeName, String textContent) {
		super(nodeName, textContent);
	}
	
	// Getters and Setters
	public String getSourceRef() {
		return sourceRef;
	}

	public void setSourceRef(String sourceRef) {
		this.sourceRef = sourceRef;
	}

	public String getTargetRef() {
		return targetRef;
	}

	public void setTargetRef(String targetRef) {
		this.targetRef = targetRef;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}
	
	public String getName2() {
		return name2;
	}
	
}
