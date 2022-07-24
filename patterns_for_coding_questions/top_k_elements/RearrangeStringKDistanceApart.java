import java.util.*;

class RearrangeStringKDistanceApart {
  public static String reorganizeString(String str, int k) {
    if (k <= 1) {
      return str;
    }

    Map<Character, Integer> freqMap = new HashMap<>();
    for (char chr : str.toCharArray()) {
      freqMap.put(chr, freqMap.getOrDefault(chr, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
      new PriorityQueue<Map.Entry<Character, Integer>>(
        (e1, e2) -> e2.getValue() - e1.getValue()
      );

    maxHeap.addAll(freqMap.entrySet());

    Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
    StringBuilder result = new StringBuilder(str.length());
    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
      result.append(currentEntry.getKey());
      currentEntry.setValue(currentEntry.getValue() - 1);
      queue.offer(currentEntry);
      if (queue.size() == k) {
        Map.Entry<Character, Integer> entry = queue.poll();
        if (entry.getValue() > 0) {
          maxHeap.add(entry);
        }
      }
    } 

    return result.length() == str.length() ? result.toString() : "";
  }
}
