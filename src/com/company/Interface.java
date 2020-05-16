package com.company;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.System.console;
import static java.lang.System.exit;

public class Interface {

    public Interface(){

        int escolha, entidade;
        Registos registos = new Registos();
        Entidades entidades = new Entidades();
        String p;

        Scanner scanner = new Scanner(System.in);
        TreeSet<String> set;

        File file;



        System.out.println("Selecione uma opção:\n");

        System.out.println("1. Registar\n");
        System.out.println("2. Log In\n");
        System.out.println("0. Sair\n");

        escolha = scanner.nextInt();
        while (escolha!=0) {
          switch (escolha) {
               case 1:
                   System.out.println("Selecione a entidade que quer registar:\n");

                    System.out.println("1. Utilizador\n");
                    System.out.println("2. Transportadora\n");
                    System.out.println("3. Voluntario\n");
                    System.out.println("4. Loja\n");
                    System.out.println("0. Sair\n");

                    entidade = scanner.nextInt();

                        switch (entidade) {
                            case 1:
                                registos.registaUtilizador();
                                int i =registos.contaNCod(new File("logs.txt"))[0]+1;
                                registos.registaTudo(1,i);
                                break;
                            case 2:
                               registos.registaTransportadora();
                                int a =registos.contaNCod(new File("logs.txt"))[1]+1;
                                registos.registaTudo(3,a);
                                break;
                            case 3:
                                registos.registaVoluntario();
                                int b =registos.contaNCod(new File("logs.txt"))[2]+1;
                                registos.registaTudo(2,b);
                                break;
                            case 4:
                                registos.registaLoja();
                                int c =registos.contaNCod(new File("logs.txt"))[3]+1;
                                registos.registaTudo(4,c);
                                break;
                            case 0:
                                exit(0);
                                break;
                        }

                    break;
                case 2:
                    System.out.println("Selecione a sua entidade:\n");


                    System.out.println("1. Utilizador\n");
                    System.out.println("2. Transportadora\n");
                    System.out.println("3. Voluntario\n");
                    System.out.println("4. Loja\n");
                    System.out.println("0. Sair\n");

                    entidade = scanner.nextInt();

                    switch (entidade) {
                        case 1:
                            file = new File("Utilizador_Credenciais.txt");
                            set = registos.fileToSet(file);
                            p = registos.verificaCredenciais(set);
                            entidades.fileToUser();
                            System.out.println(entidades.fileToUser().get(p));
                            break;
                        case 2:
                            file = new File("Transportadoras_Credenciais.txt");
                            set = registos.fileToSet(file);
                            p = registos.verificaCredenciais(set);
                            entidades.fileToTrans();
                            System.out.println(entidades.fileToTrans().get(p));
                            break;
                        case 3:
                            file = new File("Voluntarios_Credenciais.txt");
                            set = registos.fileToSet(file);
                            p = registos.verificaCredenciais(set);
                            entidades.fileToVol();
                            System.out.println(entidades.fileToVol().get(p));
                            break;
                        case 4:
                            file = new File("Lojas_Credenciais.txt");
                            set = registos.fileToSet(file);
                            p = registos.verificaCredenciais(set);
                            entidades.filetoLoja();
                            System.out.println(entidades.filetoLoja().get(p));
                            break;
                        case 0:
                            exit(0);
                            break;

                                    }
                    break;
                                }
                             }
                    }




    }

