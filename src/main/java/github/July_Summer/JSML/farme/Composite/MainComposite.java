package github.July_Summer.JSML.farme.composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.GCData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import github.July_Summer.JSML.farme.ImageManager;
import github.July_Summer.JSML.farme.MainFarme;
import github.July_Summer.JSML.farme.util.FarmeUtil;
import github.July_Summer.JSML.thread.FarmeThread.FarmeThread;

public class MainComposite {

	public static Composite mainComposite = new Composite(MainFarme.shell, SWT.NONE);
	public static Label label_launcher = new Label(mainComposite, SWT.NONE);
	
	public static void initComposite() {
		
		mainComposite.setLocation(0, 32);
		mainComposite.setSize(754, 424);
		mainComposite.setBackgroundImage(ImageManager.backgroundImage);
		
		label_launcher.setLocation(0, 350);
		label_launcher.setSize(0, 56);
		mainComposite.setBackgroundMode(SWT.TRANSPARENT);
		
		FarmeThread.builder(() -> {
			MainFarme.display.asyncExec(() -> {
				FarmeUtil.leftMove(label_launcher, 575, 160, 1);
			});
		}).exec();
		
		InfoComposite.initComposite();
	}
	
	
}
