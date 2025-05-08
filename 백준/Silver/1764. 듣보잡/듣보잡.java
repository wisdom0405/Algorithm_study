import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수

        ArrayList<String> answer = new ArrayList<>(); // 듣도보도 못한 사람
        HashSet<String> everHeard = new HashSet<>(); // 듣도 못한 사람
        for (int i=0; i<N; i++){
            everHeard.add(br.readLine());
        }

        // 보도 못한 사람
        for (int i=0; i<M; i++){
            String everSeen = br.readLine();
            if (everHeard.contains(everSeen)){
                answer.add(everSeen);
            }
        }

        // 듣도보도 못한 사람 리스트 사전순 정렬
        answer.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();

        // 듣보잡 명수
        sb.append(answer.size() + "\n");

        // 명단 출력
        for (String everHeardAndSeen : answer){
            sb.append(everHeardAndSeen + "\n");
        }

        System.out.println(sb);
    }
}
