package 큐._10845;

import java.util.*;
import java.io.*;

public class Main {
    static final int MX = 10005;
    static int[] dat = new int[MX];
    static int head = 0, tail = 0;

    static void push(int x) {
        dat[tail++] = x;
    }

    static void pop() {
        head++;
    }

    static int size() {
        return tail - head;
    }

    static int empty() {
        return tail==head ? 1 : 0;
    }

    static int front() {
        return dat[head];
    }

    static int back() {
        return dat[tail-1];
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder answer = new StringBuilder();
//
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            String cmd = br.readLine();
//            if (cmd.startsWith("push")) {
//                push(Integer.parseInt(cmd.split(" ")[1]));
//            }
//            else if (cmd.equals("pop")) {
//                if (empty() == 1) answer.append(-1).append("\n");
//                else {
//                    answer.append(front()).append("\n");
//                    pop();
//                }
//            }
//            else if (cmd.equals("size")) {
//                answer.append(size()).append("\n");
//            }
//            else if (cmd.equals("empty")) {
//                answer.append(empty()).append("\n");
//            }
//            else if (cmd.equals("front")) {
//                answer.append(empty() == 1 ? -1 : front()).append("\n");
//            }
//            else if (cmd.equals("back")) {
//                answer.append(empty() == 1 ? -1 : back()).append("\n");
//            }
//        }
//
//        System.out.print(answer);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            if (cmd.startsWith("push"))
                queue.add(Integer.parseInt(cmd.split(" ")[1]));
            else if (cmd.equals("pop")) {
                if (queue.isEmpty()) answer.append(-1).append("\n");
                else {
                    answer.append(queue.peek()).append("\n");
                    queue.remove();
                }
            }
            else if (cmd.equals("size"))
                answer.append(queue.size()).append("\n");
            else if (cmd.equals("empty"))
                answer.append(queue.isEmpty() ? 1 : 0).append("\n");
            else if (cmd.equals("front"))
                answer.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
            else if (cmd.equals("back"))
                answer.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
        }

        System.out.print(answer);
    }
}
