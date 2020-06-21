package Classes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

/**
 * Klasa zawierająca metody tworzące wykresy widma
 */
public class WykresWidma extends JFrame {
    /**
     * klasa zawierająca metody tworzące wykres widma
     * @param tab
     * @param title
     */
    public WykresWidma(widmo[] tab, String title) {

        initUI(tab, title);
    }

    /**
     * Metoda tworząca wykres
     * @param tab
     * @param title
     */
    private void initUI(widmo[] tab, String title) {

        //XYDataset dataset = createDataset(tab);
        XYDataset dataset = createDataset(tab);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle(title);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Metoda przygotowująca dane do utworzenia wykresu
     * @param tab
     * @return
     */
    private XYDataset createDataset(widmo[] tab) {

        /*var seria = new XYSeries("Widmo");

        double fs = 16000;
        double krok = fs/tab.length;
        double f = 0;
        for (int i =0; i< tab.length/2; i++)
        {
            seria.add(f, tab[i]);
            f += krok;
        }
         */
        var seria = new XYSeries("Widmo");
        for(int i = 0; i < tab.length; i++) {
            seria.add(tab[i].getCzęstotliwość(), tab[i].get_dB());
        }

        var dataset = new XYSeriesCollection();
        dataset.addSeries(seria);

        return dataset;
    }

     /**
     * Metoda pomocnicza do utworzenia wykresu
     * @param dataset
     * @return
     */
    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Widmo",
                "Częstotliwość [Hz]",
                "[dB]",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        /*var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
*/
        //plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Widmo",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }

}
