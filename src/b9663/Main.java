package b9663;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int ans = 0;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
        board = new int[N]; // 8 x 8
        queen(0);
        System.out.println(ans);

    }

    static void queen(int q) {
        if (q == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[q] = i;
            if (check(q)) { // 둘 수 있나 확인
                queen(q+1);
            }
        }
    }

    static boolean check(int r) {
        for (int i = 0; i < r; i++) { // 같은 행 잡기
            if (board[r] == board[i]) return false;
            else if (Math.abs(i - r) == Math.abs(board[i] - board[r])) return false; // 대각선 잡기
        }
        return true;
    }
}
