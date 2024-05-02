package b1012;

import java.io.*;
import java.util.*;

public class Main {
    static int T, M, N, K;
    static boolean[][] ground = new boolean[51][51];
    static boolean[][] ch = new boolean[51][51];

    static void find(int x, int y) {
        if (x > M - 1 || y > N - 1) {
            return;
        }
        if (ground[x][y]) {
            ground[x][y] = false;
            if (x == 0 && y == 0) {
                find(x + 1, y);
                find(x, y + 1);
            }
            else if (x == 0) {
                find(x + 1, y);
                find(x, y + 1);
                find(x,  y - 1);
            }
            else if (y == 0) {
                find(x + 1, y);
                find (x - 1, y);
                find (x, y + 1);
            }
            else {
                find(x + 1, y);
                find(x - 1, y);
                find(x, y + 1);
                find(x, y - 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < K; i++) {
                StringTokenizer st2 = new StringTokenizer(buf.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                ground[x][y] = true;
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ground[j][i]) {
                        ans++;
                        find(j, i);
                    }
                }
            }
            sb.append(ans + "\n");
            ground = ch;
        }
        System.out.println(sb);
    }
}

