import java.util.*;

class FrequencySort {
  public static String sortCharacterByFrequency(String str) {
    Map<Character, Integer> freqMap = new HashMap<>();
    PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
      new PriorityQueue<Map.Entry<Character, Integer>>(
        (e1, e2) -> e2.getValue() - e1.getValue()
      );
    for (char c : str.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }
    
    maxHeap.addAll(freqMap.entrySet());

    StringBuilder sortedString = new StringBuilder(str.length());
    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> entry = maxHeap.poll();
      for (int i = 0; i < entry.getValue(); i++) {
        sortedString.append(entry.getKey());
      }
    }
    return sortedString.toString();
  }
}
