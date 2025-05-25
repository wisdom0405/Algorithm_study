import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 점의 개수

        ArrayList<int[]> list = new ArrayList<>();

        // 좌표 입력받기
        StringTokenizer st;
        while (N-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        list.sort(Comparator
                .comparingInt((int[] point) -> point[0])       // x 기준
                .thenComparingInt(point -> point[1])           // x 같으면 y 기준
        );

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int[] point : list){
            bw.write(point[0] + " " +point[1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
