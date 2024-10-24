
import java.io.*;
import java.util.*;


public class Main {

    //파일명이 오름차순으로 존재한다고 가정하고 풀었다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        List<String[]> fileList = new LinkedList<>();

        for(int i=0;i<n;i++){
            String[] s = br.readLine().split(" ");
            fileList.add(i, s);
        }

        int c = 0;
        while(true){
            Set<String> set = new HashSet<>();
            for(int i=fileList.size()-1;i>=0;i--){
                String last = fileList.get(i)[c];
                if(last.equals("-1")){
                   fileList.remove(i);
                }else{
                    set.add(last);
                }
            }
            if(fileList.size() == set.size()){
                System.out.println(++c);
                return;
            }
            c++;
        }
    }

}