import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0; // 그룹단어 개수

        while (N-- > 0){
            char[] chars = br.readLine().toCharArray();
            boolean isGroup = true;
            HashSet<Character> seen = new HashSet<>();
            char prev = 0;

            for (char c : chars){
                if (c != prev){ // 현재 문자가 이전문자와 다르다면
                    if (seen.contains(c)){ // 이미 set에 있다면 그룹문자가 아님. for문 종료
                        isGroup = false;
                        break;
                    }
                    seen.add(c); // set에 현재문자 추가
                }
                prev = c;
            }

            // for문 빠져나온 후에도 isGroup이 true라면 그룹문자임
            if (isGroup) count++;
        }
        System.out.println(count);
    }
}
