import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // Arrays.sort(targets, new Comparator<int[]>(){
        //    @Override
        //     public int compare(int[] o1, int[] o2){
        //         return o1[1] - o2[1];
        //     }
        // });
        
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int loc = 0;
        for(int[] target : targets){
            if(loc <= target[0]){
                answer++;
                loc = target[1];
            }
        }
        
        return answer;
    }
}