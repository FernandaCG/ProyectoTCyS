/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.tcys.entidades;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import static javax.swing.UIManager.get;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author fernanda
 */
@WebServlet(name = "servletGrafica", urlPatterns = {"/servletGrafica"})
public class servletGrafica extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletGrafica</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletGrafica at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");

            ArrayList<Integer> alturaPuntos = new ArrayList<Integer>();
            ArrayList<XYSeries> variable = new ArrayList<XYSeries>();

            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                alturaPuntos.add(rand.nextInt(50) + 1);
            }

            XYSeriesCollection dataset = new XYSeriesCollection();
            float inicio_serie = 0.0f;
            XYSeries p1;
            for (int i = 0; i < 10; i++) {
                p1 = new XYSeries("a" + i);
                p1.add(inicio_serie, alturaPuntos.get(i));
                p1.add(i, 0.0);
                variable.add(p1);
                inicio_serie = inicio_serie + 1.0f;
            }
            for (int i = 0; i < 10; i++) {
                dataset.addSeries(variable.get(i));
            }
            JFreeChart xylineChart = ChartFactory.createXYLineChart("Grafica XY", "n", "x(n)", dataset, PlotOrientation.VERTICAL, true, true, false);
            XYPlot plot = xylineChart.getXYPlot();
            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesStroke(0, new BasicStroke(4.0f));
            plot.setRenderer(renderer);
            ChartPanel panel = new ChartPanel(xylineChart);
            JFrame ventana = new JFrame("Grafica");
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.add(panel);

            //Gŕafica XY
            /*XYSeries p1 = new XYSeries("a1");
            p1.add(0.0, 1.0);
            p1.add(0.0, 0.0);

            XYSeries p2 = new XYSeries("a2");
            p2.add(1.0, 2.0);
            p2.add(1.0, 0.0);

            XYSeries p3 = new XYSeries("a3");
            p3.add(2.0, 1.0);
            p3.add(2.0, 0.0);

            XYSeries p4 = new XYSeries("a4");
            p4.add(-1.0, 4.0);
            p4.add(-1.0, 0.0);

            
            dataset.addSeries(p1);
            dataset.addSeries(p2);
            dataset.addSeries(p3);
            dataset.addSeries(p4);
            JFreeChart xylineChart = ChartFactory.createXYLineChart("Grafica XY", "n", "x(n)", dataset, PlotOrientation.VERTICAL, true, true, false);

            XYPlot plot = xylineChart.getXYPlot();

            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesPaint(1, Color.GREEN);
            renderer.setSeriesPaint(2, Color.YELLOW);
            renderer.setSeriesPaint(3, Color.BLACK);
            renderer.setSeriesStroke(0, new BasicStroke(4.0f));
            renderer.setSeriesStroke(1, new BasicStroke(3.0f));
            renderer.setSeriesStroke(2, new BasicStroke(2.0f));
            renderer.setSeriesStroke(3, new BasicStroke(1.0f));
            plot.setRenderer(renderer);

            ChartPanel panel = new ChartPanel(xylineChart);

            JFrame ventana = new JFrame("Grafica");
            ventana.setVisible(true);
            ventana.setSize(800, 600);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ventana.add(panel);*/

 /* Gráfica de pastel
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Iphone", new Double(20));
            dataset.setValue("Samsung", new Double(20));
            dataset.setValue("MotoG", new Double(40));
            dataset.setValue("Nokia", new Double(10));
            
            JFreeChart chart = ChartFactory.createPieChart("Mobile Sales", dataset, true, true, false);
            ChartPanel panel = new ChartPanel(chart);
            
            JFrame ventana = new JFrame("");
            ventana.setVisible(true);
            ventana.setSize(800,600);
                
            ventana.add(panel);*/
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
