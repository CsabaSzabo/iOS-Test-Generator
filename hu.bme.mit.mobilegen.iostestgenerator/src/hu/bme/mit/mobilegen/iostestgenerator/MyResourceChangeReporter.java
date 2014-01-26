package hu.bme.mit.mobilegen.iostestgenerator;

import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.*;

public class MyResourceChangeReporter implements IResourceChangeListener {

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			IResource res = event.getResource();
	        switch (event.getType()) {
	           case IResourceChangeEvent.PRE_CLOSE:
	              System.out.print("Project ");
	              System.out.print(res.getFullPath());
	              System.out.println(" is about to close.");
	              break;
	           case IResourceChangeEvent.PRE_DELETE:
	              System.out.print("Project ");
	              System.out.print(res.getFullPath());
	              System.out.println(" is about to be deleted.");
	              break;
	           case IResourceChangeEvent.POST_CHANGE:
	              System.out.println("Resources have changed.");
	              //event.getDelta().accept(new DeltaPrinter());
	              break;
	           case IResourceChangeEvent.PRE_BUILD:
	              System.out.println("Build about to run.");
	              //event.getDelta().accept(new DeltaPrinter());
	              break;
	           case IResourceChangeEvent.POST_BUILD:
	              System.out.println("Build complete.");
	              event.getDelta().accept(new DeltaPrinter());
	              break;
	        }
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
