package b1074;

import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) + 1;
        c = Integer.parseInt(st.nextToken()) + 1;
        int pos = -1; // 왼쪽 위 0 오른쪽 위 1 왼쪽 아래 2 오른쪽 아래 3
        int ans = 0;
        while (N != 0) {
            double x = r / Math.pow(2, N - 1);
            double y = c / Math.pow(2, N - 1);
            if (x <= 1 && y <= 1) {
                pos = 0;
            }
            else if (x <= 1 && y > 1) {
                pos = 1;
            }
            else if (x > 1 && y <= 1) {
                pos = 2;
            }
            else if (x > 1 && y > 1) {
                pos = 3;
            }
            int block = (int)Math.pow(2, 2 * (N - 1));
            ans = ans + pos * block;
            switch (pos) {
                case 1:
                    c -= (int)Math.pow(2, N - 1);
                    break;
                case 2:
                    r -= (int)Math.pow(2, N - 1);
                    break;
                case 3:
                    r -= (int)Math.pow(2, N - 1);
                    c -= (int)Math.pow(2, N - 1);
                    break;
            }
            N--;
        }
        System.out.println(ans);
    }
}

