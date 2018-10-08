package networkTraffic;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

public class InterfazGrafica {

	private JFrame frame;
	private JTable table;
	private CaptureTraffic cp;
	private JTextField tiempo;
	private JTextPane textPane_2;
	private JTextPane textPane_3;
	private JTextPane textPane_4;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField tFvelocidad;
	private JPanel Odometro = new JPanel();
	private Throughput tp = new Throughput();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica window = new InterfazGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void mostrarDetalles(Paquete paquete){
		Packet p = cp.buscarPaquete(paquete);
		System.out.println("llegue aca");
		 
		if(p instanceof ICMPPacket){
			System.out.println("y aca");
			ICMPPacket icmp = (ICMPPacket) p;
			
			textField.setText(String.valueOf(icmp.type));
			textField_1.setText(String.valueOf(icmp.code));
			textField_2.setText(String.valueOf(icmp.checksum));
			textField_3.setText(String.valueOf(icmp.data.toString()));
		
			System.out.println(icmp.type);
			System.out.println(icmp.code);
			System.out.println(icmp.checksum);
			System.out.println(icmp.header.toString());
			
			System.out.println("Ese es mi paquete icmp");			
			textField_4.setText(String.valueOf(icmp.version));
			textField_5.setText(String.valueOf(icmp.length));
			//textField_6.setText(String.valueOf(" "));
			textField_7.setText(String.valueOf(icmp.len));
			textField_8.setText(String.valueOf(icmp.ident));
			String bandera="";
			if(icmp.d_flag){
				bandera="No se puede fragmentar";
			}else if(icmp.t_flag){
				bandera="Se puede fragmentar";
			} else if(icmp.r_flag){
				bandera="Reservado";
			}
			textField_9.setText(bandera);
			textField_10.setText(String.valueOf(icmp.offset));
			textField_11.setText(String.valueOf(icmp.hop_limit));
			textField_12.setText(String.valueOf(icmp.protocol));
			textField_13.setText(String.valueOf(icmp.checksum));
			textField_14.setText(String.valueOf(icmp.src_ip));
			textField_15.setText(String.valueOf(icmp.dst_ip));
			textField_16.setText(String.valueOf(icmp.option));
			
			EthernetPacket ethernetp = (EthernetPacket)icmp.datalink;
			
			textField_17.setText(String.valueOf(ethernetp.frametype));
			
			textField_18.setText(Utils.byteToHexaString(ethernetp.dst_mac));
			
			textField_19.setText(Utils.byteToHexaString(ethernetp.src_mac));
			textField_20.setText(String.valueOf(ethernetp.frametype));
			textField_21.setText(String.valueOf(icmp.checksum));
			
		
			System.out.println("sii");
			System.out.println(p.toString());
		}
		
		if(p instanceof UDPPacket){
			System.out.println("y aca");
			UDPPacket udp = (UDPPacket) p;	
			System.out.println("Ese es mi paquete icmp");			
			textField_4.setText(String.valueOf(udp.version));
			textField_5.setText(String.valueOf(udp.length));
			//textField_6.setText(String.valueOf(" "));
			textField_7.setText(String.valueOf(udp.len));
			textField_8.setText(String.valueOf(udp.ident));
			String bandera="";
			if(udp.d_flag){
				bandera="No se puede fragmentar";
			}else if(udp.t_flag){
				bandera="Se puede fragmentar";
			} else if(udp.r_flag){
				bandera="Reservado";
			}
			textField_9.setText(bandera);
			textField_10.setText(String.valueOf(udp.offset));
			textField_11.setText(String.valueOf(udp.hop_limit));
			textField_12.setText(String.valueOf(udp.protocol));
			//textField_13.setText(String.valueOf(udp.checksum));
			textField_14.setText(String.valueOf(udp.src_ip));
			textField_15.setText(String.valueOf(udp.dst_ip));
			textField_16.setText(String.valueOf(udp.option));
			
			EthernetPacket ethernetp = (EthernetPacket)udp.datalink;
			
			textField_17.setText(String.valueOf(ethernetp.frametype));
			
			textField_18.setText(Utils.byteToHexaString(ethernetp.dst_mac));
			
			textField_19.setText(Utils.byteToHexaString(ethernetp.src_mac));
			textField_20.setText(String.valueOf(ethernetp.frametype));
			//textField_21.setText(String.valueOf(udp.checksum));
			
		
			System.out.println("sii");
			System.out.println(p.toString());
		}
		
		if(p instanceof TCPPacket){
			System.out.println("y aca");
			TCPPacket udp = (TCPPacket) p;	
			System.out.println("Ese es mi paquete icmp");			
			textField_4.setText(String.valueOf(udp.version));
			textField_5.setText(String.valueOf(udp.length));
			//textField_6.setText(String.valueOf(" "));
			textField_7.setText(String.valueOf(udp.len));
			textField_8.setText(String.valueOf(udp.ident));
			String bandera="";
			if(udp.d_flag){
				bandera="No se puede fragmentar";
			}else if(udp.t_flag){
				bandera="Se puede fragmentar";
			} else if(udp.r_flag){
				bandera="Reservado";
			}
			textField_9.setText(bandera);
			textField_10.setText(String.valueOf(udp.offset));
			textField_11.setText(String.valueOf(udp.hop_limit));
			textField_12.setText(String.valueOf(udp.protocol));
			//textField_13.setText(String.valueOf(udp.checksum));
			textField_14.setText(String.valueOf(udp.src_ip));
			textField_15.setText(String.valueOf(udp.dst_ip));
			textField_16.setText(String.valueOf(udp.option));
			
			EthernetPacket ethernetp = (EthernetPacket)udp.datalink;
			
			textField_17.setText(String.valueOf(ethernetp.frametype));
			
			textField_18.setText(Utils.byteToHexaString(ethernetp.dst_mac));
			
			textField_19.setText(Utils.byteToHexaString(ethernetp.src_mac));
			textField_20.setText(String.valueOf(ethernetp.frametype));
			//textField_21.setText(String.valueOf(udp.checksum));
			
		
			System.out.println("sii");
			System.out.println(p.toString());
		}
	}
	public void actualizarTabla(String Protocolo, JScrollPane scrollPane){
		Vector<Object> encabe=new <Object>Vector();
		Vector<Object> msjP=new <Object>Vector();
		encabe.add("No.");
		encabe.add("Tiempo");
		encabe.add("Origen");
		encabe.add("Destino");
		encabe.add("Protocolo");
		encabe.add("Info");

		
		ArrayList<Packet> p = cp.getPackets();
		for(int i = 0; i<p.size(); i++){
			Vector<Object> msjs=new <Object>Vector();
			Packet miP = p.get(i);
			if(Protocolo.equals("UDP") && miP instanceof UDPPacket){
				UDPPacket udp = (UDPPacket) miP;
				msjs.add(udp.ident);
				msjs.add(udp.sec);
				msjs.add(udp.src_ip);
				msjs.add(udp.dst_ip);
				msjs.add(udp.protocol);
				msjs.add(udp.data.toString());
				msjP.add(msjs);
			}
			if(Protocolo.equals("TCP") && miP instanceof TCPPacket){
				System.out.println("Soy un mensaje");
				TCPPacket tcp = (TCPPacket) miP;
				msjs.add(tcp.ident);
				msjs.add(tcp.sec);
				msjs.add(tcp.src_ip);
				msjs.add(tcp.dst_ip);
				msjs.add(tcp.protocol);
				msjs.add(tcp.data.toString());
				msjP.add(msjs);
			}
			
			if(Protocolo.equals("ICMP") && miP instanceof ICMPPacket){
				ICMPPacket icmp = (ICMPPacket) miP;
				msjs.add(icmp.ident);
				msjs.add(icmp.sec);
				msjs.add(icmp.src_ip);
				msjs.add(icmp.dst_ip);
				msjs.add(icmp.protocol);
				msjs.add(icmp.data.toString());
				msjP.add(msjs);
			}
			
			if(Protocolo.equals("IP") && miP instanceof ICMPPacket){
				IPPacket ip = (IPPacket) miP;
				msjs.add(ip.ident);
				msjs.add(ip.sec);
				msjs.add(ip.src_ip);
				msjs.add(ip.dst_ip);
				msjs.add(ip.protocol);
				msjs.add(ip.data.toString());
				msjP.add(msjs);
			}
			
		}
		table = new JTable(msjP,encabe);
		DefaultTableModel modelo = new DefaultTableModel(msjP,encabe){
		    @Override
			public boolean isCellEditable(int rowIndex,int columnIndex){
		    	return false;
		    	}
		    
		};
		table = new JTable (modelo);
		((JScrollPane) scrollPane).setViewportView(table);
		
	}

