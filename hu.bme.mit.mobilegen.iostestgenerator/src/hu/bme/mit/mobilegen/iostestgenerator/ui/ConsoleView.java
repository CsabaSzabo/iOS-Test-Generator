package hu.bme.mit.mobilegen.iostestgenerator.ui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.ui.part.ViewPart;

public class ConsoleView extends ViewPart {
	Label label;
	
    public ConsoleView() {
    }
    
    public void createPartControl(Composite parent) {
       label = new Label(parent, SWT.WRAP);
       label.setText("TODO");
    }
    
    public void setFocus() {
       // set focus to my widget.  For a label, this doesn't
       // make much sense, but for more complex sets of widgets
       // you would decide which one gets the focus.
    }
    
    /*public void dispose() {
    	// when the view or editor is closed
    }*/
}
