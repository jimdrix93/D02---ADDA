package us.lsi.astar;

import java.util.Set;
import java.util.function.Function;

import org.jgrapht.Graph;

public interface AStarGraph<V, E> extends Graph<V,E> {
	/**
	 * @param vertex es el v�rtice actual
	 * @return El peso de vertex
	 */
	double getVertexWeight(V vertex);
	/**
	 * @param vertex El v�rtice actual
	 * @param edgeIn Una arista entrante o incidente en el v�rtice actual
	 * @param edgeOut Una arista saliente o incidente en el v�rtice actual
	 * @return el peso asociado al v�rtice suponiendo las dos aristas dadas d�nde la primera puede ser null
	 */
	double getVertexWeight(V vertex, E edgeIn, E edgeOut);
	
	/**
	 * @param actual El v�rtice actual
	 * @param endVertex El v�rtice destino
	 * @param goalDistance Un funci�n que mide la distancia del v�rtice actual a un objetivo. Debe cumplirse que si se alcanza el objetivo la distancia es cero
	 * @param goalSet Un conjunto de v�rtices destino
	 * @return Una cota inferior del peso del camino desde el v�rtice actual al destino, 
	 * o desde el v�rtice actual al objetivo
	 * o del m�nimo del v�rtice actual a los objetivos
	 */
	double getWeightToEnd(V actual, V endVertex, Function<V,Double> goalDistance, Set<V> goalSet);
}
