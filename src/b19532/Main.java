package b19532;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[6];

    static void find() {
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (arr[0] * i + arr[1] * j != arr[2]) continue;
                if (arr[3] * i + arr[4] * j != arr[5]) continue;
                System.out.println(i + " " + j);
                return;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        find();
    }
}
