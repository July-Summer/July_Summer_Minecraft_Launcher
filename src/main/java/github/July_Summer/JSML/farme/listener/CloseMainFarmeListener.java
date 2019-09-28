package github.July_Summer.JSML.farme.listener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import github.July_Summer.JSML.farme.MainFarme;
import github.July_Summer.JSML.farme.composite.InfoComposite;
import github.July_Summer.JSML.thread.ThreadManager;
import github.July_Summer.JSML.thread.FarmeThread.FarmeThread;

public class CloseMainFarmeListener implements ShellListener{

	@Override
	public void shellClosed(ShellEvent arg0) {
		ThreadManager.farmeExecutors.shutdown();
		FarmeThread.whileExecutors.shutdown();
	}
	
	@Override
	public void shellActivated(ShellEvent arg0) {}

	@Override
	public void shellDeactivated(ShellEvent arg0) {}

	@Override
	public void shellDeiconified(ShellEvent arg0) {}

	@Override
	public void shellIconified(ShellEvent arg0) {}
	
	public static void registerListener() {
		CloseMainFarmeListener instance = getInstance();
		MainFarme.shell.addShellListener(instance);
	}
	
	public static CloseMainFarmeListener getInstance() {
		return new CloseMainFarmeListener();
	}

	
}
