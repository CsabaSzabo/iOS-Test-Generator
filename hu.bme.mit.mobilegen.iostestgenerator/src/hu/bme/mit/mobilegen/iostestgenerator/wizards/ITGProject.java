package hu.bme.mit.mobilegen.iostestgenerator.wizards;

import java.awt.List;
import java.awt.Window;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;

import java.io.*;

import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.menus.UIElement;

import hu.bme.mit.mobilegen.iostestgenerator.model.application.Application;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.ApplicationFactory;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.UIElements;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationImpl;
import hu.bme.mit.mobilegen.iostestgenerator.model.application.impl.ApplicationPackageImpl;
import hu.bme.mit.mobilegen.iostestgenerator.wizards.*;

public class ITGProject extends Wizard implements INewWizard {

	private ITGProjectPage page;
	private ISelection selection;
	
	private String testFolderPath;

	/**
	 * Constructor for SampleNewWizard.
	 */
	public ITGProject() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new ITGProjectPage(selection);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final String projectName = page.getProjectNameText();
		final String xcodeTestFolder = page.getXcodeTestFolder();
		
		final String storyboardText;
		if (page.getStoryboardText() == null) {
			storyboardText = "";
		} else {
			storyboardText = page.getStoryboardText();
		}
		
		testFolderPath = page.getXcodeTestFolder();
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(projectName, xcodeTestFolder, storyboardText, monitor);
					
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		
//		IViewReference[] viewRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
//		for (IViewReference viewRef : viewRefs) {
//			System.out.println(viewRef.getPartName());
// 			System.out.println(viewRef.getContentDescription());
// 			System.out.println(viewRef.getClass());
//		}
				
//		try {
//			// open model folder
//			IProject createdProject = ResourcesPlugin.getWorkspace().getRoot().getProject(page.getProjectNameText());
//			System.out.println(createdProject.getName());
//			IFolder modelFolder = createdProject.getFolder("model");
//			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
//			IViewPart projectExplorer = window.getActivePage().showView("org.eclipse.jdt.ui.ProjectExplorer");
//			
//			projectExplorer.getSite().getSelectionProvider().setSelection( new StructuredSelection( createdProject ) );
//			
//		} catch (PartInitException e) {
//			e.printStackTrace();
//		}
		

//		Object[] projectsToSelect = openProjects.toArray();
//		IViewPart view = window.getActivePage().showView( "org.eclipse.jdt.ui.PackageExplorer" );
//		view.getSite().getSelectionProvider().setSelection( new StructuredSelection( projectsToSelect ) );
		
		return true;
	}
	
	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 */

	private void doFinish(String projectName, String xcodeTestFolder, String storyboardText, IProgressMonitor monitor) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
		// added
		IProject project = root.getProject(projectName);
		IFolder modelFolder = null;
		try {
			project.create(monitor);
			project.open(monitor);
			
			modelFolder = project.getFolder("model");
			modelFolder.create(true, true, monitor);
			
	        IFolder srcGenFolder = project.getFolder("src-gen");
	        srcGenFolder.create(true, true, monitor);
	        
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		// create model.bpmn template file
		String fileName = "model.bpmn";
		monitor.beginTask("Creating " + fileName, 2);
		final IFile file = modelFolder.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
		
//		// create config.txt file
//		String configFileName = "ITGConfig.txt";
//		monitor.beginTask("Creating " + configFileName, 2);
//		final IFile configFile = project.getFile(new Path(configFileName));
//		try {
//			InputStream stream = openConfigFileContentStream();
//			if (configFile.exists()) {
//				configFile.setContents(stream, true, true, monitor);
//			} else {
//				configFile.create(stream, true, monitor);
//			}
//			stream.close();
//		} catch (IOException e) {
//		}
//		monitor.worked(1);
		
		
		
		// create appSettings.application file
		String appSettingsFileName = "appSettings.application";
		monitor.beginTask("Creating " + appSettingsFileName, 2);
		final IFile appSettingsFile = project.getFile(new Path(appSettingsFileName));
		try {
			InputStream stream = openAppSettingsFileContentStream();
			if (appSettingsFile.exists()) {
				appSettingsFile.setContents(stream, true, true, monitor);
			} else {
				appSettingsFile.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		
		
//		ApplicationPackageImpl.init();
//		ApplicationFactory factory = ApplicationFactory.eINSTANCE;
//		
//		Application app = factory.createApplication();
//		app.setXcodeTestFolder("fill this");
//		
//		UIElements el = factory.createUIElements();
//		el.setAccessibilityLabel("xxxxxx");
//		
//		app.getUielements().add(el);
		
	}
	
	private InputStream openConfigFileContentStream() {
		String content = "Xcode_Test_Project_Folder=" + testFolderPath;
		//String content = "";
		return new ByteArrayInputStream(content.getBytes());
	}
	
	private InputStream openAppSettingsFileContentStream() {
		String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
				"<application:Application xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:application=\"http://application/1.0\"/>\n" + 
				"";

		return new ByteArrayInputStream(content.getBytes());
	}
	
	/**
	 * We will initialize file contents with a sample text.
	 */
	private InputStream openContentStream() {
		
		// sample basic .bpmn diagram
		String contents =
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
			"<bpmn2:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" id=\"Definitions_1\" targetNamespace=\"http://sample.bpmn2.org/bpmn2/sample/process\">\n" + 
			"  <bpmn2:process id=\"model\" name=\"Default Process\">\n" + 
			"    <bpmn2:startEvent id=\"StartEvent_1\">\n" + 
			"      <bpmn2:outgoing>SequenceFlow_1</bpmn2:outgoing>\n" + 
			"    </bpmn2:startEvent>\n" + 
			"    <bpmn2:sequenceFlow id=\"SequenceFlow_1\" sourceRef=\"StartEvent_1\" targetRef=\"EndEvent_1\"/>\n" + 
			"    <bpmn2:endEvent id=\"EndEvent_1\">\n" + 
			"      <bpmn2:incoming>SequenceFlow_1</bpmn2:incoming>\n" + 
			"    </bpmn2:endEvent>\n" + 
			"  </bpmn2:process>\n" + 
			"  <bpmndi:BPMNDiagram name=\"Default Process Diagram\">\n" + 
			"    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"model\">\n" + 
			"      <bpmndi:BPMNShape id=\"BPMNShape_1\" bpmnElement=\"StartEvent_1\">\n" + 
			"        <dc:Bounds height=\"36.0\" width=\"36.0\" x=\"100.0\" y=\"100.0\"/>\n" + 
			"      </bpmndi:BPMNShape>\n" + 
			"      <bpmndi:BPMNShape id=\"BPMNShape_2\" bpmnElement=\"EndEvent_1\">\n" + 
			"        <dc:Bounds height=\"36.0\" width=\"36.0\" x=\"500.0\" y=\"100.0\"/>\n" + 
			"      </bpmndi:BPMNShape>\n" + 
			"      <bpmndi:BPMNEdge bpmnElement=\"SequenceFlow_1\" sourceElement=\"BPMNShape_1\" targetElement=\"BPMNShape_2\">\n" + 
			"        <di:waypoint xsi:type=\"dc:Point\" x=\"136.0\" y=\"118.0\"/>\n" + 
			"        <di:waypoint xsi:type=\"dc:Point\" x=\"500.0\" y=\"118.0\"/>\n" + 
			"      </bpmndi:BPMNEdge>\n" + 
			"    </bpmndi:BPMNPlane>\n" + 
			"  </bpmndi:BPMNDiagram>\n" + 
			"</bpmn2:definitions>";
		return new ByteArrayInputStream(contents.getBytes());
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

}
