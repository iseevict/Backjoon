package b10866;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
        Deque<Integer> deq = new LinkedList<>();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            String s = st.nextToken();
            switch(s) {
                case "push_front" :
                    int X1 = Integer.parseInt(st.nextToken());
                    deq.addFirst(X1);
                    break;
                case "push_back" :
                    int X2 = Integer.parseInt(st.nextToken());
                    deq.addLast(X2);
                    break;
                case "pop_front" :
                    if (deq.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(deq.getFirst());
                        deq.removeFirst();
                    }
                    break;
                case "pop_back" :
                    if (deq.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(deq.getLast());
                        deq.removeLast();
                    }
                    break;
                case "size" :
                    System.out.println(deq.size());
                    break;
                case "empty" :
                    if (deq.isEmpty()) {
                        System.out.println("1");
                    }
                    else {
                        System.out.println("0");
                    }
                    break;
                case "front" :
                    if (deq.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(deq.getFirst());
                    }
                    break;
                case "back" :
                    if (deq.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(deq.getLast());
                    }
                    break;
            }
        }
    }
}
