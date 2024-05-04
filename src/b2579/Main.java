package b2579;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] stair = new int[301];
    static int[] dp = new int[301];
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(buf.readLine());
            stair[i] = n;
        }
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max(stair[1], stair[2]) + stair[3];
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
        }
        System.out.println(dp[N]);
    }
}

