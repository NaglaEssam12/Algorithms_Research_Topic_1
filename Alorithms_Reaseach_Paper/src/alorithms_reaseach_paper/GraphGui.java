/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alorithms_reaseach_paper;

/**
 *
 * @author Nagla Essam
 */
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.PickableVertexPaintTransformer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.picking.PickedInfo;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Paint;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.JOptionPane.showMessageDialog;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;

public class GraphGui extends JPanel implements ActionListener {

    public static int[] colors;
    public static DirectedSparseGraph<Integer, String> graph = new DirectedSparseGraph<Integer, String>();

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class VertexPaintTransformer implements Transformer<Integer, Paint> {

        private PickedInfo<Integer> pi;

        VertexPaintTransformer(PickedInfo<Integer> pi) {
            super();
            if (pi == null) {
                throw new IllegalArgumentException("PickedInfo instance must be non-null");
            }
            this.pi = pi;
        }

        //@Override
        public Paint transform(Integer i) {
            Color p = null;
            GraphGui l = new GraphGui();

            if (l.colors[i] == 1) {
                return Color.BLUE;
            }
            return Color.BLACK;
        }

    }

    private JFrame frame;
    private JFrame openFrame;
    private JFrame maxFlowFrame;
    private JTextField numofverticestext;
    private JTextField numofEdgestext;
    private JTextField srctext;
    private JTextField sourcetext;
    private JTextField sinktext;
    static int numofvertices = 0;
    int numofEdges = 0;
    int source = 0;
    int src = 0;
    int sink = 0;
    JTextArea iotext;
    JTextArea iotext1;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel1;
    private JLabel lblNewLabel2;
    private JLabel lblNewLabel3;
    private JLabel lblNewLabel4;
    private JLabel lblNewLabel5;
    private JLabel lblNewLabel6;
    private JLabel lblNewLabel7;
    private JLabel lblNewLabel8;
    private JLabel lblNewLabel9;
    boolean Dijkstra = false;
    boolean Dijkstra_directed = false;
    static boolean MaxFlow = false;
    boolean step = false;
    static boolean visible = true;
    static Timer timer;
    static ActionListener listen;
//    GraphGui gui = new GraphGui();

