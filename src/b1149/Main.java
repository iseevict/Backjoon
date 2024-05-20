package b1149;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        int[][] rgb = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            rgb[i][0] = Math.min(rgb[i - 1][1], rgb[i - 1][2]) + r;
            rgb[i][1] = Math.min(rgb[i - 1][0], rgb[i - 1][2]) + g;
            rgb[i][2] = Math.min(rgb[i - 1][0], rgb[i - 1][1]) + b;
        }
        System.out.println(Math.min(rgb[N][0], Math.min(rgb[N][1], rgb[N][2])));
    }
}


