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
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

/**
 * Klasa zawierająca metody do zbudowania wykresu dla głośności nagrania
 */
public class GłośnośćWykres extends JFrame {

    /**
     * Konstruktor klasy GłośnośćWykres
     * @param daneA - dane z korekcją krzywej A
     * @param daneC - dane z korekcją krzywej C
     * @param daneZ - dane z korekcją krzywej Z
     * @param title - tytuł wykresu
     */
    public GłośnośćWykres(double[] daneA, double[] daneC, double[] daneZ, String title) {
        initUI(daneA, daneC, daneZ,title);
    }

    /**
     * Metoda tworząca wykres
     * @param daneA - dane z korekcją krzywej A
     * @param daneC - dane z korekcją krzywej C
     * @param daneZ - dane z korekcją krzywej Z
     * @param title - tytuł wykresu
     */
    private void initUI(double[] daneA, double[] daneC, double[] daneZ, String title) {

        XYDataset dataset = createDataset(daneA, daneC, daneZ);
        JFreeChart chart = createChart(dataset);
        getContentPane().add(new ChartPanel(chart));

        pack();
        setTitle(title);
        setLocationRelativeTo(null);
    }

    /**
     * Metoda tworzy i zwraca XYDataset dla wykresu
     * @param daneA - dane z korekcją krzywej A
     * @param daneC - dane z korekcją krzywej C
     * @param daneZ - dane z korekcją krzywej Z
     * @return XYDataset
     */
    private XYDataset createDataset(double[] daneA, double[] daneC, double[] daneZ) {

        var seria1 = new XYSeries("Korekcja A");
        var seria2 = new XYSeries("Korekcja C");
        var seria3= new XYSeries("Korekcja Z");

        for (int i = 0; i< daneA.length; i++)
        {
            seria1.add(i, daneA[i]);
        }
        for (int i = 0; i< daneC.length; i++)
        {
            seria2.add(i, daneC[i]);
        }
        for (int i = 0; i< daneZ.length; i++)
        {
            seria3.add(i, daneZ[i]);
        }


        var dataset = new XYSeriesCollection();
        dataset.addSeries(seria1);
        dataset.addSeries(seria2);
        dataset.addSeries(seria3);

        return dataset;
    }

    /**
     * Metoda tworzy wykres
     * @param dataset - dane do wykresu
     * @return wykres
     */
    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Wykres głośności nagrania",
                "Nr próbki",
                "Głośność [dB]",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesPaint(2, Color.BLUE);
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Przebieg głośności nagrania",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }
}
