import java.util.*;

class Solution {
    
    public static class Tree{
        public int OE = 0;
        public int reverseOE = 0;
        
        public Tree(int OE, int rOE){
            this.OE = OE;
            this.reverseOE = rOE;
        }
    }
    
    int[] parent;
    int[] neighbor;
    
    // 유니온 파인드로 그룹을 나눔.
    // 트리에서 루트 노드를 제외한 다른 노드들은 부모 노드가 생기므로 이웃 노드 개수가 -1이 됨 
//-> 따라서 그룹 내에 홀짝 노드가 1개만 존재하면 이게 루트 노드일 때 홀짝 노드가 가능하고 나머지 경우는 불가능함. 역홀짝도 마찬가지임.
    public int[] solution(int[] nodes, int[][] edges) {
        
        Map<Integer, Boolean> visited = new HashMap<>();
        Map<Integer, Tree> treeMap = new HashMap<>();
        
        int maxNode = 0;
        for(int node : nodes){
            maxNode = Math.max(maxNode, node);
        }
        parent = new int[maxNode+1];
        neighbor = new int[maxNode+1];
        
        for(int i=1;i<parent.length; i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            int start = edge[0];
            int end = edge[1];
            
            neighbor[start]++;
            neighbor[end]++;
            
            merge(start, end);
        }
        
        for(int node : nodes){
            int p = findParent(node);
            Tree tree = treeMap.getOrDefault(p, new Tree(0, 0));
            
            if((node % 2==0 && neighbor[node] % 2==0) ||
                (node % 2!=0 && neighbor[node] % 2!=0)){
                tree.OE++;
            }else if((node % 2!=0 && neighbor[node] % 2==0) || 
                        (node % 2==0 && neighbor[node] % 2!=0)){
                tree.reverseOE++;
            }
            treeMap.put(p, tree);
        }
        
        int countOE = 0;
        int countReverseOE = 0;
        for(Tree tree : treeMap.values()){
            if(tree.OE==1) countOE++;
            if(tree.reverseOE==1) countReverseOE++;
        }
        
        int[] answer = {countOE, countReverseOE};
        return answer;
    }
    

    
    private int findParent(int a){
        int p = parent[a];
        if(p == a) return p;
        
        
        return parent[a] = findParent(p);
    }
    
    private void merge(int a, int b){
        a = findParent(a);
        b = findParent(b);
        
        if(a != b){
            parent[a] = b;
        }
    }
}