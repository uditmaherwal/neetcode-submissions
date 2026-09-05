class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        dfs(0, graph, visited);

        for(boolean node : visited){
            if(!node)
                return false;
        }

        return true;
    }

    private void dfs(int node,
                     Map<Integer, List<Integer>> graph,
                     boolean[] visited){

        visited[node] = true;

        for(int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, graph, visited);
            }
        }
    }
}
