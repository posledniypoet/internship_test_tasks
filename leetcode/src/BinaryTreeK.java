import com.sun.source.tree.Tree;

public class BinaryTreeK {

    static class BinaryTree {
        TreeNode root;

        BinaryTree(TreeNode root) {
            this.root = root;
        }

    }

    static class TreeNode {
        int value;

        TreeNode leftNode;

        TreeNode rightNode;

        TreeNode(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        int k = Integer.MAX_VALUE - 1;
        TreeNode root = new TreeNode(15);
        TreeNode elem1 = new TreeNode(7);
        TreeNode elem2 = new TreeNode(20);
        TreeNode elem3 = new TreeNode(3);
        TreeNode elem4 = new TreeNode(12);
        TreeNode elem5 = new TreeNode(Integer.MAX_VALUE);
        TreeNode elem6 = new TreeNode(10);
        elem5.rightNode = null;
        elem5.leftNode = null;
        elem6.rightNode = null;
        elem6.leftNode = null;
        elem3.rightNode = null;
        elem3.leftNode = null;
        elem4.rightNode = null;
        elem4.leftNode = elem6;
        elem2.rightNode = elem5;
        elem2.leftNode = null;
        elem1.leftNode = elem3;
        elem1.rightNode = elem4;
        root.rightNode = elem2;
        root.leftNode = elem1;
        BinaryTree tree = new BinaryTree(root);
        Integer answer = null;
        TreeNode tempNode = root;
        while (tempNode != null) {
            if (tempNode.value <= k) {
                tempNode = tempNode.rightNode;
            } else {
                int tempAnswer = tempNode.value;
                answer = tempAnswer;
                tempNode = tempNode.leftNode;
            }
        }
        if(answer == null){
            throw new IllegalArgumentException("k must be smaller than max element of tree");
        }
        System.out.println(answer);
    }
}
