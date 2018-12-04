package edu.neu.ccs.cs5010.assignment7.step1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListMap;


/**
 * The type Generate chart.
 */
public class GenerateChart {

  /**
   * Compute.
   *
   * @param <T> the type parameter
   * @param <U> the type parameter
   * @param map the latency map
   * @param name the name
   */
  public <T, U> void compute(ConcurrentSkipListMap<T, U> map, String name) {
    CategoryDataset categoryDataset = createDataset(map);
    JFreeChart freeChart = createChart(categoryDataset, map.size());
    final String fileName =
        System.getProperty("user.dir") + "/" + name + ".png";
    saveAsFile(freeChart, fileName, 60, 40);
  }

  /**
   * Create chart j free chart.
   *
   * @param categoryDataset the category dataset
   * @param size the size
   * @return the j free chart
   */
  public JFreeChart createChart(CategoryDataset categoryDataset, int size) {
    // 创建JFreeChart对象：ChartFactory.createLineChart
    JFreeChart jfreechart = ChartFactory.createLineChart("plot", // 标题
        "latency", // categoryAxisLabel （category轴，横轴，X轴标签）
        "frequency", // valueAxisLabel（value轴，纵轴，Y轴的标签）
        categoryDataset, // dataset
        PlotOrientation.VERTICAL, true, // legend
        false, // tooltips
        false); // URLs
    // 使用CategoryPlot设置各种参数。以下设置可以省略。
    CategoryPlot plot = (CategoryPlot) jfreechart.getPlot();
    // 背景色 透明度
    plot.setBackgroundAlpha(0.5f);
    // 前景色 透明度
    plot.setForegroundAlpha(0.5f);
    // 其他设置 参考 CategoryPlot类
    ValueAxis xyplot = plot.getRangeAxis();
    xyplot.setAutoRange(true);
    CategoryAxis domainAxis = plot.getDomainAxis();
    LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
    renderer.setBaseShapesVisible(true); // series 点（即数据点）可见
    renderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
    renderer.setUseSeriesOffset(true); // 设置偏移量
    renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
    renderer.setBaseItemLabelsVisible(true);
    return jfreechart;
  }

  private static void setDomainAxis(CategoryAxis domainAxis, int max) {
    domainAxis.setTickMarksVisible(true);  //用于显示X轴刻度
    domainAxis.setTickLabelsVisible(false);
    domainAxis.setMaximumCategoryLabelLines(5);
    for (int i = 0; i < max; i++) {
      if (i % 100 == 0) {
        domainAxis.setTickLabelPaint(Integer.toString(i), Color.black);
      } else {
        domainAxis.setTickLabelPaint(Integer.toString(i), Color.white);
      }
    }
    domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);  //设置X轴90
    domainAxis.setCategoryMargin(0.2);
  }

  /**
   * Save as file.
   *
   * @param chart the chart
   * @param outputPath the output path
   * @param weight the weight
   * @param height the height
   */
  public static void saveAsFile(JFreeChart chart, String outputPath,
      int weight, int height) {
    FileOutputStream out = null;
    try {
      File outFile = new File(outputPath);
      if (!outFile.getParentFile().exists()) {
        outFile.getParentFile().mkdirs();
      }
      out = new FileOutputStream(outputPath);
      // 保存为PNG
      ChartUtilities.writeChartAsPNG(out, chart, weight, height);
      // 保存为JPEG
      //ChartUtilities.writeChartAsJPEG(out, chart, 600, 400);
      out.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          // do nothing
        }
      }
    }
  }

  /**
   * Create dataset category dataset.
   *
   * @param <T> the type parameter
   * @param <U> the type parameter
   * @param bucketMap the bucket map
   * @return the category dataset
   */
  public <T, U> CategoryDataset createDataset(ConcurrentSkipListMap<T, U> bucketMap) {
    String[] rowKeys = {"latency"};
    int size = bucketMap.size();
    String[] colKeys = new String[size];
    double[] data1D = new double[size];
    int kindex = 0;
    for (T key : bucketMap.keySet()) {
      colKeys[kindex] = String.valueOf(key);
      if (bucketMap.get(key).getClass().equals(Long.class)) {
        data1D[kindex] = Double.valueOf((Long) bucketMap.get(key));
      } else {
        data1D[kindex] = Double.valueOf(bucketMap.get(key).toString());
      }
      kindex++;
    }
    double[][] data = {data1D,};
    // 或者使用类似以下代码
    // DefaultCategoryDataset categoryDataset = new
    // DefaultCategoryDataset();
    // categoryDataset.addValue(10, "rowKey", "colKey");
    return DatasetUtilities.createCategoryDataset(rowKeys, colKeys, data);
  }
}
