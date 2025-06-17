import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        ArrayList<String> suffixList = new ArrayList<>();

        for (int i=0; i<word.length(); i++){
            suffixList.add(word.substring(i));
        }
        suffixList.sort(Comparator.naturalOrder()); // 사전순 정렬

        StringBuilder sb = new StringBuilder();
        
        for (String suffix : suffixList){
            sb.append(suffix + "\n");
        }

        System.out.println(sb);
    }
}
