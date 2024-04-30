package b10816;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>(); // HashMap 객체 생성
        N = Integer.parseInt(buf.readLine());

        StringTokenizer st1 = new StringTokenizer(buf.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st1.nextToken());

            if (map.containsKey(temp)) { // 만약 map에 입력받은 정수가 있다면 : 값++
                int value = map.get(temp) + 1;
                map.replace(temp, value);
            }
            else { // 없다면 : 추가
                map.put(temp, 1);
            }
        }
        M = Integer.parseInt(buf.readLine());

        StringTokenizer st2 = new StringTokenizer(buf.readLine());
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st2.nextToken());

            if (map.containsKey(temp)) { // 만약 입력받은 정수가 있다면 : 값 가져와서 빌더에 추가
                sb.append(map.get(temp)+ " ");
            }
            else { // 없다면 : 0을 빌더에 추가
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }
}
