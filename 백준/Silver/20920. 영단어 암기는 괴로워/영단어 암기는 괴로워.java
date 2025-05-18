import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 단어개수
        int M = Integer.parseInt(st.nextToken()); // 단어길이 기준
        HashMap<String, Integer> map = new HashMap<>(); // 단어장 (단어, 나온횟수)

        // 단어 입력받기
        for (int i=0; i<N; i++){
            String word = br.readLine();
            if (word.length() >= M){ // 단어길이 기준 충족하면 해시맵에 저장
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }

        // 단어 리스트 만들기
        List<String> words = new ArrayList<>(map.keySet());

        // 정렬 적용하기
        words.sort((a,b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA != freqB) return freqB - freqA; //빈도 내림차순
            if (a.length() != b.length()) return b.length() - a.length(); // 단어길이 내림채순
            return a.compareTo(b); // 사전순 오름차 순
        });

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String word : words){
            bw.write(word + "\n");
        }

        bw.flush();
        bw.close();
    }
}
