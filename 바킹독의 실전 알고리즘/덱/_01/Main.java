package 덱._01;

public class Main {
    final static int MX = 100005;
    static int[] dat = new int[2*MX + 1];
    static int head = MX, tail = MX;

    void push_front(int x) {
        dat[--head] = x;
    }

    void push_back(int x) {
        dat[tail++] = x;
    }

    void pop_front() {
        head++;
    }

    void pop_back() {
        tail--;
    }

    int front() {
        return dat[head];
    }

    int back() {
        return dat[tail-1];
    }

}
