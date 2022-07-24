import java.util.*;

class TaskScheduler {
  public static int scheduleTasks(char[] tasks, int k) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : tasks) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    int result = 0;
    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = 
      new PriorityQueue<Map.Entry<Character, Integer>>(
        (e1, e2) -> e2.getValue() - e1.getValue()
      );
    maxHeap.addAll(freqMap.entrySet());

    while (!maxHeap.isEmpty()) {
      List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
      int n = k + 1;
      for (; n > 0 && !maxHeap.isEmpty(); n--) {
        result++;
        Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
        if (currentEntry.getValue() > 1) {
          currentEntry.setValue(currentEntry.getValue() - 1);
          waitList.add(currentEntry);
        }
      }
      maxHeap.addAll(waitList);
      if (!maxHeap.isEmpty()) {
        result += n;
      }
    } 

    return result;
  }
}
