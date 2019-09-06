package github.July_Summer.JSML.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {

	public static List<Integer> taskIdList = new ArrayList<>();
	public static ExecutorService farmeExecutors = Executors.newFixedThreadPool(10);
	
	public static int createNewTaskId() {
		taskIdList.add(taskIdList.size() + 1);
		return taskIdList.size() + 1;
	}
	
	
}
