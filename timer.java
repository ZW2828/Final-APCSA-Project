import java.util.Timer;
import java.util.TimerTask;

public class timer extends gui{
    static Timer timer = new Timer();

    public static void addMoney() {
        //timer to update money earned
        TimerTask task;//initialize timer task
        task = new TimerTask() {
            @Override
            public void run() { 
                if (isOpen) {
                    money += (numberOfSlaves*1)+(numberOfChildren*5);
                    moneyD.setText("  Money: " + Integer.toString(money));//updates money label
                    //updates extra money per second
                    moneyPS.setText("Extra Money Per Second: " + ((numberOfSlaves*1)+(numberOfChildren*5)));
                } else {
                    cancel();//stops the timer
                }
            }
        };
        timer.schedule(task, 0, 1000);//task,delay,runtime
        //timer to update extra money per second shown
        TimerTask task2;
        task2 = new TimerTask() {
            @Override
            public void run() { 
                if (isOpen) {
                    //updates extra money per second
                    moneyPS.setText("Extra Money Per Second: " + ((numberOfSlaves*1)+(numberOfChildren*5)));
                } else {
                    cancel();//stops the timer
                }
            }
        };
        timer.schedule(task2, 0, 1);//task,delay,runtime
    }
}