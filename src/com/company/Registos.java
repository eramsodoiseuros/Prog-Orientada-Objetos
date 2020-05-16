package com.company;

import java.io.*;
import java.util.*;
import java.util.prefs.Preferences;

public class Registos {

    private TreeSet<String> logIn_trans;
    private TreeSet<String> logIn_vol;
    private TreeSet<String>logIn_loja;
    private TreeSet<String> logIn_user;



    public Registos(){
        this.logIn_loja = new TreeSet<>();
        this.logIn_trans = new TreeSet<String>();
        this.logIn_user = new TreeSet<String>();
        this.logIn_vol = new TreeSet<String>();

    }


    public TreeSet<String> getLogIn_loja() {
        return logIn_loja;
    }

    public TreeSet<String> getLogIn_trans() {
        return logIn_trans;
    }

    public TreeSet<String> getLogIn_user() {
        return logIn_user;
    }

    public TreeSet<String> getLogIn_vol() {
        return logIn_vol;
    }

    public void setLogIn_loja(TreeSet<String> logIn_loja) {
        this.logIn_loja = logIn_loja;
    }

    public void setLogIn_trans(TreeSet<String> logIn_trans) {
        this.logIn_trans = logIn_trans;
    }

    public void setLogIn_user(TreeSet<String> logIn_user) {
        this.logIn_user = logIn_user;
    }

    public void setLogIn_vol(TreeSet<String> logIn_vol) {
        this.logIn_vol = logIn_vol;
    }


    public void registaTransportadora() {

        String v;
        String p;
        String e;
        Scanner scanner = new Scanner(System.in);
        File file = new File("Transportadoras_Credenciais.txt");

        System.out.println("Insira o Email:\n");
        e = scanner.nextLine();
        v = e;
        System.out.println("Insira a Password:\n");
        p = scanner.nextLine();
        v = v + "=" + p + "\n";


        if (logIn_trans.contains(v))
            System.out.println("Password ou email ja existentes. Tente novamente.");
        else logIn_trans.add(v);


        try {
            FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
            myWriter.write(v);
            myWriter.close();
            System.out.println("Registo efetuado");
        } catch (IOException i) {
            System.out.println("Ocorreu um erro");
            i.printStackTrace();
        }

    }


    public void dadosTransportadora (int i){

        String s;
        String v;

        Scanner scanner = new Scanner(System.in);
        File file = new File("Transportadoras.txt");

        String cod = "t" + i + ", ";
        System.out.println("Insira o nome:\n");
        s = scanner.nextLine();
        v = cod + s;

        System.out.println("Insira o NIF da empresa:\n");
        s = scanner.nextLine();
        v = v + ", " + s;


        System.out.println("Insira o raio de ação:\n");
        s = scanner.nextLine();
        v = v + ", " + s;


        System.out.println("Insira o preço por km:\n");
        s = scanner.nextLine();
        v = v + ", " + s + "\n";

        try {
            FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
            myWriter.write(v);
            myWriter.close();
            System.out.println("Registo efetuado");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }



    }


    public void registaVoluntario() {

        String v;
        String p;
        String e;
        Scanner scanner = new Scanner(System.in);
        File file = new File("Voluntarios_Credenciais.txt");

        System.out.println("Insira o Email:\n");
        e = scanner.nextLine();
        v = e;
        System.out.println("Insira a Password:\n");
        p = scanner.nextLine();
        v = v + "=" + p + "\n";


        if (logIn_vol.contains(v))
            System.out.println("Password ou email ja existentes. Tente novamente.");
        else logIn_vol.add(v);


        try {
            FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
            myWriter.write(v);
            myWriter.close();
            System.out.println("Registo efetuado");
        } catch (IOException i) {
            System.out.println("Ocorreu um erro");
            i.printStackTrace();
        }

    }

