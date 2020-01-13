import java.util.ArrayList;

//稀疏图 - 邻接表
public class SparseGraph implements Graph{
    /*class adjIterator{
        private SparseGraph Graph;
        private int vertex;
        private int index;
        public adjIterator(SparseGraph graph,int v){
            this.Graph=graph;
            this.vertex=v;
            this.index=0;
        }

        public int begin(){
            index=0;
            if(Graph.graph[vertex].size()!=0)
                return Graph.graph[vertex].get(0);
            return -1;
        }

        public int next(){
            index++;
            if(index<Graph.graph[vertex].size())
                return Graph.graph[vertex].get(index);
            return -1;
        }

        public boolean end(){
            return index>=Graph.graph[vertex].size();
        }
    }*/

    private int vertex;
    private int edge;
    private boolean directed;
    private ArrayList<Integer>[] graph;

    public SparseGraph(int v,boolean d){
        this.vertex=v;
        this.edge=0;
        this.directed=d;
        graph=new ArrayList[v];
        for(int i=0;i<v;i++)
            graph[i]=new ArrayList<>();
    }
    @Override
    public int V(){
        return vertex;
    }

    @Override
    public int E(){
        return edge;
    }

    @Override
    public void addEdge(int v,int w){
        assert (v<0 && v>vertex && w<0 && w>vertex);
        if(hasEdge(v,w))
            return;
        graph[v].add(w);
        if(v!=w && !directed)
            graph[w].add(v);
        edge++;
    }

    @Override
    public boolean hasEdge(int v,int w) {
        assert (v<0 && v>vertex && w<0 && w>vertex);
        for( int i = 0 ; i < graph[v].size() ; i ++ )
            if( graph[v].get(i) == w )
                return true;
        return false;
    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < vertex ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < graph[i].size() ; j ++ )
                System.out.print(graph[i].get(j) + "\t");
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个ArrayList不会带来额外开销,
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < vertex;
        return graph[v];
    }
}
