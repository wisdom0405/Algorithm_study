import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node[] tree = new Node[26]; // A-Z (최대 26개)
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드개수

        for (int i=0; i<26; i++){
            tree[i] = new Node((char)('A' + i)); // A-Z 노드 미리 생성
        }

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            // left, right 노드 비어있지 않다면 parent의 left/right 노드에 저장해주기
            if (left != '.'){
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            if (right != '.'){
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        // 전위순회
        preOrder(tree[0]); // A가 루트노드
        System.out.println();

        // 중위순회
        inOrder(tree[0]);
        System.out.println();

        // 후위순회
        postOrder(tree[0]);
    }

    // 전위순회 VLR
    private static void preOrder(Node node){
        if (node == null) return;
        System.out.print(node.data); // 루트
        preOrder(node.left);
        preOrder(node.right);
    }
    // 중위순회 LVR
    private static void inOrder(Node node){
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }
    // 후위순회 LRV
    private static void postOrder(Node node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}
class Node{
    char data;
    Node left;
    Node right;

    public Node(char data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}