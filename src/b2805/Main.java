package b2805;

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
        int[] tree = new int[N];
        long pos = Integer.MIN_VALUE;
        StringTokenizer st1 = new StringTokenizer(buf.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st1.nextToken());
            if (pos < tree[i]) pos = tree[i];
        }
        long ans = 0;
        long left = 0;
        long right = pos;
        Loop1:
        while (true) {
            long sum = 0;
            long posTree = (left + right) / 2;
            if (posTree == left) break;
            for (int i = 0; i < N; i++) {
                int high = tree[i];
                if (high >= posTree) {
                    sum += high - posTree;
                }
            }
            if (sum == M) {
                ans = posTree;
                break Loop1;
            }
            else if (sum < M) {
                right = posTree;
            }
            else {
                if (ans < posTree) ans = posTree;
                left = posTree;
            }
        }
        System.out.println(ans);
    }
}

