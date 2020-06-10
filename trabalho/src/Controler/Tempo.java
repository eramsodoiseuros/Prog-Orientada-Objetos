package Controler;

import java.time.*;
import java.util.Timer;
import java.util.TimerTask;

public class Tempo  {
    int segundos;
    LocalDateTime agora;

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            segundos +=60;
            agora.plusSeconds(segundos);
        }
    };
}

