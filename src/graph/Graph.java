package graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vertex.Vertex;

public interface Graph<L,E> {
//public static  <L,E> Graph<L,E> empty(); //构造一张图的空实例
public void setName(String name);
public String getName();
public String getType();
public boolean addVertex(L v);//向图中添加一个节点	
public boolean removeVertex(L v);    //在图中删除一个节点，如果是某条边的两段之一，则该边被删除，如果是超边，如果合法就留下，如果不合法就删除。

public Set<L> vertices();//返回图中节点的集合
public Map<L,List<Double>> sources(L target);//key为source节点，List<Double>为当前节点与source节点之间的所有边的权值
public Map<L,List<Double>> targets(L source);//同上差不多
public boolean addEdge(E adge);  //添加一条边
public boolean removeEdge(E edge);//删除一条边
public Set<E> edges() ;//返回边的集合

public boolean legalEdge(String type, String weighted, String directed);

 

























}
