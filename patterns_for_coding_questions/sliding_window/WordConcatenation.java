import java.util.*;

class WordConcatenation {
  public static List<Integer> findWordConcatenation(String str, String[] words) {
    List<Integer> resultIndices = new ArrayList<Integer>();

    Map<String, Integer> wordFreqMap = new HashMap<>();
    for (String word : words) {
      wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
    }

    int wordsCount = words.length;
    int wordLength = words[0].length();

    for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
      Map<String, Integer> wordsSeen = new HashMap<>();
      for (int j = 0; j < wordsCount; j++) {
        int nextWordIndex = i + j * wordLength;
        String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
        if (!wordFreqMap.containsKey(word)) {
          break;
        }

        wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

        if (wordsSeen.get(word) > wordFreqMap.getOrDefault(word, 0)) {
          break;
        }

        if (j + 1 == wordsCount) {
          resultIndices.add(i);
        }
      }
    }

    return resultIndices;
  }
}
