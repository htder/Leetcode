import java.util.*;

class Program {

  public int tandemBicycle(
    int[] redShirtSpeeds,
    int[] blueShirtSpeeds,
    boolean fastest
  ) {
    // sort both arrays in place.
    Arrays.sort(redShirtSpeeds);
    Arrays.sort(blueShirtSpeeds);

    int speed = 0;
    for (int i = 0; i < redShirtSpeeds.length; i++) {
      // if we want to fastest option, we will use 
      // this to traverse blueShirtSpeeds backwards.
      int blueIndex = blueShirtSpeeds.length - 1 - i;
      if (fastest) {
        // if we want the fastest option, pair the
        // slowest redShirtSpeeds item with the
        // fastest blueShirtSpeeds item.
        speed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[blueIndex]);
      } else {
        // if we want the slowest option, pair the
        // slowest redShirtSpeeds item and the 
        // slowest blueShirtSpeeds item.
        speed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
      }
    }
    return speed;
  }
}
