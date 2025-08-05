package 스택의_활용_수식의_괄호쌍_연습문제._2504;

import java.util.*;
import java.io.*;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int answer = 0;

  public static void main(String[] args) throws IOException {
      String s = br.readLine();
      int res = 1;
      boolean isValid = true;
      Stack<Character> st = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c == '(') {
              st.push(c);
              res *= 2;
          }
          else if (c == '[') {
              st.push(c);
              res *= 3;
          }
          else if (c == ']') {
              if (st.isEmpty() || st.peek() != '[') {
                  isValid = false;
                  break;
              }
              if (s.charAt(i-1) == '[') {
                  answer += res;
              }
              st.pop();
              res /= 3;
          }
          else if (c == ')') {
              if (st.isEmpty() || st.peek() != '(') {
                  isValid = false;
                  break;
              }
              if (s.charAt(i-1) == '(') answer += res;
              st.pop();
              res /= 2;
          }
      }
      if (!st.isEmpty()) isValid = false;
      if (!isValid) answer = 0;
      System.out.print(answer);

  }
}
