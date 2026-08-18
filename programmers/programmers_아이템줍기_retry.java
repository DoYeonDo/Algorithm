import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int res = 0;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        for(int[] rec : rectangle){
            makeRectangle(2*rec[0], 2*rec[1], 2*rec[2], 2*rec[3]);
        }

        bfs(2*characterX, 2*characterY, 2*itemX, 2*itemY);

        return res/2;
    }

    static void bfs(int characterX, int characterY, int itemX, int itemY){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{characterY, characterX, 0});
        visited[characterY][characterX] = true;

        while(!que.isEmpty()){
            int[] curLoc = que.poll();
            int y = curLoc[0];
            int x = curLoc[1];
            int d = curLoc[2];

            if(y==itemY && x==itemX){
                res = d;
                break;
            }

            for(int dir=0; dir<4; dir++){
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                //범위 벗어남
                if(1>ny || ny>100 || 1>nx || nx>100) continue;
                //사각형 내부이거나 이미 방문
                if(map[ny][nx]!=1 || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                que.offer(new int[]{ny,nx,d+1});
            }
        }
    }

    static void makeRectangle(int leftX, int leftY, int rightX, int rightY){
        for(int i = leftY; i <= rightY; i++){
            for(int j = leftX; j <= rightX; j++){
                if(map[i][j]==2) continue;

                if(i==leftY || j==leftX ||
                        i==rightY || j==rightX){
                    map[i][j] = 1;
                }
                else{
                    map[i][j] = 2;
                }
            }
        }
    }
}