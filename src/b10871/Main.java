package b10871;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(buf.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st2.nextToken());
            if (temp < X) {
                System.out.print(temp + " ");
            }
        }
    }
}
