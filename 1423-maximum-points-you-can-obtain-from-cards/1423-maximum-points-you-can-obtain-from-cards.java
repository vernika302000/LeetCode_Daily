class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;
        for(int i=0;i<=k-1;i++) lsum += cardPoints[i];
        maxSum = lsum;
        int rIndex = cardPoints.length-1;
        for(int i=k-1;i>=0;i--)
        {
            lsum = lsum - cardPoints[i];
            rsum = rsum + cardPoints[rIndex];
            rIndex--;
            maxSum = Math.max(maxSum, lsum+rsum);
        }
        return maxSum;
    }
}