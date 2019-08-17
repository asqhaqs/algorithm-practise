package algorithms.digraph;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by xudong on 2019/8/17.
 * 检测有向图中是否有 环的存在， 保证该图 为有向无环图（DAG）， 因为环的存在在有向图中常常指代死锁问题，
 * 所以建模需要有向无环图
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle; //有向环中所有顶点（如果存在）
    private boolean[] onStack; //递归调用的栈上的所有顶点

    public DirectedCycle(Digraph G){
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++){
            if(!marked[v]){
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v){
        onStack[v] = true;
        marked[v] = true;
        for(int w: G.adj(v)){
            if(this.hasCycle()) return;
            else if(!marked[w]){
                edgeTo[w] = v;  // 顶点的上一个顶点
                dfs(G, w);
            }
            else if(onStack[w]){
                cycle = new Stack<Integer>();
                for(int x = v; x != w; x = edgeTo[x]){
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);   // w的上一个是 v
            }
        }

        onStack[v] = false;   //深度优先结束后将 v 出栈
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }

    public boolean hasCycle(){
        return cycle != null;
    }

}
