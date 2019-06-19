package medium

func numIslands(grid [][]byte) int {
	res := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			res = dfs(grid, i, j) + res
		}
	}
	return res
}

func dfs(grid [][]byte, i, j int) int {
	if i < 0 || i >= len(grid) ||
		j < 0 || j >= len(grid[0]) || grid[i][j] == 0 {
		return 0
	}

	grid[i][j] = 0
	dfs(grid, i-1, j)
	dfs(grid, i+1, j)
	dfs(grid, i, j+1)
	dfs(grid, i, j-1)
	return 1
}
