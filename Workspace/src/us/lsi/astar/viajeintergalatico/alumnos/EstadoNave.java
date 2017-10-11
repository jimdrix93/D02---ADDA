package us.lsi.astar.viajeintergalatico.alumnos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.VirtualVertex;

public class EstadoNave implements VirtualVertex<EstadoNave, SimpleEdge<EstadoNave>> {

	static List<ObjetoHangar> hangar;
	
	private List<ObjetoHangar> armas_seleccionadas;
	private int arma_i;
	

	public EstadoNave() {
		//TODO
		super();
		this.armas_seleccionadas= new ArrayList<ObjetoHangar>();
		this.arma_i = 0;
		
	}

	public EstadoNave(List<ObjetoHangar> armas_seleccionadas, int arma_i, List<ObjetoHangar> hangar) {
		// TODO
		this.arma_i=arma_i;
		
		this.armas_seleccionadas=armas_seleccionadas;
		this.hangar = hangar;
	}

	@Override
	public boolean isValid() {
		boolean res = false;
		if(this.arma_i>=0 || this.arma_i<this.hangar.size()-1){
			res = true;
		}
		return res;
	}
	
	@Override
	public Set<EstadoNave> getNeighborListOf() {
		//conjuntoVecinos
		Set<EstadoNave> ret = new HashSet<EstadoNave>();
		Integer arma1 = 0;
		List<ObjetoHangar> l = new ArrayList<ObjetoHangar>(this.armas_seleccionadas);
		//CogeArma
		l.add(hangar.get(arma_i));
		EstadoNave cogeArma = new EstadoNave(l, arma1, this.hangar);
		//Float peso1 = hangar.get(arma_i).getPeso();
		//NoCogeArma
		if(this.arma_i<this.hangar.size()-1){
			arma1=this.arma_i+1;
		}
		List<ObjetoHangar> l2 = new ArrayList<ObjetoHangar>(this.armas_seleccionadas);
		EstadoNave noCogeArma = new EstadoNave(l2,arma1, this.hangar);
		//AñadeVecinos
		
		if(cogeArma.isValid()){
			ret.add(cogeArma);
		}
		if(noCogeArma.isValid()){
			ret.add(noCogeArma);
		}
		return ret;
	}

	@Override
	public Set<SimpleEdge<EstadoNave>> edgesOf() {
		
		return getNeighborListOf().stream()
				.map(v -> SimpleEdge.create(this, v))
				.collect(Collectors.toSet());
	}

	@Override
	public boolean isNeighbor(EstadoNave e) {
		boolean res = false;
		if(this.getNeighborListOf().contains(e)){
			res = true;
		}
		return res;
	}

	public List<ObjetoHangar> getArmas_seleccionadas() {
		// TODO Auto-generated method stub
		return this.armas_seleccionadas;
	}
	
	public int getArma_i(){
		return this.arma_i;
	}
	
	public double getPeso(){
		Double res = 0.0;
		for(ObjetoHangar o : this.armas_seleccionadas){
			res += o.getPeso();
		}
		return res;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + arma_i;
		result = prime * result + ((armas_seleccionadas == null) ? 0 : armas_seleccionadas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoNave other = (EstadoNave) obj;
		if (arma_i != other.arma_i)
			return false;
		if (armas_seleccionadas == null) {
			if (other.armas_seleccionadas != null)
				return false;
		} else if (!armas_seleccionadas.equals(other.armas_seleccionadas))
			return false;
		return true;
	}

	
	
	
	
	
	

}
