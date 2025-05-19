import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 채팅 기록 수
        int count = 0;
        HashSet<String> set = new HashSet<>();
        while (N-->0){
            String chat = br.readLine();
            if (chat.equals("ENTER")){
                count += set.size();
                set = new HashSet<>();
            }else{
                set.add(chat);
            }
        }
        count += set.size();
        System.out.println(count);
    }
}
