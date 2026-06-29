class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(i,isConnected,n,visited);
                count++;
            }
        }
        return count;
    }
    void bfs(int start,int[][] Graph,int n,boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i=0;i<n;i++){
                if(!visited[i]&&Graph[start][i]==1){
                    bfs(i,Graph,n,visited);
                    visited[i] = true;
                }
            }
        }
    }
}