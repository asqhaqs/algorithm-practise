package algorithms.digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 有向图的可达性API
 * 多点可达性的一个重要应用是 典型的内存管理系统中，在java的内存实现中，一个顶点表示一个对象，一条边表示一个对象对另一
 * 个的引用，标记-清除 的垃圾回收策略会为每一个对象保留一个标志位作垃圾回收使用，周期性的运行一个类似DirectedDFS的有向图
 * 可达性算法来标记所有可以被访问到的对象，然后清理所有未被标记的对象
 * DepthFirstPaths 和 BreadthFirstPaths 也是有向图的重要算法，他们主要解决以下问题：
 * 单点有向路径：“从s到给定目的定点v是否有一条有向路径”
 * 单点最短有向路径： “从s到给定目的顶点是否有一条有向路径， 如果有，找出最短路径”
 * Created by xudong on 2019/8/17.
 */
public class DirectedDFS {
    private boolean[] marked;

    // 在 有向图 G 中， 端点s 开始 的可达路径有哪些
    public DirectedDFS( Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    // 多个起始点的情况
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
