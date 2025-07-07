import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque = new LinkedList<>();
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령어 개수

        while (N-->0){
            dequeProcess(br.readLine());
        }

        System.out.println(sb);
    }
    private static void dequeProcess (String command) {
        st = new StringTokenizer(command);

        while (st.hasMoreTokens()){
            switch (st.nextToken()) {
                case "push" :
                    deque.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(!deque.isEmpty() ? deque.poll() + "\n" : -1 + "\n");
                    break;
                case "size" :
                    sb.append(deque.size() + "\n");
                    break;
                case "empty" :
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front" :
                    sb.append(!deque.isEmpty() ? deque.getFirst() + "\n" : -1 + "\n");
                    break;
                case "back" :
                    sb.append(!deque.isEmpty() ? deque.getLast()  + "\n" : -1 + "\n");
                    break;
            }
        }


    }
}
