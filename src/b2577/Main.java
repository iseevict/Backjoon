package b2577;

import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] ans = new int[10];
        A = Integer.parseInt(buf.readLine());
        B = Integer.parseInt(buf.readLine());
        C = Integer.parseInt(buf.readLine());
        int temp = A * B * C;
        int count = (int)Math.log10(temp);
        for (int i = 0; i <= count; i++) {
            int num = temp % 10;
            ans[num]++;
            temp /= 10;
        }
        for (int i = 0; i < 10; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }
}
