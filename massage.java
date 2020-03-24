public class massage {
    //3.24按摩师
    public static int massage(int nums[]){
        //动态规划
        //dp[i] = max(dp[i-2],dp[i-3]) + nums[i]
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        for(int i = 3;i < nums.length;i ++){
            dp[i] = nums[i] + Math.max(dp[i-2],dp[i-3]);
        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);
    }
    public static int massageSolution(int nums[]){
        //题解做法，dp数组保存当前最优值
        //dp[i] = max(dp[i-1],dp[i-2] + nums[i])
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < nums.length;i ++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];

    }

    public static void main(String[] args) {
        int nums[] = {2,1,4,5,3,1,1,3};
        massage(nums);
    }
}
