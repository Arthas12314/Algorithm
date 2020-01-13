public class Components {
    Graph graph;
    private boolean[] visited;
    private int ccount;
    private int[] id;

    public Components(Graph graph){
        this.graph=graph;
        visited=new boolean[graph.V()];
        id=new int[graph.V()];
        ccount=0;
        for(int i=0;i<graph.V();i++){
            id[i]=-1;
            visited[i]=false;
        }

        for(int i=0;i<graph.V();i++){
            if(!visited[i]){
                dfs(i);
                ccount++;
            }
        }
    }
    public int getCcount(){
        return ccount;
    }

    // 查询点v和点w是否联通
    boolean isConnected(int v, int w) {
        assert(v >= 0 && v < graph.V());
        assert(w >= 0 && w < graph.V());
        return id[v] == id[w];
    }
    private void dfs(int v){
        visited[v]=true;
        id[v]=ccount;
        for(int i:graph.adj(v)){
            if(!visited[i])
                dfs(i);
        }
    }
}
