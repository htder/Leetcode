import java.util.*;

class Program {

  public boolean classPhotos(
    ArrayList<Integer> redShirtHeights,
    ArrayList<Integer> blueShirtHeights
  ) {
    // sort both arrays so each index
    // can be easily compared.
    Collections.sort(redShirtHeights);
    Collections.sort(blueShirtHeights);
    // decide which shirt is going at
    // the back.
    boolean isRedBack = redShirtHeights.get(0) > blueShirtHeights.get(0);
    for (int i = 0; i < redShirtHeights.size(); i++) {
      int redHeight = redShirtHeights.get(i);
      int blueHeight = blueShirtHeights.get(i);
      // if red should go at the back make sure
      // that current red is taller than current
      // blue. if not return false.
      if (isRedBack && !(redHeight > blueHeight)) {
        return false;
      // if blue should go at the back make sure
      // that current blue is taller than current
      // red. if not return false.
      } else if (!isRedBack && !(redHeight < blueHeight)) {
        return false;
      }
    }
    return true;
  }
}
