package 스택._10828;

import java.io.*;

public class Main {

    /**
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push"))
                st.push(Integer.parseInt(cmd[1]));
            else if (cmd[0].equals("pop")) {
                if (st.empty()) answer.append(-1).append("\n");
                else {
                    answer.append(st.peek()).append("\n");
                    st.pop();
                }
            }
            else if (cmd[0].equals("size"))
                answer.append(st.size()).append("\n");
            else if (cmd[0].equals("empty")) {
                if (st.empty()) answer.append(1).append("\n");
                else answer.append(0).append("\n");
            }
            else {
                if (st.empty()) answer.append(-1).append("\n");
                else answer.append(st.peek()).append("\n");
            }
        }

        System.out.print(answer);
    }
     **
     */

    static final int MX = 10005;
    static int[] dat = new int[MX];
    static int pos = 0;
    static void push(int x) {
        dat[pos++] =x ;
    }
    static void pop() {
        pos--;
    }
    static int size() {
        return pos;
    }
    static int empty() {
        return pos == 0 ? 1 : 0;
    }
    static int top() {
        return pos == 0 ? -1 : dat[pos-1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push")) {
                push(Integer.parseInt(cmd.split(" ")[1]));
            }
            else if (cmd.equals("pop")) {
                if (empty() == 1) answer.append(-1).append("\n");
                else {
                    answer.append(top()).append("\n");
                    pop();
                }
            }
            else if (cmd.equals("size")) {
                answer.append(size()).append("\n");
            }
            else if (cmd.equals("empty"))
                answer.append(empty()).append("\n");
            else if (cmd.equals("top"))
                if (empty() == 1) answer.append(-1).append("\n");
                else answer.append(top()).append("\n");
        }

        System.out.print(answer);
    }
}
