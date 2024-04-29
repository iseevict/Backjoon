package b2164;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(buf.readLine());
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            que.add(i);
        }
        int check = 0;
        while(que.size() != 1) {
            if (check == 0) {
                que.remove();
                check = 1;
            }
            else {
                int temp = que.remove();
                que.add(temp);
                check = 0;
            }
        }
        System.out.println(que.remove());
    }
}
