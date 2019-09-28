package github.July_Summer.JSML.thread.FarmeThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import github.July_Summer.JSML.thread.ThreadManager;

public class FarmeThread {
	
	private int taskId = -1;
	private boolean success;
	private Runnable runnable = () -> {};
	private Runnable successRunnable = () -> {};
	private Future<?> future;
	//don't mind
	private Future<?> fucker;
	public static ExecutorService whileExecutors = Executors.newFixedThreadPool(10);
	
	public FarmeThread(Runnable runnable) {
		this.runnable = runnable;
		this.taskId = ThreadManager.createNewTaskId();
	}
	
	public static FarmeThread builder(Runnable runnable) {
		return new FarmeThread(runnable);
	}
	
	public FarmeThread successRunnable(Runnable successRunnable) {
		this.successRunnable = successRunnable;
		return this;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public void exec() {
		this.future = ThreadManager.farmeExecutors.submit(runnable);
	    fucker = FarmeThread.whileExecutors.submit(() -> {
			while(!future.isDone());
			success();
		});
	}
	
	public Future<?> getFuture() {
		return this.future;
	}
	
	public void success() {
		this.success = true;
		//successRunnable.run();
	}
	
	public boolean isSuccess() {
		return success;
	}
}
