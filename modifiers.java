
/**
 * Write a description of class modifiers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;//import JOptionPane to use pop up messages
import java.util.Timer;
import java.util.TimerTask;
public class modifiers extends gui
{
    public static void modifier(int m,int p, String type){
        if (money-p<0){//if not enough money to buy, pop up message
            JOptionPane.showMessageDialog(frame, "You don't have enough money!");
        }
        else{
            if(type.equals("s")){//checking if it is a slave
                numberOfSlaves++;//increase # of slaves
                numSlaves.setText("Slaves Owned: " + Integer.toString(numberOfSlaves));//update # of slaves display
            }
            else if(type.equals("c")){//checking if it is a child
                numberOfChildren++;//increase # of children
                numChilds.setText("Children Owned: " + Integer.toString(numberOfChildren));//update # of children display
            }
            money -= p;//subract price from money, ie buying the modifier
            moneyD.setText("  Money: " + Integer.toString(money));//update how much money user has display
        }
    }
}
