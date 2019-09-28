package github.July_Summer.JSML.farme.composite;

import java.io.ObjectStreamClass;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.internal.win32.TCHAR;
import org.eclipse.swt.widgets.Composite;

import github.July_Summer.JSML.farme.ImageManager;
import github.July_Summer.JSML.farme.MainFarme;
import github.July_Summer.JSML.farme.util.FarmeUtil;
import github.July_Summer.JSML.thread.FarmeThread.FarmeThread;

public class InfoComposite {

	public static Composite infoComposite = new Composite(MainComposite.mainComposite, SWT.NONE);
	public static Image backgroundImage = null;
	public static boolean flag = false;
	
	public static void initComposite() {
		infoComposite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		infoComposite.setLocation(0, 0);
		infoComposite.setSize(0, 424);
		infoComposite.setBackgroundImage(backgroundImage);

		FarmeThread.builder(() -> {
			Image image = ImageManager.blur(ImageManager.backgroundImage, 10);

	    	MainFarme.display.asyncExec(() -> {
	    		infoComposite.setBackgroundImage(image);
	        	FarmeUtil.disappearRight(infoComposite, 200, 1);
	    	});
	    	
		}
	    	).successRunnable(() -> {
	    		infoComposite.getBackgroundImage().getImageData().alpha = 2;
	    		System.out.print(infoComposite.getBackgroundImage().getImageData().alpha);
	    	}).exec();
	    
	}

}
