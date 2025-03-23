import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static long[] distance;
    static Bus[] buses;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance = new long[N + 1];
        buses = new Bus[E];

        Arrays.fill(distance, INF);
        distance[1] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            buses[i] = new Bus(start, end, time);
        }

        // 벨만-포드 알고리즘 (최적화: 갱신 없을 시 종료)
        boolean updated;
        for (int i = 1; i < N; i++) {
            updated = false;
            for (int j = 0; j < E; j++) {
                Bus bus = buses[j];
                if (distance[bus.start] != INF && distance[bus.end] > distance[bus.start] + bus.time) {
                    distance[bus.end] = distance[bus.start] + bus.time;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        // 음수 사이클 체크
        for (int i = 0; i < E; i++) {
            Bus bus = buses[i];
            if (distance[bus.start] != INF && distance[bus.end] > distance[bus.start] + bus.time) {
                System.out.println("-1");
                return;
            }
        }

        // 출력 최적화
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int i = 2; i <= N; i++) {
                bw.write((distance[i] == INF) ? "-1\n" : distance[i] + "\n");
            }
        }
    }
}

class Bus {
    int start, end, time;

    public Bus(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}
