package b10809;

import java.io.*;
import java.util.*;

public class Main {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s = buf.readLine();
        int[] alpa = new int[130];
        Arrays.fill(alpa, -1);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (alpa[arr[i]] == -1) {
                alpa[arr[i]] = i;
            }
        }
        for (int i = 97; i < 123; i++) {
            sb.append(alpa[i] + " ");
        }
        System.out.print(sb);
    }
}
