/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intherow.intherow;

import java.util.ArrayList;


/**
 *
 * @author Jusaa
 */
public class Piirtaja {
    private ArrayList<ArrayList<Integer>> lista;
    
    public Piirtaja(){
        uusiPeli();
        vuoronPiirto(7, "X");
        vuoronPiirto(7, "X");
        vuoronPiirto(7, "O");
        vuoronPiirto(7, "O");
        vuoronPiirto(7, "X");
        vuoronPiirto(7, "X");
        vuoronPiirto(3, "X");
        vuoronPiirto(3, "X");
        uusiPeli();
        vuoronPiirto(3, "O");
        vuoronPiirto(3, "O");
        vuoronPiirto(3, "X");
        vuoronPiirto(3, "X");
        vuoronPiirto(2, "O");
        vuoronPiirto(2, "X");
        vuoronPiirto(2, "X");
        vuoronPiirto(2, "O");
        vuoronPiirto(1, "O");
        vuoronPiirto(4, "X");
        vuoronPiirto(4, "X");
        vuoronPiirto(5, "O");
    }
    
    public void uusiPeli(){
        System.out.println(" -1- -2- -3- -4- -5- -6- -7- ");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println(" --- --- --- --- --- --- --- ");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println(" --- --- --- --- --- --- --- ");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println(" --- --- --- --- --- --- --- ");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println(" --- --- --- --- --- --- --- ");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println(" --- --- --- --- --- --- --- ");
        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println(" --- --- --- --- --- --- --- ");
        
        lista = new ArrayList<>();
        ArrayList<Integer> sisaLista = new ArrayList<>();
        for(int i=7;i>0;i--){
            sisaLista = new ArrayList<>();
            for(int ii=6;ii>0;ii--){
                sisaLista.add(0);
            }
            lista.add(sisaLista);
        }
    }
    
    public void vuoronPiirto(int pylvas, String merkki){
        for(int i=5 ; i>=-1; i--){
            if(i == -1 || lista.get(pylvas-1).get(i) != 0){
                if(merkki.equals("X")){
                    lista.get(pylvas-1).set(i+1, 1);
                }else if(merkki.equals("O")){
                    lista.get(pylvas-1).set(i+1, 2);
                }
                break;
            }
        }
        System.out.println("\n\n -1- -2- -3- -4- -5- -6- -7- ");
        int numero = 0;
        int nro = 10;
        for(int ii=0;ii<7;ii++){
            for(int i=0;i<6;i++){
                if(lista.get(ii).get(i) == 0){
                    numero++;
                }
            }
            if(nro > numero){
                nro = numero;
            }
            numero = 0;
        }    
        
        for(int i=nro;i>0;i--){
            System.out.println("|   |   |   |   |   |   |   |");
            System.out.println(" --- --- --- --- --- --- --- ");
        }
        nro = 6-nro;
        for(int i=nro;i>0;i--){
            for(int ii=0;ii<7;ii++){
                if(lista.get(ii).get(nro-1) == 0){
                    System.out.print("|   ");
                }else if(lista.get(ii).get(nro-1) == 1){
                    System.out.print("| X ");
                }else{
                    System.out.print("| O ");
                }
            }
            nro--;
            System.out.println("|\n --- --- --- --- --- --- --- ");
        }
    }
}
