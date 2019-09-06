package github.July_Summer.JSML.farme.Composite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import github.July_Summer.JSML.farme.ImageManager;
import github.July_Summer.JSML.farme.MainFarme;
import github.July_Summer.JSML.farme.listener.CloseButtonListener;
import github.July_Summer.JSML.farme.listener.CompositeListener;
import github.July_Summer.JSML.farme.listener.HideListener;

public class TrimComposite {

	public static Composite trimComposite = new Composite(MainFarme.shell, SWT.NO_TRIM);
	public static Label label_title = new Label(trimComposite, SWT.NONE);
	public static Label label_mainIcon = new Label(trimComposite, SWT.NONE);
	public static Label label_close = new Label(trimComposite, SWT.NONE);
	public static Label label_hide = new Label(trimComposite, SWT.NONE);
	
	public static void initComposite() {
		trimComposite.setSize(754, 32);
		trimComposite.setLocation(0, 0);
		trimComposite.setBackground(MainFarme.color);
		CompositeListener.registerListener();
		
		label_title.setLocation(38, 3);
		label_title.setSize(656, 32);
		label_title.setText(MainFarme.TITLE);
		label_title.setFont(new Font(MainFarme.display, "ËÎÌו", 16, SWT.None));
	    label_title.setForeground(new Color(MainFarme.display, 240, 255 ,255));
		label_title.setBackground(MainFarme.color);
		
		label_mainIcon.setLocation(0, 0);
		label_mainIcon.setSize(32, 32);
		label_mainIcon.setImage(ImageManager.mainIcon);
		label_mainIcon.setBackground(MainFarme.color);
	
		label_close.setLocation(720, 0);
		label_close.setSize(32, 32);
		label_close.setBackground(MainFarme.color);
		label_close.setImage(ImageManager.close);
		CloseButtonListener.registerListener();
		
		label_hide.setLocation(688, -10);
		label_hide.setSize(32, 32);
		label_hide.setBackground(MainFarme.color);
		label_hide.setForeground(new Color(MainFarme.display, 76, 100, 111));
		label_hide.setText("-");
		label_hide.setFont(new Font(MainFarme.display, "ËÎÌו", 38, SWT.None));
		HideListener.registerListener();
	}
	
}
