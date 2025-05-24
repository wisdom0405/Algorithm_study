import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
        int M = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수
        HashMap<String, String> map = new HashMap<>();

        // 사이트, 비밀번호 입력받기
        while (N-->0){
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken(); // 사이트 주소
            String pwd = st.nextToken(); // 비밀번호
            map.put(site, pwd);
        }

        // 비밀번호 찾기
        while (M-->0){
            String site = br.readLine();
            System.out.println(map.get(site));
        }
    }
}
