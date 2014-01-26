package hu.bme.mit.mobilegen.iostestgenerator;

import hu.bme.mit.mobilegen.iostestgenerator.model.application.Application;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationFactory;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationPackage;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElement;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.bpmn2.*;
import org.eclipse.bpmn2.Process;
import org.eclipse.bpmn2.impl.SequenceFlowImpl;
import org.eclipse.bpmn2.modeler.examples.customtask.MyModel.TaskConfig;
import org.eclipse.bpmn2.util.Bpmn2ResourceFactoryImpl;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.*;
import org.eclipse.dd.di.Diagram;
import org.eclipse.dd.di.impl.DiagramImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
















// from xml tutorial
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.eclipse.emf.ecore.*;


public class BpmnModelProcesser {
	
	private IProgressMonitor monitor;
	
	public BpmnModelProcesser() {
		monitor = new IProgressMonitor() {
			
			@Override
			public void worked(int work) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void subTask(String name) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTaskName(String name) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setCanceled(boolean value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isCanceled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void internalWorked(double work) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void done() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beginTask(String name, int totalWork) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	
	public void processModel(IPath filePath) {
		System.out.println("IPath = " + filePath);
		
		boolean PROCESS_MODEL_DEBUG = true;
		
		// --- 1 --- INIT variables
		//		root					(IWorkspaceRoot)
		//	 	projectName				(String)
		// 		appSettings 			(Resource)
		//		xcodeTestFolder			(String)
		//		uiElementLabelList		(EList<UIElements>)
		// 		accessibilityLabelList 	(ArrayList<String>)

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
		String[] filePathSegments = filePath.segments();
		String projectName = filePathSegments[0];
		String sourceFileName = filePathSegments[2];
		String testFileName = sourceFileName.substring(0, sourceFileName.length()-5);
		
		Resource appSettingsResource = getAppSettingsResource(root, projectName);
	    Application app = (Application) appSettingsResource.getContents().get(0);
	    String xcodeTestFolder = app.getXcodeTestFolder();
	    ArrayList<String> accessibilityLabelList = new ArrayList<String>();
	    EList<UIElement> uiElementList = app.getUielements();
	    for (int i = 0; i < uiElementList.size(); i++) {
	    	accessibilityLabelList.add(uiElementList.get(i).getAccessibilityLabel());
	    }	    
		
		IResource resource = root.findMember(filePath);
		if (resource != null) {
		    URI location = resource.getLocationURI();
		    
		    try {
				File file = new File(FileLocator.resolve(URIUtil.toURL(location)).toURI());
				
				// --- 2 --- Normalize the Document
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(file);
				doc.getDocumentElement().normalize();
						
				// --- 3 --- Find bpmn2:process element
				NodeList processList = doc.getElementsByTagName("bpmn2:process");
				Node process = processList.item(0);
				NodeList processNodes = process.getChildNodes();
				
				// --- 4 --- Parse BPMN model (!!!)
				ParsedBPMNModel parsedBPMNModel = parseBPMN(root, projectName, testFileName);
				ArrayList<ArrayList<String>> tests 	= parsedBPMNModel.generateTests();
								
				// DEBUG
				if (PROCESS_MODEL_DEBUG) {
					for (int i = 0; i < tests.size(); i++) {
						ArrayList<String> test = tests.get(i);
						System.out.println("Test #" + i);
						for (int j = 0; j < test.size(); j++) {
							System.out.println("   Step#" + j + " - " + test.get(j));
						}
					}
				}
				
				// --- 5 --- Init CodeGenerator
				HelloXtend codeGenerator = new HelloXtend();
				
				// --- 6 --- Code generation
				String contentOfTestfile = "";
				contentOfTestfile = contentOfTestfile.concat(codeGenerator.testFileBegin(testFileName, projectName).toString());
				contentOfTestfile = contentOfTestfile.concat(codeGenerator.newLine().toString());
				contentOfTestfile = contentOfTestfile.concat(codeGenerator.beforeAll().toString());
				contentOfTestfile = contentOfTestfile.concat(codeGenerator.newLine().toString());
				contentOfTestfile = contentOfTestfile.concat(codeGenerator.afterAll().toString());
				contentOfTestfile = contentOfTestfile.concat(codeGenerator.newLine().toString());
				
				// generate all test code
				for (int i = 0; i < tests.size(); i++) {
					String contentOfTestMethod = "";
					String methodName = "" + i;
					contentOfTestMethod = contentOfTestMethod.concat(codeGenerator.testMethodBegin(methodName).toString());
					
					ArrayList<String> test = tests.get(i);
					for (int j = 0; j < test.size(); j++) {
						String contentOfTestRow = "";
						
						if ((test.get(j).startsWith("TestStep___")) || (test.get(j).startsWith("ExpectedResult___"))) {
							String[] testParts = test.get(j).split("/");
							
							String KIFActionParameter = testParts[1];
							String AccessibilityLabelParameter = testParts[2];
							
							if (KIFActionParameter.matches("swipeViewWithAccessibilityLabelinDirection") || KIFActionParameter.matches("enterTextintoViewWithAccessibilityLabel")) {
								// tobb parameter az AccessibilityLabelParameter-en belul
								
								if (KIFActionParameter.matches("swipeViewWithAccessibilityLabelinDirection")) {
									// swipe
									String accLabel = AccessibilityLabelParameter.split(",")[0];
									String swipeDir = AccessibilityLabelParameter.split(",")[1];
									
									// accessiblityLabel ellenorzes
									if (accessibilityLabelList.contains(accLabel)) {
										contentOfTestRow = contentOfTestRow.concat("	[tester swipeViewWithAccessibilityLabel:@\""+accLabel+"\" inDirection:"+swipeDir+"];");
									} else {
										contentOfTestRow = contentOfTestRow.concat("	HIBAS ACCESSIBILITYLABEL: " + accLabel);
									}
									
									contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
									
								} else if (KIFActionParameter.matches("enterTextintoViewWithAccessibilityLabel")) {
									// enter text
									String enterText = AccessibilityLabelParameter.split(",")[0];
									String accLabel  = AccessibilityLabelParameter.split(",")[1];
									
									// accessiblityLabel ellenorzes
									if (accessibilityLabelList.contains(accLabel)) {
										contentOfTestRow = contentOfTestRow.concat("	[tester enterText:@\""+enterText+"\" intoViewWithAccessibilityLabel:@\""+accLabel+"\"];");
									} else {
										contentOfTestRow = contentOfTestRow.concat("	HIBAS ACCESSIBILITYLABEL: " + accLabel);
									}
									
									contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
								}
							
							} else {
								// egy parameteres lepesek
								
								if (accessibilityLabelList.contains(AccessibilityLabelParameter)) {
									if (test.get(j).startsWith("TestStep___")) {
										
										if (KIFActionParameter.matches("tapViewWithAccessibilityLabel")) {
											contentOfTestRow = contentOfTestRow.concat("	[tester tapViewWithAccessibilityLabel:@\""+AccessibilityLabelParameter+"\"];");
											
										} else {
											contentOfTestRow = contentOfTestRow.concat("	// Test step");
											contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
											contentOfTestRow = contentOfTestRow.concat("	//INVALID KIFAction!!!");
										}
										
										contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
																	
									} else if (test.get(j).startsWith("ExpectedResult___")) {
																				
										if (KIFActionParameter.matches("waitForViewWithAccessibilityLabel")) {
											contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
											contentOfTestRow = contentOfTestRow.concat("	// Expected result");
											contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
											contentOfTestRow = contentOfTestRow.concat("	[tester waitForViewWithAccessibilityLabel:@\""+AccessibilityLabelParameter+"\"];");
										} else if (KIFActionParameter.matches("waitForAbsenceOfViewWithAccessibilityLabel")) {
											contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
											contentOfTestRow = contentOfTestRow.concat("	// Expected result");
											contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
											contentOfTestRow = contentOfTestRow.concat("	[tester waitForAbsenceOfViewWithAccessibilityLabel:@\""+AccessibilityLabelParameter+"\"];");
										} else {
											contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
											contentOfTestRow = contentOfTestRow.concat("	// Expected result");
											contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
											contentOfTestRow = contentOfTestRow.concat("	//INVALID KIFAction!!!");
										}
										
										contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
										contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
									}
								} else {
									contentOfTestRow = contentOfTestRow.concat("	HIBAS ACCESSIBILITYLABEL: " + AccessibilityLabelParameter);
									contentOfTestRow = contentOfTestRow.concat(codeGenerator.newLine().toString());
								}
							}
							
							
						}
						
						

						contentOfTestMethod = contentOfTestMethod.concat(contentOfTestRow);
					}
					contentOfTestMethod = contentOfTestMethod.concat(codeGenerator.testMethodEnd().toString());
					contentOfTestMethod = contentOfTestMethod.concat(codeGenerator.newLine().toString());

					contentOfTestfile = contentOfTestfile.concat(contentOfTestMethod);
				}
				
				contentOfTestfile = contentOfTestfile.concat(codeGenerator.testFileEnd().toString());
								
				// ---- generate test file
				IFile generatedFile = this.addFileToProject(testFileName + ".m", projectName, "src-gen", contentOfTestfile);
				
				
						
			    
			    // ---- copy files to Xcode test folder
				System.out.println("Xcode test folder: " + xcodeTestFolder);			
				xcodeTestFolder = xcodeTestFolder.concat(generatedFile.getName());
				File genFile = new File(xcodeTestFolder);
				
				IPath generatedFileLocation = generatedFile.getLocation();
				
				// copy file content
				FileChannel src = new FileInputStream(generatedFileLocation.toString()).getChannel();
				FileChannel dest = new FileOutputStream(genFile.getAbsolutePath()).getChannel();
				dest.transferFrom(src, 0, src.size());
				
				// create copied file
				genFile.createNewFile();
				
								
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private ParsedBPMNModel parseBPMN(IWorkspaceRoot root, String projectName, String testFileName) throws IOException {
		
		IProject project = root.getProject(projectName);
		IFile modelFile = project.getFile(new Path("model/"+ testFileName +".bpmn"));
		
		org.eclipse.emf.common.util.URI modelFileURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(modelFile.getFullPath().toString(), true);
		
		Bpmn2ResourceFactoryImpl resFactory = new Bpmn2ResourceFactoryImpl();
		Resource resource = resFactory.createResource(modelFileURI);
		resource.load(Collections.EMPTY_MAP);
		
		// Definitions is the root element in our xml file
		Definitions d = (Definitions) resource.getContents().get(0).eContents().get(0);
		
		// We are only interested in the processes for the moment
		
		
		Process process = (Process) d.getRootElements().get(0);
		List<FlowElement> flowElements = process.getFlowElements();
		
		// --- Innen kezdodik a tenyleges BPMN2 model feldolgozas
		
		ParsedBPMNModel parsedBPMNModel = new ParsedBPMNModel();
		
		for (FlowElement possibleFlowElement: flowElements) {
			
			ParsedBPMNNode parsedBPMNNode = null;
			
			if (possibleFlowElement instanceof org.eclipse.bpmn2.EndEvent) {
				EndEvent bpmnEndEvent = (EndEvent) possibleFlowElement;
				
				ParsedBPMNNodeEndEvent endEvent = new ParsedBPMNNodeEndEvent("bpmn2:endEvent", "");
				endEvent.setId(bpmnEndEvent.getId());
				endEvent.setIncoming(bpmnEndEvent.getIncoming().get(0).getId());
				
				parsedBPMNModel.add(endEvent);
							
			} else if (possibleFlowElement instanceof org.eclipse.bpmn2.StartEvent) {				
				StartEvent bpmnStartEvent = (StartEvent) possibleFlowElement;
				
				ParsedBPMNNodeStartEvent startEvent = new ParsedBPMNNodeStartEvent("bpmn2:startEvent", "");
				startEvent.setId(bpmnStartEvent.getId());
				startEvent.setOutgoing(bpmnStartEvent.getOutgoing().get(0).getId());
				
				parsedBPMNModel.add(startEvent);
				
			} else if (possibleFlowElement instanceof org.eclipse.bpmn2.Task) {
				Task bpmnTask = (Task) possibleFlowElement;
				
				ParsedBPMNNodeTask task = new ParsedBPMNNodeTask("bpmn2:task", "");
				
				TaskConfig taskConfig = (TaskConfig) bpmnTask.getExtensionValues().get(0).getValue().get(0).getValue();
				String accesibilityLabelValue = taskConfig.getParameters().get(0).getValue();
				String KifActionValue = taskConfig.getParameters().get(1).getValue();
				
				System.out.println(bpmnTask.getAnyAttribute());
				
				String taskType = bpmnTask.getAnyAttribute().get(0).getValue().toString();
				
				task.setAccVal(accesibilityLabelValue);
				task.setKIFval(KifActionValue);
				task.setId(bpmnTask.getId());
				task.setIncoming(bpmnTask.getIncoming().get(0).getId());
				task.setOutgoing(bpmnTask.getOutgoing().get(0).getId());
				task.setType(taskType);
				task.setName2(bpmnTask.getName());
				
				parsedBPMNModel.add(task);
							
			} else if (possibleFlowElement instanceof org.eclipse.bpmn2.SequenceFlow) {
				SequenceFlow bpmnSequenceFlow = (SequenceFlow) possibleFlowElement;
				
				ParsedBPMNNodeSequenceFlow sequenceFlow = new ParsedBPMNNodeSequenceFlow("bpmn2:sequenceFlow", "");
				
				sequenceFlow.setId(bpmnSequenceFlow.getId());
				sequenceFlow.setName2(bpmnSequenceFlow.getName());
				sequenceFlow.setSourceRef(bpmnSequenceFlow.getSourceRef().getId());
				sequenceFlow.setTargetRef(bpmnSequenceFlow.getTargetRef().getId());
				
				parsedBPMNModel.add(sequenceFlow);
				
			} else if (possibleFlowElement instanceof org.eclipse.bpmn2.InclusiveGateway) {
				InclusiveGateway bpmnInclusiveGateway = (InclusiveGateway) possibleFlowElement;
				
				ParsedBPMNNodeInclusiveGateway inclusiveGateway = new ParsedBPMNNodeInclusiveGateway("bpmn2:inclusiveGateway", "");
				
				List<SequenceFlow> outgoings = bpmnInclusiveGateway.getOutgoing();
				ArrayList<String> outgoingIds = new ArrayList<String>();
				
				for (int i = 0; i < outgoings.size(); i++) {
					outgoingIds.add(outgoings.get(i).getId());
				}
				
				inclusiveGateway.setId(bpmnInclusiveGateway.getId());
				inclusiveGateway.setIncoming(bpmnInclusiveGateway.getIncoming().get(0).getId());
				inclusiveGateway.setName2(bpmnInclusiveGateway.getName());
				inclusiveGateway.setOutgoings(outgoingIds);
				inclusiveGateway.setGatewayDirection(bpmnInclusiveGateway.getGatewayDirection().toString());
				
				parsedBPMNModel.add(inclusiveGateway);
				
			} else if (possibleFlowElement instanceof org.eclipse.bpmn2.ExclusiveGateway) {
				ExclusiveGateway bpmnExclusiveGateway = (ExclusiveGateway) possibleFlowElement;
				
				ParsedBPMNNodeExclusiveGateway exclusiveGateway = new ParsedBPMNNodeExclusiveGateway("bpmn2:exclusiveGateway", "");
				
				List<SequenceFlow> incomings = bpmnExclusiveGateway.getIncoming();
				ArrayList<String> incomingIds = new ArrayList<String>();
				
				for (int i = 0; i < incomings.size(); i++) {
					incomingIds.add(incomings.get(i).getId());
				}
				
				exclusiveGateway.setId(bpmnExclusiveGateway.getId());
				exclusiveGateway.setOutgoing(bpmnExclusiveGateway.getOutgoing().get(0).getId());
				exclusiveGateway.setName2(bpmnExclusiveGateway.getName());
				exclusiveGateway.setIncomings(incomingIds);
				exclusiveGateway.setGatewayDirection(bpmnExclusiveGateway.getGatewayDirection().toString());
				
				parsedBPMNModel.add(exclusiveGateway);
				
			} else {
				System.out.println("PROBLEM");
			}
		}
		
		return parsedBPMNModel;
	}
	
	// during Step #1
	private Resource getAppSettingsResource(IWorkspaceRoot root, String projectName) {
		IProject project = root.getProject(projectName);
		IFile appSettingsFile = project.getFile(new Path("appSettings.application"));
		System.out.println(appSettingsFile.getName());
		// init model
		ApplicationPackage.eINSTANCE.eClass();
		// Register the XMI resource factory for the .website extension
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("Application", new XMIResourceFactoryImpl());
	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();
	    // Get the resource
	    org.eclipse.emf.common.util.URI appSettingsURI = org.eclipse.emf.common.util.URI.createPlatformResourceURI(appSettingsFile.getFullPath().toString(), true);
	    
	    Resource appSettingsResource = resSet.getResource(appSettingsURI, true);
	    
	    return appSettingsResource;
	}
	
	// during Step #
	private IFile addFileToProject(String fileName, String projectName, String folderName, String content) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		IFolder srcGenFolder = project.getFolder(folderName);
		
		final IFile testFile2 = srcGenFolder.getFile(new Path(fileName));
		try {
			InputStream stream = new ByteArrayInputStream(content.getBytes());
			
			if (testFile2.exists()) {
				testFile2.setContents(stream, true, true, monitor);
			} else {
				testFile2.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return testFile2;
	}
	
	
}
