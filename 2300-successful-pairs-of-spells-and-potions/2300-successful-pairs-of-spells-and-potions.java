class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++){
            int left=0;
            int right=potions.length-1;
            int index=potions.length;
            while(left<=right){
                int mid = left+(right-left)/2;
                long prod=1L*spells[i]*potions[mid];
                if(prod>=success){
                    index=mid;
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            ans[i]=potions.length-index;
        }
        return ans;
    }
}