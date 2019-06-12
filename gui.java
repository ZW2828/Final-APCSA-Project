
/**
 * Write a description of class gui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class gui
{   
    public static int money = 0;//initialize money
    public static int numberOfSlaves = 0;//initialize numberOfSlaves
    public static int numberOfChildren = 0;//initialize numberOfChildren
    public static JFrame frame = new JFrame("gui");//creates JFrame named gui
    public static JLabel moneyD = new JLabel("  Money: 0");//initialize JLabel to display money
    public static JLabel numSlaves = new JLabel("Slaves Owned: 0");//initialize JLabel for slaves
    public static JLabel numChilds = new JLabel("Children Owned: 0");//initialize JLabel for children
    public static JLabel moneyPS = new JLabel("Extra Money Per Second: 0");//initialize JLabel to display money per second
    public static boolean isOpen = true;//initialize boolean isOpen to check if game is running
    public void guiSetUp(){
        //Labels
        JLabel infoS = new JLabel("  Price: 5");
        JLabel infoS2 = new JLabel("Money: 1");
        JLabel infoC = new JLabel("  Price: 10");
        JLabel infoC2 = new JLabel("Money: 5");
        
        //Frame
        frame.setSize(1000,500);//set size of frame:width,height
        frame.setLayout(null);//no layout managers
        frame.setVisible(true);//visible frame
        Color fBackground = new Color(255,255,255);//make new color
        frame.getContentPane().setBackground(fBackground);//set background color of frame
        
        //Button to get money
        JButton button = new JButton("get");//create money button
        button.setBounds(225,225,50,50);//x,y,width,height
        frame.add(button);//adds button to frame
        button.addActionListener(new ActionListener(){//adding action on button click
            @Override
            public void actionPerformed(ActionEvent e){
                money++;//increases money by 1
                moneyD.setText("  Money: " + Integer.toString(money));//updates money label
            }
        });
        
        //Button to buy slaves
        JButton slaves = new JButton("buy slave");//create buy slave button
        slaves.addActionListener(new ActionListener(){//adding action on button click
            @Override
            public void actionPerformed(ActionEvent e){
                modifiers.modifier(1,5,"s");//"s" for slave, 1 is money per second, 5 is price
            }
        });
        
        //Button to buy slaves
        JButton childs = new JButton("buy child");//create buy child button
        childs.addActionListener(new ActionListener(){//adding action on button click
            @Override
            public void actionPerformed(ActionEvent e){
                modifiers.modifier(5,10,"c");//"c" for slave, 5 is money per second, 10 is price
            }
        });
        
        //Panel to buy modifiers and display money, number of each modifier, price of each modifier, and money per second
        JPanel panel = new JPanel(new GridBagLayout(), true);//new JPanel with Grid Bag layout
        panel.setBounds(450,25,450,450);//x,y,width,height
        panel.setOpaque(false);//transparent background
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));//black border

        GridBagConstraints con = new GridBagConstraints();//initializes con to use for constraints on the layout
        con.anchor = GridBagConstraints.LINE_START;//makes content in each grid start on the line
        con.insets = new Insets(15,0,15,15);//creates margins between the cells that use con: top,left,bottom,right
        GridBagConstraints con2 = new GridBagConstraints();//initializes con2 for different constraints for other cells
        con2.anchor = GridBagConstraints.LINE_START;//makes content in each grid start on the line
        con2.insets = new Insets(-30,0,10,15);//different margins for specific cells: top,left,bottom,right
        
        con.gridx = 0;//selects 1st column
        con.gridy = 0;//selects 1st row
        panel.add(moneyD,con);//money displayed in [0,0]
        
        con2.gridx = 0;
        con2.gridy = 1;
        panel.add(infoS,con2);//adds slave price to a second grid that overlaps the first
        
        con.gridy = 1;//changes to 2nd row
        panel.add(slaves,con);//buy slaves button in [0,1]
        
        con2.gridx = 0;
        con2.gridy = 2;
        panel.add(infoC,con2);//adds child price to second gird
        
        con.gridy = 2;//changes to 3rd row
        panel.add(childs,con);//buy child button in [0,2]
        
        con2.gridx = 1;
        con2.gridy = 2;
        panel.add(infoC2,con2);//adds child money earned to a second grid
        
        con.gridx = 1;//changes to 2nd column
        panel.add(numChilds, con);//number of children displayed in [1,2]
        
        con2.gridx = 1;
        con2.gridy = 1;
        panel.add(infoS2,con2);//adds slave money earned to a second grid
        
        con.gridy = 1;//changes to 2nd row
        panel.add(numSlaves, con);//number of slaves displayed in [1,1]
        
        con.gridy = 0;//changes to 1st row
        panel.add(moneyPS, con);//money per second displayed in [1,0]

        frame.add(panel);//add panel to frame
        
        frame.setLocationRelativeTo(null);//centers frame in the middle of the screen
        panel.setVisible(true);//makes panel visible
        frame.setVisible(true);//makes frame visible
        frame.repaint();//repaints frame to make sure everything in the frame shows
        frame.addWindowListener(new java.awt.event.WindowAdapter(){//sets isOpen to false when close button is clicked
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                isOpen = false;
            }
        });
        timer.addMoney();//run addMoney() in timer class
    }
}
