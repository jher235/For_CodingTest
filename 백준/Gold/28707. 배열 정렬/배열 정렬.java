import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    private static int N;
    private static int M;
    private static int[][] swaps;

    private static Set<Numbers> dupNumber = new HashSet<>();

    private static int[] ans;

    private static class Numbers{
        private final int[] value;
        private final int cost;

        public Numbers(int[] value, int cost) {
            this.value = value;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return  true;
            if(o instanceof Numbers){
                Numbers that = (Numbers) o;
                return Arrays.equals(value, that.value);
            }
            return false;
        }

        @Override
        public int hashCode(){
            return Arrays.hashCode(value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] input = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        M = Integer.parseInt(br.readLine());
        swaps = new int[M][3];
        for (int i=0; i<M; i++){
            swaps[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        ans = Arrays.copyOf(input, input.length);
        Arrays.sort(ans);

        PriorityQueue<Numbers> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));

        pq.add(new Numbers(input, 0));

        while (!pq.isEmpty()){
            Numbers poll = pq.poll();

            if(dupNumber.contains(poll)){
                continue;
            }
            dupNumber.add(poll);

            if (Arrays.equals(ans, poll.value)){
                System.out.println(poll.cost);
                return;
            }
            for (int[] swap : swaps){
                int[] newArr = Arrays.copyOf(poll.value, poll.value.length);
                int temp = newArr[swap[0] - 1];
                newArr[swap[0] - 1] = newArr[swap[1] - 1];
                newArr[swap[1] - 1] = temp;

                int totalCost = poll.cost + swap[2];
                pq.add(new Numbers(newArr, totalCost));
            }
        }
        System.out.println(-1);
    }
}