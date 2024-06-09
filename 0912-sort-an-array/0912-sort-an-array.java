class Solution {
    public void merge(int low,int mid,int high,int[] nums)
    {
        ArrayList<Integer> al=new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left<=mid && right<=high)
        {
            if(nums[left]<=nums[right]) 
            {
                al.add(nums[left]);
                left++;
            }
            else
            {
                al.add(nums[right]);
                right++;
            }
        }
        while(left<=mid)
        {
            al.add(nums[left]);
            left++;
        }
        while(right<=high)
        {
            al.add(nums[right]);
            right++;
        }
        for(int i=low;i<=high;i++)
        {
            nums[i]=al.get(i-low);
        }
    }
    public void mergeSort(int low,int high,int[] nums)
    {
        if(low>=high) return;
        int mid = (low+high)/2;
        mergeSort(low,mid,nums);
        mergeSort(mid+1,high,nums);
        merge(low,mid,high,nums);
    }
    public int[] sortArray(int[] nums) 
    {
        mergeSort(0,nums.length-1,nums);
        return nums;
    }
    
}