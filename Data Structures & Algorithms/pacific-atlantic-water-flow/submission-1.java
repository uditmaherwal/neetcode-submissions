class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;
        for(int[] d : directions){
            
            int nr = r + d[0], nc = c + d[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && 
            !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, ocean, heights);
            }
        }
        
    }


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows_size = heights.length;
        int cols_size = heights[0].length;
        boolean[][] pac = new boolean[rows_size][cols_size];
        boolean[][] atl = new boolean[rows_size][cols_size];
        
        for(int c = 0; c < cols_size; c++){
            dfs(0, c, pac, heights);
            dfs(rows_size - 1, c, atl, heights);
        }

        for(int r = 0; r < rows_size; r++){
            dfs(r, 0, pac, heights);
            dfs(r, cols_size - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < rows_size; r++){
            for(int c = 0; c < cols_size; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }
}
