package b1966;

import java.io.*;
import java.util.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(buf.readLine());
        while (T-- > 0) {
            Queue<Integer> que = new LinkedList<Integer>();
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int N = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[N];
            int findNum = Integer.parseInt(st.nextToken());
            StringTokenizer st2 = new StringTokenizer(buf.readLine());
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st2.nextToken());
                que.add(temp);
                arr[i] = temp;
            }
            Arrays.sort(arr, Collections.reverseOrder());
            int pos = 0;
            int count = 0;
            int cnt = arr.length;
            while (!que.isEmpty()) {
                if (findNum == 0) {
                    if (que.peek().equals(arr[pos])) {
                        count++;
                        break;
                    }
                    else {
                        int num = que.remove();
                        que.add(num);
                        findNum = cnt - 1;
                    }
                }
                else {
                    if (que.peek().equals(arr[pos])) {
                        count++;
                        que.remove();
                        cnt--;
                        pos++;
                        findNum--;
                    }
                    else {
                        int num = que.remove();
                        que.add(num);
                        findNum--;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
