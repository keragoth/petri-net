/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testowa;

import java.awt.Color;
import java.text.NumberFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.IntervalCategoryDataset;

/**
 *
 * @author Grzegorz
 */
public class GanttChartFactory extends ChartFactory {

    public static JFreeChart createGanttChart(String title,
            String categoryAxisLabel, String valueAxisLabel,
            IntervalCategoryDataset dataset, boolean legend, boolean tooltips,
            boolean urls) {

        CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
        ValueAxis valueAxis = new NumberAxis(valueAxisLabel);

        CategoryItemRenderer renderer = new GanttRenderer();
        System.out.println(renderer.getBaseShape());
        if (tooltips) {
            renderer.setBaseToolTipGenerator(
                    new IntervalCategoryToolTipGenerator(
                            "{1}: {3} - {4}", NumberFormat.getNumberInstance()));
        }
        if (urls) {
            renderer.setBaseItemURLGenerator(
                    new StandardCategoryURLGenerator());
        }


        CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis,
                renderer);

        plot.setOrientation(PlotOrientation.HORIZONTAL);

        JFreeChart chart = new JFreeChart(title, JFreeChart.DEFAULT_TITLE_FONT,
                plot, legend);
        //  currentTheme.apply(chart);
        return chart;
    }
}
