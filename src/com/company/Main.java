package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {


    static void registaVoluntario(){

        String s;
        String v;
        Scanner scanner = new Scanner(System.in);
        File file = new File("Voluntarios.txt");

        System.out.println("Insira o nome:\n");
        s = scanner.nextLine();
        v = s;

        System.out.println("Insira o seu raio de ação:\n");
        s = scanner.nextLine();
        v = v + ", " + s + "\n";

        try {
            FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
            myWriter.write(v);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }


    static void registaTransportadora(){

        String s;
        String v;
        Scanner scanner = new Scanner(System.in);
        File file = new File("Transportadoras.txt");

        System.out.println("Insira o nome:\n");
        s = scanner.nextLine();
        v = s;

        System.out.println("Insira o preço por km:\n");
        s = scanner.nextLine();
        v = v + ", " + s;

        System.out.println("Insira o seu raio de ação:\n");
        s = scanner.nextLine();
        v = v + ", " + s + "\n";

        try {
            FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
            myWriter.write(v);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }

    public static void main(String[] args) {
        // write your code here

        File file = new File("C:\\Users\\ramg2\\Documents\\GitHub\\POO\\teste.txt");
        Voluntario v1 = new Voluntario();
/*
        try {
        String st;
        BufferedReader br = new BufferedReader(new FileReader(file));

           while ((st = br.readLine())!= null)
                //System.out.println(st);
                if(st.startsWith("Voluntario:")){
                    String[] v = st.split(",");
                    v1.setId(v[0]);
                    v1.setNome(v[1]);
                    v1.setRange(Double.parseDouble(v[4]));

                }

        }
        catch (IOException ex) {
            ex.printStackTrace();
            //System.out.println("sdjnakhsjdk");
        }

        System.out.println(v1.toString());
    */
        //registaVoluntario();
        registaTransportadora();
    }
}
