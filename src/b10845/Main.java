package b10845;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
        Queue<Integer> origin = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            String s = st.nextToken();
            switch(s) {
                case "push" :
                    int X = Integer.parseInt(st.nextToken());
                    origin.add(X);
                    temp.add(X);
                    break;
                case "pop" :
                    if (origin.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(origin.peek());
                        origin.remove();
                        temp.remove(0);
                    }
                    break;
                case "size" :
                    System.out.println(origin.size());
                    break;
                case "empty" :
                    if (origin.isEmpty()) {
                        System.out.println("1");
                    }
                    else System.out.println("0");
                    break;
                case "front" :
                    if (origin.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        System.out.println(origin.peek());
                    }
                    break;
                case "back" :
                    if (origin.isEmpty()) {
                        System.out.println("-1");
                    }
                    else {
                        int size = origin.size() - 1;
                        System.out.println(temp.get(size));
                    }
                    break;
            }
        }
    }
}
