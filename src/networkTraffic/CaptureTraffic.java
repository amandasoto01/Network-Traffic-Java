package networkTraffic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import jpcap.*;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

public class CaptureTraffic implements Runnable {
	ArrayList<Packet> packets = new ArrayList<Packet>();
	ArrayList<ICMPPacket> icmpPackets = new ArrayList<ICMPPacket>();
	
	boolean isRunning;
	
	NetworkInterface [] dispositivos;
	JpcapCaptor capturador;
	
	int tiempo;
	
	public void setTiempo(int t){
		tiempo = t;
	}
	
	public CaptureTraffic(){
		isRunning = true;
		dispositivos = JpcapCaptor.getDeviceList();
		tiempo = 5; //Tiempo por defecto
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			capturador = JpcapCaptor.openDevice(dispositivos[2], 65535,false,1000);
			Date startDate = new Date();
			isRunning = true;
			while(isRunning){
				Date endDate = new Date();
				int numSeconds = (int)((endDate.getTime() - startDate.getTime()) / 1000);
				if(numSeconds>= tiempo){
					isRunning = false;
					break;
				}
				Packet p = capturador.getPacket();
				if(p != null){
					//System.out.println("PaqueteAqui");
					if(p instanceof IPPacket || p instanceof ARPPacket) {
						packets.add(p);
					}
					if(p instanceof ICMPPacket){
						ICMPPacket icmp = (ICMPPacket) p;
						icmpPackets.add(icmp);
					}
					
				}
					//capturador.processPacket(1, new Receptor());
			}
			capturador.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
	}

	public ArrayList<Packet> getPackets() {
		return packets;
	}
	
	public Packet buscarPaquete (Paquete paquete){
		ArrayList<Packet> p = this.getPackets();
		for(int i=0; i<p.size(); i++){
			Packet miP = p.get(i);
			if(miP instanceof UDPPacket){
				UDPPacket udp = (UDPPacket) miP;
				if(udp.ident == paquete.numero && 
					udp.sec == paquete.tiempo && udp.protocol == paquete.protocolo){
					return miP;
				}
			}
			
			if(miP instanceof TCPPacket){
				TCPPacket tcp = (TCPPacket) miP;
				if(tcp.ident == paquete.numero && 
					tcp.sec == paquete.tiempo  && tcp.protocol == paquete.protocolo){
					return miP;
				}
			}
			
			if(miP instanceof ICMPPacket){
				ICMPPacket icmp = (ICMPPacket) miP;
				if(icmp.ident == paquete.numero && 
					icmp.sec == paquete.tiempo &&  icmp.protocol == paquete.protocolo){
					return miP;
				}
			}
		}
		return null;
	}
	
}
