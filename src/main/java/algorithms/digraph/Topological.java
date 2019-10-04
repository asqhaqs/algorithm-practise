package algorithms.digraph;

import edu.princeton.cs.algs4.SymbolDigraph;

public class Topological {
    private Iterable<Integer> order;   //拓扑的顺序

    public Topological(Digraph G){
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if(!cycleFinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }
    //拓扑有序的所有顶点
    public Iterable<Integer> order(){
        return order;
    }

    //G是有向无环图吗
    public boolean isDAG(){
        return order != null;
    }

    public static void main(String[] args) {

    }
}
