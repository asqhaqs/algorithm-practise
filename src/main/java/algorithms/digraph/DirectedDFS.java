package algorithms.digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 有向图的可达性API
 * Created by xudong on 2019/8/17.
 */
public class DirectedDFS {
    private boolean[] marked;

    // 在 有向图 G 中， 端点s 开始 的可达路径有哪些
    public DirectedDFS( Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for(int s: sources){
            if(!marked[s])
                dfs(G, s);
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w])
                dfs(G, w);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In("tinyDG.txt"));
        Bag<Integer> sources = new Bag<Integer>();
        for(int i = 0; i < args.length; i++){
            sources.add(Integer.parseInt(args[i]));
        }

        DirectedDFS reachable = new DirectedDFS(G, sources);
        for(int v = 0; v < G.V(); v++){
            if(reachable.marked(v))
                StdOut.print(v + " ");
        }
        System.out.println();
    }

}
