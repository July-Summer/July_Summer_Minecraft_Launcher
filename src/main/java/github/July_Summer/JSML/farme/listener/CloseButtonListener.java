package github.July_Summer.JSML.farme.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import github.July_Summer.JSML.farme.MainFarme;
import github.July_Summer.JSML.farme.composite.TrimComposite;

public class CloseButtonListener implements Listener{

	public void handleEvent(Event event) {
		if(event.type == SWT.MouseMove)
			MainFarme.shell.setCursor(new Cursor(MainFarme.display,SWT.CURSOR_HAND));
		if(event.type == SWT.FOCUSED && event.button == 1)
			MainFarme.shell.close();
		if(event.type == SWT.MouseExit)
			MainFarme.shell.setCursor(new Cursor(MainFarme.display,SWT.NONE));
		}
	
	public static void registerListener() {
		CloseButtonListener instance = getInstance();
		TrimComposite.label_close.addListener(SWT.MouseMove, instance);
		TrimComposite.label_close.addListener(SWT.MouseExit, instance);
		TrimComposite.label_close.addListener(SWT.FOCUSED, instance);
	}
	
	public static CloseButtonListener getInstance() {
		return new CloseButtonListener();
	}
}
