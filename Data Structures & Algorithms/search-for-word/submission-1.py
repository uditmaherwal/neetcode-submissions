class Solution:

    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])
        visited = [[False for _ in range(cols)] for _ in range(rows)]

        def dfs(r, c, i):
            if i == len(word):
                return True
            
            if r < 0 or c < 0 or r >= rows or c >= cols or word[i] != board[r][c] or visited[r][c]:
                return False
            
            visited[r][c] = True

            res = (dfs(r + 1, c, i+1) or
                dfs(r - 1, c, i+1) or
                dfs(r , c + 1, i+1) or
                dfs(r , c - 1, i+1))
            
            visited[r][c] = False
            return res

        for r in range(rows):
            for c in range(cols):
                if(dfs(r, c, 0)):
                    return True
        return False