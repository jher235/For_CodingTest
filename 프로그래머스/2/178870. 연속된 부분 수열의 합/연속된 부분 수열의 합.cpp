#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    
    int answerLength = sequence.size()+2;

    int start = 0;
    int end = 0;
    int sum = 0;
    
    while(start < sequence.size()){
        if(sum < k){
            if(end < sequence.size()){
                sum += sequence[end];
                end++;
            }else{
                break; // end가 끝까지 간 상태인데 부분 수열이 k보다 작으면 종료.
            }
        }else if(sum == k){
            if(end - start < answerLength){
                answer = {start, end-1};
                answerLength = end - start;
            }
            if(end < sequence.size()){
                sum += sequence[end];
                end++;
            }else{
                break;
            }
        }else if (sum > k){
            sum -= sequence[start];
            start++;
        }
    }
        
    return answer;
}