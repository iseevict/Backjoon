package b11399;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        List<Integer> arr = new ArrayList<>();
        int[] dp = new int[1001];
        StringTokenizer st = new StringTokenizer(buf.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr.add(temp);
        }
        Collections.sort(arr);

        dp[0] = arr.get(0);
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + arr.get(i);
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += dp[i];
        }
        System.out.println(sum);
    }
}

