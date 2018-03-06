import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/** @author Mahaikel Zimmerahmam
    @author Olwiwa Bahrand
    @author Amir Houssaini
*/

public class TicTacToe extends JFrame implements ActionListener {
    
    JFrame appFrame;
    JPanel appPanel;
    
    JPanel topLeftPanel;
    JPanel topCenterPanel;
    JPanel topRightPanel;
    
    JPanel middleLeftPanel;
    JPanel middleCenterPanel;
    JPanel middleRightPanel;
    
    JPanel bottomLeftPanel;
    JPanel bottomCenterPanel;
    JPanel bottomRightPanel;

    
    public TicTacToe(){
        // Frame wird erstellt
        appFrame = new JFrame("Tic Tac Toe");
        
        appFrame.setLayout(new GridLayout(3,3));

        // innere Panels werden generier
        topLeftPanel = new JPanel();
        topCenterPanel = new JPanel();
        topRightPanel = new JPanel();
    
        middleLeftPanel = new JPanel();
        middleCenterPanel = new JPanel();
        middleRightPanel = new JPanel();
    
        bottomLeftPanel = new JPanel();
        bottomCenterPanel = new JPanel();
        bottomRightPanel = new JPanel();
        
        // Panels werden dem umfassenden Panel hinzugefügt
        appFrame.add(topLeftPanel);
        appFrame.add(topCenterPanel);
        appFrame.add(topRightPanel);
        appFrame.add(middleLeftPanel);
        appFrame.add(middleCenterPanel);
        appFrame.add(middleRightPanel);
        appFrame.add(bottomLeftPanel);
        appFrame.add(bottomCenterPanel);
        appFrame.add(bottomRightPanel);
        
        topLeftPanel.setBackground(Color.RED);
        topCenterPanel.setBackground(Color.BLUE);
        topRightPanel.setBackground(Color.GREEN);
        
        // Frame wird in den Vollbildmodus gesetzt
        appFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        
        // Frames und Panel werden sichtbar gemacht
        topLeftPanel.setVisible(true);
        topCenterPanel.setVisible(true);
        topRightPanel.setVisible(true);
    
        middleLeftPanel.setVisible(true);
        middleCenterPanel.setVisible(true);
        middleRightPanel.setVisible(true);
    
        bottomLeftPanel.setVisible(true);
        bottomCenterPanel.setVisible(true);
        bottomRightPanel.setVisible(true);
        
        appFrame.setVisible(true);
        
        
    }
    
    public void actionPerformed (ActionEvent ae){
        
        
         
    }
    
}
