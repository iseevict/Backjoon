package b9461;

import java.io.*;
import java.util.*;

public class Main {
    static int T, n;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        dp[9] = 7;
        dp[10] = 9;
        for (int i = 11; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        while (T-- > 0) {
            n = Integer.parseInt(buf.readLine());
            sb.append(dp[n] + "\n");
        }
        System.out.println(sb);
    }
}