	/**
	 * Create the application.
	 */
	public InterfazGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Inicio", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnCapturarMensajes = new JButton("Capturar Mensajes");
		btnCapturarMensajes.setBounds(259, 187, 157, 23);
		panel_2.add(btnCapturarMensajes);
		
		JLabel lblDefinirTiempoDe = new JLabel("Definir tiempo de captura");
		lblDefinirTiempoDe.setBounds(277, 58, 139, 28);
		panel_2.add(lblDefinirTiempoDe);
		
		tiempo = new JTextField();
		tiempo.setBounds(277, 131, 122, 20);
		panel_2.add(tiempo);
		tiempo.setColumns(10);
		
		JButton btnMedirThroughput = new JButton("Medir Throughput");
		btnMedirThroughput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cp = new CaptureTraffic();
				cp.setTiempo(1);
				cp.run();
								
				Odometro.add(tp.crear());
				
				System.out.println(cp.getPackets().size());
				int sum = 0;
				
				ArrayList<Packet> pac = cp.getPackets();
				for(int i = 0 ; i < pac.size(); i ++ ) {
					sum= sum + pac.get(i).caplen;
					
				}
				
				System.out.println(sum/100);
				tp.DATASET.setValue(sum/100);
				tFvelocidad.setText(String.valueOf(sum/100));
				              
