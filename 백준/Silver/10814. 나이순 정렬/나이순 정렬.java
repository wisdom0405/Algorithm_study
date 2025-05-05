import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람 인원 수
        ArrayList<User> users = new ArrayList<>();

        StringTokenizer st;
        for (int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            users.add(new User(i, age, name));
        }

        // 나이 오름차순 정렬, 나이 같다면 가입 순서대로 정렬
        users.sort(Comparator.comparingInt((User u) -> u.age)
                .thenComparing(u -> u.id));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=0; i<users.size(); i++){
            bw.write(users.get(i).toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
class User{
    public int id;
    public int age;
    public String name;

    public User(int id, int age, String name){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
