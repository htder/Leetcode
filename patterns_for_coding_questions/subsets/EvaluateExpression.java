import java.util.*;

class EvaluateExpression {
  public static List<Integer> diffWaysToEvaluateExpression(String input) {
    List<Integer> result = new ArrayList<>();
    if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
      result.add(Integer.parseInt(input));
    } else {
      for (int i = 0; i < input.length(); i++) {
        char chr = input.charAt(i);
        if (!Character.isDigit(chr)) {
          List<Integer> left = diffWaysToEvaluateExpression(input.substring(0, i));
          List<Integer> right = diffWaysToEvaluateExpression(input.substring(i + 1));
          for (int part1 : left) {
            for (int part2 : right) {
              if (chr == '+') {
                result.add(part1 + part2);
              } else if (chr == '-') {
                result.add(part1 - part2);
              } else if (chr == '*') {
                result.add(part1 * part2);
              }
            }
          }
        }
      }
    }
    return result;
  }
}