    /**
     * Launch the application.
     */
    public static void test() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GraphGui window = new GraphGui();
                    window.initializeFrame();
                    window.openFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GraphGui() {
   
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initializeFrame() {
        openFrame = new JFrame();
        openFrame.setBounds(450, 150, 600, 400);
        openFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        openFrame.getContentPane().setLayout(null);
        openFrame.getContentPane().setBackground(Color.GRAY);
        
        lblNewLabel = new JLabel("Name");
        lblNewLabel.setBounds(115, 120, 100, 14);
        lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        openFrame.getContentPane().add(lblNewLabel);
        
        lblNewLabel1 = new JLabel("ID");
        lblNewLabel1.setBounds(425, 120, 100, 14);
        lblNewLabel1.setFont(new Font("SansSerif", Font.BOLD, 18));
        openFrame.getContentPane().add(lblNewLabel1);
        
        lblNewLabel2 = new JLabel("Mona Mohamed Fathy");
        lblNewLabel2.setBounds(90, 150, 200, 22);
        lblNewLabel2.setFont(new Font("SansSerif", Font.BOLD, 16));
        openFrame.getContentPane().add(lblNewLabel2);
        
        lblNewLabel3 = new JLabel("20170300");
        lblNewLabel3.setBounds(400, 150, 100, 14);
        lblNewLabel3.setFont(new Font("SansSerif", Font.BOLD, 16));
        openFrame.getContentPane().add(lblNewLabel3);
        
        lblNewLabel4 = new JLabel("Mayada Mohamed Mahmoud");
        lblNewLabel4.setBounds(90, 180, 250, 22);
        lblNewLabel4.setFont(new Font("SansSerif", Font.BOLD, 16));
        openFrame.getContentPane().add(lblNewLabel4);
        
        lblNewLabel5 = new JLabel("20170304");
        lblNewLabel5.setBounds(400, 180, 100, 14);
        lblNewLabel5.setFont(new Font("SansSerif", Font.BOLD, 16));
        openFrame.getContentPane().add(lblNewLabel5);
        
        lblNewLabel6 = new JLabel("Naglaa Essam Fathy");
        lblNewLabel6.setBounds(90, 210, 200, 22);
        lblNewLabel6.setFont(new Font("SansSerif", Font.BOLD, 16));
        openFrame.getContentPane().add(lblNewLabel6);
        
        lblNewLabel7 = new JLabel("20170313");
        lblNewLabel7.setBounds(400, 210, 100, 14);
        lblNewLabel7.setFont(new Font("SansSerif", Font.BOLD, 16));
        openFrame.getContentPane().add(lblNewLabel7);
        
        lblNewLabel8 = new JLabel("Team Number");
        lblNewLabel8.setBounds(90, 250, 200, 22);
        lblNewLabel8.setFont(new Font("SansSerif", Font.BOLD, 16));
        openFrame.getContentPane().add(lblNewLabel8);
        
        lblNewLabel9 = new JLabel("29");
        lblNewLabel9.setBounds(425, 250, 100, 14);
        lblNewLabel9.setFont(new Font("SansSerif", Font.BOLD, 16));
        openFrame.getContentPane().add(lblNewLabel9);
        
        JButton dijkstraBttn = new JButton("Dijkstra Graph");
        dijkstraBttn.setFont(new Font("SansSerif", Font.BOLD, 13));
        dijkstraBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFrame.hide();
                initialize();
                frame.setVisible(true);
            }

        });
        

       
        JButton maxFlowBttn = new JButton("Max Flow Graph");
        maxFlowBttn.setFont(new Font("SansSerif", Font.BOLD, 13));
        maxFlowBttn.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                 openFrame.hide();
                 initializeMaxFlow();
                 maxFlowFrame.setVisible(true);
             }
        
    });
        dijkstraBttn.setBounds(90, 70, 127, 20);
        openFrame.getContentPane().add(dijkstraBttn);

        maxFlowBttn.setBounds(325, 70, 150, 20);
        openFrame.getContentPane().add(maxFlowBttn);
    }

    

    public void drawRepresentation(int costReprestentation[][], String name, ArrayList<Integer> list0, int num, int x1, int y1, Color p , int flag) {
        construct_graph(costReprestentation, name, list0, num, x1, y1, p , flag);
    }

    public void construct_graph(int costReprestentation[][], String name, ArrayList<Integer> list0, int num, int x1, int y1, Color p , int flag) {

        int x = 1;
        int y = num;
        DirectedSparseGraph<Integer, String> graph = new DirectedSparseGraph<Integer, String>();
        for (int i = 0; i < costReprestentation.length; i++) {
            graph.addVertex(y);
            y++;
            for (int j = 0; j < costReprestentation.length; j++) {
                if (costReprestentation[i][j] != 0) {
                    String s = "Distance " + x + ":" + "(" + costReprestentation[i][j] + ")";
                    graph.addEdge(s, list0.get(i), list0.get(j), EdgeType.DIRECTED);
                    x++;
                }
            }
        }
        
        Layout<Integer, String> layout = new CircleLayout(graph);
        layout.setSize(new Dimension(400, 400)); // sets the initial size of the space
        // The BasicVisualizationServer<V,E> is parameterized by the edge types
        BasicVisualizationServer<Integer, String> vv
                = new BasicVisualizationServer<Integer, String>(layout);
        vv.setPreferredSize(new Dimension(500, 480)); //Sets the viewing area size
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setVertexFillPaintTransformer(new PickableVertexPaintTransformer<Integer>(vv.getPickedVertexState(), Color.BLACK, Color.BLUE));

        vv.getRenderContext().setEdgeFontTransformer(new ConstantTransformer(new Font("SansSerif", Font.BOLD, 14)));
        vv.getRenderContext().setEdgeFillPaintTransformer(new PickableVertexPaintTransformer<String>(vv.getPickedEdgeState(), p, Color.BLUE));
        JFrame frame = new JFrame(name);
        frame.setBounds(x1, y1, 300, 400);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vv.hide();
        int delay = 0;
        if(flag == 1){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
         delay = (numofvertices -1 ) * 1000 * flag; 
        }
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vv.show();
                frame.getContentPane().add(vv);
                frame.pack();
                frame.setVisible(true);
               
                                }
                            });
        timer.setRepeats(false);
        timer.start();
        
    }

    public void draw_Undirected(int costReprestentation[][], ArrayList<Integer> list0, int num, String name, int x1, int y1, Color p , int flag) {
        SparseMultigraph<Integer, String> graph = new SparseMultigraph();
        int c = 1;
        for (int i = 0; i < costReprestentation.length; i++) {
            graph.addVertex(num);
            num++;

            for (int j = 0; j < costReprestentation.length; j++) {
                if (costReprestentation[i][j] != 0) {
                    String s = "Distance " + c + ":" + "(" + costReprestentation[i][j] + ")";
                    graph.addEdge(s, list0.get(i), list0.get(j));
                    c++;
                }
            }
        }

        Layout<Integer, String> layout = new CircleLayout(graph);
        layout.setSize(new Dimension(400, 400));
        BasicVisualizationServer<Integer, String> vv
                = new BasicVisualizationServer<Integer, String>(layout);
        vv.setPreferredSize(new Dimension(500, 480)); //Sets the viewing area size
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());

        vv.getRenderContext().setVertexFillPaintTransformer(new PickableVertexPaintTransformer<Integer>(vv.getPickedVertexState(), Color.BLACK, Color.BLUE));

        vv.getRenderContext().setEdgeFontTransformer(new ConstantTransformer(new Font("SansSerif", Font.BOLD, 14)));
        vv.getRenderContext().setEdgeFillPaintTransformer(new PickableVertexPaintTransformer<String>(vv.getPickedEdgeState(), p, Color.BLUE));

        JFrame frame = new JFrame(name);
        frame.setBackground(Color.yellow);
        frame.setBounds(x1, y1, 600, 800);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       vv.hide();
       int delay = 0;
       if(flag == 1){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
         delay = (numofvertices -1 ) * 1000 * flag; 
       }
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vv.show();
                frame.getContentPane().add(vv);
                frame.pack();
                frame.setVisible(true);
               
                                }
                            });
        timer.setRepeats(false);
        timer.start();
    }

    public static void construct_graph1(int graph1[][], int costReprestentation[][], String name, ArrayList<Integer> list0, int num, int x1, int y1, Color p , int flag) {

        int x = 1;
        int y = num;
    
        String s = "";
        DirectedSparseGraph<Integer, String> graph = new DirectedSparseGraph<Integer, String>();
        for (int i = 0; i < costReprestentation.length; i++) {
            graph.addVertex(y);
            y++;
            for (int j = 0; j < graph1.length; j++) {
                if (graph1[i][j] != 0) {
                    if(graph1[i][j] != costReprestentation[i][j]){
                     s = "Distance " + x + ":" + "(" + graph1[i][j] + ")" + " / " + "(" + costReprestentation[i][j] + ")";
                    }
                    else
                    {
                         s = "Distance " + x + ":" + "(" + graph1[i][j] + ")";
                    }
                    graph.addEdge(s, list0.get(i), list0.get(j), EdgeType.DIRECTED);
                    x++;
                }
            }
        }

        Layout<Integer, String> layout = new CircleLayout(graph);
        layout.setSize(new Dimension(600, 600));
        BasicVisualizationServer<Integer, String> vv
                = new BasicVisualizationServer<Integer, String>(layout);
        vv.setPreferredSize(new Dimension(600, 600)); //Sets the viewing area size
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setVertexFillPaintTransformer(new VertexPaintTransformer(vv.getPickedVertexState()));
        vv.getRenderContext().setEdgeFontTransformer(new ConstantTransformer(new Font("SansSerif", Font.BOLD, 12)));
        vv.getRenderContext().setEdgeFillPaintTransformer(new PickableVertexPaintTransformer<String>(vv.getPickedEdgeState(), p, Color.BLUE));

        JFrame frame1 = new JFrame(name);
        frame1.setBounds(x1, y1, 300, 400);
        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        vv.hide();
        int delay = 0;
        if(flag == 1){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
         delay = (numofvertices -1 ) * 1000 * flag; 
        }
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vv.show();
                frame1.getContentPane().add(vv);
                frame1.pack();
                frame1.setVisible(true);
               
                                }
                            });
        timer.setRepeats(false);
        timer.start();
        
    }

    private void initializeMaxFlow() {
        maxFlowFrame = new JFrame("Max Flow");
        maxFlowFrame.setBounds(450, 150, 500, 539);
        maxFlowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maxFlowFrame.getContentPane().setLayout(null);
        maxFlowFrame.getContentPane().setBackground(Color.PINK);

        numofverticestext = new JTextField();
        numofverticestext.setBounds(155, 18, 96, 20);
        numofverticestext.setFont(new Font("SansSerif", Font.BOLD, 14));
        maxFlowFrame.getContentPane().add(numofverticestext);
        numofverticestext.setColumns(10);

        sourcetext = new JTextField();
        sourcetext.setBounds(155, 63, 96, 20);
        sourcetext.setFont(new Font("SansSerif", Font.BOLD, 14));
        maxFlowFrame.getContentPane().add(sourcetext);
        sourcetext.setColumns(10);

        sinktext = new JTextField();
        sinktext.setBounds(155, 86, 96, 20);
        sinktext.setFont(new Font("SansSerif", Font.BOLD, 14));
        maxFlowFrame.getContentPane().add(sinktext);
        sinktext.setColumns(10);

        numofEdgestext = new JTextField();
        numofEdgestext.setBounds(155, 41, 96, 20);
        numofEdgestext.setFont(new Font("SansSerif", Font.BOLD, 14));
        maxFlowFrame.getContentPane().add(numofEdgestext);
        numofEdgestext.setColumns(10);

        JLabel lblNumberOfVertices = new JLabel("Number of vertices");
        lblNumberOfVertices.setBounds(10, 21, 150, 14);
        lblNumberOfVertices.setFont(new Font("SansSerif", Font.BOLD, 14));
        maxFlowFrame.getContentPane().add(lblNumberOfVertices);

        JLabel lblNumberOfEdges = new JLabel("Number of Edgs");
        lblNumberOfEdges.setBounds(10, 41, 212, 27);
        lblNumberOfEdges.setFont(new Font("SansSerif", Font.BOLD, 14));
        maxFlowFrame.getContentPane().add(lblNumberOfEdges);

        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(10, 63, 200, 20);
        lblsource.setFont(new Font("SansSerif", Font.BOLD, 14));
        maxFlowFrame.getContentPane().add(lblsource);

        JLabel lblsink = new JLabel("Sink");
        lblsink.setBounds(10, 86, 150, 14);
        lblsink.setFont(new Font("SansSerif", Font.BOLD, 14));
        maxFlowFrame.getContentPane().add(lblsink);
        
        JCheckBox outputStepsCheckBox = new JCheckBox("Show Output Steps ");
        outputStepsCheckBox.setBounds(300, 167, 300, 30);
        outputStepsCheckBox.setFont(new Font("SansSerif", Font.BOLD, 13));
        outputStepsCheckBox.setBackground(Color.PINK);
        maxFlowFrame.getContentPane().add(outputStepsCheckBox);
        
        JButton myClearButton= new JButton("Clear");
         myClearButton.setFont(new Font("SansSerif", Font.BOLD, 13));
       myClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String clearString = new String("");
                numofverticestext.setText(clearString);
                numofEdgestext.setText(clearString);
                sourcetext.setText(clearString);
                sinktext.setText(clearString);
                iotext1.setText(clearString);
                outputStepsCheckBox.setSelected(false);
            }
        });
        myClearButton.setBounds(300, 410, 127, 20);
        maxFlowFrame.getContentPane().add(myClearButton);
        
        JButton backBttn = new JButton("Back");
        backBttn.setFont(new Font("SansSerif", Font.BOLD, 13));

        backBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                maxFlowFrame.hide();
                initializeFrame();
                openFrame.setVisible(true);
            }
        });
        backBttn.setBounds(250, 459, 127, 20);
        maxFlowFrame.getContentPane().add(backBttn);

        JButton btnGetMatrises = new JButton("get Graph");
        btnGetMatrises.setFont(new Font("SansSerif", Font.BOLD, 13));

        btnGetMatrises.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numofvertices = Integer.parseInt(numofverticestext.getText());
                numofEdges = Integer.parseInt(numofEdgestext.getText());
                source = Integer.parseInt(sourcetext.getText());
                sink = Integer.parseInt(sinktext.getText());
                
                int costReprestentation[][] = new int[numofvertices][numofvertices];
                int temp[][] = new int[numofEdges][3];
                ArrayList<Integer> list0 = new ArrayList<Integer>();
                int[] list2 = new int[numofvertices];
                int digraph[][] = new int[numofvertices][numofvertices];
               
                for (int i = 0; i < numofvertices; i++) {
                    for (int j = 0; j < numofvertices; j++) {
                        costReprestentation[i][j] = 0;
                    }
                }
                for (int k = 0; k < list2.length; k++) {
                    list2[k] = Integer.MAX_VALUE;
                }
                int first = 0, second = 0, third = 0;
                boolean flag = false;
                String[] strTmp = null;
                int l = 0;
                MaxFlow = outputStepsCheckBox.isSelected();
                for (int i = 0; i < numofvertices; i++) {
                    String[] tmp = iotext1.getText().split("\n");
                    String str = "";
                    for (String a : tmp) {
                        str += a;
                        str += " ";
                        strTmp = str.split(" ");
                        str = "";

                        first = Integer.parseInt(strTmp[0]);
                        second = Integer.parseInt(strTmp[1]);
                        third = Integer.parseInt(strTmp[2]);
                        if (l < numofEdges) {
                            temp[l][0] = first;
                            temp[l][1] = second;
                            temp[l][2] = third;
                            l++;
                        }
                        if (third < 0) {
                            flag = true;
                        }
                        if (!list0.contains(first)) {
                            list0.add(first);
                        }
                        if (!list0.contains(second)) {
                            list0.add(second);
                        }
                        for (int j = 0; j < list0.size(); j++) {
                            list2[j] = list0.get(j);
                        }
                        Arrays.sort(list2);
                        for (int j = 0; j < list0.size(); j++) {
                            list0.set(j, list2[j]);

                        }
                    }
                }
                for (int i = 0; i < numofEdges; i++) {
                    first = temp[i][0];
                    second = temp[i][1];
                    third = temp[i][2];

                    digraph[list0.indexOf(first)][list0.indexOf(second)] = third;

                }
                Graph h = new Graph();
                MaxFlow f = new MaxFlow();
                if (flag) {
                    showMessageDialog(null, "distance invaild");
                } else {
                    drawRepresentation(digraph, "MaxFlow Input", list0, list0.get(0), 100, 100, Color.CYAN , 0);
                    
                    int z = f.fordFulkerson(digraph, source, sink, numofvertices, list0);
                   
                }
               
            }

        });
        btnGetMatrises.setBounds(50, 459, 127, 20);
        maxFlowFrame.getContentPane().add(btnGetMatrises);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 147, 250, 266);
        maxFlowFrame.getContentPane().add(scrollPane);
        
        iotext1 = new JTextArea();
        iotext1.setFont(new Font("SansSerif", Font.BOLD, 14));
        scrollPane.setViewportView(iotext1);
    }

    private void initialize() {

        frame = new JFrame("Dijkstra");
        frame.setBounds(450, 150, 500, 539);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.PINK);

        iotext=new JTextArea();
        
        numofverticestext = new JTextField();
        numofverticestext.setBounds(155, 18, 96, 20);
        numofverticestext.setFont(new Font("SansSerif", Font.BOLD, 14));
        frame.getContentPane().add(numofverticestext);
        numofverticestext.setColumns(10);

        numofEdgestext = new JTextField();
        numofEdgestext.setBounds(155, 41, 96, 20);
        numofEdgestext.setFont(new Font("SansSerif", Font.BOLD, 14));
        frame.getContentPane().add(numofEdgestext);
        numofEdgestext.setColumns(10);
        
        srctext = new JTextField();
        srctext.setBounds(155, 65, 96, 20);
        srctext.setFont(new Font("SansSerif", Font.BOLD, 14));
        frame.getContentPane().add(srctext);
        srctext.setColumns(10);
        
        
        JLabel lblNumberOfVertices = new JLabel("Number of vertices");
        lblNumberOfVertices.setBounds(10, 21, 150, 14);
        lblNumberOfVertices.setFont(new Font("SansSerif", Font.BOLD, 14));
        frame.getContentPane().add(lblNumberOfVertices);

        JLabel lblNumberOfEdges = new JLabel("Number of Edgs");
        lblNumberOfEdges.setBounds(10, 41, 212, 27);
        lblNumberOfEdges.setFont(new Font("SansSerif", Font.BOLD, 14));
        frame.getContentPane().add(lblNumberOfEdges);

        lblNewLabel3 = new JLabel("Source");
        lblNewLabel3.setBounds(10, 71, 412, 14);
        lblNewLabel3.setFont(new Font("SansSerif", Font.BOLD, 14));
        frame.getContentPane().add(lblNewLabel3);

        JCheckBox DijkstraCheckBox = new JCheckBox("Dijkstra_undirected");
        DijkstraCheckBox.setBounds(300, 167, 300, 23);
        DijkstraCheckBox.setFont(new Font("SansSerif", Font.BOLD, 13));
        DijkstraCheckBox.setBackground(Color.PINK);
        frame.getContentPane().add(DijkstraCheckBox);
        
        JCheckBox Dijkstra_directedCheckBox = new JCheckBox("Dijkstra_directed ");
        Dijkstra_directedCheckBox.setBounds(300, 187, 300, 30);
        Dijkstra_directedCheckBox.setFont(new Font("SansSerif", Font.BOLD, 13));
        Dijkstra_directedCheckBox.setBackground(Color.PINK);
        frame.getContentPane().add(Dijkstra_directedCheckBox);
        
        JCheckBox outputStepsCheckBox = new JCheckBox("Show Output Steps ");
        outputStepsCheckBox.setBounds(300, 210, 300, 30);
        outputStepsCheckBox.setFont(new Font("SansSerif", Font.BOLD, 13));
        outputStepsCheckBox.setBackground(Color.PINK);
        frame.getContentPane().add(outputStepsCheckBox);
        
        
                
         JButton myClearButton= new JButton("Clear");
         myClearButton.setFont(new Font("SansSerif", Font.BOLD, 13));
       myClearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String clearString = new String("");
                numofverticestext.setText(clearString);
                numofEdgestext.setText(clearString);
                srctext.setText(clearString);
                DijkstraCheckBox.setSelected(false);
                Dijkstra_directedCheckBox.setSelected(false);
                outputStepsCheckBox.setSelected(false);
                iotext.setText(clearString);
                
            }
        });
        myClearButton.setBounds(300, 410, 127, 20);
        frame.getContentPane().add(myClearButton);

        JButton backBttn = new JButton("Back");
        backBttn.setFont(new Font("SansSerif", Font.BOLD, 13));

        backBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.hide();
                initializeFrame();
                openFrame.setVisible(true);
            }
        });
        backBttn.setBounds(250, 459, 127, 20);
        frame.getContentPane().add(backBttn);
        
        JButton btnGetMatrises = new JButton("get Graph");
        btnGetMatrises.setFont(new Font("SansSerif", Font.BOLD, 13));
     
        btnGetMatrises.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 ArrayList<Integer> list0 = new ArrayList<Integer>();                
                 ArrayList<Integer> list = new ArrayList<Integer>();
                numofvertices = 0;
                numofvertices = Integer.parseInt(numofverticestext.getText());
                numofEdges = Integer.parseInt(numofEdgestext.getText());
                src = Integer.parseInt(srctext.getText());
                
                int costReprestentation[][] = new int[numofvertices][numofvertices];

                int temp[][] = new int[numofEdges][3];
                int[] list2 = new int[numofvertices];
               
                int graph[][] = new int[numofvertices][numofvertices];
                int digraph[][] = new int[numofvertices][numofvertices];
                int graph1[][] = new int[numofvertices][numofvertices];
                
                for (int i = 0; i < numofvertices; i++) {
                    for (int j = 0; j < numofvertices; j++) {
                        costReprestentation[i][j] = 0;
                    }
                }
                for (int k = 0; k < list2.length; k++) {
                    list2[k] = Integer.MAX_VALUE;
                }
                int first = 0, second = 0, third = 0;
                boolean flag = false;
                String[] strTmp = null;
                int l = 0;
                for (int i = 0; i < 1; i++) {
                    String[] tmp = iotext.getText().split("\n");
                    String str = "";
                    for (String a : tmp) {
                        str += a;
                        str += " ";
                        strTmp = str.split(" ");
                        str = "";

                        first = Integer.parseInt(strTmp[0]);
                        second = Integer.parseInt(strTmp[1]);
                        third = Integer.parseInt(strTmp[2]);
                        if (l < numofEdges) {
                            temp[l][0] = first;
                            temp[l][1] = second;
                            temp[l][2] = third;
                            l++;
                        }
                        if (third < 0) {
                            flag = true;
                        }

                        Dijkstra = DijkstraCheckBox.isSelected();
                        Dijkstra_directed = Dijkstra_directedCheckBox.isSelected();
                        step = outputStepsCheckBox.isSelected();
                        if (!list0.contains(first)) {
                            list0.add(first);
                          
                        }
                        if (!list0.contains(second)) {
                            list0.add(second);
                            
                        }
                        for (int j = 0; j < list0.size(); j++) {
                            list2[j] = list0.get(j);
                        }
                        Arrays.sort(list2);
                        for (int j = 0; j < list0.size(); j++) {
                            list0.set(j, list2[j]);
                           

                        }
                    }
                }
                for (int i = 0; i < numofEdges; i++) {
                    first = temp[i][0];
                    second = temp[i][1];
                    third = temp[i][2];
                    if (Dijkstra) {
                        graph[list0.indexOf(first)][list0.indexOf(second)] = third;
                        graph[list0.indexOf(second)][list0.indexOf(first)] = third;
                    }
                    if (Dijkstra_directed || MaxFlow) {
                        digraph[list0.indexOf(first)][list0.indexOf(second)] = third;
                    }
                }
                Dijkstrapath m = new Dijkstrapath();
                Graph h = new Graph();
                MaxFlow f = new MaxFlow();
                if (flag) {
                    showMessageDialog(null, "distance invaild");
                }
                if (Dijkstra_directed && !flag) {
                    
                    list = m.dijkstra(digraph, src, numofvertices);
                    costReprestentation = h.representOutput(list);
                    int counter = 0;
                    int c = 0;
                    drawRepresentation(digraph, "Input of Directed Graph", list0, list0.get(0), 750, 100, Color.PINK , 0);
                    for (int i = 0; i < costReprestentation.length; i++) {

                        first = costReprestentation[i][0];
                        second = costReprestentation[i][1];
                        third = costReprestentation[i][2];
                        graph1[list0.indexOf(first)][list0.indexOf(second)] = third;
                     if(step)
                     {
                        if (counter <= 3) {
                            c++;
                            drawRepresentation(graph1, "Step" + (i + 1), list0, list0.get(0), (400 * counter), 0, Color.CYAN , 1);
                            		
                        } else {
                            counter = 0;
                            drawRepresentation(graph1, "Step " + (i + 1), list0, list0.get(0), (400 * counter), (100 * (counter + c)), Color.CYAN , 1);
                        }

                        counter++;
                     }
                    }
                    if(!step){
                    
                    drawRepresentation(graph1, "Output of Directed Graph", list0, list0.get(0), 100, 100, Color.PINK , 0);  
                    }
                }
                if (Dijkstra && !flag) {
                    
                   int counter = 0, c = 0;
                    list = m.dijkstra(graph, src, numofvertices);
                    costReprestentation = h.representOutput(list);
                    for (int i = 0; i < numofvertices; i++) {
                            for (int j = 0; j < numofvertices; j++) {
                                if (graph[i][j] == graph[j][i]) {
                                    graph[j][i] = 0;
                                }
                            }
                        }
                        draw_Undirected(graph, list0, list0.get(0), "Input of Undirected Graph", 750, 100, Color.MAGENTA , 0);
                    for (int i = 0; i < costReprestentation.length; i++) {
                        first = costReprestentation[i][0];
                        second = costReprestentation[i][1];
                        third = costReprestentation[i][2];
                        graph1[first][second] = third;
                        
                      if(step)
                      {
                          
                        if (counter <= 3) {
                            c++;
                            draw_Undirected(graph1, list0, list0.get(0), "Step" + (i + 1), (400 * counter), 0, Color.ORANGE , 1);
                        } else {
                            counter = 0;
                            draw_Undirected(graph1, list0, list0.get(0), "Step " + (i + 1), (400 * counter), (100 * (counter + c)), Color.ORANGE , 1);   
                        }
                        counter++;
                      }

                    }
                    if(!step)
                    {
                        draw_Undirected(graph1, list0, list0.get(0), "Output of Undirected Graph", 100, 100, Color.MAGENTA , 0);
                    }
                }
            }

        });

        btnGetMatrises.setBounds(50, 459, 127, 20);
        frame.getContentPane().add(btnGetMatrises);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 147, 250, 266);
        frame.getContentPane().add(scrollPane);
        iotext = new JTextArea();
        iotext.setFont(new Font("SansSerif", Font.BOLD, 14));
        scrollPane.setViewportView(iotext);

    }
}
