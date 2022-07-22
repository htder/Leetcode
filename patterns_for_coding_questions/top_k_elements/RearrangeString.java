import java.util.*;

class RearrangeString {
  public static String rearrangeString(String str) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : str.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap 
      = new PriorityQueue<Map.Entry<Character, Integer>>(
        (e1, e2) -> e2.getValue() - e1.getValue()
      );
    maxHeap.addAll(freqMap.entrySet());

    Map.Entry<Character, Integer> previousEntry = null;
    StringBuilder result = new StringBuilder(str.length());
    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
      if (previousEntry != null && previousEntry.getValue() > 0) {
        maxHeap.offer(previousEntry);
      }
      result.append(currentEntry.getKey());
      currentEntry.setValue(currentEntry.getValue() - 1);
      previousEntry = currentEntry;
    }
    return result.length() == str.length() ? result.toString() : "";
  }
}
