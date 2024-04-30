package b2775;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        int[][] arr = new int[15][15];
        for(int i = 0; i <= 14; i++) {
            if (i == 0) {
                for (int j = 0; j < 14; j++) {
                    arr[0][j] = j + 1;
                }
            }
            else {
                for (int j = 0; j < 14; j++) {
                    int sum = 0;
                    for (int k = 0; k <= j; k++) {
                        sum += arr[i - 1][k];
                    }
                    arr[i][j] = sum;
                }
            }
        }
        while (T-- > 0) {
            int k = Integer.parseInt(buf.readLine());
            int n = Integer.parseInt(buf.readLine());
            sb.append(arr[k][n - 1] + "\n");
        }
        System.out.println(sb);
    }
}
