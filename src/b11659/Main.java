package b11659;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num = new int[100001];
    static int[] dp = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(buf.readLine());
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(st2.nextToken());
            num[i] = temp;
            dp[i] = dp[i - 1] + temp;
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(buf.readLine());
            int left = Integer.parseInt(st3.nextToken());
            int right = Integer.parseInt(st3.nextToken());
            sb.append((dp[right] - dp[left - 1]) + "\n");
        }
        System.out.println(sb);
    }
}

