package us.lsi.astar.viajeintergalatico.alumnos;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import org.jgrapht.EdgeFactory;

import us.lsi.astar.AStarGraph;
import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.UndirectedSimpleVirtualGraph;

public class GrafoNave extends UndirectedSimpleVirtualGraph<EstadoNave, SimpleEdge<EstadoNave>>
		implements AStarGraph<EstadoNave, SimpleEdge<EstadoNave>> {

	public GrafoNave(EdgeFactory<EstadoNave, SimpleEdge<EstadoNave>> edgeFactory) {
		super(edgeFactory);
	}
	public static GrafoNave create(EdgeFactory<EstadoNave, SimpleEdge<EstadoNave>> edgeFactory) {
		return new GrafoNave(edgeFactory);
	}
	@Override
	public double getEdgeWeight(SimpleEdge<EstadoNave> e) {
		double res = 0.;
		if(e.getSource().getArmas_seleccionadas().size()<e.getTarget().getArmas_seleccionadas().size()){
			res = e.getTarget().getPeso()-e.getSource().getPeso();
		}
		
		return res;
	}
	@Override
	public double getVertexWeight(EstadoNave vertex) {
		// TODO
		return 0.;
	}

	@Override
	public double getVertexWeight(EstadoNave vertex, SimpleEdge<EstadoNave> edgeIn, SimpleEdge<EstadoNave> edgeOut) {
		// TODO
		return 0.;
	}

	
	@Override
	public double getWeightToEnd(EstadoNave actual, EstadoNave endVertex, Function<EstadoNave, Double> goalDistance,
			Set<EstadoNave> goalSet) {
		// TODO
		//utilizar la function del test goalDistance
		return 0.;
	}

}
