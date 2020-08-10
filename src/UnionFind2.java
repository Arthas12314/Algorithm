public class UnionFind2 implements UnionFind {
    private int[] parent;
    private int size;

    public UnionFind2(int n) {
        parent = new int[n];
        size = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }
}
