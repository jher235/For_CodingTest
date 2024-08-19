import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int s, n;
    static int start=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        List<Integer> arr = new LinkedList<>(Arrays.stream(br.readLine().split(" ")).map(i->
                Integer.parseInt(i)).collect(Collectors.toList())); //중간에 값을 넣고 삭제하는 작업을 많이 해야하므로 LinkedList 사용

        s = Integer.parseInt(br.readLine());

        while (s!=0 && start<n){//변환 가능한 횟수 s를 모두 소진하거나, 시작 인덱스가 리스트 개수보다 커지기 전까지 반복
            customSort(arr);
        }

        printArr(arr);
    }

    private static void customSort(List<Integer> arr){
        //시작 값으로 초기화
        int indexOfMaxValue = start;
        int maxValue = arr.get(start);

        int end = s + start + 1; //n은 개수(1부터 시작)이고 start는 인덱스(0부터 시작)이므로 +1을 해준다. 밑에 for문에서 i<end로 하기 위함.
        if(s+start>=n){//리스트 인덱스 범위를 넘어가지 않도록 조정
            end = n;
        }

        //순회하며 max값과 그 인덱스를 탐색
        for (int i=start;i<end;i++){
            if(maxValue<arr.get(i)){
                indexOfMaxValue = i;
                maxValue = arr.get(i);
            }
        }

        /*연속된 두 개의 원소만 교환할 수 있으므로 이동 가능한 범위 중
        가장 큰 수가 이동한 만큼을 교환 가능한 수 s에서 빼줌.
        이후 가장 큰 수를 리스트에서 지우고 가장 앞 인덱스로 옮겨옴*/
        s-=indexOfMaxValue-start;
        arr.remove(indexOfMaxValue);
        arr.add(start,maxValue);
        start++;
    }

    private static void printArr(List<Integer> arr){
        for (Integer o : arr){
            System.out.print(o+" ");
        }
    }
}