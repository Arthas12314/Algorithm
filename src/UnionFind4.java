public class UnionFind4 implements UnionFind {
    private int[] parent;
    private int[] rank;
    private int size;
    public UnionFind4(int n){
        parent=new int[n];
        rank=new int[n];
        size=n;
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    @Override
    public int find(int p) {
        while(parent[p]!=p)
            p=parent[p];
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
        if(rank[pRoot]>rank[qRoot]){
            parent[qRoot]=pRoot;
        }
        else if(rank[pRoot]<rank[qRoot]){
            parent[pRoot]=qRoot;
        }
        else {
            parent[pRoot]=qRoot;
            rank[qRoot]+=1;
        }
    }
}
