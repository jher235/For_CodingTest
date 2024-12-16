import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[3];
        int n=0;
        String[] ans = new String[51];
        StringBuilder answer = new StringBuilder();

        String s = br.readLine();
        String[] sChar = s.split("");

        for(String people : sChar){
            if(people.equals("A")){
                count[0]++;
            }
            if(people.equals("B")){
                count[1]++;
            }
            if(people.equals("C")){
                count[2]++;
            }
        }

        if(count[2]*3 < count[1]*2){
            count[1]--;
            ans[n] = "B";
            n++;
        }else if(count[2]*3 > count[1]*2){
            count[2]--;
            ans[n] = "C";
            n++;
        } else if (count[2]>0) {
            count[2]--;
            ans[n] = "C";
            n++;
        } else if(count[0]>0){
            count[0]--;
            ans[n] = "A";
            n++;
        }else{
            System.out.println("-1");
            return;
        }

        if(sChar.length>1){
            if(!ans[0].equals("C") && count[2]>0){
                count[2]--;
                ans[n] = "C";
                n++;
            }else if(!ans[0].equals("B") && count[1]>0){
                count[1]--;
                ans[n] = "B";
                n++;
            }else if(count[0]>0) {
                count[0]--;
                ans[n] = "A";
                n++;
            }else{
                System.out.println("-1");
                return;
            }
        }


        while (n < sChar.length){
            if(count[2]*3 < count[1]*2
                    && !ans[n-1].equals("B")){
                count[1]--;
                ans[n] = "B";
                n++;
            }
            else if(!ans[n-2].equals("C")
                    && !ans[n-1].equals("C")
                    && count[2]>0){
                count[2]--;
                ans[n] = "C";
                n++;
            }else if(!ans[n-1].equals("B")
                    && count[1]>0){
                count[1]--;
                ans[n] = "B";
                n++;
            }else if(count[0]>0) {
                count[0]--;
                ans[n] = "A";
                n++;
            }else{
                System.out.println("-1");
                return;
            }
        }

        for (int i=0;i<n;i++ ){
            answer.append(ans[i]);
        }
        System.out.println(answer);

    }

}