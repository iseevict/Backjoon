package b2630;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] paper = new boolean[129][129];
    static int ans1 = 0;
    static int ans0 = 0;

    static void cut(int square, int x, int y) {
        int n = square / 2;
        if (n == 1) {
            for (int i = y; i <= y + 1; i++) {
                for (int j = x; j <= x + 1; j++) {
                    if (paper[j][i]) ans1++;
                    else ans0++;
                }
            }
        }
        else {
            int number = 4;
            while (number > 0) {
                switch (number) {
                    case 4: // 좌상단
                        boolean yesNo4 = false;
                        boolean btn4 = paper[x][y];
                        for (int i = y; i < y + n; i++) {
                            for (int j = x; j < x + n; j++) {
                                if (paper[j][i] != btn4) {
                                    yesNo4 = true;
                                }
                            }
                        }
                        if (!yesNo4) {
                            if (btn4) ans1++;
                            else ans0++;
                        }
                        else cut(n, x, y);
                        break;
                    case 3: // 우상단
                        boolean yesNo3 = false;
                        boolean btn3 = paper[x + n][y];
                        for (int i = y; i < y + n; i++) {
                            for (int j = x + n; j < x + n * 2; j++) {
                                if (paper[j][i] != btn3) {
                                    yesNo3 = true;
                                }
                            }
                        }
                        if (!yesNo3) {
                            if (btn3) ans1++;
                            else ans0++;
                        }
                        else cut(n, x + n, y);
                        break;
                    case 2: // 좌하단
                        boolean yesNo2 = false;
                        boolean btn2 = paper[x][y + n];
                        for (int i = y + n; i < y + n * 2; i++) {
                            for (int j = x; j < x + n; j++) {
                                if (paper[j][i] != btn2) {
                                    yesNo2 = true;
                                }
                            }
                        }
                        if (!yesNo2) {
                            if (btn2) ans1++;
                            else ans0++;
                        }
                        else cut(n, x, y + n);
                        break;
                    case 1: // 우하단
                        boolean yesNo1 = false;
                        boolean btn1 = paper[x + n][y + n];
                        for (int i = y + n; i < y + n * 2; i++) {
                            for (int j = x + n; j < x + n * 2; j++) {
                                if (paper[j][i] != btn1) {
                                    yesNo1 = true;
                                }
                            }
                        }
                        if (!yesNo1) {
                            if (btn1) ans1++;
                            else ans0++;
                        }
                        else cut(n, x + n, y + n);
                        break;
                }
                number--;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        int num = 0;
        for(int i= 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    paper[j][i] = true;
                    num++;
                }
            }
        }
        if (num == N * N) {
            System.out.println("0\n1");
            return;
        }
        else if (num == 0) {
            System.out.println("1\n0");
            return;
        }
        cut(N, 1, 1);
        System.out.println(ans0 + "\n" + ans1);
    }
}

