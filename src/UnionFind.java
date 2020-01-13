public interface UnionFind {
    int find(int p);
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
}