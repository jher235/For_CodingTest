import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


class Main{

    private static int[] mx = {-1 , 1, 0, 0};
    private static int[] my = {0, 0, -1 , 1};

    private static int count = 0;

    private static int N, M;

    private static boolean[][] originMap;

    private static Set<Integer> dup = new HashSet<>();

    private static class MapHistory{
        boolean[][] map;
        int cnt;

        public MapHistory(boolean[][] map, int cnt) {
            this.map = map;
            this.cnt = cnt;
        }
    }

    private static Queue<MapHistory> maps = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        originMap = new boolean[5][5];


        for (int i=0; i<5; i++){
            char[] input = br.readLine().toCharArray();
            for (int j=0; j<5; j++){
                if(input[j] == '*'){
                    originMap[i][j] = true;
                    count++;
                }
                if(input[j] == '.'){
                    originMap[i][j] = false;
                }
            }
        }

        maps.add(new MapHistory(originMap, 0));
        dup.add(toInt(originMap));


        while(!maps.isEmpty()){
            MapHistory cur = maps.poll();

            if(isLinked(cur.map)){
                System.out.println(cur.cnt);
                break;
            }

            for (int i=0; i<5; i++){
                for (int j=0; j<5; j++){
                    if(cur.map[i][j]){
                        for (int k = 0; k<4; k++) {
                            int ny = i + my[k];
                            int nx = j + mx[k];
                            if (ny >= 0 && ny < 5 && nx >= 0 && nx <5) {
                                if (!cur.map[ny][nx]) {
                                    boolean[][] newMap = new boolean[5][5];
                                    for (int m = 0; m < 5; m++){
                                        newMap[m] = cur.map[m].clone();
                                    }
                                    newMap[ny][nx] = true;
                                    newMap[i][j] = false;
                                    Integer mapToInt = toInt(newMap);
                                    if(dup.contains(mapToInt)){
                                        continue;
                                    }else {
                                        dup.add(mapToInt);
                                        maps.add(new MapHistory(newMap, cur.cnt + 1));
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

    }

    private static Integer toInt (boolean[][] map){
        int bit = 0;
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                cnt++;
                if(map[i][j]){
                    bit = bit | (1<< cnt);
                }
            }
        }
        return bit;
    }

    private static boolean isLinked(boolean[][] map){

        boolean[][] visited = new boolean[5][5];

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){

                if(map[i][j]) {
                    visited[i][j] = true;
                    return count == dfs(map, visited, i, j, 1);
                }
            }
        }

        return false;
    }

    private static int dfs(boolean[][] map, boolean[][]visited, int i, int j, int c){

        for (int k = 0; k<4; k++){
            if(map[i][j]){
                int ny = i + my[k];
                int nx = j + mx[k];

                if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length){

                    if(map[ny][nx] && !visited[ny][nx]){
                        visited[ny][nx] = true;

                        c++;

                        c = dfs(map, visited, ny, nx, c);

                    }
                }
            }
        }

        return c;
    }

}
