import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;

                if(computers[i][j]==1){
                    list.get(i).add(j);
                }
            }
        }

        for(int idx=0; idx<n; idx++){
            if(!visited[idx]) {
                bfs(idx);
                answer++;
            }
        }

        return answer;
    }

    static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);

        while(!queue.isEmpty()){
            int curNode = queue.poll();

            for(int idx=0; idx<list.get(curNode).size(); idx++){
                int nextNode = list.get(curNode).get(idx);

                if(visited[nextNode]) continue;

                visited[nextNode] = true;
                queue.offer(nextNode);
            }
        }
    }
}