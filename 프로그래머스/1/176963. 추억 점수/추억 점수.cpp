#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    for(int i=0; i<photo.size();i++){
        int point = 0;
        for(int j=0 ; j<photo.at(i).size(); j++){
            for (int k=0; k < name.size() ; k++){
                if(photo.at(i).at(j) == name[k]){
                    point += yearning[k];
                }
            }
            
        }
        answer.push_back(point);
    }
    return answer;
}