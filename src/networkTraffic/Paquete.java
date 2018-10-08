package networkTraffic;

public class Paquete {
	 int numero;
	 int tiempo;
	 String origen;
	 String destino;
	 int protocolo; 
	 String info;
	 
	public Paquete() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(int protocolo) {
		this.protocolo = protocolo;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Paquete [numero=" + numero + ", tiempo=" + tiempo + ", origen="
				+ origen + ", destino=" + destino + ", protocolo=" + protocolo
				+ ", info=" + info + "]";
	}
	
	
}
