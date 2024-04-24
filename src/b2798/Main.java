package b2798;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visit;
    static int N;
    static int M;
    static int ans = 0;

    static void run(int count, int sum) {
        if (sum > M) return;
        if (count >= 3) {
            if (sum > ans) {
                ans = sum;
            }
        }
        else {
            for (int i = 0; i < N; i++) {
                if (visit[i]) {
                    continue;
                }
                visit[i] = true;
                run(count + 1, sum + arr[i]);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        arr = new int[N];
        visit = new boolean[N];
        StringTokenizer st2 = new StringTokenizer(buf.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st2.nextToken());
            arr[i] = num;
        }
        run(0, 0);
        System.out.println(ans);
    }
}