				tabbedPane.setSelectedIndex(3);				
			}
		});
		btnMedirThroughput.setBounds(567, 188, 163, 21);
		panel_2.add(btnMedirThroughput);
		btnCapturarMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int segundos = Integer.parseInt(tiempo.getText());
				cp = new CaptureTraffic();
				cp.setTiempo(segundos);
				cp.run();
				tabbedPane.setSelectedIndex(1);
			}
		});
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("mensajes", null, panel, null);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 104, 763, 357);
		scrollPane.setEnabled(false);
		DefaultTableModel modelo = new DefaultTableModel(){
		    public boolean isCellEditable(int rowIndex,int columnIndex){
		    	return false;
		    	}
		    
		};
		JButton btnMostrarMensajes = new JButton("mostrar mensajes");
		btnMostrarMensajes.setBounds(368, 474, 137, 25);
		btnMostrarMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Vector<Object> encabe=new <Object>Vector();
				Vector<Object> msjP=new <Object>Vector();
				encabe.add("No.");
				encabe.add("Tiempo");
				encabe.add("Origen");
				encabe.add("Destino");
				encabe.add("Protocolo");
				encabe.add("Info");

				
				ArrayList<Packet> p = cp.getPackets();
				for(int i = 0; i<p.size(); i++){
					Vector<Object> msjs=new <Object>Vector();
					Packet miP = p.get(i);
					if(miP instanceof UDPPacket){
						UDPPacket udp = (UDPPacket) miP;
						msjs.add(i+1);
						msjs.add(udp.sec);
						msjs.add(udp.src_ip);
						msjs.add(udp.dst_ip);
						msjs.add(udp.protocol);
						msjs.add(Utils.byteToHexaString(udp.data));
						msjP.add(msjs);
					}
					
					if(miP instanceof TCPPacket){
						TCPPacket tcp = (TCPPacket) miP;
						msjs.add(i+1);
						msjs.add(tcp.sec);
						msjs.add(tcp.src_ip);
						msjs.add(tcp.dst_ip);
						msjs.add(tcp.protocol);
						msjs.add(tcp.data.toString());
						msjP.add(msjs);
					}
					
					if(miP instanceof ICMPPacket){
						ICMPPacket icmp = (ICMPPacket) miP;
						msjs.add(i+1);
						msjs.add(icmp.sec);
						msjs.add(icmp.src_ip);
						msjs.add(icmp.dst_ip);
						msjs.add(icmp.protocol);
						msjs.add(icmp.data.toString());
						msjP.add(msjs);
					}
					
					if(miP instanceof IPPacket){
						IPPacket ip = (IPPacket) miP;
						msjs.add(i+1);
						msjs.add(ip.sec);
						msjs.add(ip.src_ip);
						msjs.add(ip.dst_ip);
						msjs.add(ip.protocol);
						msjs.add(ip.data.toString());
						msjP.add(msjs);
					}
					
					if(miP instanceof ARPPacket){
						ARPPacket arp = (ARPPacket) miP;
						msjs.add(i+1);
						msjs.add(arp.sec);
						msjs.add(arp.getSenderHardwareAddress());
						msjs.add(arp.getTargetHardwareAddress());
						msjs.add(arp.getSenderProtocolAddress());
						msjs.add(Utils.byteToHexaString(arp.data));
						msjP.add(msjs);
						//msjs.add(arp.);
						/*msjs.add(ip.sec);
						msjs.add(ip.src_ip);
						msjs.add(ip.dst_ip);
						msjs.add(ip.protocol);
						msjs.add(ip.data.toString());
						msjP.add(msjs);*/
					}
					
				}
				table = new JTable(msjP,encabe);
				DefaultTableModel modelo = new DefaultTableModel(msjP,encabe){
				    @Override
					public boolean isCellEditable(int rowIndex,int columnIndex){
				    	return false;
				    	}
				    
				};
				table = new JTable (modelo);
				scrollPane.setViewportView(table);
				//Listener de Mouse para ver que celda selecciono
				table.addMouseListener(new java.awt.event.MouseAdapter() {
				      public void mouseClicked(java.awt.event.MouseEvent e) {
				      if(e.getClickCount()==2){
				    	  int fila = table.getColumnCount();
				    	  int fil= table.getSelectedRow();
				    	  
				    	  Paquete paquete = new Paquete();
				    	  paquete.setNumero(Integer.parseInt(String.valueOf(table.getValueAt(fil, 0))));
				    	  paquete.setTiempo(Integer.parseInt(String.valueOf(table.getValueAt(fil, 1))));
				    	  paquete.setOrigen(String.valueOf(table.getValueAt(fil, 2)));
				    	  paquete.setDestino(String.valueOf(table.getValueAt(fil, 3)));
				    	  paquete.setProtocolo(Integer.parseInt(String.valueOf(table.getValueAt(fil, 4))));
				    	  paquete.setInfo(String.valueOf(table.getValueAt(fil, 5)));
				    	  
				    	  textField.setText("asdasd");
				    	  
				    	  mostrarDetalles(paquete);
				    	  System.out.println(paquete.toString());
				    	  /*for (int i = 0; i < fila; i++) {
				    	  System.out.println( (String) table.getValueAt(fil, i));
				    	  }*/
				    	  tabbedPane.setSelectedIndex(2);
				       }
				 }
				});		
				
			}
			
		});
		panel.setLayout(null);
		panel.add(scrollPane);
		panel.add(btnMostrarMensajes);
		
		JTextPane txtpnFiltro = new JTextPane();
		txtpnFiltro.setBounds(50, 49, 40, 22);
		txtpnFiltro.setEnabled(false);
		txtpnFiltro.setEditable(false);
		txtpnFiltro.setText("Filtro:");
		panel.add(txtpnFiltro);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(134, 49, 150, 22);
		panel.add(comboBox);
		comboBox.addItem("Seleccione un filtro");
		comboBox.addItem("UDP");
		comboBox.addItem("TCP");
		comboBox.addItem("ICMP");
		comboBox.addItem("IP");
		comboBox.addItem("ARP");
		
		JButton btnAplicarFiltro = new JButton("Aplicar Filtro");
		btnAplicarFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table != null){
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					while(dm.getRowCount() > 0)
					{
					    dm.removeRow(0);
					}
				}
				
				String Protocolo = (String)comboBox.getSelectedItem();
				Vector<Object> encabe=new <Object>Vector();
				Vector<Object> msjP=new <Object>Vector();
				encabe.add("No.");
				encabe.add("Tiempo");
				encabe.add("Origen");
				encabe.add("Destino");
				encabe.add("Protocolo");
				encabe.add("Info");

				
				ArrayList<Packet> p = cp.getPackets();
				for(int i = 0; i<p.size(); i++){
					Vector<Object> msjs=new <Object>Vector();
					Packet miP = p.get(i);
					if(Protocolo.equals("UDP") && miP instanceof UDPPacket){
						UDPPacket udp = (UDPPacket) miP;
						msjs.add(udp.ident);
						msjs.add(udp.sec);
						msjs.add(udp.src_ip);
						msjs.add(udp.dst_ip);
						msjs.add(udp.protocol);
						msjs.add(udp.data.toString());
						msjP.add(msjs);
					}
					if(Protocolo.equals("TCP") && miP instanceof TCPPacket){
						System.out.println("Soy un mensaje");
						TCPPacket tcp = (TCPPacket) miP;
						msjs.add(tcp.ident);
						msjs.add(tcp.sec);
						msjs.add(tcp.src_ip);
						msjs.add(tcp.dst_ip);
						msjs.add(tcp.protocol);
						msjs.add(tcp.data.toString());
						msjP.add(msjs);
					}
					
					if(Protocolo.equals("ICMP") && miP instanceof ICMPPacket){
						ICMPPacket icmp = (ICMPPacket) miP;
						msjs.add(icmp.ident);
						msjs.add(icmp.sec);
						msjs.add(icmp.src_ip);
						msjs.add(icmp.dst_ip);
						msjs.add(icmp.protocol);
						msjs.add(icmp.data.toString());
						msjP.add(msjs);
					}
				}
				table = new JTable(msjP,encabe);
				DefaultTableModel modelo = new DefaultTableModel(msjP,encabe){
				    @Override
					public boolean isCellEditable(int rowIndex,int columnIndex){
				    	return false;
				    	}
				    
				};
				table = new JTable (modelo);
				scrollPane.setViewportView(table);
				//Listener de Mouse para ver que celda selecciono
				table.addMouseListener(new java.awt.event.MouseAdapter() {
				      public void mouseClicked(java.awt.event.MouseEvent e) {
				      if(e.getClickCount()==2){
				    	  int fila = table.getColumnCount();
				    	  int fil= table.getSelectedRow();
				    	
				    	  Paquete paquete = new Paquete();
				    	  paquete.setNumero(Integer.parseInt(String.valueOf(table.getValueAt(fil, 0))));
				    	  paquete.setTiempo(Integer.parseInt(String.valueOf(table.getValueAt(fil, 1))));
				    	  paquete.setOrigen(String.valueOf(table.getValueAt(fil, 2)));
				    	  paquete.setDestino(String.valueOf(table.getValueAt(fil, 3)));
				    	  paquete.setProtocolo(Integer.parseInt(String.valueOf(table.getValueAt(fil, 4))));
				    	  paquete.setInfo(String.valueOf(table.getValueAt(fil, 5)));
				    	  textField.setText("asdasd");
				    	  mostrarDetalles(paquete);
				    	  System.out.println(paquete.toString());
				    	  /*for (int i = 0; i < fila; i++) {
				    		  System.out.println( String.valueOf(table.getValueAt(fil, i)));
				    		  mostrarDetalles(String.valueOf(table.getValueAt(fil, i) ) );
				    	  }*/
				    	  tabbedPane.setSelectedIndex(2);
				       }
				 }
				});
			}
		});
		
		
		btnAplicarFiltro.setBounds(392, 48, 137, 23);
		panel.add(btnAplicarFiltro);
		
		JButton btnAtras_1 = new JButton("Atras");
		btnAtras_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnAtras_1.setBounds(715, 475, 89, 23);
		panel.add(btnAtras_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("throughput", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnDetener = new JButton("Atras");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnDetener.setBounds(614, 456, 131, 23);
		panel_3.add(btnDetener);
		
		
		Odometro.setBounds(47, 26, 774, 403);
		panel_3.add(Odometro);
		
		tFvelocidad = new JTextField();
		tFvelocidad.setBounds(461, 457, 86, 20);
		panel_3.add(tFvelocidad);
		tFvelocidad.setColumns(10);
		
		JPanel DetallesPaquete = new JPanel();
		tabbedPane.addTab("Detalles Paquete", null, DetallesPaquete, null);
		DetallesPaquete.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ICMP");
		lblNewLabel.setBounds(64, 24, 54, 21);
		DetallesPaquete.add(lblNewLabel);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(27, 68, 46, 14);
		DetallesPaquete.add(lblTipo);
		
		textField = new JTextField();
		textField.setBounds(122, 65, 86, 20);
		DetallesPaquete.add(textField);
		textField.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(27, 111, 46, 14);
		DetallesPaquete.add(lblCodigo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(122, 108, 86, 20);
		DetallesPaquete.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCrc = new JLabel("Checksum:");
		lblCrc.setBounds(27, 150, 46, 14);
		DetallesPaquete.add(lblCrc);
		
		textField_2 = new JTextField();
		textField_2.setBounds(122, 147, 86, 20);
		DetallesPaquete.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblIdentificador = new JLabel("Version");
		lblIdentificador.setBounds(293, 68, 70, 14);
		DetallesPaquete.add(lblIdentificador);
		
		textField_3 = new JTextField();
		textField_3.setBounds(122, 184, 86, 20);
		DetallesPaquete.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(393, 65, 86, 20);
		DetallesPaquete.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDatos = new JLabel("Datos:");
		lblDatos.setBounds(27, 187, 46, 14);
		DetallesPaquete.add(lblDatos);
		
		textField_5 = new JTextField();
		textField_5.setBounds(393, 105, 86, 20);
		DetallesPaquete.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblIp = new JLabel("IP");
		lblIp.setBounds(365, 27, 46, 14);
		DetallesPaquete.add(lblIp);
		
		JLabel lblNewLabel_1 = new JLabel("IHL");
		lblNewLabel_1.setBounds(293, 111, 46, 14);
		DetallesPaquete.add(lblNewLabel_1);
		
		JLabel lblLongitud = new JLabel("Longitud");
		lblLongitud.setBounds(293, 150, 46, 14);
		DetallesPaquete.add(lblLongitud);
		
		JLabel lblNewLabel_2 = new JLabel("Identificador");
		lblNewLabel_2.setBounds(293, 187, 70, 14);
		DetallesPaquete.add(lblNewLabel_2);
		
		JLabel lblBanderas = new JLabel("Banderas");
		lblBanderas.setBounds(293, 224, 70, 14);
		DetallesPaquete.add(lblBanderas);
		
		JLabel lblOffset = new JLabel("OffSet");
		lblOffset.setBounds(293, 271, 46, 14);
		DetallesPaquete.add(lblOffset);
		
		JLabel lblTtl = new JLabel("TTL");
		lblTtl.setBounds(293, 307, 46, 14);
		DetallesPaquete.add(lblTtl);
		
		JLabel lblProtocolo = new JLabel("Protocolo");
		lblProtocolo.setBounds(293, 354, 46, 14);
		DetallesPaquete.add(lblProtocolo);
		
		JLabel lblCrc_1 = new JLabel("CRC");
		lblCrc_1.setBounds(293, 389, 46, 14);
		DetallesPaquete.add(lblCrc_1);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(293, 414, 46, 14);
		DetallesPaquete.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(293, 440, 46, 14);
		DetallesPaquete.add(lblDestino);
		
		textField_7 = new JTextField();
		textField_7.setBounds(393, 147, 86, 20);
		DetallesPaquete.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(393, 184, 86, 20);
		DetallesPaquete.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(393, 221, 86, 20);
		DetallesPaquete.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(393, 268, 86, 20);
		DetallesPaquete.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(393, 304, 86, 20);
		DetallesPaquete.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(393, 351, 86, 20);
		DetallesPaquete.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(393, 386, 86, 20);
		DetallesPaquete.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(393, 411, 86, 20);
		DetallesPaquete.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(393, 437, 86, 20);
		DetallesPaquete.add(textField_15);
		textField_15.setColumns(10);
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setBounds(293, 471, 46, 14);
		DetallesPaquete.add(lblOpciones);
		
		textField_16 = new JTextField();
		textField_16.setBounds(393, 468, 86, 20);
		DetallesPaquete.add(textField_16);
		textField_16.setColumns(10);
		
		JLabel lblEthernet = new JLabel("Ethernet");
		lblEthernet.setBounds(634, 27, 46, 14);
		DetallesPaquete.add(lblEthernet);
		
		JLabel lblDelimitador = new JLabel("Delimitador");
		lblDelimitador.setBounds(613, 68, 70, 14);
		DetallesPaquete.add(lblDelimitador);
		
		JLabel lblMacDestino = new JLabel("MAC destino");
		lblMacDestino.setBounds(613, 108, 67, 14);
		DetallesPaquete.add(lblMacDestino);
		
		JLabel lblMacOrigen = new JLabel("MAC origen");
		lblMacOrigen.setBounds(613, 144, 70, 14);
		DetallesPaquete.add(lblMacOrigen);
		
		JLabel lblTipo_1 = new JLabel("Tipo");
		lblTipo_1.setBounds(613, 173, 46, 14);
		DetallesPaquete.add(lblTipo_1);
		
		JLabel lblDatos_1 = new JLabel("CRC");
		lblDatos_1.setBounds(613, 208, 46, 14);
		DetallesPaquete.add(lblDatos_1);
		
		textField_17 = new JTextField();
		textField_17.setBounds(701, 65, 86, 20);
		DetallesPaquete.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(701, 105, 86, 20);
		DetallesPaquete.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(701, 141, 86, 20);
		DetallesPaquete.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setBounds(701, 170, 86, 20);
		DetallesPaquete.add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setBounds(701, 205, 86, 20);
		DetallesPaquete.add(textField_21);
		textField_21.setColumns(10);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnAtras.setBounds(710, 410, 89, 23);
		DetallesPaquete.add(btnAtras);
		
		
	}
}
