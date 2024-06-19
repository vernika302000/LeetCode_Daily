class Solution {
    public int longestConsecutive(int[] nums) 
    {
        Set<Integer> hs = new HashSet<>();
        for(int val:nums) hs.add(val);
        
        int longest = 0;
        for(int val:nums)
        {
            if(hs.contains(val-1)) continue;
            else
            {
                int curr = val;
                int len = 1;
                while(hs.contains(curr+1))
                {
                    curr++;
                    len++;
                }
                longest = Math.max(len,longest);
            }
        }
        return longest;
        
    }
}