import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
class Job{
    int start;
    int end;
    int cpuLoad;

    public Job(int start,int end,int cpuLoad){
        this.start=start;
        this.end=end;
        this.cpuLoad=cpuLoad;
    }
}

public class MaxCPULoad {
    
    public static int findMaxCPULoad(List<Job> jobs)
  {
    
    // sort the jobs by start time
    Collections.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));

    int maxCPULoad = 0;
    int currentCPULoad = 0;
    PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), 
                                                     (a, b) -> Integer.compare(a.end, b.end));
    for (Job job : jobs) {
      // remove all jobs that have ended
      while (!minHeap.isEmpty() && job.start > minHeap.peek().end)
        currentCPULoad -= minHeap.poll().cpuLoad;

      // add the current job into the minHeap
      minHeap.offer(job);
      currentCPULoad += job.cpuLoad;
      maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
    }
    return maxCPULoad;
  }
}
