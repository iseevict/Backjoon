package b9093;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(buf.readLine());
        do {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int count = st.countTokens();
            for (int i = 0; i < count; i++) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                System.out.print(sb.reverse() + " ");
            }
            System.out.println();
        } while(--T > 0);
    }
}
