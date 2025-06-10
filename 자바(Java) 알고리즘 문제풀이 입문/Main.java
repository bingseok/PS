import java.util.*;

class Main {
    public String solution(String str) {
        String[] strArray = str.split(" ");
        String answer = strArray[0];
        for (int i = 1; i < strArray.length; i++) {
            if (strArray[i].length() > answer.length()) answer = strArray[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}