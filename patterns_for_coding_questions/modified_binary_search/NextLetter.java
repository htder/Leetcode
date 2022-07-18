class NextLetter {
  public static char searchNextLetter(char[] letters, char key) {
    int start = 0;
    int end = letters.length - 1; 
    while (start <= end) {
      int middle = start + (end - start) / 2;
      if (key < letters[middle]) {
        end = middle - 1;
      } else {
        start = middle + 1;
      }
    }
    return letters[start % letters.length];
  }
}
