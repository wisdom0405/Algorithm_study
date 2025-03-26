import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수 (노드 개수)
        int M = Integer.parseInt(br.readLine()); // 버스노선 개수 (에지 개수)
        int[][] D = new int[N+1][N+1]; // 거리인접행렬 (도시번호 1번부터 시작)
        int INF = 100000000;

        // 인접행렬 초기화 (자기자신과의 거리 : 0, 그 외는 무한대)
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(i==j){
                    D[i][j] = 0;
                }else{
                    D[i][j] = INF;
                }
            }
        }

        // 노선정보 입력받기
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 출발도시
            int E = Integer.parseInt(st.nextToken()); // 도착도시
            int cost = Integer.parseInt(st.nextToken()); // 비용

            // 기존값, 현재 들어오는 값 중 최솟값 입력
            D[S][E] = Math.min(D[S][E], cost);
        }

        // 최단거리 비교
        for(int K=1; K<N+1; K++){
            for(int S=1; S<N+1; S++){
                for(int E=1; E<N+1; E++){
                    if(D[S][K] == INF || D[K][E] == INF) continue;
                    D[S][E] = Math.min(D[S][E], D[S][K] + D[K][E]);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int S=1; S<N+1; S++){
            for(int E=1; E<N+1; E++){
                if(D[S][E] == INF){
                    bw.write("0 ");
                }else{
                    bw.write(D[S][E]+" ");   
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
