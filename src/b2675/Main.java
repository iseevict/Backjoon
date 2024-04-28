package b2675;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int count;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            count = Integer.parseInt(st.nextToken());
            s = st.nextToken();
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < count; j++) {
                    sb.append(arr[i]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
