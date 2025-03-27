import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] A;
    static ArrayList<LAN> lans;
    static int count;
    static int[] parent;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 컴퓨터 개수
        A = new int[N][N]; // 랜선정보 저장
        int totalLength = 0;

        // 랜선정보 입력받아서 -> 정수형으로 저장하기
        for(int i=0; i<N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (Character.isLowerCase(chars[j])) {
                    // 현재 문자가 소문자라면
                    A[i][j] = chars[j] - 'a' + 1;
                    totalLength += A[i][j];
                } else if (Character.isUpperCase(chars[j])){
                    // 현재 문자가 대문자라면
                    A[i][j] = chars[j] - 'A' + 27;
                    totalLength += A[i][j];
                }else{
                    // '0'이라면
                    A[i][j] = chars[j] - '0';
                }
            }
        }

        // 랜선정보 담는 리스트 (중복저장 방지)
        lans = new ArrayList<>();
        for (int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (i==j) continue;
                if (A[i][j] > 0) {
                    lans.add(new LAN(i, j, A[i][j])); // 시작노드, 도착노드, 랜선길이
                }
            }
        }

        // 랜선의 length 기준으로 오름차순 정렬
        Collections.sort(lans, Comparator.comparingInt(a -> a.length));

        count = 0; // 연결 랜선개수
        parent = new int[N]; // 대표노드 배열 초기화
        for (int i=0; i<N; i++){
            parent[i] = i; // 내 자신이 대표노드
        }

        int usedLength = 0; // 사용된 랜선길이
        for(LAN lan : lans){
            // 랜선 사용개수가 N-1개가 되면 종료
            if(count > N-1) break;

            if (find(lan.start) != find(lan.end)){
                union(lan.start, lan.end);
                usedLength += lan.length; // 합계에서 사용한 랜선길이 빼주기
                count++; // 랜선사용 개수 증가
            }
        }
        System.out.println(count == N-1 ? totalLength - usedLength : -1);
    }
    private static int find(int a){
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]); // 자신의 대표노드 찾아서 넣어줌
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){ // a와 b의 대표노드가 서로 다르다면 union 연산
            parent[b] = a;
        }
    }
}
class LAN implements Comparable<LAN> {
    int start;
    int end;
    int length;

    public LAN(int start, int end, int length){
        this.start = start;
        this.end = end;
        this.length = length;
    }
    @Override
    public int compareTo(LAN o) {
        return this.length - o.length; // 길이 기준 오름차순 정렬
    }
}
