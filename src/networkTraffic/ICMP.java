package networkTraffic;

import jpcap.packet.IPPacket;

public class ICMP {
	private String tipo;
	private int codigo;
	private String checksum;
	private IPPacket ip;
	
	
	public IPPacket getIp() {
		return ip;
	}
	public void setIp(IPPacket ip) {
		this.ip = ip;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	
	
	
}
