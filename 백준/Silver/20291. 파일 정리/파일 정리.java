import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st;

        while (N-->0){
            st = new StringTokenizer(br.readLine(),".");
            String fileName = st.nextToken();
            String fileType = st.nextToken();
            map.put(fileType, map.getOrDefault(fileType, 0) + 1);
        }

        ArrayList<String> result = new ArrayList<>(map.keySet());
        result.sort(Comparator.naturalOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String fileType : result) {
            int count = map.get(fileType);
            bw.write(fileType + " " + count + "\n");
        }

        bw.flush();
        bw.close();

    }
}
