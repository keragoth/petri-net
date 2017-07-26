package testowa;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class GanttDemo2 extends ApplicationFrame {

    private static HashMap<Integer, Historia> zadania = new HashMap<>();
    private static HashMap<String, Integer> zliczenie = new HashMap<>();

    public GanttDemo2(final String title, HashMap a) {

        super(title);
        zadania.clear();
        zliczenie.clear();
        //Zlicz();
        zadania = Symulacja.getDeepCopy(a);
        Zlicz();

        final IntervalCategoryDataset dataset = createSampleDataset();

        //  final CategoryDataset dataset = createSampleDataset();
        //final JFreeChart chart = ChartFactory.createGanttChart("Wykres Gantta","Tranzycja","Czas",dataset,true,
        //       true,false);
        //JFreeChart chart = ChartFactory.createBarChart(title, title, title, dataset, PlotOrientation.HORIZONTAL, rootPaneCheckingEnabled, rootPaneCheckingEnabled, rootPaneCheckingEnabled)
        //  JFreeChart chart = ChartFactory.createBarChart("Wykres Gantta", "Tranzycja", "Czas", dataset);
        final JFreeChart chart = GanttChartFactory.createGanttChart(
                "Wykres", "Tranzycja", "Czas", dataset, true, true, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        final BarRenderer rendererb = (BarRenderer) plot.getRenderer();
        rendererb.setShadowVisible(false);

        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    public void windowClosing(final WindowEvent evt) {
        if (evt.getWindow() == this) {
            dispose();
        }
    }

    public void Close() {
        dispose();
    }

    private IntervalCategoryDataset createSampleDataset() {

        long start = 0;

        long end = Ustawienia.czas_symulacji;
//        Tablica();

        int tmp = 0;
        int zm, zm1;
        int size;

        final TaskSeriesCollection collection = new TaskSeriesCollection();
        //  System.out.println("ilosc " + Ustawienia.ilosc_tranzycji);
        for (int i = 0; i < Ustawienia.ilosc_tranzycji; i++) {
            switch (i) {
                case 0:
//                    String zm2="t0"
                    final TaskSeries s0 = new TaskSeries("t0");
                    zm1 = 0;
                    // <editor-fold defaultstate="collapsed" desc="Getters & setters">
                    Task t0 = null;
                    try {
                        tmp = zliczenie.get("t0").intValue();
                    } catch (Exception e) {
                        tmp = 0;
                    }
                    if (tmp == 0) {
                        t0 = new TaskNumeric("t0", 0, 0);
//                        t0 = new Task(
                        //                              "t0", new SimpleTimePeriod(0, 0));
                    } else {
                        //      t0 = new Task(
                        //            "t0", new SimpleTimePeriod(start, end));
                        t0 = new TaskNumeric("t0", start, end);
                    }

                    for (int j = 1; j <= tmp; j++) {
                        zm = 0;
                        size = zadania.size();
                        for (int k = 0; k < size; k++) {
                            if ((zadania.get(k).getID().equals("t0")) && (zm == zm1)) {
                                //   final Task s0t1 = new Task(
                                //   "t0", new SimpleTimePeriod(zadania.get(k).getP(), zadania.get(k).getK())
                                //   );
                                final Task s0t1 = new TaskNumeric("t0", zadania.get(k).getP(), zadania.get(k).getK());

                                t0.addSubtask(s0t1);
                            } else if (zadania.get(k).getID() == "t0") {
                                zm++;
                            }
                        }
                    }

                    // </editor-fold>
                    s0.add(t0);
                    collection.add(s0);
                    break;
                case 1:
                    final TaskSeries s1 = new TaskSeries("t1");
                    zm1 = 0;
                    // <editor-fold defaultstate="collapsed" desc="Getters & setters">
                    Task t1 = null;
                    try {
                        tmp = zliczenie.get("t1").intValue();
                    } catch (Exception e) {
                        tmp = 0;
                    }
                    if (tmp == 0) {
                        //t1 = new Task(          "t1", new SimpleTimePeriod(end, end));
                        t1 = new TaskNumeric("t1", 0, 0);
                    } else {
                        //t1 = new Task("t1", new SimpleTimePeriod(start, end));
                        t1 = new TaskNumeric("t1", start, end);
                    }
                    for (int j = 1; j <= tmp; j++) {
                        zm = 0;
                        size = zadania.size();
                        for (int k = 0; k < size; k++) {
                            if (zadania.get(k).getID().equals("t1") && zm == zm1) {

                                final Task s1t1 = new TaskNumeric("t1", zadania.get(k).getP(), zadania.get(k).getK());
                                t1.addSubtask(s1t1);
                            } else if (zadania.get(k).getID() == "t1") {
                                zm++;
                            }
                        }
                    }
                    // </editor-fold>
                    s1.add(t1);
                    collection.add(s1);
                    break;
                case 2:
                    final TaskSeries s2 = new TaskSeries("t2");
                    zm1 = 0;
                    // <editor-fold defaultstate="collapsed" desc="Getters & setters">
                    Task t2 = null;
                    try {
                        tmp = zliczenie.get("t2").intValue();
                    } catch (Exception e) {
                        tmp = 0;
                    }
                    if (tmp == 0) {
                        //t2 = new Task("t2", new SimpleTimePeriod(end, end));
                        t2 = new TaskNumeric("t2", 0, 0);
                    } else {
                        //t2 = new Task("t2", new SimpleTimePeriod(start, end));
                        t2 = new TaskNumeric("t2", start, end);
                    }
                    for (int j = 1; j <= tmp; j++) {
                        zm = 0;
                        size = zadania.size();
                        for (int k = 0; k < size; k++) {
                            if (zadania.get(k).getID().equals("t2") && zm == zm1) {
                                //final Task s2t1 = new Task("t2", new SimpleTimePeriod(zadania.get(k).getP(), zadania.get(k).getK()));
                                final Task s2t1 = new TaskNumeric("t2", zadania.get(k).getP(), zadania.get(k).getK());
                                t2.addSubtask(s2t1);
                            } else if (zadania.get(k).getID() == "t2") {
                                zm++;
                            }
                        }
                    }
                    // </editor-fold>
                    s2.add(t2);
                    collection.add(s2);
                    break;
                case 3:
                    final TaskSeries s3 = new TaskSeries("t3");
                    zm1 = 0;
                    // <editor-fold defaultstate="collapsed" desc="Getters & setters">
                    Task t3 = null;
                    try {
                        tmp = zliczenie.get("t3").intValue();
                    } catch (Exception e) {
                        tmp = 0;
                    }
                    if (tmp == 0) {
                        //t3 = new Task("t3", new SimpleTimePeriod(end, end));
                        t3 = new TaskNumeric("t3", 0, 0);
                    } else {
                        //t3 = new Task("t3", new SimpleTimePeriod(start, end));
                        t3 = new TaskNumeric("t3", start, end);
                    }
                    for (int j = 1; j <= tmp; j++) {
                        zm = 0;
                        size = zadania.size();
                        for (int k = 0; k < size; k++) {
                            if (zadania.get(k).getID().equals("t3") && zm == zm1) {

                                final Task s3t1 = new TaskNumeric("t3", zadania.get(k).getP(), zadania.get(k).getK());
                                t3.addSubtask(s3t1);
                            } else if (zadania.get(k).getID() == "t3") {
                                zm++;
                            }
                        }
                    }
                    // </editor-fold>
                    s3.add(t3);
                    collection.add(s3);
                    break;
                case 4:
                    final TaskSeries s4 = new TaskSeries("t4");
                    zm1 = 0;
                    // <editor-fold defaultstate="collapsed" desc="Getters & setters">
                    Task t4 = null;
                    try {
                        tmp = zliczenie.get("t4").intValue();
                    } catch (Exception e) {
                        tmp = 0;
                    }
                    if (tmp == 0) {
                        //t4 = new Task("t4", new SimpleTimePeriod(end, end));
                        t4 = new TaskNumeric("t4", 0, 0);
                    } else {
                        //t4 = new Task("t4", new SimpleTimePeriod(start, end));
                        t4 = new TaskNumeric("t4", start, end);
                    }
                    for (int j = 0; j < tmp; j++) {
                        zm = 0;
                        size = zadania.size();
                        for (int k = 0; k < size; k++) {
                            if (zadania.get(k).getID().equals("t4") && zm == zm1) {

                                final Task s4t1 = new TaskNumeric("t4", zadania.get(k).getP(), zadania.get(k).getK());
                                t4.addSubtask(s4t1);
                            } else if (zadania.get(k).getID() == "t4") {
                                zm++;
                            }
                        }
                    }
                    // </editor-fold>
                    s4.add(t4);
                    collection.add(s4);
                    break;
                case 5:
                    final TaskSeries s5 = new TaskSeries("t5");
                    zm1 = 0;
                    // <editor-fold defaultstate="collapsed" desc="Getters & setters">
                    Task t5 = null;
                    try {
                        tmp = zliczenie.get("t5").intValue();
                    } catch (Exception e) {
                        tmp = 0;
                    }
                    if (tmp == 0) {
                        // t5 = new Task("t5", new SimpleTimePeriod(end, end));
                        t5 = new TaskNumeric("t5", 0, 0);
                    } else {
                        //t5 = new Task("t5", new SimpleTimePeriod(start, end));
                        t5 = new TaskNumeric("t5", start, end);
                    }
                    for (int j = 0; j < tmp; j++) {
                        zm = 0;
                        size = zadania.size();
                        for (int k = 0; k < size; k++) {
                            if (zadania.get(k).getID().equals("t5") && zm == zm1) {

                                final Task st1 = new TaskNumeric(
                                        "t5", zadania.get(k).getP(), zadania.get(k).getK()
                                );
                                t5.addSubtask(st1);
                            } else if (zadania.get(k).getID() == "t5") {
                                zm++;
                            }
                        }
                    }
                    // </editor-fold>
                    s5.add(t5);
                    collection.add(s5);
                    break;
                case 6:
                    final TaskSeries s6 = new TaskSeries("t6");
                    zm1 = 0;
                    // <editor-fold defaultstate="collapsed" desc="Getters & setters">
                    Task t6 = null;
                    try {
                        tmp = zliczenie.get("t6").intValue();
                    } catch (Exception e) {
                        tmp = 0;
                    }
                    if (tmp == 0) {
                        //t6 = new Task("t6", new SimpleTimePeriod(end, end));
                        t6 = new TaskNumeric("t6", 0, 0);
                    } else {
                        //t6 = new Task("t6", new SimpleTimePeriod(start, end));
                        t6 = new TaskNumeric("t6", start, end);
                    }
                    for (int j = 0; j < tmp; j++) {
                        zm = 0;
                        size = zadania.size();
                        for (int k = 0; k < size; k++) {
                            if (zadania.get(k).getID().equals("t6") && zm == zm1) {

                                final Task st1 = new TaskNumeric(
                                        "t6", zadania.get(k).getP(), zadania.get(k).getK()
                                );
                                t6.addSubtask(st1);
                            } else if (zadania.get(k).getID() == "t6") {
                                zm++;
                            }
                        }
                    }
                    // </editor-fold>
                    s6.add(t6);
                    collection.add(s6);
                    break;
                case 7:
                    final TaskSeries s7 = new TaskSeries("t7");
                    zm1 = 0;
                    // <editor-fold defaultstate="collapsed" desc="Getters & setters">
                    Task t7 = null;
                    try {
                        tmp = zliczenie.get("t7").intValue();
                    } catch (Exception e) {
                        tmp = 0;
                    }
                    if (tmp == 0) {
                        //t7 = new Task("t7", new SimpleTimePeriod(end, end));
                        t7 = new TaskNumeric("t7", 0, 0);
                    } else {
                        //t7 = new Task("t7", new SimpleTimePeriod(start, end));
                        t7 = new TaskNumeric("t7", start, end);
                    }
                    for (int j = 0; j < tmp; j++) {
                        zm = 0;
                        size = zadania.size();
                        for (int k = 0; k < size; k++) {
                            if (zadania.get(k).getID().equals("t7") && zm == zm1) {

                                final Task st1 = new TaskNumeric(
                                        "t7", zadania.get(k).getP(), zadania.get(k).getK()
                                );
                                t7.addSubtask(st1);
                            } else if (zadania.get(k).getID() == "t7") {
                                zm++;
                            }
                        }
                    }
                    // </editor-fold>
                    s7.add(t7);
                    collection.add(s7);
                    break;
                case 8:
                    final TaskSeries s8 = new TaskSeries("t8");
                    zm1 = 0;
                    // <editor-fold defaultstate="collapsed" desc="Getters & setters">
                    Task t8 = null;
                    try {
                        tmp = zliczenie.get("t8").intValue();
                    } catch (Exception e) {
                        tmp = 0;
                    }
                    if (tmp == 0) {
                        //t8 = new Task("t8", new SimpleTimePeriod(end, end));
                        t8 = new TaskNumeric("t8", 0, 0);
                    } else {
                        //t8 = new Task("t8", new SimpleTimePeriod(start, end));
                        t8 = new TaskNumeric("t8", start, end);
                    }
                    for (int j = 0; j < tmp; j++) {
                        zm = 0;
                        size = zadania.size();
                        for (int k = 0; k < size; k++) {
                            if (zadania.get(k).getID().equals("t8") && zm == zm1) {

                                final Task s8t1 = new TaskNumeric(
                                        "t8", zadania.get(k).getP(), zadania.get(k).getK()
                                );
                                t8.addSubtask(s8t1);
                            } else if (zadania.get(k).getID() == "t8") {
                                zm++;
                            }
                        }
                    }
                    // </editor-fold>
                    s8.add(t8);
                    collection.add(s8);
                    break;

            }
        }

        return collection;
    }
// <editor-fold>
/*
     public void Tablica() {
     int e = Ustawienia.ilosc_tranzycji;
     int tmp = 0, tmp1 = 0, tmp2 = 0;
     tmp1 = 0;
     tmp = MainMenu.tabela.get(0).intValue();
     int licznik = 0;
     for (int i = 1; i < e; i++) {
     if (MainMenu.tabela.get(i).intValue() != tmp) {
     tmp2 = i;
     Wykres a = new Wykres(tmp, tmp1, tmp2);
     zadania.put(licznik, a);
     tmp = MainMenu.tabela.get(i).intValue();
     tmp1 = i;
     licznik++;
     }
     if ((i + 1) == e) {
     tmp2 = i + 1;
     Wykres a = new Wykres(tmp, tmp1, tmp2);
     zadania.put(licznik, a);
     }

     }

     Sortuj();
     /*      int inte = zadania.size();
     for (int zm = 0;
     zm < inte;
     zm++) {
     System.out.println("---------------");
     System.out.println("zadanie: " + zadania.get(zm).Zadanie() + " start: " + zadania.get(zm).Start() + " koniec: " + zadania.get(zm).End());
     }
     */
    //}
    /*
     private void Sortuj() {
     int zmiana, ile;
     int size = zadania.size();
     Wykres tmp = new Wykres();
     if (size > 1) {
     do {
     zmiana = 0;
     ile = size - 1;
     do {
     ile--;
     if (zadania.get(ile + 1).Zadanie() < (zadania.get(ile).Zadanie())) {
     tmp.WZ(zadania.get(ile).Zadanie());
     tmp.WS(zadania.get(ile).Start());
     tmp.WE(zadania.get(ile).End());

     zadania.get(ile).WZ(zadania.get(ile + 1).Zadanie());
     zadania.get(ile).WS(zadania.get(ile + 1).Start());
     zadania.get(ile).WE(zadania.get(ile + 1).End());

     zadania.get(ile + 1).WZ(tmp.Zadanie());
     zadania.get(ile + 1).WS(tmp.Start());
     zadania.get(ile + 1).WE(tmp.End());

     zmiana = 1;
     }

     } while (ile != 0);

     } while (zmiana != 0);
     }
     /*   int inte = zadania.size();
     int zm = 0;
     System.out.println("sorotwanie D");
     for (int i = 0; i < inte; i++) {
     System.out.println("\nZ: " + zadania.get(i).Zadanie());
     System.out.println("S: " + zadania.get(i).Start());
     System.out.println("E: " + zadania.get(i).End());
           
     }
     System.out.println("--------D");
     */
    /*
     Zlicz();
     }
     */

    public void Zlicz() {
        String zm = null;
        int tmp0 = 0, tmp1 = 0, tmp2 = 0, tmp3 = 0, tmp4 = 0, tmp5 = 0, tmp6 = 0, tmp7 = 0, tmp8 = 0, tmp9 = 0;
        int ile = zadania.size();

        //ile = Ustawienia.HIST;
        //  System.out.println("ile " + ile);
        for (int i = 0; i < ile; i++) {
            zm = zadania.get(i).getID();
            switch (zm) {
                case "t0":
                    tmp0++;
                    zliczenie.put("t0", tmp0);
                    break;
                case "t1":
                    tmp1++;
                    zliczenie.put("t1", tmp1);
                    break;
                case "t2":
                    tmp2++;
                    zliczenie.put("t2", tmp2);
                    break;
                case "t3":
                    tmp3++;
                    zliczenie.put("t3", tmp3);
                    break;
                case "t4":
                    tmp4++;
                    zliczenie.put("t4", tmp4);
                    break;
                case "t5":
                    tmp5++;
                    zliczenie.put("t5", tmp5);
                    break;
                case "t6":
                    tmp6++;
                    zliczenie.put("t6", tmp6);
                    break;
                case "t7":
                    tmp7++;
                    zliczenie.put("t7", tmp7);
                    break;
                case "t8":
                    tmp8++;
                    zliczenie.put("t8", tmp8);
                    break;
                case "t9":
                    tmp9++;
                    zliczenie.put(zm, tmp9);
                    break;

            }
        }

        /*        int inte = zliczenie.size();

         System.out.println("zliczenie D");
         for (int i = 0; i < inte; i++) {
         System.out.println("\nE: " + i);
         System.out.println("Z: " + zliczenie.get(i));

         }
         System.out.println("--------D");
         */
    }

    // </editor-fold>
}
