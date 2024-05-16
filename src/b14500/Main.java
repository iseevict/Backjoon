package b14500;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] value = new int[502][502];
    static boolean[][] visit = new boolean[502][502];
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void run (int x, int y, int sum, int count) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xPos = x + dx[i];
            int yPos = y + dy[i];

            if (xPos < 1 || xPos > M || yPos < 1 || yPos > N) {
                continue;
            }

            if (!visit[xPos][yPos]) {

                if (count == 2) {
                    visit[xPos][yPos] = true;
                    run(x, y, sum + value[xPos][yPos], count + 1);
                    visit[xPos][yPos] = false;
                }

                visit[xPos][yPos] = true;
                run(xPos, yPos, sum + value[xPos][yPos], count + 1);
                visit[xPos][yPos] = false;
            }
        }
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
                visit[j][i] = true;
                run(j, i, value[j][i], 1);
                visit[j][i] = false;
            }
        }
        System.out.println(max);
    }
}


