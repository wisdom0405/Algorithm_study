import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<int[]> list = new ArrayList<>();
        while (N-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[] {x,y});
        }

        list.sort((a, b)->{
            if (a[1] == b[1]) return a[0] - b[0]; // y좌표 같으면 x좌표 증가하는 순서
            return a[1] - b[1]; // y좌표 증가하는 순서정렬
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int[] point : list){
            bw.write(point[0] + " " + point[1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
