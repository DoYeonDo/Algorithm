import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[1] != i2[1]){
                    return i1[1] - i2[1];
                }
                else{
                    return i1[0] - i2[0];
                }
            }
        });

        int cnt = 0;
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for(int row = 1; row < intervals.length; row++){
            int start = intervals[row][0];
            int end = intervals[row][1];

            if(start<prevEnd){
                cnt++;
                continue;
            }

            prevStart = start;
            prevEnd = end;
        }

        return cnt;
    }
}