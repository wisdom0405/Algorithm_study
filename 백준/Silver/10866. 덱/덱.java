import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque = new LinkedList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-->0) {
            dequeProcess(br.readLine());
        }
    }
    private static void dequeProcess(String command) {
        st = new StringTokenizer(command);

        switch (st.nextToken()){
            case "push_front" :
                deque.addFirst(Integer.parseInt(st.nextToken()));
                break;

            case "push_back" :
                deque.addLast(Integer.parseInt(st.nextToken()));
                break;

            case "pop_front" :
                System.out.println(!deque.isEmpty() ? deque.pollFirst() : -1);
                break;

            case "pop_back" :
                System.out.println(!deque.isEmpty() ? deque.pollLast() : -1);
                break;

            case "size" :
                System.out.println(deque.size());
                break;

            case "empty" :
                System.out.println(deque.isEmpty() ? 1 : 0);
                break;

            case "front" :
                System.out.println(!deque.isEmpty() ? deque.peekFirst() : -1);
                break;

            case "back" :
                System.out.println(!deque.isEmpty() ? deque.peekLast() : -1);
                break;
        }
    }
}
