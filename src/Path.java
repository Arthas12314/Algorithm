import java.util.ArrayList;
import java.util.LinkedList;

public class Path {
    Graph graph;
    int start;
    private int[] from;
    private boolean[] visited;

    public Path(Graph graph, int s) {
        this.graph = graph;
        this.start = s;
        from = new int[graph.V()];
        visited = new boolean[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        dfs(start);
    }

    public boolean hasPath(int w) {
        return visited[w];
    }

    public ArrayList<Integer> path(int w) {
        LinkedList<Integer> list = new LinkedList<>();
        int temp = w;
        while (temp != -1) {
            list.add(temp);
            temp = from[temp];
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!list.isEmpty()) {
            res.add(list.removeLast());
        }
        return res;
    }

    public void showPath(int w) {
        ArrayList<Integer> res = path(w);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i == res.size() - 1) {
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int i : graph.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    // 测试寻路算法
    public static void main(String[] args) {

        String filename = "testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g, 0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}
