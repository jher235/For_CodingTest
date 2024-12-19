import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static List<Node> nodes = new LinkedList<>();

    static class Node{
        char value;
        Node left;
        Node right;

        Node(char value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        char getValue(){
            return this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine()," ");
            char value = tokenizer.nextToken().charAt(0);
            char left = tokenizer.nextToken().charAt(0);
            char right = tokenizer.nextToken().charAt(0);

            // 기존에 생성했던 노드인지 확인하는데, 여기서 orElseGet 으로 새로 객체를 만드는 경우는 루트 노드 밖에 없다.
            Node parentNode = nodes.stream()
                    .filter(node -> node.getValue()==value)
                    .findFirst()
                    .orElseGet(()->new Node(value));

            if(!nodes.contains(parentNode)){
                nodes.add(parentNode);
            }

            if(left != '.'){
                Node node = new Node(left);
                parentNode.left = node;
                nodes.add(node);
            }
            if(right != '.'){
                Node node = new Node(right);
                parentNode.right = node;
                nodes.add(node);
            }

        }

        Node root = nodes.get(0);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    public static void preOrder(Node node){
        System.out.print(node.getValue());
        if(node.left != null){
            preOrder(node.left);
        }
        if(node.right != null){
            preOrder(node.right);
        }
    }

    public static void inOrder(Node node){
        if(node.left != null){
            inOrder(node.left);
        }
        System.out.print(node.getValue());
        if(node.right != null){
            inOrder(node.right);
        }
    }

    public static void postOrder(Node node){
        if(node.left != null){
            postOrder(node.left);
        }
        if(node.right != null){
            postOrder(node.right);
        }
        System.out.print(node.getValue());
    }
    
}