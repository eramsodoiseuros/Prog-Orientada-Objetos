package com.company;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        HashMap<String, Loja> vol = new HashMap<>();
        Registos registos = new Registos();
        //Voluntario vol = new Voluntario();
        new Interface();
        //registos.registaLoja();
       // registos.registaTransportadora();
        //map = registos.getLogIn_trans();
       // map = registos.FileToMap("Transportadoras_Credenciais.txt");
      //  set = registos.FileToSet("Transportadoras_Credenciais.txt");
       // registos.loadRegistos();
       Entidades e = new Entidades();
      // vol = e.fileToLoja();
      // System.out.println(vol);
      }
}
