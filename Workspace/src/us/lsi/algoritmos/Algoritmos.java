package us.lsi.algoritmos;

import java.util.Set;
import java.util.function.Function;


import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;

public class Algoritmos {

	
	
	

	/**
	 * Un algoritmo AStar para ir del vértice de inicio hasta el vértice destino
	 * 
	 * @param <V> Tipo del vértice
	 * @param <E> Tipo de la arista
	 * @param graph Grafo 
	 * @param startVertex Vértice origen
	 * @param endVertex Vértice destino
	 * @return Algoritmo AStar
	 * 
	 */
	public static <V, E> AStarAlgorithm<V, E> createAStar(
			AStarGraph<V, E> graph, V startVertex, V endVertex) {
		return new AStarAlgorithm<V, E>(graph, startVertex, endVertex);
	}
	/**
	 * Un algoritmo AStar para ir del vértice de inicio hasta el  primer vértice que cumple el predicado
	 * @param <V> Tipo del vértice
	 * @param <E> Tipo de la arista
	 * @param graph Grafo
	 * @param startVertex Vértice origen
	 * @param goalDistance Distancia a un objetivo 
	 * @return Algoritmo AStar
	 */
	
	public static <V, E> AStarAlgorithm<V, E> createAStar(
			AStarGraph<V, E> graph, V startVertex, Function<V,Double> goalDistance) {
		return new AStarAlgorithm<V, E>(graph, startVertex, goalDistance);
	}

	/**
	 * Un algoritmo AStar para ir del vértice de inicio hasta alcanzar uno de los vértices objetivo
	 * 
	 * @param <V> Tipo del vértice
	 * @param <E> Tipo de la arista
	 * @param graph Grafo
	 * @param startVertex Vértice origen
	 * @param goalSet Conjunto de vértices objetivo 
	 * @return Algoritmo AStar
	 * 
	 */
	public static <V, E> AStarAlgorithm<V, E> createAStar(
			AStarGraph<V, E> graph, V startVertex, Set<V> goalSet) {
		return new AStarAlgorithm<V, E>(graph, startVertex, goalSet);
	}



}
