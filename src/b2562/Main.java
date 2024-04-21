package b2562;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int ans = 0;
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) { // 채워넣기
            int n = Integer.parseInt(buf.readLine());
            arr[i] = n;
        }
        int maxPos = recur(9);
        System.out.println(arr[maxPos]);
        System.out.println(maxPos + 1);

    }

    static int recur(int num) {
        if (num == 1) {
            return num - 1;
        }
        else {
            int max = recur(num - 1);
            if (arr[max] > arr[num - 1]) {
                return max;
            }
            else {
                return num - 1;
            }
        }
    }
}
