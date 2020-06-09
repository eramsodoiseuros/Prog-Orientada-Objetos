import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.*;

import java.util.*;

public class Main {


    public static void main(String[] args)  {

        Entidades e = new Entidades();
        Controler c = new Controler();

        try {
            Viewer v = new Viewer();
            v.inicia();
            v.menu();

        } catch (IOException | ClassNotFoundException | CloneNotSupportedException i) {
            i.printStackTrace();
        }

        //System.out.println(c.getModel().contaNCodEnc());
    }
}
