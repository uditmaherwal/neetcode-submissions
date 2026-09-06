class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n-1 :
            return False;

        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        visited = [False] * n
        q = collections.deque();
        q.append(0);
        visited[0] = True

        while len(q) > 0:
            current = q.popleft();
            for v in adj[current]:
                if not visited[v]:
                    visited[v] = True
                    q.append(v)
            
        return all(visited)


        
