package algorithms.digraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;


/**
 * Created by xudong on 2019/8/16.
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public Digraph(In in){
        this(in.readInt());     //读取V并将图初始化
        int E = in.readInt();   //读取E
        for( int i =0; i < E; i++){
            //添加一条边
            int v = in.readInt(); //读取一个顶点
            int w = in.readInt(); //读取另一个顶点
            addEdge(v, w); // 添加一条连接他们的边
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    // 返回一个反向的 有向图
    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for(int v = 0; v < V; v++ ){
            for(int w : adj(v))
                R.addEdge(w, v);
        }
        return R;
    }

    //图的邻接表的字符串表示
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append(V + "vertices, " + E + " edges\n");
        for( int v = 0; v < V; v++){
            s.append(v + ": ");
            for( int w : this.adj(v) ){
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }



}

