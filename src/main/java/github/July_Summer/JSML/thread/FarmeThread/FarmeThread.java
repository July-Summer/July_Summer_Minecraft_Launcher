package github.July_Summer.JSML.thread.FarmeThread;

import java.util.concurrent.Future;

import github.July_Summer.JSML.thread.ThreadManager;

public class FarmeThread {
	
	private int taskId = -1;
	private boolean success;
	private Runnable runnable;
	
	public FarmeThread(Runnable runnable) {
		this.runnable = runnable;
	}
	
	public static FarmeThread builder(Runnable runnable) {
		return new FarmeThread(runnable);
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public void exec() {
		Future<?> a = ThreadManager.farmeExecutors.submit(runnable);
		ThreadManager.farmeExecutors.execute(() -> {
			while(!a.isDone());
			success();
		});
	}
	
	public void success() {
		this.success = true;
	}
	
	public boolean isSuccess() {
		return success;
	}
}
