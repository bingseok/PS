package 스택._01;

public class Main {
    final int MX = 1000005;
    int[] dat = new int[MX];
    int pos = 0;

    void push(int x) {
        dat[pos++] = x;
    }

    void pop() {
        pos--;
    }

    int top() {
        return dat[pos-1];
    }
}
