package us.lsi.astar.viajeintergalatico.alumnos;

import java.util.List;

public class ObjetoHangar implements Comparable<ObjetoHangar>{

	String nombre;
	List<String> caracteristicas;
	private Float danyo;
	private Float peso;
	
	public ObjetoHangar(String id, List<String> caracteristicas, Float peso, Float danyo) {
		this.nombre = id;
		this.caracteristicas = caracteristicas;
		this.peso = peso;
		this.danyo = danyo;

	}

	public ObjetoHangar(String id, List<String> caracteristicas, Float peso) {
		this.nombre = id;
		this.caracteristicas = caracteristicas;
		this.peso = peso;
		this.danyo = 0f;

	}

	
	
	public Float getDanyo() {
		return danyo;
	}

	public void setDanyo(Float danyo) {
		this.danyo = danyo;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String toString() {
		return "Arma [id=" + nombre + ", peso=" + peso + ", daño=" + danyo + "]";
	}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracteristicas == null) ? 0 : caracteristicas.hashCode());
		result = prime * result + ((danyo == null) ? 0 : danyo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ObjetoHangar))
			return false;
		ObjetoHangar other = (ObjetoHangar) obj;
		if (caracteristicas == null) {
			if (other.caracteristicas != null)
				return false;
		} else if (!caracteristicas.equals(other.caracteristicas))
			return false;
		if (danyo == null) {
			if (other.danyo != null)
				return false;
		} else if (!danyo.equals(other.danyo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		return true;
	}

	@Override
	public int compareTo(ObjetoHangar o) {
		int res = 0;
		
		if(this.getPeso() > o.getPeso()){
			res = 1;
		} else{
			res = -1;
		}
		
		return res;
	}

	
	
	

}
