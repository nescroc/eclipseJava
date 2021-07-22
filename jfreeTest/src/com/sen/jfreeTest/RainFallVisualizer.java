package com.sen.jfreeTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Label;
import java.awt.Panel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class RainFallVisualizer extends ApplicationFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//colum keys
	private final String[] MONTH = {"Jan","Feb","Mar","Apr","May","Jun"
				,"Jul","Aug","Sep","Oct","Nov","Dec"};
	
	
	public RainFallVisualizer(String title) {
		super(title);
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		
		chartPanel.setPreferredSize(new Dimension(700, 400));
		Panel panel = new Panel(new BorderLayout());
		Label label = new Label("* 2016년 서울시 강수량 분포 *");
		label.setFont(new Font("Arial",Font.BOLD,20));
		panel.add("North",label);
		panel.add("Center",chartPanel);
		setContentPane(panel);
		
		pack();
		setVisible(true);
	}

		
	public JFreeChart createChart(CategoryDataset dataset) {
		JFreeChart chart  =ChartFactory.createBarChart(
				"The RainFall Distribution on Seoul in 2016", // chart title
				"Month", // domain axis label
				"RainFall(ml)", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips?
				false // URLs?
		);
		
		
		chart.setBackgroundPaint(java.awt.Color.WHITE);
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(java.awt.Color.WHITE);
		plot.setDomainGridlinePaint(java.awt.Color.WHITE);
		plot.setDomainGridlinesVisible(false);
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
// disable bar outlines...
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(true);
// set up gradient paints for series...
		GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, new Color(255,255,102), 0.0f, 0.0f,new Color(255,255,102));
		GradientPaint gp1 = new GradientPaint(0.0f, 0.0f,new Color(153,255,153) , 0.0f, 0.0f, new Color(153,255,153));
		
		renderer.setSeriesPaint(0, gp0);
		renderer.setSeriesPaint(1, gp1);
		
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
		return chart;
	}

	public CategoryDataset createDataset() {
		// row keys
		String rainVolume = "RainFall Volume(ml)";
		String rainyDay = "Rainy Days(day)";
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//1월데이터
		dataset.addValue(1, rainVolume, MONTH[0]);
		dataset.addValue(4, rainyDay, MONTH[0]);
		//2월데이터
		dataset.addValue(47.6, rainVolume, MONTH[1]);
		dataset.addValue(8, rainyDay, MONTH[1]);
		//3월데이터
		dataset.addValue(40.5, rainVolume, MONTH[2]);
		dataset.addValue(5, rainyDay, MONTH[2]);
		//4월데이터
		dataset.addValue(76.8, rainVolume, MONTH[3]);
		dataset.addValue(10, rainyDay, MONTH[3]);
		//5월데이터
		dataset.addValue(160.5, rainVolume, MONTH[4]);
		dataset.addValue(9, rainyDay, MONTH[4]);
		//6월데이터
		dataset.addValue(54.4, rainVolume, MONTH[5]);
		dataset.addValue(8, rainyDay, MONTH[5]);
		//7월데이터
		dataset.addValue(358.2, rainVolume, MONTH[6]);
		dataset.addValue(17, rainyDay, MONTH[6]);
		//8월데이터
		dataset.addValue(67.1, rainVolume, MONTH[7]);
		dataset.addValue(11, rainyDay, MONTH[7]);
		//9월데이터
		dataset.addValue(33, rainVolume, MONTH[8]);
		dataset.addValue(7, rainyDay, MONTH[8]);
		//10월데이터
		dataset.addValue(74.8, rainVolume, MONTH[9]);
		dataset.addValue(9, rainyDay, MONTH[9]);
		//11월데이터
		dataset.addValue(16.7, rainVolume, MONTH[10]);
		dataset.addValue(11, rainyDay, MONTH[10]);
		//12월데이터
		dataset.addValue(61.1, rainVolume, MONTH[11]);
		dataset.addValue(10, rainyDay, MONTH[11]);		
		return dataset;
		
	}
	
	public static void main(String[] args) {
		new RainFallVisualizer(
				"Weather Statistics Data Visualization Program");
	}
}
