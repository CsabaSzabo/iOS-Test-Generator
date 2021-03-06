package hu.bme.mit.mobilegen.iostestgenerator.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

import hu.bme.mit.mobilegen.iostestgenerator.wizards.ITGProjectPageBrowseType;

public class ITGProjectPage extends WizardPage {

	private Text projectNameText;	
	private Text xcodeTestFolder;
	private Text storyboardText;
	
//	private ISelection selection;

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public ITGProjectPage(ISelection selection) {
		super("wizardPage");
		setTitle("iOS Test Generator Project");
		setDescription("This wizard creates an ITG project.");
//		this.selection = selection;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		
		// Project name TextField
		Label label = new Label(container, SWT.NULL);
		label.setText("&Project name:");
		projectNameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		projectNameText.setLayoutData(gd);
		Button button = new Button(container, SWT.PUSH);
		button.setText("");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				//handleBrowse(ITGProjectPageBrowseType.XCODETESTFOLDER);
			}
		});
		
		// Xcode Test folder Browser
		label = new Label(container, SWT.NULL);
		label.setText("&Xcode test folder:");
		xcodeTestFolder = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		xcodeTestFolder.setLayoutData(gd);
		xcodeTestFolder.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleBrowse(ITGProjectPageBrowseType.XCODETESTFOLDER);
			}
		});
		
		// Storyboard file Browser
//		label = new Label(container, SWT.NULL);
//		label.setText("&Storyboard:");
//		storyboardText = new Text(container, SWT.BORDER | SWT.SINGLE);
//		
//		gd = new GridData(GridData.FILL_HORIZONTAL);
//		storyboardText.setLayoutData(gd);
//		storyboardText.addModifyListener(new ModifyListener() {
//			public void modifyText(ModifyEvent e) {
//				dialogChanged();
//			}
//		});
//		button = new Button(container, SWT.PUSH);
//		button.setText("Browse...");
//		button.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				handleBrowse(ITGProjectPageBrowseType.STORYBOARD);
//			}
//		});
				
		initialize();
		dialogChanged();
		setControl(container);
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */

	private void initialize() {
		
		// old Container seletor init
//		if (selection != null && selection.isEmpty() == false
//				&& selection instanceof IStructuredSelection) {
//			IStructuredSelection ssel = (IStructuredSelection) selection;
//			if (ssel.size() > 1)
//				return;
//			Object obj = ssel.getFirstElement();
//			if (obj instanceof IResource) {
//				IContainer container;
//				if (obj instanceof IContainer)
//					container = (IContainer) obj;
//				else
//					container = ((IResource) obj).getParent();
//				containerText.setText(container.getFullPath().toString());
//			}
//		}
		
		projectNameText.setText("New ITG project");
	}

	/**
	 * Uses the standard container selection dialog to choose the new value for
	 * the container field.
	 * @param string 
	 */

	private void handleBrowse(ITGProjectPageBrowseType type) {
		
		switch (type) {
		case XCODETESTFOLDER:
			System.out.println("TODO - ITGProjectPage - handleBrowse:XCODETESTFOLDER");
			break;
		
		case STORYBOARD:
			System.out.println("TODO - ITGProjectPage - handleBrowse::STORYBOARD");
			break;
		
		default:
			// old container selector code
//			ContainerSelectionDialog dialog = new ContainerSelectionDialog(
//					getShell(), ResourcesPlugin.getWorkspace().getRoot(), false,
//					"Select new file container");
//			if (dialog.open() == ContainerSelectionDialog.OK) {
//				Object[] result = dialog.getResult();
//				if (result.length == 1) {
//					containerText.setText(((Path) result[0]).toString());
//				}
//			}
			break;
		}
	}


	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getProjectNameText() {
		return projectNameText.getText();
	}

	public String getXcodeTestFolder() {
		return xcodeTestFolder.getText();
	}

	public String getStoryboardText() {
		
		if (storyboardText != null) {
			return storyboardText.getText();
		} else {
			return "";
		}
		
	}
	
	

}
