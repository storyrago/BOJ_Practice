import java.io.*;
import java.util.*;
public class Main {
	public static class Node{
		char data;
		Node left;
		Node right;
		Node(char data){
			this.data =data;
			this.left = null;
			this.right = null;
		}
	}
	public static void inorder(Node tree) { //중
		if(tree == null) return;
		inorder(tree.left);
		System.out.print(tree.data);
		inorder(tree.right);
	}
	public static void preorder(Node tree) { //전
		if(tree == null) return;
		System.out.print(tree.data);
		preorder(tree.left);
		preorder(tree.right);
	}
	public static void postorder(Node tree) { //후
		if(tree == null) return;
		postorder(tree.left);
		postorder(tree.right);
		System.out.print(tree.data);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Node[] tree = new Node[n+1];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			char PNode = st.nextToken().charAt(0);
			char LNode = st.nextToken().charAt(0);
			char RNode = st.nextToken().charAt(0);
			
			if(tree[PNode-'A'] == null) {
				tree[PNode-'A'] = new Node(PNode);
			}
			if(LNode != '.') {
				tree[LNode-'A'] = new Node(LNode);
				tree[PNode-'A'].left = tree[LNode-'A'];
			}
			if(RNode != '.') {
				tree[RNode-'A'] = new Node(RNode);
				tree[PNode-'A'].right = tree[RNode-'A'];
			}
		}
		preorder(tree[0]);
		System.out.println();
		inorder(tree[0]);
		System.out.println();
		postorder(tree[0]);
	}
}
