package github.July_Summer.JSML.farme.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import github.July_Summer.JSML.farme.MainFarme;
import github.July_Summer.JSML.farme.Composite.InfoComposite;
import github.July_Summer.JSML.farme.Composite.TrimComposite;
import github.July_Summer.JSML.farme.util.FarmeUtil;


public class CompositeListener implements Listener{

	private int startX, startY;

	public void handleEvent(Event event) {
		if(event.type == SWT.MouseDown  && event.button == 1) {
			startX = event.x;
			startY = event.y;
		}
		if(event.type == SWT.MouseMove && (event.stateMask & SWT.BUTTON1) != 0) {
		    Point p = MainFarme.shell.toDisplay(event.x, event.y);  
	        p.x -= startX;  
	        p.y -= startY;
	        MainFarme.shell.setLocation(p);
		}
	}
	
	public static void registerListener() {
		CompositeListener instance = getInstance();
		TrimComposite.label_close.addListener(SWT.MouseDown, instance);
		TrimComposite.label_close.addListener(SWT.MouseMove, instance);
		TrimComposite.label_title.addListener(SWT.MouseDown, instance);
		TrimComposite.label_title.addListener(SWT.MouseMove, instance);
	}
	
	public static CompositeListener getInstance() {
		return new CompositeListener();
	}
	
}
