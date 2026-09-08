class Solution {

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean pacific, atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                pacific = false;
                atlantic = false;
                dfs(heights, i, j, Integer.MAX_VALUE);
                if(pacific && atlantic){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        return res;
    }

    private void dfs(int[][] heights, int r, int c, int prevVal){

        if(r < 0 || c < 0){
            pacific = true;
            return;
        }

        if(r >= heights.length || c >= heights[0].length){
            atlantic = true;
            return;
        }

        if(heights[r][c] > prevVal){
            return;
        }

        int tmp = heights[r][c];
        heights[r][c] = Integer.MAX_VALUE;
        for(int[] dir : directions){
            dfs(heights, r + dir[0], c + dir[1], tmp);
            if(pacific & atlantic) break;
        }
        heights[r][c] = tmp;

    }
}
