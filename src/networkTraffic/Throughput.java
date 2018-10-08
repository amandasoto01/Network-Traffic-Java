package networkTraffic;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.data.general.DefaultValueDataset;

public class Throughput {
	public DefaultValueDataset DATASET;
	private ThermometerPlot plot;
	private JFreeChart chart;
	private ChartPanel panel;
	
	public Throughput() {
		
	}
	
	public ChartPanel crear() {
		DATASET = new DefaultValueDataset(100);
		plot = new ThermometerPlot(DATASET);
		chart = new JFreeChart("Throughput", plot);
		ChartUtilities.applyCurrentTheme(chart);
		panel = new ChartPanel(chart);
		return panel;
	}
	
	
	
}
