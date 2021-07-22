package com.sen.jfreeTest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartTest {
	CategoryDataset cd;
	DefaultCategoryDataset dataset;
	JFreeChart chart;
	ChartFrame frame;
	public BarChartTest() {
		
		createDataset();
		chart = ChartFactory.createBarChart(
				"The RainFall Distribution on Seoul in 2016",
				"Month"	,
				"RainFall(ml)"	,			
				dataset,				
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		frame = new ChartFrame(
				"[Future Weather] Weather Statistics Data Visualization Program "+
					"- RainFaill Visualizer",
				chart);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	private void createDataset() {
	}
	public static void main(String[] args) {
		new BarChartTest();
	}
}
