import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String input = br.readLine();

        int point = 0;
        int pattern = 0;
        int count = 0;

        while (point < M-2){
//            if (input.substring(point, point+3).equals("IOI")){
            if (input.startsWith("IOI", point)){
                pattern ++;

                if (pattern == N){ // Pn패턴 일치 시
                    count++;
                    pattern--; // 하나 줄여서 다음 패턴을 바로 계산할 수 있게 함
                }
                point++; // 2칸 이동하기 위해 미리 1칸 이동
            }else{
                pattern = 0; // IOI 패턴 일치 안하면 초기화
            }
            point++;
        }
        System.out.println(count);

    }
}