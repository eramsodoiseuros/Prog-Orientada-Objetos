package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registos {

    void regista (){

        String s;
        String v;
        Scanner scanner = new Scanner(System.in);
        File file = new File("Registos.txt");

        int r =0;

        System.out.println("Selecione a opção de registo\n");

        System.out.println("1. Utilizador\n");
        System.out.println("2. Voluntario\n");
        System.out.println("3. Transportadora\n");
        System.out.println("4. Loja\n");

        r = scanner.nextInt();

        System.out.println("Insira o nome:\n");
        s = scanner.nextLine();
        v = s;

        System.out.println("Insira o seu raio de ação:\n");
        s = scanner.nextLine();
        v = v + ", " + s;

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




}
