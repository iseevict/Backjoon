package b2741;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
