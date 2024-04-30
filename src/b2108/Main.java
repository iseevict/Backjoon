package b2108;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        N = Integer.parseInt(buf.readLine());
        int test = N;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        while (test-- > 0) {
            int temp = Integer.parseInt(buf.readLine());
            arr.add(temp);
            sum += temp;
            if (min > temp) min = temp;
            if (max < temp) max = temp;
            if (map.containsKey(temp)) {
                int count = map.get(temp);
                count++;
                map.replace(temp, count);
            }
            else {
                map.put(temp, 1);
            }
        }
        int avg = (int)Math.round((double)sum / N); // 산술평균
        sb.append(avg + "\n");

        Collections.sort(arr); // 정렬
        int index = N / 2;
        sb.append(arr.get(index) + "\n"); // 중앙값

        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) count = entry.getValue();
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (entry.getValue() == count) arr2.add(key);
        }
        Collections.sort(arr2);
        int size = arr2.size();
        int idx = 0;
        if (size != 1) {
            idx = 1;
        }
        sb.append(arr2.get(idx) + "\n"); // 최빈값
        sb.append(max - min + "\n"); // 범위
        System.out.println(sb);
    }
}
