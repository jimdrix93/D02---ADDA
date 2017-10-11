package us.lsi.algoritmos;

import java.util.Set;
import java.util.function.Function;


import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;

public class Algoritmos {

	
	
	

	/**
	 * Un algoritmo AStar para ir del v�rtice de inicio hasta el v�rtice destino
	 * 
	 * @param <V> Tipo del v�rtice
	 * @param <E> Tipo de la arista
	 * @param graph Grafo 
	 * @param startVertex V�rtice origen
	 * @param endVertex V�rtice destino
	 * @return Algoritmo AStar
	 * 
	 */
	public static <V, E> AStarAlgorithm<V, E> createAStar(
			AStarGraph<V, E> graph, V startVertex, V endVertex) {
		return new AStarAlgorithm<V, E>(graph, startVertex, endVertex);
	}
	/**
	 * Un algoritmo AStar para ir del v�rtice de inicio hasta el  primer v�rtice que cumple el predicado
	 * @param <V> Tipo del v�rtice
	 * @param <E> Tipo de la arista
	 * @param graph Grafo
	 * @param startVertex V�rtice origen
	 * @param goalDistance Distancia a un objetivo 
	 * @return Algoritmo AStar
	 */
	
	public static <V, E> AStarAlgorithm<V, E> createAStar(
			AStarGraph<V, E> graph, V startVertex, Function<V,Double> goalDistance) {
		return new AStarAlgorithm<V, E>(graph, startVertex, goalDistance);
	}

	/**
	 * Un algoritmo AStar para ir del v�rtice de inicio hasta alcanzar uno de los v�rtices objetivo
	 * 
	 * @param <V> Tipo del v�rtice
	 * @param <E> Tipo de la arista
	 * @param graph Grafo
	 * @param startVertex V�rtice origen
	 * @param goalSet Conjunto de v�rtices objetivo 
	 * @return Algoritmo AStar
	 * 
	 */
	public static <V, E> AStarAlgorithm<V, E> createAStar(
			AStarGraph<V, E> graph, V startVertex, Set<V> goalSet) {
		return new AStarAlgorithm<V, E>(graph, startVertex, goalSet);
	}



}
