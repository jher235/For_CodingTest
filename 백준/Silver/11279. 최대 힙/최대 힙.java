import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);//람다식이 양수면(b>a) 두번째인 b의 우선순위가 더 높음.음수면 반대
        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());

            if(num==0){
                if(priorityQueue.isEmpty()){
                    bw.write("0"+"\n");
                    continue;
                }
                bw.write(priorityQueue.poll()+"\n");// 줄내림 +"\n"을 넣으며 자동으로 문자열로 바뀜
                continue;
            }
            priorityQueue.offer(num);
        }
        bw.flush();
        bw.close();
    }
}