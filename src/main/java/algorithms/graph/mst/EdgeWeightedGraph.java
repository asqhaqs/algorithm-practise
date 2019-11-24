package algorithms.graph.mst;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 最小生成树（加权无向图）
 * 典型应用：电路（元器件，导线）， 航空（机场，航线），电力分配（电站，输电线），图像分析（面部容貌，相似关系）
 */


public class EdgeWeightedGraph {
    private final int V; // 顶点总数
    private int E;       // 边的总数
    private Bag<Edge>[] adj; // 邻接表

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        for(int v = 0; v < V; v++){
            adj[v] = new Bag<Edge>();
        }
    }

    public EdgeWeightedGraph(In in){
        this(in.readInt());
        this.E = in.readInt();
        for(int v = 0; v < E; v++){
            int v1 = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v1, w, weight);
            addEdge(e);
        }
    }

    public int V(){ return V;}
    public int E(){ return E;}

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> b = new Bag<>();
        for(int v=0; v<V; v++){
            for(Edge e: adj[v]){
                if(e.other(v) > v) b.add(e);
            }
        }
        return b;
    }

}
