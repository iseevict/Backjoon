package b1003;

import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[] dp1 = new int[41];
    static int[] dp0 = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        dp0[0] = 1;
        dp0[1] = 0;
        dp1[1] = 1;
        dp1[0] = 0;
        for (int i = 2; i <= 40; i++) {
            dp0[i] = dp0[i - 1] + dp0[i - 2];
            dp1[i] = dp1[i - 1] + dp1[i - 2];
        }
        while (T-- > 0) {
            N = Integer.parseInt(buf.readLine());
            sb.append(dp0[N] + " " + dp1[N] + "\n");
        }
        System.out.println(sb);
    }
}

