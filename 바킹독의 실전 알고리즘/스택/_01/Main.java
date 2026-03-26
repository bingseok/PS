package 스택._01;

public class Main {
    final static int MX = 100005;
    static int[] dat = new int[MX];
    static int pos = 0;

    static void push(int x) {
        dat[pos++] = x;
    }

    static void pop() {
        pos--;
    }

    static int top() {
        return dat[pos-1];
    }

}
