import java.util.*;

class Job {
  int start;
  int end; 
  int cpuLoad;

  public Job(int start, int end, int cpuLoad) {
    this.start = start;
    this.end = end;
    this.cpuLoad = cpuLoad;
  }
};

class MaximumCPULoad {
  public static int findMaxCPULoad(List<Job> jobs) {
    Collections.sort(jobs, (a,b) -> Integer.compare(a.start, b.start));

    int maxCPULoad = 0;
    int currentCPULoad = 0;
    PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a, b) -> Integer.compare(a.end, b.end));

    for (Job job : jobs) {
      while (!minHeap.isEmpty() && job.start > minHeap.peek().end) {
        currentCPULoad -= minHeap.poll().cpuLoad;
      }

      minHeap.offer(job);
      currentCPULoad += job.cpuLoad;
      maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
    }

    return maxCPULoad;
  }
}
