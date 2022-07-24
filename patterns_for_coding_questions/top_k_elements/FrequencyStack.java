import java.util.*;

class Data {
  int value;
  int count;
  int sequence;

  public Data(int value, int count, int sequence) {
    this.value = value;
    this.count = count;
    this.sequence = sequence;
  }
}

class DataComparator implements Comparator<Data> {
  public int compare(Data d1, Data d2) {
    if (d1.count != d2.count) {
      return d2.count - d1.count;
    }
    return d2.sequence - d1.sequence;
  }
}

class FrequencyStack {
  int sequence = 0;
  PriorityQueue<Data> maxHeap = new PriorityQueue<Data>(new DataComparator());
  Map<Integer, Integer> freqMap = new HashMap<>();

  public void push(int num) {
    freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    maxHeap.add(new Data(num, freqMap.get(num), sequence++));
  }

  public int pop() {
    int value = maxHeap.poll().value;

    if (freqMap.get(value) > 1) {
      freqMap.put(value, freqMap.get(value) - 1);
    } else {
      freqMap.remove(value);
    } 

    return value;
  }
}
