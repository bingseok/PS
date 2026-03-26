package 큐._01;

public class Main {

    final static int MX = 100005;
    static int[] dat = new int[MX];
    static int head = 0, tail = 0;

    void push(int x) {
        dat[tail++] = x;
    }

    void pop() {
        head++;
    }

    int front() {
        return dat[head];
    }

    int back() {
        return dat[tail - 1];
    }

}
