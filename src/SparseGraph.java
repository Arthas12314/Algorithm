import java.util.ArrayList;

//稀疏图 - 邻接表
public class SparseGraph {
    class adjIterator{
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
    }

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

    public int V(){
        return vertex;
    }
    public int E(){
        return edge;
    }

    public void addEdge(int v,int w){
        if(hasEdge(v,w))
            return;
        graph[v].add(w);
        if(v!=w && !directed)
            graph[w].add(v);
        edge++;
    }

    public boolean hasEdge(int v,int w){
        for( int i = 0 ; i < graph[v].size() ; i ++ )
            if( graph[v].get(i) == w )
                return true;
        return false;
    }
}
