#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    int cover = 0;
    for (int point : section){
        if(point > cover){
            answer++;
            cover = point + m - 1;
        }
    }
    
    return answer;
}