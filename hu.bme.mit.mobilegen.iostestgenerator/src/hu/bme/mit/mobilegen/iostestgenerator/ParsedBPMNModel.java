package hu.bme.mit.mobilegen.iostestgenerator;

import java.util.ArrayList;

public class ParsedBPMNModel {
	
	private ArrayList<ParsedBPMNNode> nodes;
	
	public ParsedBPMNModel() {
		nodes = new ArrayList<ParsedBPMNNode>();
	}
	
	public void add(ParsedBPMNNode parsedBPMNNode) {
		nodes.add(parsedBPMNNode);
	}
	
	public void writeToConsole() {
		for (int i = 0; i < nodes.size(); i++) {
			ParsedBPMNNode node = nodes.get(i);
			
			System.out.println("[name]=" + node.getName() + " - [id]=" + node.getId());
			
			if (node.getName().matches("bpmn2:startEvent")) {
				ParsedBPMNNodeStartEvent startEvent = (ParsedBPMNNodeStartEvent) node;
				
				System.out.println("	[outgoing]=" + startEvent.getOutgoing());
				
			} else if (node.getName().matches("bpmn2:endEvent")) {
				ParsedBPMNNodeEndEvent endEvent = (ParsedBPMNNodeEndEvent) node;
				
				System.out.println("	[incoming]=" + endEvent.getIncoming());
				
			} else if (node.getName().matches("bpmn2:sequenceFlow")) {
				ParsedBPMNNodeSequenceFlow sequenceFlow = (ParsedBPMNNodeSequenceFlow) node;
				
				System.out.println("	[name2]=" + sequenceFlow.getName2());
				System.out.println("	[sourceRef]=" + sequenceFlow.getSourceRef());
				System.out.println("	[targetRef]=" + sequenceFlow.getTargetRef());
				
			} else if (node.getName().matches("bpmn2:task")) {
				ParsedBPMNNodeTask task = (ParsedBPMNNodeTask) node;
				
				System.out.println("	[name2]=" + task.getName2());
				System.out.println("	[incoming]=" + task.getIncoming());
				System.out.println("	[outgoing]=" + task.getOutgoing());
				
			} else if (node.getName().matches("bpmn2:inclusiveGateway")) {
				ParsedBPMNNodeInclusiveGateway inclusiveGateway = (ParsedBPMNNodeInclusiveGateway) node;
				
				System.out.println("	[name2]=" + inclusiveGateway.getName2());
				System.out.println("	[gatewayDirection]=" + inclusiveGateway.getGatewayDirection());
				System.out.println("	[incoming]=" + inclusiveGateway.getIncoming());
				
				for (int j = 0; j < inclusiveGateway.getOutgoings().size(); j++) {
					System.out.println("	[outgoing]=" + inclusiveGateway.getOutgoing(j));
				}
				
			} else if (node.getName().matches("bpmn2:exclusiveGateway")) {
				ParsedBPMNNodeExclusiveGateway exclusiveGateway = (ParsedBPMNNodeExclusiveGateway) node;
				
				System.out.println("	[name2]=" + exclusiveGateway.getName2());
				System.out.println("	[gatewayDirection]=" + exclusiveGateway.getGatewayDirection());
				System.out.println("	[outgoing]=" + exclusiveGateway.getOutgoing());
				
				for (int j = 0; j < exclusiveGateway.getIncomings().size(); j++) {
					System.out.println("	[incoming]=" + exclusiveGateway.getIncoming(j));
				}
				
			} else {
				
			}
		}
	}

