package b10773;

import java.io.*;
import java.util.*;

public class Main {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        K = Integer.parseInt(buf.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(buf.readLine());
            if (num == 0) {
                stack.pop();
            }
            else {
                stack.add(num);
            }
        }
        while (!stack.empty()) {
            int temp = stack.pop();
            sum += temp;
        }
        System.out.println(sum);
    }
}
