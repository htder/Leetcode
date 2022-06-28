import java.util.*;

class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

class MinimumMeetingRooms {
  public static int findMinimumMeetingRooms(List<Meeting> meetings) {
    if (meetings == null || meetings.size() == 0) {
      return 0;
    }

    Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

    int minRooms = 0;
    PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));
    for (Meeting meeting : meetings) {
      while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
        minHeap.poll();
      }
      minHeap.offer(meeting);
      minRooms = Math.max(minRooms, minHeap.size());
    }
    return minRooms;
  }
}
