package github.July_Summer.JSML.farme.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import github.July_Summer.JSML.farme.MainFarme;
import github.July_Summer.JSML.farme.Composite.TrimComposite;

public class HideListener implements Listener{

	public void handleEvent(Event event) {
		if(event.type == SWT.MouseMove)
			MainFarme.shell.setCursor(new Cursor(MainFarme.display,SWT.CURSOR_HAND));
		if(event.type == SWT.FOCUSED && event.button == 1)
			MainFarme.shell.setMinimized(true);
		if(event.type == SWT.MouseExit)
			MainFarme.shell.setCursor(new Cursor(MainFarme.display,SWT.NONE));
	}

	public static void registerListener() {
		HideListener instance = getInstance();
		TrimComposite.label_hide.addListener(SWT.MouseMove, instance);
		TrimComposite.label_hide.addListener(SWT.MouseExit, instance);
		TrimComposite.label_hide.addListener(SWT.FOCUSED, instance);
	}
	
	public static HideListener getInstance() {
		return new HideListener();
	}
	
}
