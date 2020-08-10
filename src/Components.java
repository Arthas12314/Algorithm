public class Components {
    Graph graph;
    private boolean[] visited;
    private int ccount;
    private int[] id;

    public Components(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        id = new int[graph.V()];
        ccount = 0;
        for (int i = 0; i < graph.V(); i++) {
            id[i] = -1;
            visited[i] = false;
        }

        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    public int getCcount() {
        return ccount;
    }

    // 查询点v和点w是否联通
    boolean isConnected(int v, int w) {
        assert (v >= 0 && v < graph.V());
        assert (w >= 0 && w < graph.V());
        return id[v] == id[w];
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;
        for (int i : graph.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        // TestG1.txt
        String filename1 = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.getCcount());
        System.out.println();

        // TestG2.txt
        String filename2 = "testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.getCcount());
    }
}
