package b1654;

import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long max = -1;
        long temp = 0;
        int[] arr = new int[K];
        for(int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(buf.readLine());
            if (arr[i] > max) max = arr[i];
        }
        for(int i = 0; i < K; i++) {
            temp += arr[i] / max;
        }
        if (temp == N) {
            System.out.println(max);
            return;
        }
        long left = 0;
        long right = max + 1;
        long mid = 0;
        while(left < right) {
            mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
            }
            if (count < N) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}
