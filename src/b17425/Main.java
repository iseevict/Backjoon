package b17425;

import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static long[] arr = new long[1000001];
    static long[] dp = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        T = Integer.parseInt(buf.readLine());

        Arrays.fill(arr, 1);

        for (int i = 2; i <= 1000000; i++) { //에라토스테네스의 채
            for (int j = 1; i * j <= 1000000; j++) {
                arr[i * j] += i;
            }
        }

        for (int i = 1; i <= 1000000; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }

        for (int i = 0; i < T; i++) {
            sb.append(dp[Integer.parseInt(buf.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}
