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
import java.util.ArrayList;

public class Graph {
	int [][] representOutput(ArrayList <Integer> list){
        int list1[] = new int[3];
        int counter=0;
        int out[][] = new int[(list.size()/3)][3] ;
        int j=0;
        for (int i=0;i<3;i++){
            list1[i]=0;
        }
        for (int i=0;i<=list.size();i++){
            
            if(counter==3){
                for(int x=0;x<3;x++){    
                    out[j][x]=list1[x];
                }
                counter=0;
                j++;
            }
            if(i!=list.size()){
            counter+=1;
            list1[counter-1]=list.get(i);
            }
        }
   return out;
  }
}