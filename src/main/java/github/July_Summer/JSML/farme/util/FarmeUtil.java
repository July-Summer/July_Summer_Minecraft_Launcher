package github.July_Summer.JSML.farme.util;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import github.July_Summer.JSML.farme.MainFarme;
import github.July_Summer.JSML.thread.FarmeThread.FarmeThread;

public class FarmeUtil {
	

	/**
	 * Button left
	 * @param label_launcher
	 * @param size
	 * @param width
	 * @param speed
	 */
	public static void leftMove(Label label_launcher, int x,  int width, int speed) {
		FarmeThread.builder(new Runnable() {
			private int startWidth = 0;
			
			@Override
			public void run() {
				while (startWidth <= width) {
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MainFarme.display.syncExec(() -> {
						if(label_launcher.isDisposed())
							return;
						
						label_launcher.setSize(++startWidth, label_launcher.getSize().y);
						label_launcher.setLocation(x + width - startWidth, label_launcher.getLocation().y);  
					});
				}
			}
			
		}).exec();
	}
	
	/**
	 * composite left
	 * @param composite
	 * @param widths
	 * @param speed
	 */
	public static void disappearLeft(Composite composite, int widths, int speed) {
		FarmeThread.builder(new Runnable() {
		
			private int width = widths;
			
			@Override
			public void run() {
				while (width > 0) {
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
					MainFarme.display.syncExec(() -> {
						if(composite.isDisposed())
							return;
						
						composite.setSize(--width, composite.getSize().y);
						
					});
				}
			}
		}).exec();
	}
	
	/**
	 * composite right
	 * @param composite
	 * @param width
	 * @param speed
	 */
	public static void disappearRight(Composite composite, int width, int speed) {
		final int startX = composite.getLocation().x;
		FarmeThread.builder(new Runnable() {
			private int startWidth = 0;
			
			@Override
			public void run() {
				while (startWidth <= width) {
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
					MainFarme.display.syncExec(() -> {
						if(composite.isDisposed())
							return;
						
						composite.setSize(++startWidth, composite.getSize().y);
					});
				}
			}
		}).exec();
		
	}
	
}
