package b11727;

import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(buf.readLine());
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        dp[4] = 11;
        dp[5] = 21;
        for (int i = 6; i <= 1000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[n]);
    }
}

