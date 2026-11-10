import java.util.*;

class Solution {

    // class Word{
    //     int cnt;
    //     String value;

    //     public Word(int cnt, value){
    //         this.cnt = cnt;
    //         this.value = value;
    //     }
    // }

    Map<String, Integer> map = new HashMap<>();

    
    public List<String> topKFrequent(String[] words, int k) {

        // 우선순위 큐

        // 우선 디폴트는 오름차순이므로...
        // PriorityQueue<Word> pq = new PriorityQueue<>((a, b) ->{
        //     if(a.cnt != b.cnt) return b.cnt-a.cnt;
        //     return String.compare(a.value, b.value);
        // });

        /*
        방법 2가지 생각남.
        우선 map으로 전부 기록한 뒤 반복문 돌면서 횟수를 뽑음. 그 다음 다시 윗 횟수에 
        해당하는 애들만 뽑아서 문자열로 정렬하고 그거만큼 k에서 뺀다.
        -> n^2인데
        여기서 만약 돌고 해당하는 애들은 map에서 제거해줬다면 nlogn이네.
        
        다른 하나는 우선 순위 큐를 사용하는건데... 근데 다시 생각해보니까 이건 이미 기록 
        되어 있던 문자인지 확인하는 부분이 단순히 우선 순위 큐로 해결 안되어서 결국 map을 써야함

         */

        for(String s : words){

            map.merge(s, 1, Integer::sum);
            
        }

        List<String> keys = new ArrayList<>(map.keySet());

        keys.sort((a,b) -> {
            if(!map.get(a).equals(map.get(b))) return map.get(b) - map.get(a);
            return a.compareTo(b);
        });

        return keys.subList(0, k);


    }
}