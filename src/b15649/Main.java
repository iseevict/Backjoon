package b15649;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visit;

    static void setN(int num) {
        N = num;
    }

    static void setM(int num) {
        M = num;
    }

    static void setArr() {
        arr = new int[M];
    }

    static void setVisit() {
        visit = new boolean[N];
    }

    static void backTracking(int N, int M, int depth) {
        if (depth == M) {
            for (int temp : arr) {
                System.out.print(temp + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                arr[depth] = i + 1;
                backTracking(N, M, depth + 1);

                visit[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        setN(Integer.parseInt(st.nextToken()));
        setM(Integer.parseInt(st.nextToken()));
        setArr(); setVisit();
        backTracking(N, M, 0);
    }
}
