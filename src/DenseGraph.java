import java.util.ArrayList;

public class DenseGraph {
    private int vertex;
    private int edge;
    private boolean directed;
    private boolean[][] graph;
    public DenseGraph(int v,boolean d){
        this.vertex=v;
        this.edge=0;
        this.directed=d;
        graph=new boolean[v][v];
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
       graph[v][w]=true;
        if(!directed)
            graph[v][w]=true;
        edge++;
    }
    public boolean hasEdge(int v,int w){
        return graph[v][w];
    }
}
