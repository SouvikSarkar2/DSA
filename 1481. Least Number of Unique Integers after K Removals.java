class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0  ; i <arr.length ; i++){
            if(hm.containsKey(arr[i])){
                int val = hm.get(arr[i])+1;
                hm.put(arr[i],val);
            }
            else{
                hm.put(arr[i],1);
            }
        }

        int freq[]=new int[hm.size()];
        int i = 0 ;
        for (Integer key : hm.keySet()) {
            freq[i] = hm.get(key);
            i++;
}


        
    Arrays.sort(freq); 
  
        int j = 0;
        while(k>0){
            if(freq[j]==0){
                j++;
            }
            else{
                freq[j]--;
                k--;
            }
        }
        int count = 0 ;
        for(i = 0 ; i<freq.length ; i++){
            if(freq[i]!=0){
                count++;
            }
        }
        

        return count;
    }
}
