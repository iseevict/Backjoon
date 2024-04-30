package b11650;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Integer, List<Integer>> map = new TreeMap<>();
        N = Integer.parseInt(buf.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(buf.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (map.containsKey(key)) { // key 있을 때 : 값에 입력받은 정수 추가
                map.get(key).add(value);
            }
            else { // 없을 때 : map에 추가
                List<Integer> arr = new LinkedList<>();
                arr.add(value);
                map.put(key, arr);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int x = entry.getKey();
            List<Integer> yArr = entry.getValue();
            Collections.sort(yArr);
            for (int y : yArr) {
                sb.append(x + " " + y + "\n");
            }
        }
        System.out.println(sb);
    }
}
