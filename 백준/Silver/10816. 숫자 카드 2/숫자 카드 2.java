import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 카드개수 N
        HashMap<Integer,Integer> map = new HashMap<>();

        // 상근이가 가진 카드 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-->0){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1); // 숫자카드, 개수
        }

        int M = Integer.parseInt(br.readLine()); // 비교 카드개수 M
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        while (M-->0){
            int num = Integer.parseInt(st.nextToken());
            if (map.get(num) == null){
                bw.write(0 + " ");
            }else{
                bw.write(map.get(num) + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}




