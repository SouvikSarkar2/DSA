class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        findSrcToDest(graph,0,graph.length-1,ans,new ArrayList<>());
        return ans;
    }   

    void findSrcToDest(int[][] graph , int src , int dest,List<List<Integer>> ans , List<Integer> curr){
        if(src==dest){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0 ; i<graph[src].length ; i++){
            int currDest = graph[src][i];
            if(curr.size()==0){
                curr.add(0);
            }
            curr.add(currDest);
            findSrcToDest(graph,currDest,dest,ans,curr);
            curr.remove(curr.size()-1);
        }
    }
}
