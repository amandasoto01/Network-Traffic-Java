package networkTraffic;

import java.util.ArrayList;

import jpcap.PacketReceiver;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;


public class Receptor implements PacketReceiver {
	ArrayList<Packet> packets = new ArrayList<Packet>();
	
	public Receptor(){
		
	}
	@Override
	public void receivePacket(Packet packet) {
		if(packet.datalink instanceof EthernetPacket ){
			EthernetPacket ep = (EthernetPacket) packet.datalink;
		}
	
		if(packet instanceof UDPPacket){
			
			UDPPacket udp = (UDPPacket) packet;
			System.out.println("protocol: " + udp.protocol
								//+"\nPort dts: " + udp.dst_port
								//+"\nPort src: " + udp.src_port
								//+"\nip src: " + udp.src_ip
								//+"\nip dts: " + udp.dst_ip
								//+"\nCosa rara: " + udp.d_flag
		);
			if(udp.datalink instanceof EthernetPacket)
			{
				//Imprimir info trama ethernet
			}			
		}
		
		if(packet instanceof ICMPPacket) {
			ICMPPacket icmp = (ICMPPacket) packet;
			System.out.println("protocol: " + icmp.protocol);
			
			if(icmp.datalink instanceof EthernetPacket) {
				EthernetPacket ethernet = (EthernetPacket) icmp.datalink;
				
			}
		}
		
		if(packet instanceof IPPacket) {
			IPPacket ip = (IPPacket) packet;
			System.out.println("protocol: " + ip.protocol); 
		}
	
	}
	
}

