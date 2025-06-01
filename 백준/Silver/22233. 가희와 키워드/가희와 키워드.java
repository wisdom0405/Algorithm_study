import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가희가 메모장에 적은 키워드 개수
        int M = Integer.parseInt(st.nextToken()); // 가희가 블로그에 쓴 글의 개수

        // 메모장에 키워드 저장
        HashSet<String> set = new HashSet<>();
        while (N-->0){
            set.add(br.readLine());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (M-->0){
            st = new StringTokenizer(br.readLine(),","); // ,(쉼표 구분)
            while (st.hasMoreTokens()){
                String keyword = st.nextToken();
                set.remove(keyword);
            }
            bw.write(set.size() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
