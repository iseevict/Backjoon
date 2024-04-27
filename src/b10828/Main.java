package b10828;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        Stack<Integer> fun = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(buf.readLine());
            String temp = st2.nextToken();
            if (temp.equals("push")) {
                int X = Integer.parseInt(st2.nextToken());
                fun.push(X);
            }
            else if (temp.equals("pop")) {
                if (fun.empty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(fun.pop());
                }
            }
            else if (temp.equals("size")) {
                System.out.println(fun.size());
            }
            else if (temp.equals("empty")) {
                if (fun.empty()) {
                    System.out.println("1");
                }
                else {
                    System.out.println("0");
                }
            }
            else {
                if (fun.empty()) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(fun.peek());
                }
            }
        }
    }
}
