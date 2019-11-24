package algorithms.graph.mst;

/**
 * 最小生成树边对象(加权无向图的边)
 * 典型应用：电路（元器件，导线）， 航空（机场，航线），电力分配（电站，输电线），图像分析（面部容貌，相似关系）
 */
public class Edge implements Comparable<Edge>{
    private final int v; //顶点之一
    private final int w; //另一个顶点
    private final double weight; // 边的权重

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if(vertex == this.v) return w;
        else if(vertex == this.w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    public int compareTo(Edge that){
        if( this.weight > that.weight ) return 1;
        else if( this.weight < that.weight ) return -1;
        else return 0;
    }

    public String toString(){
        return String.format("%d-%d %.2f", v, w, weight);
    }

}
