package 배열.배열_구현;

public class Main {
    static int len = 6;
    public static void main(String[] args) {
        int[] arr = {10, 50, 40, 30, 70, 20, 0, 0, 0, 0};
        insert(3, 60, arr, len); // 10 50 40 60 30 70 20

        printArr(arr, len);

        erase(4, arr, len); // 10 50 40 60 70 20

        printArr(arr, len);

    }

    static void insert(int idx, int num, int[] arr, int len) {
        for (int i = len - 1; i >= idx; i--)
            arr[i+1] = arr[i];
        arr[idx] = num;
        len++;
    }

    static void erase(int idx, int[] arr, int len) {
        for (int i = idx + 1; i < len; i++)
            arr[i-1] = arr[i];
        len--;
    }

    static void printArr(int[] arr, int len) {
        for (int i = 0; i < len; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}
