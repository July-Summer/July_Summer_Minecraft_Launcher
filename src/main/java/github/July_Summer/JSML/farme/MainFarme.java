package github.July_Summer.JSML.farme;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.DeviceData;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import github.July_Summer.JSML.farme.composite.InfoComposite;
import github.July_Summer.JSML.farme.composite.MainComposite;
import github.July_Summer.JSML.farme.composite.TrimComposite;
import github.July_Summer.JSML.farme.listener.CloseButtonListener;
import github.July_Summer.JSML.farme.listener.CloseMainFarmeListener;
import github.July_Summer.JSML.farme.listener.CompositeListener;
import github.July_Summer.JSML.farme.listener.HideListener;

public class MainFarme {

	public static Display display = Display.getDefault();
	public static Shell shell = new Shell(display, SWT.NONE);
	public static int[] size = new int[] {754, 453};
	public static int width = shell.getMonitor().getClientArea().width;
	public static int height = shell.getMonitor().getClientArea().height;
	public static Color color = new Color(display, 135, 206, 235);
	public static final String TITLE = new String("July_Summer's Minecraft Launcher");
	
	public static void loadComponent() {
		shell.setSize(size[0], size[1]);
		
		width = size[0] > width ? size[0] : width;
		height = size[1] > height ? size[1] : height;
		shell.setLocation((width - size[0]) / 2, (height - size[1]) / 2);
		CloseMainFarmeListener.registerListener();
		
		TrimComposite.initComposite();
		MainComposite.initComposite();
	}
	
	public static void init() {
		loadComponent();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