	public ArrayList<ArrayList<String>> generateTests() {
		ArrayList<ParsedBPMNNode> actualPositions = new ArrayList<ParsedBPMNNode>();
		
		// search startEvent
		for (int i = 0; i < nodes.size(); i++) {
			ParsedBPMNNode node = nodes.get(i);
			
			if (node.getName().matches("bpmn2:startEvent")) {
				ParsedBPMNNode startEvent = (ParsedBPMNNodeStartEvent) node;
				actualPositions.add(startEvent);
			}
		}
		
		ArrayList<ArrayList<String>> tests = new ArrayList<ArrayList<String>>();
		ArrayList<String> test = new ArrayList<String>();
		tests.add(test);
		
		ArrayList<ArrayList<String>> testParameters = new ArrayList<ArrayList<String>>();

		boolean genEnded = false;
		
		while (genEnded != true) {
			
			ParsedBPMNNode outgoing = null;
			int testEnded = 0;
			
			for (int i = 0; i < tests.size(); i++) {
				ParsedBPMNNode actualPosition = actualPositions.get(i);
				
				if ( (tests.get(i).size() < 2) || (!tests.get(i).get(tests.get(i).size()-1).startsWith("EndEvent")) ) {
					
					String addedString = "";
					
					if (actualPosition.getName().matches("bpmn2:task")) {
						
						if (((ParsedBPMNNodeTask) actualPosition).getType().matches("TestStep")) {
							addedString = addedString.concat("TestStep___");
						} else if (((ParsedBPMNNodeTask) actualPosition).getType().matches("ExpectedResult")) {
							addedString = addedString.concat("ExpectedResult___");
						} else {
							System.out.println("ERROR: error 3432");
						}
					}
					
					addedString = addedString.concat(actualPosition.getId());
					
					tests.get(i).add(addedString);
				}
				
				if (actualPosition.getName().matches("bpmn2:startEvent")) {
					ParsedBPMNNodeStartEvent act = (ParsedBPMNNodeStartEvent) actualPosition;
					String outgoingId = act.getOutgoing();
					outgoing = getElement(outgoingId);
					
				} else if (actualPosition.getName().matches("bpmn2:endEvent")) {
					testEnded++;
					if (testEnded == tests.size()) {
						genEnded = true;
					}
					outgoing = actualPosition;
					
				} else if (actualPosition.getName().matches("bpmn2:sequenceFlow")) {
					ParsedBPMNNodeSequenceFlow act = (ParsedBPMNNodeSequenceFlow) actualPosition;
					String outgoingId = act.getTargetRef();
					outgoing = getElement(outgoingId);
					
				} else if (actualPosition.getName().matches("bpmn2:task")) {
					ParsedBPMNNodeTask act = (ParsedBPMNNodeTask) actualPosition;
					String outgoingId = act.getOutgoing();
					outgoing = getElement(outgoingId);
					
					String actId = act.getId();
					String kifVal = act.getKIFval();
					String accVal = act.getAccVal();
					ArrayList<String> params = new ArrayList<String>();
					params.add(actId);
					params.add(kifVal);
					params.add(accVal);
					
					if (act.getType().matches("TestStep")) {
						params.add("TestStep");
					} else if (act.getType().matches("ExpectedResult")) {
						params.add("ExpectedResult");
					} else {
						System.out.println("ERROR: act.getType != TestStep | ExpectedResult");
					}
					
					testParameters.add(params);
					
				} else if (actualPosition.getName().matches("bpmn2:inclusiveGateway")) {
					ParsedBPMNNodeInclusiveGateway act = (ParsedBPMNNodeInclusiveGateway) actualPosition;
					int num = act.generatedTestsNumber;
					ArrayList<String> outGoingIds = act.getOutgoings();
					ParsedBPMNNodeSequenceFlow actSeq = (ParsedBPMNNodeSequenceFlow) getElement(outGoingIds.get(num));
					outgoing = actSeq;
					
					if (num == 0) {
						for (int j = 1; j < outGoingIds.size(); j++) {
							ArrayList<String> actTest = tests.get(i);
							
							// new test ArrayLisy
							ArrayList<String> newTest = new ArrayList<String>();
							
							for(String s : actTest) {
								newTest.add(s);
							}
							newTest.remove(newTest.size()-1);
							tests.add(newTest);
							
							// new actualPosition
							// TODO: set newPosition's Class, not only PArsedBPMNNode!!!
							ParsedBPMNNodeInclusiveGateway pos = act;
							actualPositions.add(act);
							//ParsedBPMNNodeSequenceFlow newPosition = (ParsedBPMNNodeSequenceFlow) getElement(outGoingIds.get(j));
						}
					}
					act.generatedTestsNumber++;
					
				} else if (actualPosition.getName().matches("bpmn2:exclusiveGateway")) {
					ParsedBPMNNodeExclusiveGateway act = (ParsedBPMNNodeExclusiveGateway) actualPosition;
					String outgoingId = act.getOutgoing();
					outgoing = getElement(outgoingId);
					
				} else if (actualPosition.getName().matches("bpmn2:scriptTask")) {
					ParsedBPMNNodeScriptTask act = (ParsedBPMNNodeScriptTask) actualPosition;
					String outgoingId = act.getOutgoing();
					outgoing = getElement(outgoingId);
					
				} else {
					// TODO: validation error
					System.out.println("ERROR: can't use this BPMN element - " + actualPosition.getName());
				}
				
				actualPositions.set(i, outgoing);
			}
			
		}
		
		// reset counter for InclusiveGateways
		for (int i = 0; i < nodes.size(); i++) {
			ParsedBPMNNode node = nodes.get(i);
			
			if (node.getName().matches("bpmn2:inclusiveGateway")) {
				ParsedBPMNNodeInclusiveGateway inc = (ParsedBPMNNodeInclusiveGateway) node;
				inc.generatedTestsNumber = 0;
			}
		}
		
		// keep only Task*, ScriptTask* steps
		ArrayList<ArrayList<String>> cleanedTests = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < tests.size(); i++) {
			ArrayList<String> oldTest = tests.get(i);
			ArrayList<String> newTest = new ArrayList<String>();
			for (int j = 0; j < oldTest.size(); j++) {
				String oldTestStep = oldTest.get(j);
				
				if (oldTest.get(j).startsWith("TestStep___") || oldTest.get(j).startsWith("ExpectedResult___")) {
					String testRow = "";
					testRow = testRow.concat(oldTestStep);
					testRow = testRow.concat("/");
					
					for (int k = 0; k < testParameters.size(); k++) {
						String testStepRegex = "TestStep___" + testParameters.get(k).get(0);
						String expResultRegex = "ExpectedResult___" + testParameters.get(k).get(0);
						
						if (testStepRegex.matches(oldTestStep) || expResultRegex.matches(oldTestStep)) {							
							if (testParameters.get(k).get(1) != null) {
								testRow = testRow.concat(testParameters.get(k).get(1));
								testRow = testRow.concat("/");
							} else {
								testRow = testRow.concat("null");
								testRow = testRow.concat("/");
							}
							
							if (testParameters.get(k).get(2) != null) {
								testRow = testRow.concat(testParameters.get(k).get(2));
								testRow = testRow.concat("/");
								break;
							} else {
								testRow = testRow.concat("null");
								testRow = testRow.concat("/");
								break;
							}
						}
					}
					
					newTest.add(testRow);
				}
			}
			cleanedTests.add(newTest);
		}
		
		return cleanedTests;
	}
	
	private ParsedBPMNNode getElement(String id) {
		ParsedBPMNNode result = null;
		
		for (int i = 0; i < nodes.size(); i++) {
			ParsedBPMNNode node = nodes.get(i);
			
			if (node.getId().matches(id)) {
				result = node;
			}
		}
		
		return result;
	}
}
