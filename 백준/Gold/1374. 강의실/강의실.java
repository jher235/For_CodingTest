import java.io.*;
import java.util.*;


public class Main {

    private static class Sche{
        int start;
        int end;

        Sche(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //우선 순위 큐로 시작 시간 순으로 정렬해서 사용
        PriorityQueue<Sche> queue = new PriorityQueue<>((a, b) -> a.start - b.start);

        PriorityQueue<Integer> endMinHeap = new PriorityQueue<>(Integer::compareTo); // 강의실 끝 시간을 넣을 최소힙

        for (int i=0;i<n;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int id = Integer.parseInt(stringTokenizer.nextToken());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            queue.add(new Sche(start, end));
        }

        for (int i=0;i<n;i++){
            Sche sche = queue.poll();

            if(!endMinHeap.isEmpty()){
                int minEnd = endMinHeap.peek();

                if(sche.start < minEnd){ // 빈 강의실이 없는 경우
                    endMinHeap.add(sche.end);
                    continue;
                }

                endMinHeap.poll();
            }
            endMinHeap.add(sche.end);
        }

        System.out.println(endMinHeap.size());

    }

}


