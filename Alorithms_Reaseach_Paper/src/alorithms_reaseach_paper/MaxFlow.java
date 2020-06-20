/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alorithms_reaseach_paper;

import java.awt.Color;
import java.util.ArrayList;



/**
 *
 * @author Nagla Essam
 */
public class MaxFlow {

    public static int[] colors;
    static ArrayList<Integer> path = new ArrayList<Integer>();
    static ArrayList<Integer> path1 = new ArrayList<Integer>();
    static ArrayList<Integer> path2 = new ArrayList<Integer>();

    /* Returns true if there is a path from source 's' to sink 
     't' in residual graph. Also fills parent[] to store the 
     path */
    // Returns tne maximum flow from s to t in the given graph 
    int fordFulkerson(int graph[][], int s, int t, int V, ArrayList<Integer> list0) {
        int u, v;

        // Create a residual graph and fill the residual graph 
        // with given capacities in the original graph as 
        // residual capacities in residual graph 
        // Residual graph where rGraph[i][j] indicates 
        // residual capacity of edge from i to j (if there 
        // is an edge. If rGraph[i][j] is 0, then there is 
        // not) 
        int rGraph[][] = new int[V][V];
        BFS object = new BFS();
        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }
        Color [] array={Color.ORANGE,Color.PINK,Color.white,Color.YELLOW,Color.lightGray,Color.GREEN,Color.MAGENTA}; 
        // This array is filled by BFS and to store path 
        int parent[] = new int[V];
        int max_flow = 0;  // There is no flow initially 
        int X = 0;
        // Augment the flow while tere is path from source 
        // to sink

        //GraphGui.drawRepresentation(rGraph, "output MaxFlow", list0, list0.get(0), 400*X, 100, Color.CYAN);
        while (object.bfs(rGraph, s, t, parent, V)) {

            
             // Find minimum residual capacity of the edhes 
             // along the path filled by BFS. Or we can say 
             // find the maximum flow through the path found. 
             
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {

                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);

            }
            GraphGui j = new GraphGui();
            j.colors = new int[V];
            for (int i = 0; i < V; i++) {
                j.colors[i] = 0;
            }
            // update residual capacities of the edges and 
            // reverse edges along the path 
            for (v = t; v != s; v = parent[v]) {

                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] = 0;
            }
            if(GraphGui.MaxFlow)
            {
                GraphGui.construct_graph1(graph,rGraph, "Step " + (X+1), list0, list0.get(0), 400 * X, 100,array[X%array.length],1);
                
                X++;
            }

            // Add path flow to overall flow 
            max_flow += path_flow;
        
        }
        return max_flow;
    }
    
}
