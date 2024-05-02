package b1463;

import java.io.*;
import java.util.*;

public class Main {
    static int X;
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        X = Integer.parseInt(buf.readLine());
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[X]);
    }
}

