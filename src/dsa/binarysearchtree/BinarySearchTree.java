package dsa.binarysearchtree;

public class BinarySearchTree {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        if(root == null) return false;
        Node temp = root;
        while(temp != null){
            if(value < temp.value) {
                temp = temp.left;
            } else if(value > temp.value) {
                temp = temp.right;
            } else {
                if(value == temp.value) return true;
            }
        }
        return false;
    }

    private boolean rContains(Node currentNode, int value){
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;
        if(value < currentNode.value){
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    private boolean rContains(int value){
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value){
        if(currentNode == null) return new Node(value);
        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    private void rInsert(int value){
        if(root == null) root = new Node(value);
        rInsert(root, value);
    }

    public int minValue(Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private Node deleteNode(Node currentNode, int value){
        if(currentNode == null) return null;
        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left, value);
        } else if(value > currentNode.value){
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if(currentNode.left == null && currentNode.right == null){
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subtreeMin = minValue(currentNode.right);
                currentNode.value = subtreeMin;
                currentNode.right = deleteNode(currentNode.right, subtreeMin);
            }
        }
        return currentNode;
    }

    public void deleteNode(int value){
        deleteNode(root, value);
    }

    public void invert() {
        root = invertTree(root);
    }

    public Node invertTree(Node node){
     return node;
    }

    /*
    Objective: Write a method to invert (or mirror) a binary tree. This means that for every node in the binary tree, you will swap its left and right children.

    Method Signature:
    private Node invertTree(Node node)

    Input:
    node: A Node object representing the root of a binary tree. The Node class has attributes value, left, and right, where value is the value stored in the node, and left and right are pointers to the node's left and right children, respectively.

    Output:
    The root node of the inverted binary tree.

    Requirements:
    The method must be recursive. It should work by traversing the tree and swapping the left and right children of every node encountered.
    If the input tree is empty (i.e., node is null), the method should return null.
    The inversion should happen in-place, meaning you should not create a new tree but instead modify the existing tree structure.
    The method should handle binary trees of any size and structure, ensuring that every node's left and right children are swapped.

    */

}
