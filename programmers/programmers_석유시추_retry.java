import java.util.*;

class Solution {
    static int height;
    static int width;
    static boolean[][] visited;
    static int[][] map;
    
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    
    static List<Integer> loafs = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> colNumbering = new ArrayList<>();
    
    public int solution(int[][] land) {
        height = land.length;
        width = land[0].length;
        map = land;
        
        visited = new boolean[height][width];
        
        for(int idx=0; idx<width; idx++)
            colNumbering.add(new ArrayList<>());
        
        int numbering = 0;
        for(int row=0; row<height; row++){
            for(int col=0; col<width; col++){
                if(!visited[row][col] && map[row][col]==1) bfs(row, col, numbering++);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<colNumbering.size(); i++){
            int sum = 0;
            for(int j=0; j<colNumbering.get(i).size(); j++){
                int loaf = colNumbering.get(i).get(j);
                sum += loafs.get(loaf);
            }
            max = Math.max(max, sum);
        }
        
        return max;
    }
    
    static void bfs(int row, int col, int numbering){
        Set<Integer> cols = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.offer(new int[]{row, col, 1});
        int sum = 0;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int s = cur[2];
            cols.add(c);
            sum++;
            
            for(int dir=0; dir<4; dir++){
                int nr = r + dy[dir];
                int nc = c + dx[dir];
                
                if(nr<0 || nr>=height || nc<0 || nc>=width) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc]==0) continue;
                
                visited[nr][nc] = true;
                queue.offer(new int[]{nr,nc,s+1});
            }
        }
        
        loafs.add(sum);
        for(int c : cols){
            colNumbering.get(c).add(numbering);
        }
    }
}