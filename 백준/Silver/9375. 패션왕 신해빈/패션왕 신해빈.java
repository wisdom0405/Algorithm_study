import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        // 테스트 케이스 시작
        while (T-->0){
            int N = Integer.parseInt(br.readLine()); // 의상 수
            HashMap<String, Integer> closet = new HashMap<>(); // 의상종류, 개수 저장

            for (int i=0; i<N; i++){
                String[] input = br.readLine().split(" "); // '의상이름, 의상종류' 형태임
                String type = input[1];

                closet.put(type, closet.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int count : closet.values()){
                result *= (count + 1); // 안입는 경우 포함
            }

            System.out.println(result -1); // 전부 안입는 경우 제외
        }
    }
}
