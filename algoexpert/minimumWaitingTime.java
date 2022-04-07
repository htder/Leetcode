// Time = O(nlog(n)), Space = O(1) 
import java.util.*;

class Program {
  
  public int minimumWaitingTime(int[] queries) {
    // sort array in place so that when looping
    // the quickest queues goes first.
    Arrays.sort(queries);

    // if there is only one item, there 
    // will be no waiting time.
    if (queries.length == 1) return 0;
    // loop from the second item in the array
    // to the second to last item.
    for (int i = 1; i < queries.length - 1; i++) {
      // add the previous value to the current.
      queries[i] += queries[i - 1];
      // add the updated current to the running
      // total.
      queries[0] += queries[i];
    }
    // return the running total.
    return queries[0];
  }

  public int minimumWaitingTime1(int[] queries) {
    // sort array in place so that when looping
    // the quickest queues goes first.
    Arrays.sort(queries);

    // variable to keep track of total time.
    int totalWaitingTime = 0;
    for (int i = 0; i < queries.length; i++) {
      // each duration will appear in the total
      // the amount of time there are items left
      // in the list from its current position.
      int duration = queries[i];
      // need to add 1 to the index to exclude 
      // the current item.
      int queriesLeft = queries.length - (i + 1);
      totalWaitingTime += duration * queriesLeft;
    }
    return totalWaitingTime;
  }
}
