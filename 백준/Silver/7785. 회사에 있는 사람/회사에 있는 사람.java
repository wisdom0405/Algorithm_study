import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        StringTokenizer st;
        while (N-->0){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); // 사람이름
            String record = st.nextToken(); // 출입여부 (출근,퇴근)
            if (record.equals("enter")){
                set.add(name);
            }else{
                set.remove(name);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        list.sort(Comparator.reverseOrder());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String name : list){
            bw.write(name + "\n");
        }
        bw.flush();
        bw.close();
    }
}
