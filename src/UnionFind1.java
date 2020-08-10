public class UnionFind1 implements UnionFind {
    private int[] id;
    private int size;

    public UnionFind1(int n) {
        id = new int[n];
        size = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = id[p];
        int qID = id[q];
        for (int i = 0; i < size; i++) {
            if (id[i] == pID) {
                id[i] = qID;
                break;
            }
        }
    }
}
