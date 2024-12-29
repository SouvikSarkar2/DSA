class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        if(m==0){
            for(int i = 0 ; i<n  ; i++ ){
                nums1[i]=nums2[i];
            }
            return;
        }
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        int ans[]=new int[m+n];
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                ans[k++]=nums1[i++];
            }
            else{
                ans[k++]=nums2[j++];
            }
        }
        while(i<m){
            ans[k++]=nums1[i++];
        }
        while(j<n){
             ans[k++]=nums2[j++];
        }
        for(k = 0 ; k<m+n ; k++){
            nums1[k]=ans[k];
        }
    }
}
