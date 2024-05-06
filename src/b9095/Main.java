package b9095;

import java.io.*;
import java.util.*;

public class Main {
    static int T, n;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        while (T-- > 0) {
            n = Integer.parseInt(buf.readLine());
            sb.append(dp[n] + "\n");
        }

        System.out.println(sb);
    }
}

