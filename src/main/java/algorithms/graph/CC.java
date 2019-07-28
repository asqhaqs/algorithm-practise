package algorithms.graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 连通分量api
 */
public class CC {
    private boolean[] marked;
    private int[] id;  // v所在的连通分量的标识符 （0 ~ count-1）
    private int count; // 连通分量数

    /**
     * 预处理构造函数
     * @param G
     */
    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int s = 0; s < G.V(); s++){
            if(!marked[s]){
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for(int w: G.adj(v)){
            if(!marked[w])
                dfs(G, w);
        }
    }

    //v 和 w 连通吗
    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }


    public static void main(String[] args) {
        Graph G = new Graph(new In("tinyCG.txt"));
        CC cc = new CC(G);

        int M = cc.count;
        StdOut.println(M + " components");
        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];
        for(int i = 0; i < M; i++ ){
            components[i] = new Bag<Integer>();
        }
        for (int v = 0; v < G.V(); v++ ){
            components[cc.id[v]].add(v);
        }
        for(int i = 0; i < M; i++){
            for(int v: components[i]){
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
    }

}
