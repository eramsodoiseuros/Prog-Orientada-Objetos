import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.*;

import java.util.*;

public class Main {


    public static void main(String[] args)  {
        Controler c = new Controler();

        try {
                Viewer v =new Viewer();
                c.inicia();
                v.menu();
                System.out.println(v.getControler().getModel().getUserMap().toString());

        } catch (IOException | ClassNotFoundException | CloneNotSupportedException i) {
            i.printStackTrace();
        }

        //System.out.println(c.getModel().contaNCodEnc());
    }
}
