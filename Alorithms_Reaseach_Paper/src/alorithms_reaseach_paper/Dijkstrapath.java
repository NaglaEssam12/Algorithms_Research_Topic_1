/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alorithms_reaseach_paper;


import java.util.ArrayList;



/**
 *
 * @author Nagla Essam
 */
public class Dijkstrapath {
    static ArrayList<Integer> path = new ArrayList<Integer>();  
    static ArrayList<Integer> list = new ArrayList<Integer>(); 
    int minDistance(int dist[], Boolean sptSet[],int V) 
    { 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < V; v++){
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
        }
        return min_index; 
    } 
 
   
     GraphGui gui = new GraphGui();
     
    ArrayList <Integer> dijkstra(int graph[][], int src,int V) 
    { 
        list.clear();
        path.clear();
        int num =0;
        int dist[] = new int[V]; 
        
        // the shortest distance from src to i 
        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[V]; 
  
        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < V; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false;   
        } 
        // Distance of source vertex from itself is always 0 
        dist[src] = 0; 
        
        // Find shortest path for all vertices 
        for (int count = 0; count < V - 1; count++) { 
            // Pick the minimum distance vertex from the set of vertices 
            
            int u = minDistance(dist, sptSet,V); 
            sptSet[u] = true; 
           
            for (int v = 0; v < V; v++) {
                num=0;
                
                if (!sptSet[v] && graph[u][v] != 0 &&  
                   dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){ 
                    if(dist[v]!=Integer.MAX_VALUE){
                        num = path.indexOf(v);
                        path.remove(num+1);
                        path.remove(Integer.valueOf(v));
                        path.remove(num-1);
                        list.remove(num+1);
                        list.remove(num);
                        list.remove(num-1);
                    }
                    
                    dist[v] = dist[u] + graph[u][v]; 
                  
                    path.add(u);
                    path.add(v);
                    path.add(10000000);
                    list.add(u);
                    list.add(v);
                    list.add(graph[u][v]);
                }
                
            }
               
        } 
        return list;
    } 
  
   
}
