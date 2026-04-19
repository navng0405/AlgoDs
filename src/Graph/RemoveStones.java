package Graph;

public class RemoveStones {
    private static int[] parent;

    public static int removeStones(int[][] stones) {
        int N = stones.length;
        parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
        }

        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }

        int components = 0;
        for (int i = 0; i < N; ++i) {
            if (parent[i] == i) {
                components++;
            }
        }

        return N - components;
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));
    }
}
