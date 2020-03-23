import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toCollection;

class Solution {

	private static final int WORK_MAX_PROGRESS = 100;

	public int[] solution(int[] progresses, int[] speeds) {
        
		List<Integer> completeCount = new ArrayList<>();
        int partialCompleteCount = 0;
        
		Queue<Work> workQueue = generateWorkQueue(progresses, speeds);

		while (!workQueue.isEmpty()) {
			workQueue = workQueue.stream()
				.peek(work -> work.progress = work.progress + work.speed)
				.collect(toCollection(LinkedList::new));
            
            partialCompleteCount = 0;
            
            while (nonNull(workQueue.peek()) && workQueue.peek().progress > WORK_MAX_PROGRESS) {
                workQueue.remove();
                partialCompleteCount++;
            }
            
            if (partialCompleteCount > 0) {
                completeCount.add(partialCompleteCount);
            }
		}

		return completeCount.stream().mapToInt(Integer::intValue).toArray();
	}

	private Queue<Work> generateWorkQueue(int[] progresses, int[] speeds) {
		Queue<Work> workQueue = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			workQueue.add(new Work(progresses[i], speeds[i]));
		}

		return workQueue;
	}
}

class Work {
    
	int progress;
	int speed;

	Work(int progress, int speed) {
		this.progress = progress;
		this.speed = speed;
	}
}