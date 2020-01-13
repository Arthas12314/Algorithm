import java.util.ArrayList;

//稠密图 邻接矩阵
public class DenseGraph implements Graph{
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
        if(hasEdge(v,w))
            return;
       graph[v][w]=true;
        if(!directed)
            graph[v][w]=true;
        edge++;
    }
    @Override
    public boolean hasEdge(int v,int w){
        return graph[v][w];
    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < vertex ; i ++ ){
            for( int j = 0 ; j < vertex ; j ++ )
                System.out.print(graph[i][j]+"\t");
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个ArrayList不会带来额外开销,
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < vertex;
        ArrayList<Integer> adjV = new ArrayList<>();
        for(int i = 0 ; i < vertex ; i ++ )
            if( graph[v][i] )
                adjV.add(i);
        return adjV;
    }
}
