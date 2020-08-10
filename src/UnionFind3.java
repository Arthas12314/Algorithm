public class UnionFind3 implements UnionFind {
    private int[] parent;
    private int[] sz;
    private int size;
    public UnionFind3(int n){
        parent=new int[n];
        sz=new int[n];
        size=n;
        for(int i=0;i<n;i++){
            parent[i]=i;
            sz[i]=1;
        }
    }
    @Override
    public int find(int p) {
        while(parent[p]!=p) {
            p=parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if(qRoot==pRoot)
            return;
        if(sz[pRoot]>sz[qRoot]){
            parent[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];
        }
        else {
            parent[pRoot]=qRoot;
            sz[qRoot]+=sz[pRoot];
        }
    }
}
