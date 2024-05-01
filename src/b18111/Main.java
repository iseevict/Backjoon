package b18111;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, B;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int[][] ground = new int[M][N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ansTime = Integer.MAX_VALUE;
        int ansHigh = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(buf.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st2.nextToken());
                if (min > temp) min = temp;
                if (max < temp) max = temp;
                ground[j][i] = temp;
            }
        }
        for (int i = min; i <= max; i++) {
            int time = 0;
            int bag = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int num = ground[k][j];
                    int gap = i - num;
                    if (gap > 0) {
                        time = time + gap;
                        bag = bag - gap;
                    }
                    else if (gap < 0) {
                        gap *= -1;
                        time = time + 2 * gap;
                        bag = bag + gap;
                    }
                }
            }
            if (bag >= 0) {
                if (time < ansTime) {
                    ansTime = time;
                    ansHigh = i;
                }
                else if (time == ansTime) {
                    if (ansHigh < i) ansHigh = i;
                }
            }
        }
        System.out.println(ansTime + " " + ansHigh);
    }
}

