import java.util.*;

class Solution {
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        dist = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        list = new ArrayList<>();
        
        for(int idx=0; idx<=n; idx++) list.add(new ArrayList<>());
        
        for(int[] road : roads){
            int s = road[0];
            int e = road[1];
            
            list.get(s).add(e);
            list.get(e).add(s);
        }
        
        dijkstra(destination);
        
        int i = 0;
        for(int source : sources){
            if(dist[source]==Integer.MAX_VALUE) answer[i++] = -1;
            else answer[i++] = dist[source];
        }
        
        return answer;
    }
    
    static void dijkstra(int d){
        Queue<int[]> queue = new LinkedList<>();
        visited[d] = true;
        dist[d] = 0;
        queue.offer(new int[]{d, 0});
        
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            
            int curLoc = info[0];
            int curDist = info[1];
            
            for(int idx=0; idx<list.get(curLoc).size(); idx++){
                int nextLoc = list.get(curLoc).get(idx);
                
                if(!visited[nextLoc]){
                    visited[nextLoc] = true;
                    dist[nextLoc] = Math.min(dist[nextLoc], curDist+1);
                    queue.offer(new int[]{nextLoc, curDist+1});
                }
            }
        }
    }
}