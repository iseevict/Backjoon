package b14500;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][][][] sum = new int[502][502][502][502];
    static int[][] value = new int[502][502];
    static int ans = 0;

    static void run(int x, int y) {
        // 0000 형태
        if (x + 3 <= M) {
            if (sum[x][x + 1][x + 2][x + 3] != 0) {
                sum[x][x + 1][x + 2][x + 3] = value[x][y] + value[x + 1][y] + value[x + 2][y] + value[x + 3][y];
                if (ans < sum[x][x + 1][x + 2][x + 3]) {
                    ans = sum[x][x + 1][x + 2][x + 3];
                }
            }
        }


        // 000  형태
        // 0

        // 00 형태
        // 00

        // 000 형태
        //  0

        // 00 형태
        //  00
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(buf.readLine());
            for (int j = 1; j <= M; j++) {
                value[j][i] = Integer.parseInt(st2.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                run(j, i);
            }
        }
        System.out.println(ans);
    }
}


