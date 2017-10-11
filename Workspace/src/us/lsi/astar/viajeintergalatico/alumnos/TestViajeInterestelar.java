package us.lsi.astar.viajeintergalatico.alumnos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.jgrapht.GraphPath;

import com.google.common.collect.Lists;

import us.lsi.algoritmos.Algoritmos;
import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;
import us.lsi.graphs.SimpleEdge;

public class TestViajeInterestelar {
	
	public static EstadoNave estadoInicial;
	public static void main(String[] args) {

		// TODO: Inicializa el problema hangar y requisitos
		List<String> requisitos= Lists.newArrayList("Laser", "Ligera", "Paralizante",
				"Cuerpo-Cuerpo");
		List<ObjetoHangar> hangar = Lists.newArrayList(
				new ObjetoHangar("P-90", Lists.newArrayList("Laser", "Ligera"), 150f, 750f),
				new ObjetoHangar("P-90-2", Lists.newArrayList("Laser", "Ligera"), 250f, 650f),
				new ObjetoHangar("Disruptor kull", Lists.newArrayList("Paralizante", "Ligera"),
				250f, 500f),
				new ObjetoHangar("Zat", Lists.newArrayList("Laser", "Paralizante", "Cuerpo-Cuerpo"), 220f, 350f),
				new ObjetoHangar("OriZouk", Lists.newArrayList("Torpedo"), 100f, 100f)
		);
				
		// TODO: Crear estado inicial vacio
		List<ObjetoHangar> l = new ArrayList<ObjetoHangar>();
		Integer i = 0;
		estadoInicial = new EstadoNave(l,i, hangar);
		
		// TODO: Generar function objetivo
		Function<EstadoNave, Double> function = (e -> {
			if (requisitos.stream().allMatch(req ->
			 e.getArmas_seleccionadas().stream().anyMatch(arma ->
			 arma.caracteristicas.contains(req)))) {
			return 0.0;
			} else {
			return Double.MAX_VALUE;
			}
		});
		
		// TODO: Crear grafo AStart
		AStarGraph<EstadoNave,SimpleEdge<EstadoNave>> graph = GrafoNave.create(SimpleEdge::create);
		
		// TODO: Crear Algoritmo AStar y le pasamos el grafo, el estado inicial
		// y el function
		AStarAlgorithm<EstadoNave,SimpleEdge<EstadoNave>> alg = Algoritmos.createAStar(graph, estadoInicial, function);
		
		
		
		if (alg.getPath() == null) {
			System.out.println("No se encuentra solucion");
		} else {
			System.out.println(
					"Danyo: " + alg.getPathLength() + ":" + alg.getPath().getEndVertex().getArmas_seleccionadas());
		}
	}

}
