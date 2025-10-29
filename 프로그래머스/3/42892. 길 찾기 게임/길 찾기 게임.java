import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Node {
    int x, y, value;
    Node left, right;
    public Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;  // 노드 번호 (1부터)
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node root;

    public void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
}

class Solution {
    void preOrder(Node node, ArrayList<Integer> list) {
        if (node == null) return;
        list.add(node.value);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    void postOrder(Node node, ArrayList<Integer> list) {
        if (node == null) return;
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.value);
    }

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        // y 내림차순, y 같으면 x 오름차순 정렬 (인덱스 배열 기준)
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (nodeinfo[a][1] == nodeinfo[b][1]) {
                    return nodeinfo[a][0] - nodeinfo[b][0];
                } else {
                    return nodeinfo[b][1] - nodeinfo[a][1];
                }
            }
        });

        Tree tree = new Tree();

        for (int i = 0; i < n; i++) {
            int x = nodeinfo[idx[i]][0];
            int y = nodeinfo[idx[i]][1];
            int value = idx[i] + 1;    // 실제 노드 번호는 원래 입력 인덱스 +1
            Node node = new Node(x, y, value);

            if (tree.root == null) {
                tree.root = node;
            } else {
                tree.insert(tree.root, node);
            }
        }

        ArrayList<Integer>[] list = new ArrayList[2];
        list[0] = new ArrayList<>();
        list[1] = new ArrayList<>();

        preOrder(tree.root, list[0]);
        postOrder(tree.root, list[1]);

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = list[0].get(i);
            answer[1][i] = list[1].get(i);
        }

        return answer;
    }
}