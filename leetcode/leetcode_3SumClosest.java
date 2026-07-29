class Solution {
    static int[] comb = new int[3];
    static int[] numbers;
    static int minDiff;
    static int res;

    public int threeSumClosest(int[] nums, int target) {
        numbers = nums;
        minDiff = Integer.MAX_VALUE;
        res = 0;
        comb(0,0,target);
        return res;
    }

    static void comb(int start, int cnt, int target){
        if(cnt==3){
            int sum = comb[0] + comb[1] + comb[2];

            int diff = 0;
            if(target < sum) diff = sum - target;
            else diff = target - sum;

            if(minDiff > diff){
                minDiff = diff;
                res = sum;
            }

            return;
        }

        for(int idx = start; idx < numbers.length; idx++){
            comb[cnt] = numbers[idx];
            comb(idx+1, cnt+1, target);
        }
    }
}