import java.util.*;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int distFromOrigin() {
    return (x * x) + (y * y);
  }
}

class KClosestPointsToOrigin {
  public static List<Point> findClosestPoints(Point[] points, int k) {
    PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(
      (p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin()
    );

    for (int i = 0; i < k; i++) {
      maxHeap.add(points[i]);
    }

    for (int i = k; i < points.length; i++) {
      if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
        maxHeap.poll();
        maxHeap.add(points[i]);
      }
    }

    return new ArrayList<>(maxHeap);
  }
}
