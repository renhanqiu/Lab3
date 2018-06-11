package graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vertex.Vertex;

public interface Graph<L,E> {
//public static  <L,E> Graph<L,E> empty(); //����һ��ͼ�Ŀ�ʵ��
public void setName(String name);
public String getName();
public String getType();
public boolean addVertex(L v);//��ͼ�����һ���ڵ�	
public boolean removeVertex(L v);    //��ͼ��ɾ��һ���ڵ㣬�����ĳ���ߵ�����֮һ����ñ߱�ɾ��������ǳ��ߣ�����Ϸ������£�������Ϸ���ɾ����

public Set<L> vertices();//����ͼ�нڵ�ļ���
public Map<L,List<Double>> sources(L target);//keyΪsource�ڵ㣬List<Double>Ϊ��ǰ�ڵ���source�ڵ�֮������бߵ�Ȩֵ
public Map<L,List<Double>> targets(L source);//ͬ�ϲ��
public boolean addEdge(E adge);  //���һ����
public boolean removeEdge(E edge);//ɾ��һ����
public Set<E> edges() ;//���رߵļ���

public boolean legalEdge(String type, String weighted, String directed);

 

























}
