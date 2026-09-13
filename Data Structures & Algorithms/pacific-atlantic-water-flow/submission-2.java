class Solution {

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacifics = new boolean[rows][cols];
        boolean[][] atlantics = new boolean[rows][cols];

        for(int c = 0; c < cols; c++){
            dfs(0, c, pacifics, heights);
            dfs(rows - 1, c, atlantics, heights);
        }

        for(int r = 0; r < rows; r++){
            dfs(r, 0, pacifics, heights);
            dfs(r, cols - 1, atlantics, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pacifics[r][c] && atlantics[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;
        for(int[] d : directions){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length 
            && heights[nr][nc] >= heights[r][c] && !ocean[nr][nc]){
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
