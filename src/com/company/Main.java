package com.company;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.*;

import java.util.*;

public class Main {


    public static void main(String[] args)  {

       // Model m = new Model() ;
        Entidades e = new Entidades();
        Controler c = new Controler();

  /*     try {
         c.getModel().setTransMap(e.fileToTrans());
            c.getModel().setLojaMap(e.filetoLoja());
            c.getModel().setUserMap(e.fileToUser());
            c.getModel().setVolMap(e.fileToVol());
            c.getModel().setEncMap(e.fileToEnc());
            c.getModel().loadInventLoja();
            c.getModel().guardaEstado();

        } catch (IOException ex) {
            ex.printStackTrace();
        }*/




        try {
        Viewer v =new Viewer();




        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }

        //System.out.println(c.getModel().contaNCodEnc());


    }
}