    public void dadosVoluntarios(int i){

        String s;
        String v;

        Scanner scanner = new Scanner(System.in);
        File file = new File("Voluntarios.txt");
        String cod = "v" + i + ", ";
        System.out.println("Insira o nome:\n");
        s = scanner.nextLine();
        v = cod + s;

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


    public void registaLoja() {

        String v;
        String p;
        String e;
        Scanner scanner = new Scanner(System.in);
        File file = new File("Lojas_Credenciais.txt");

        System.out.println("Insira o Email:\n");
        e = scanner.nextLine();
        v = e;
        System.out.println("Insira a Password:\n");
        p = scanner.nextLine();
        v = v + "=" + p + "\n";


        if (logIn_loja.contains(v))
            System.out.println("Password ou email ja existentes. Tente novamente.");
        else logIn_loja.add(v);


        try {
            FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
            myWriter.write(v);
            myWriter.close();
            System.out.println("Registo efetuado");
        } catch (IOException i) {
            System.out.println("Ocorreu um erro");
            i.printStackTrace();
        }

    }

    public void dadosLojas (int i){

        String v;
        String s;

        Scanner scanner = new Scanner(System.in);
        File file = new File("Lojas.txt");

        String cod = "l" + i + ", ";

        System.out.println("Insira o nome:\n");
        s = scanner.nextLine();
        v = cod + s;

        System.out.println("Insira os produtos disponiveis:\n");
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


    public void registaUtilizador(){

        String v;
        String p;
        String e;
        Scanner scanner = new Scanner(System.in);
        File file = new File("Utilizador_Credenciais.txt");

        System.out.println("Insira o Email:\n");
        e = scanner.nextLine();
        v = e;
        System.out.println("Insira a Password:\n");
        p = scanner.nextLine();
        v = v + "=" + p + "\n";


        if (logIn_user.contains(v))
            System.out.println("Password ou email ja existentes. Tente novamente.");
        else logIn_user.add(v);


        try {
            FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
            myWriter.write(v);
            myWriter.close();
            System.out.println("Registo efetuado");
        } catch (IOException i) {
            System.out.println("Ocorreu um erro");
            i.printStackTrace();
        }

    }

    public void dadosUtilizador(int i){

        String v;
        String s;

        Scanner scanner = new Scanner(System.in);
        File file = new File("Utilizador.txt");

        String cod = "u" + i + ", ";
        System.out.println("Insira o nome:\n");
        s = scanner.nextLine();
        v = cod + s;

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

    public HashMap<String,Object>  fileToMap (File file1, File file2)
    {

        HashMap<String, Object> map = new HashMap<>();

        String line = "Erro";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true)
        {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] parts = line.split(",", 2);
            if (parts.length >= 2)
            {
                String key = parts[1];
                String value = parts[0];
                map.put(key, value);
            } else {
                System.out.println(line);
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return map;

    }

    public TreeSet<String>  fileToSet (File file)
    {

        TreeSet<String> set = new TreeSet<>();

        String line = "Erro";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true)
        {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            set.add(line);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;

    }

    
    public String verificaCredenciais (TreeSet<String> set) {

        String e;
        String p;
        String s;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Email:");
        e = scanner.nextLine();

        System.out.println("Password:");
        p = scanner.nextLine();
        s = e + "=" + p;
        if(set.contains(s)) {
            System.out.println("Log In bem sucedido");
            }

        else{
            System.out.println("Credenciais erradas");

        }
        return e;
    }


    private static File fileUser = new File("Utilizador_Credenciais.txt");
    private static File fileTrans = new File("Transportadoras_Credenciais.txt");
    private static File fileLoja = new File("Lojas_Credenciais.txt");
    private static File fileVol = new File("Voluntarios_Credenciais.txt");

    public static File getFileLoja() {
        return fileLoja;
    }

    public static File getFileTrans() {
        return fileTrans;
    }

    public static File getFileUser() {
        return fileUser;
    }

    public static File getFileVol() {
        return fileVol;
    }

    public void loadRegistos(){
        this.logIn_user = fileToSet( fileUser);
        this.logIn_trans = fileToSet( fileTrans);
        this.logIn_loja = fileToSet(fileLoja);
        this.logIn_vol = fileToSet(fileVol);

    }


    public  int[] contaNCod (File file) {

        BufferedReader reader = null;
        int [] array = new int[4];
        int u = 0,t = 0,v = 0,l = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "Erro";
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(line.startsWith("u")) u++;
            if (line.startsWith("v")) v++;
            if (line.startsWith("t")) t++;
            if (line.startsWith("l")) l++;

            array[0]=u;
            array[1] = t;
            array[2] = v;
            array[3]= l;

        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }


    public void registaTudo (int n, int i){


        String v;
        String s;

        Scanner scanner = new Scanner(System.in);
        File file = new File("logs.txt");

        switch (n){
            case 1:
                String codU = "u" + i + ", ";
                System.out.println("Insira o nome:\n");
                s = scanner.nextLine();
                v = codU + s + "\n";


                try {
                    FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
                    myWriter.write(v);
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                break;
            case 2:
                String codV = "v" + i + ", ";
                System.out.println("Insira o nome:\n");
                s = scanner.nextLine();
                v = codV + s;

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
                break;
            case 3:
                String codT = "t" + i + ", ";
                System.out.println("Insira o nome:\n");
                s = scanner.nextLine();
                v = codT + s;

                System.out.println("Insira o NIF da empresa:\n");
                s = scanner.nextLine();
                v = v + ", " + s;


                System.out.println("Insira o raio de ação:\n");
                s = scanner.nextLine();
                v = v + ", " + s;


                System.out.println("Insira o preço por km:\n");
                s = scanner.nextLine();
                v = v + ", " + s + "\n";

                try {
                    FileWriter myWriter = new FileWriter(file.getAbsoluteFile(), true);
                    myWriter.write(v);
                    myWriter.close();
                    System.out.println("Registo efetuado");
                } catch (IOException e) {
                    System.out.println("Ocorreu um erro");
                    e.printStackTrace();
                }
                break;

            case 4:
                String codL = "l" + i + ", ";

                System.out.println("Insira o nome:\n");
                s = scanner.nextLine();
                v = codL + s;

                System.out.println("Insira os produtos disponiveis:\n");
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
                break;


        }



    }

}
