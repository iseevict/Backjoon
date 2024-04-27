package b1158;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        List<Integer> yose = new LinkedList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        int index = K - 1;
        for (int i = 1; i <= N; i++) {
            yose.add(i);
        }
        while(!yose.isEmpty()) {
            if(yose.size() == 1) {
                ans.add(yose.get(0));
                break;
            }
            ans.add(yose.get(index));
            yose.remove(index);
            N -= 1;
            index--;
            if (index + K > N - 1) {
                index = (index + K) % N;
            }
            else {
                index += K;
            }
        }
        int count = 0;
        System.out.print("<");
        for (int c : ans) {
            count++;
            if (count == ans.size()) {
                System.out.print(c);
                break;
            }
            System.out.print(c + ", ");
        }
        System.out.print(">");
    }
}
