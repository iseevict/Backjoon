package b1389;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] ans = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ans[i][j] = 100000000;
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(buf.readLine());
            int left = Integer.parseInt(st2.nextToken());
            int right = Integer.parseInt(st2.nextToken());
            ans[left][right] = 1;
            ans[right][left] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (ans[j][k] > ans[j][i] + ans[i][k]) {
                        ans[j][k] = ans[j][i] + ans[i][k];
                    }
                }
            }
        }
        int[] sum = new int[N +1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    sum[i] += ans[i][j];
                }
            }
            if (min > sum[i]) min = sum[i];
        }
        for (int i = 1; i <= N; i++) {
            if (sum[i] == min) {
                System.out.println(i);
                break;
            }
        }
    }
}

