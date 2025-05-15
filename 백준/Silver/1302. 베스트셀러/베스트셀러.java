import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> sold = new HashMap<>();

        int N = Integer.parseInt(br.readLine()); // 팔린 책 개수
        int max = 0;

        while (N-->0){
            String title = br.readLine(); // 책 제목
            sold.put(title, sold.getOrDefault(title, 0) + 1); // key: 책제목, value : 개수
            max = Math.max(max, sold.get(title)); // 최댓값 업데이트
        }

        ArrayList<String> result = new ArrayList<>();
        for (String key : sold.keySet()){
           if (sold.get(key) == max){
                result.add(key);
           }
        }

        Collections.sort(result); // 사전순 정렬
        System.out.println(result.get(0));
    }
}
