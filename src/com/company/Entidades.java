package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Entidades {

    private HashMap<String,Transportadora> dadosTrans;
    private HashMap<String,Utilizador> dadosUser;
    private HashMap<String,Voluntario> dadosVol;
    private HashMap<String,Loja> dadosLoja;


    public Entidades (){
        this.dadosLoja = new HashMap<>();
        this.dadosTrans = new HashMap<>();
        this.dadosUser = new HashMap<>();
        this.dadosVol = new HashMap<>();
    }

    public HashMap<String, Voluntario> getDadosVol() {
        return dadosVol;
    }

    public HashMap<String, Utilizador> getDadosUser() {
        return dadosUser;
    }

    public HashMap<String,Transportadora> getDadosTrans() {
        return dadosTrans;
    }

    public HashMap<String,Loja>  getDadosLoja() {
        return dadosLoja;
    }


    public HashMap<String,Voluntario> fileToVol () {

        String line = "Erro";
        String line2 = "Erro";
        int count = 0;
        BufferedReader reader = null;
        BufferedReader reader2 = null;

        try {
            reader = new BufferedReader(new FileReader("logs.txt"));
            reader2 = new BufferedReader(new FileReader("Voluntarios_Credenciais.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!((line2 = reader2.readLine()) != null)) break;
            } catch (IOException o) {
                o.printStackTrace();
            }
            count++;

            while (!line.startsWith("v"+count) && reader!=null) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException o) {
                    o.printStackTrace();
                }

            }

            String[] parts = line.split(",", 3);
            String[] parts2 = line2.split("=", 2);

            Voluntario voluntario = new Voluntario();

            voluntario.setId(parts[0]);
            voluntario.setNome(parts[1]);
            voluntario.setRange(Double.parseDouble(parts[2]));


            dadosVol.putIfAbsent(parts2[0], voluntario);

        }

        try {
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dadosVol;
    }

    public HashMap<String, Utilizador> fileToUser () {

        String line = "Erro";
        String line2 = "Erro";
        int count = 0;
        BufferedReader reader = null;
        BufferedReader reader2 = null;

        try {
            reader = new BufferedReader(new FileReader("logs.txt"));
            reader2 = new BufferedReader(new FileReader("Utilizador_Credenciais.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!((line2 = reader2.readLine()) != null)) break;
            } catch (IOException o) {
                o.printStackTrace();
            }
            count++;

            while (!line.startsWith("u"+count) && reader!=null) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException o) {
                    o.printStackTrace();
                }

            }

            String[] parts = line.split(",", 3);
            String[] parts2 = line2.split("=", 2);

            Utilizador utilizador = new Utilizador();

            utilizador.setId(parts[0]);
            utilizador.setNome(parts[1]);


            dadosUser.putIfAbsent(parts2[0], utilizador);

        }

        try {
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dadosUser;
    }

    public HashMap<String,Transportadora> fileToTrans () {

        String line = "Erro";
        String line2 = "Erro";
        int count = 0;
        BufferedReader reader = null;
        BufferedReader reader2 = null;

        try {
            reader = new BufferedReader(new FileReader("logs.txt"));
            reader2 = new BufferedReader(new FileReader("Transportadoras_Credenciais.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!((line2 = reader2.readLine()) != null)) break;
            } catch (IOException o) {
                o.printStackTrace();
            }
            count++;

            while (!line.startsWith("t"+count) && reader!=null) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException o) {
                    o.printStackTrace();
                }

            }

            String[] parts = line.split(",", 7);
            String[] parts2 = line2.split("=", 2);

            Transportadora transportadora = new Transportadora();

            transportadora.setId(parts[0]);
            transportadora.setNome(parts[1]);
            transportadora.setNif(parts[2]);
            transportadora.setRange(Double.parseDouble(parts[3]));
            transportadora.setPreco_transporte(Double.parseDouble(parts[4]));


            dadosTrans.putIfAbsent(parts2[0], transportadora);

        }

        try {
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dadosTrans;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entidades entidades = (Entidades) o;
        return Objects.equals(dadosTrans, entidades.dadosTrans) &&
                Objects.equals(dadosUser, entidades.dadosUser) &&
                Objects.equals(dadosVol, entidades.dadosVol) &&
                Objects.equals(dadosLoja, entidades.dadosLoja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dadosTrans, dadosUser, dadosVol, dadosLoja);
    }




    public HashMap<String, Loja> filetoLoja () {

        String line = "Erro";
        String line2 = "Erro";
        int count = 0;
        BufferedReader reader = null;
        BufferedReader reader2 = null;

        try {
            reader = new BufferedReader(new FileReader("logs.txt"));
            reader2 = new BufferedReader(new FileReader("Lojas_Credenciais.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!((line2 = reader2.readLine()) != null)) break;
            } catch (IOException o) {
                o.printStackTrace();
            }
            count++;

            while (!line.startsWith("l"+count) && reader!=null) {
                try {
                    if (!((line = reader.readLine()) != null)) break;
                } catch (IOException o) {
                    o.printStackTrace();
                }

            }

            String[] parts = line.split(",", 3);
            String[] parts2 = line2.split("=", 2);

            Loja loja = new Loja();

            loja.setId(parts[0]);
            loja.setNome(parts[1]);


            dadosLoja.putIfAbsent(parts2[0], loja);

        }

        try {
            reader2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dadosLoja;
    }

}
