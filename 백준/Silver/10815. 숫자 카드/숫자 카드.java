import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> cards = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 상근이가 가진 카드 저장하기
        for (int i=0; i<N; i++){
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine()); // 비교할 카드 개수
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++){
            int compare = Integer.parseInt(st.nextToken());
            if (cards.contains(compare)){
                sb.append(1 + " ");
            }else{
                sb.append(0 + " ");
            }
        }

        System.out.println(sb);
    }
}
