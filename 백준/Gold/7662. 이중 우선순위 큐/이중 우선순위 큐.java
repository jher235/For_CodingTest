import java.io.*;
import java.util.*;


public class Main {

    public static class Node{
        int index;
        int value;
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tryCount = Integer.parseInt(br.readLine());

        for(int i=0;i<tryCount;i++){
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Node> minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x.value, y.value));
            PriorityQueue<Node> maxHeap = new PriorityQueue<>((x, y) -> Integer.compare(y.value, x.value));
//            PriorityQueue<Node> maxQueue = new PriorityQueue<>((x, y) -> x.value > y.value ? -1 : 1); // 새로 들어온 x가 크면 -1로 우선 처리하도록

            Boolean[] deleted = new Boolean[k];
            Arrays.fill(deleted, false);
            
            for (int temporaryNumber=0;temporaryNumber<k;temporaryNumber++){
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
                String command = stringTokenizer.nextToken();

                if(command.equals("I")){
                    Integer value = Integer.parseInt(stringTokenizer.nextToken());

                    minHeap.add(new Node(temporaryNumber, value));
                    maxHeap.add(new Node(temporaryNumber, value));
                }else{
                    Integer subCommand = Integer.parseInt(stringTokenizer.nextToken());
                    if (subCommand == -1){
                        while (!minHeap.isEmpty()) {
                            Node minNode = minHeap.poll();
                            if (!deleted[minNode.index]) {
                                deleted[minNode.index] = true;
                                break;
                            }
                        }
                    }else{
                        while (!maxHeap.isEmpty()) {
                            Node maxNode = maxHeap.poll();
                            if (!deleted[maxNode.index]) {
                                deleted[maxNode.index] = true;
                                break;
                            }
                        }

                    }
                }

            }
            long minAns = Long.MAX_VALUE;
            long maxAns = Long.MIN_VALUE;

            while (!minHeap.isEmpty()){
                Node minNode = minHeap.poll();
                if(!deleted[minNode.index]){
                    minAns = minNode.value;
                    break;
                }
            }

            while (!maxHeap.isEmpty()){
                Node maxNode = maxHeap.poll();
                if(!deleted[maxNode.index]){
                    maxAns = maxNode.value;
                    break;
                }
            }

            if (maxAns >= minAns){ // 초기값에서 업데이트가 이뤄졌으면
                System.out.println(maxAns + " " + minAns);
            }else {
                System.out.println("EMPTY");
            }

        }
    }
}