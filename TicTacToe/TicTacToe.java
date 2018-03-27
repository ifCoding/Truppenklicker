import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants; 

import java.awt.Dimension;

import java.io.File;

/** @author Mahaikel Zimmerahmam
    @author Olwiwa Bahrand
    @author Amir Houssaini
*/

public class TicTacToe extends JFrame implements MouseListener, ActionListener {
    // Frame wird deklariert
    JFrame appFrame;
    
    // Frame-Icon wird ermittelt und gespeichert
    ImageIcon frameIcon= new ImageIcon("icon.png");
    
    // umfassendes Panel wird deklariert
    JPanel appPanel;
    
    // inneren Panels (Felder des TicTacToe) werden deklariert
    // außerdem werden Booleans erstellt die ausgeben ob das Feld bereits belegt ist
    JPanel topLeftPanel;
    boolean topLeftFull = false;
    
    JPanel topCenterPanel;
    boolean topCenterFull = false;
    
    JPanel topRightPanel;
    boolean topRightFull = false;
    
    JPanel middleLeftPanel;
    boolean middleLeftFull = false;
    
    JPanel middleCenterPanel;
    boolean middleCenterFull = false;
    
    JPanel middleRightPanel;
    boolean middleRightFull = false;
    
    JPanel bottomLeftPanel;
    boolean bottomLeftFull = false;
    
    JPanel bottomCenterPanel;
    boolean bottomCenterFull = false;
    
    JPanel bottomRightPanel;
    boolean bottomRightFull = false;
    
    // die Labels in denen nachher das X oder das O steht werden deklariert
    JLabel topLeftLabel;
    JLabel topCenterLabel;
    JLabel topRightLabel;
    
    JLabel middleLeftLabel;
    JLabel middleCenterLabel;
    JLabel middleRightLabel;
    
    JLabel bottomLeftLabel;
    JLabel bottomCenterLabel;
    JLabel bottomRightLabel;
    
    // Menu-Bar, Dropdown und Menu-Items werden deklariert
    JMenuBar appMenuBar;
    JMenu appMenu;
    JMenuItem menuNewGame, menuReset;
    
    // ein String wird deklariert, der bestimmt ob X oder O dran ist
    public String whosTurn = "X";
    
    // 2D-Array der die Belegungen der Felder speichert
    public String filledBox[][] = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    
    // Bildschirmgröße wird abgefragt
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public int devHeight = screenSize.height;
    public int devWidth = screenSize.width;
    
    // Spielstanddatei wird deklariert
    File saveGame = null;
    
    // Anzahl an Siegen von X und O
    int xWon = 0;
    int oWon = 0;
    
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
    }
    
    public TicTacToe(){
        // Frame wird erstellt
        appFrame = new JFrame("Tic Tac Toe");
        appFrame.setIconImage(frameIcon.getImage());
        appFrame.pack();
        
        // Frame Layout wird gewählt
        appFrame.setLayout(new GridLayout(3,3));
        
        // Frame wird in die Mitte des Bildschirms gesetzt
        appFrame.setSize(600, 600);
        appFrame.setLocation(devWidth/3, devHeight/4);
        
        // Menu-Bar, Dropdown und Menu-Items werden erstellt
        appMenuBar = new JMenuBar();
        appMenu = new JMenu("Spiel");
        menuNewGame = new JMenuItem("Neue Runde");
        menuReset = new JMenuItem("Zurücksetzen");
        
        // die oben erstellten Sachen werden dem jeweiligen Objekt hinzugefügt
        appMenu.add(menuNewGame);
        appMenu.add(menuReset);
        appMenuBar.add(appMenu);
        appFrame.setJMenuBar(appMenuBar);
        
        // Menu-Bar wird farblich gestaltet
        appMenuBar.setBackground(Color.WHITE);
        appMenu.setForeground(new Color(0, 0, 90));
        
        // innere Panels werden generiert
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
        
        // Farbe der Panels werden angepasst
        topLeftPanel.setBackground(Color.WHITE);
        topCenterPanel.setBackground(Color.WHITE);
        topRightPanel.setBackground(Color.WHITE);
        
        middleLeftPanel.setBackground(Color.WHITE);
        middleCenterPanel.setBackground(Color.WHITE);
        middleRightPanel.setBackground(Color.WHITE);
        
        bottomLeftPanel.setBackground(Color.WHITE);
        bottomCenterPanel.setBackground(Color.WHITE);
        bottomRightPanel.setBackground(Color.WHITE);
        
        // Border der Panels wird erstellt
        topLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        topCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        topRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        middleLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        middleCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        middleRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        bottomLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bottomCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        bottomRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        // Labels werden generiert und farblich gestaltet
        topLeftLabel = new JLabel();
        topLeftPanel.add(topLeftLabel);
        topLeftLabel.setFont(new Font("Sans Serif", Font.BOLD, 120));
        topLeftLabel.setForeground(new Color(0,0,50));
        topLeftLabel.setVisible(true);
        
        topCenterLabel = new JLabel();
        topCenterPanel.add(topCenterLabel);
        topCenterLabel.setFont(new Font("Sans Serif", Font.BOLD, 120));
        topCenterLabel.setForeground(new Color(0,0,50));
        topCenterLabel.setVisible(true);
        
        topRightLabel = new JLabel();
        topRightPanel.add(topRightLabel);
        topRightLabel.setFont(new Font("Sans Serif", Font.BOLD, 120));
        topRightLabel.setForeground(new Color(0,0,50));
        topRightLabel.setVisible(true);
        
        middleLeftLabel = new JLabel();
        middleLeftPanel.add(middleLeftLabel);
        middleLeftLabel.setFont(new Font("Sans Serif", Font.BOLD, 120));
        middleLeftLabel.setForeground(new Color(0,0,50));
        middleLeftLabel.setVisible(true);
        
        middleCenterLabel = new JLabel();
        middleCenterPanel.add(middleCenterLabel);
        middleCenterLabel.setFont(new Font("Sans Serif", Font.BOLD, 120));
        middleCenterLabel.setForeground(new Color(0,0,50));
        middleCenterLabel.setVisible(true);
        
        middleRightLabel = new JLabel();
        middleRightPanel.add(middleRightLabel);
        middleRightLabel.setFont(new Font("Sans Serif", Font.BOLD, 120));
        middleRightLabel.setForeground(new Color(0,0,50));
        middleRightLabel.setVisible(true);
    
        bottomLeftLabel = new JLabel();
        bottomLeftPanel.add(bottomLeftLabel);
        bottomLeftLabel.setFont(new Font("Sans Serif", Font.BOLD, 120));
        bottomLeftLabel.setForeground(new Color(0,0,50));
        bottomLeftLabel.setVisible(true);
        
        bottomCenterLabel = new JLabel();
        bottomCenterPanel.add(bottomCenterLabel);
        bottomCenterLabel.setFont(new Font("Sans Serif", Font.BOLD, 120));
        bottomCenterLabel.setForeground(new Color(0,0,50));
        bottomCenterLabel.setVisible(true);
        
        bottomRightLabel = new JLabel();
        bottomRightPanel.add(bottomRightLabel);
        bottomRightLabel.setFont(new Font("Sans Serif", Font.BOLD, 120));
        bottomRightLabel.setForeground(new Color(0,0,50));
        bottomRightLabel.setVisible(true);
        
        // MouseListener wird hinzugefügt
        topLeftPanel.addMouseListener(this);
        topCenterPanel.addMouseListener(this);
        topRightPanel.addMouseListener(this);
        
        middleLeftPanel.addMouseListener(this);
        middleCenterPanel.addMouseListener(this);
        middleRightPanel.addMouseListener(this);
        
        bottomLeftPanel.addMouseListener(this);
        bottomCenterPanel.addMouseListener(this);
        bottomRightPanel.addMouseListener(this);
        
        menuNewGame.addActionListener(this);
        menuReset.addActionListener(this);
        
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
    
    public void actionPerformed (ActionEvent ae) {
        
        if(ae.getSource() == this.menuNewGame) {
            
            topLeftFull = false;
            topCenterFull = false;
            topRightFull = false;
            middleLeftFull = false;
            middleCenterFull = false;
            middleRightFull = false;
            bottomLeftFull = false;
            bottomCenterFull = false;
            bottomRightFull = false;
            
            topLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            topCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            topRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            
            middleLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            middleCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            middleRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            
            bottomLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            bottomCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            bottomRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            
            topLeftLabel.setForeground(new Color(0,0,50));
            topCenterLabel.setForeground(new Color(0,0,50));
            topRightLabel.setForeground(new Color(0,0,50));
            
            middleLeftLabel.setForeground(new Color(0,0,50));
            middleCenterLabel.setForeground(new Color(0,0,50));
            middleRightLabel.setForeground(new Color(0,0,50));
            
            bottomLeftLabel.setForeground(new Color(0,0,50));
            bottomCenterLabel.setForeground(new Color(0,0,50));
            bottomRightLabel.setForeground(new Color(0,0,50));
            
            filledBox[0][0] = " ";
            filledBox[0][1] = " ";
            filledBox[0][2] = " ";
            filledBox[1][0] = " ";
            filledBox[1][1] = " ";
            filledBox[1][2] = " ";
            filledBox[2][0] = " ";
            filledBox[2][1] = " ";
            filledBox[2][2] = " ";
                
            topLeftLabel.setText(filledBox[0][0]);
            topCenterLabel.setText(filledBox[0][1]);
            topRightLabel.setText(filledBox[0][2]);
            middleLeftLabel.setText(filledBox[1][0]);
            middleCenterLabel.setText(filledBox[1][1]);
            middleRightLabel.setText(filledBox[1][2]);
            bottomLeftLabel.setText(filledBox[2][0]);
            bottomCenterLabel.setText(filledBox[2][1]);
            bottomRightLabel.setText(filledBox[2][2]);
            
            whosTurn = "X";
            
        }
        
        if(ae.getSource() == this.menuReset) {
            
            topLeftFull = false;
            topCenterFull = false;
            topRightFull = false;
            middleLeftFull = false;
            middleCenterFull = false;
            middleRightFull = false;
            bottomLeftFull = false;
            bottomCenterFull = false;
            bottomRightFull = false;
            
            topLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            topCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            topRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            
            middleLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            middleCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            middleRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            
            bottomLeftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            bottomCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            bottomRightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            
            topLeftLabel.setForeground(new Color(0,0,50));
            topCenterLabel.setForeground(new Color(0,0,50));
            topRightLabel.setForeground(new Color(0,0,50));
            
            middleLeftLabel.setForeground(new Color(0,0,50));
            middleCenterLabel.setForeground(new Color(0,0,50));
            middleRightLabel.setForeground(new Color(0,0,50));
            
            bottomLeftLabel.setForeground(new Color(0,0,50));
            bottomCenterLabel.setForeground(new Color(0,0,50));
            bottomRightLabel.setForeground(new Color(0,0,50));
            
            filledBox[0][0] = " ";
            filledBox[0][1] = " ";
            filledBox[0][2] = " ";
            filledBox[1][0] = " ";
            filledBox[1][1] = " ";
            filledBox[1][2] = " ";
            filledBox[2][0] = " ";
            filledBox[2][1] = " ";
            filledBox[2][2] = " ";
                
            topLeftLabel.setText(filledBox[0][0]);
            topCenterLabel.setText(filledBox[0][1]);
            topRightLabel.setText(filledBox[0][2]);
            middleLeftLabel.setText(filledBox[1][0]);
            middleCenterLabel.setText(filledBox[1][1]);
            middleRightLabel.setText(filledBox[1][2]);
            bottomLeftLabel.setText(filledBox[2][0]);
            bottomCenterLabel.setText(filledBox[2][1]);
            bottomRightLabel.setText(filledBox[2][2]);
            
            whosTurn = "X";
            xWon = 0;
            oWon = 0;
        
        }
      
    }
    
    public void mouseClicked (MouseEvent me) {
        
        
         
    }
    
    public void mousePressed (MouseEvent me) {
        
        if(me.getSource() == this.topLeftPanel && topLeftFull == false) {
            
            if(whosTurn == "X") {
                
                topLeftLabel.setText(whosTurn);
                filledBox[0][0] = whosTurn;
                whosTurn = "O";
                topLeftFull = true;
                
            } else if(whosTurn == "O") {
                
                topLeftLabel.setText(whosTurn);
                filledBox[0][0] = whosTurn;
                whosTurn = "X";
                topLeftFull = true;
                
            }
            
        } else if(me.getSource() == this.topCenterPanel && topCenterFull == false) {
            
            if(whosTurn == "X") {
                
                topCenterLabel.setText(whosTurn);
                filledBox[0][1] = whosTurn;
                whosTurn = "O";
                topCenterFull = true;
                
            } else if(whosTurn == "O") {
                
                topCenterLabel.setText(whosTurn);
                filledBox[0][1] = whosTurn;
                whosTurn = "X";
                topCenterFull = true;
                
            }
                
        } else if(me.getSource() == this.topRightPanel && topRightFull == false) {
            
            if(whosTurn == "X") {
                
                topRightLabel.setText(whosTurn);
                filledBox[0][2] = whosTurn;
                whosTurn = "O";
                topRightFull = true;
                
            } else if(whosTurn == "O") {
                
                topRightLabel.setText(whosTurn);
                filledBox[0][2] = whosTurn;
                whosTurn = "X";
                topRightFull = true;
                
            }
                
        } else if(me.getSource() == this.middleLeftPanel && middleLeftFull == false) {
            
            if(whosTurn == "X") {
                
                middleLeftLabel.setText(whosTurn);
                filledBox[1][0] = whosTurn;
                whosTurn = "O";
                middleLeftFull = true;
                
            } else if(whosTurn == "O") {
                
                middleLeftLabel.setText(whosTurn);
                filledBox[1][0] = whosTurn;
                whosTurn = "X";
                middleLeftFull = true;
                
            }
            
        } else if(me.getSource() == this.middleCenterPanel && middleCenterFull == false) {
            
            if(whosTurn == "X") {
                
                middleCenterLabel.setText(whosTurn);
                filledBox[1][1] = whosTurn;
                whosTurn = "O";
                middleCenterFull = true;
                
            } else if(whosTurn == "O") {
                
                middleCenterLabel.setText(whosTurn);
                filledBox[1][1] = whosTurn;
                whosTurn = "X";
                middleCenterFull = true;
                
            }
            
        } else if(me.getSource() == this.middleRightPanel && middleRightFull == false) {
            
            if(whosTurn == "X") {
                
                middleRightLabel.setText(whosTurn);
                filledBox[1][2] = whosTurn;
                whosTurn = "O";
                middleRightFull = true;
                
            } else if(whosTurn == "O") {
                
                middleRightLabel.setText(whosTurn);
                filledBox[1][2] = whosTurn;
                whosTurn = "X";
                middleRightFull = true;
                
            }
            
        } else if(me.getSource() == this.bottomLeftPanel && bottomLeftFull == false) {
            
            if(whosTurn == "X") {
                
                bottomLeftLabel.setText(whosTurn);
                filledBox[2][0] = whosTurn;
                whosTurn = "O";
                bottomLeftFull = true;
                
            } else if(whosTurn == "O") {
                
                bottomLeftLabel.setText(whosTurn);
                filledBox[2][0] = whosTurn;
                whosTurn = "X";
                bottomLeftFull = true;
                
            }
            
        } else if(me.getSource() == this.bottomCenterPanel && bottomCenterFull == false) {
            
            if(whosTurn == "X") {
                
                bottomCenterLabel.setText(whosTurn);
                filledBox[2][1] = whosTurn;
                whosTurn = "O";
                bottomCenterFull = true;
                
            } else if(whosTurn == "O") {
                
                bottomCenterLabel.setText(whosTurn);
                filledBox[2][1] = whosTurn;
                whosTurn = "X";
                bottomCenterFull = true;
                
            }
            
        } else if(me.getSource() == this.bottomRightPanel && bottomRightFull == false) {
            
            if(whosTurn == "X") {
                
                bottomRightLabel.setText(whosTurn);
                filledBox[2][2] = whosTurn;
                whosTurn = "O";
                bottomRightFull = true;
                
            } else if(whosTurn == "O") {
                
                bottomRightLabel.setText(whosTurn);
                filledBox[2][2] = whosTurn;
                whosTurn = "X";
                bottomRightFull = true;
                
            }
            
        }
         
    }
    
    public void mouseReleased (MouseEvent me) {
        
        if(filledBox[0][0].equals("X") && filledBox[0][1].equals("X") && filledBox[0][2].equals("X")) {
            
            winnerX();
            
        } else if(filledBox[1][0].equals("X") && filledBox[1][1].equals("X") && filledBox[1][2].equals("X")) {
            
            winnerX();
            
        } else if(filledBox[2][0].equals("X") && filledBox[2][1].equals("X") && filledBox[2][2].equals("X")) {
            
            winnerX();
            
        } else if(filledBox[0][0].equals("X") && filledBox[1][0].equals("X") && filledBox[2][0].equals("X")) {
            
            winnerX();
            
        } else if(filledBox[0][1].equals("X") && filledBox[1][1].equals("X") && filledBox[2][1].equals("X")) {
            
            winnerX();
            
        } else if(filledBox[0][2].equals("X") && filledBox[1][2].equals("X") && filledBox[2][2].equals("X")) {
            
            winnerX();
            
        } else if(filledBox[0][2].equals("X") && filledBox[1][2].equals("X") && filledBox[2][2].equals("X")) {
            
            winnerX();
            
        } else if(filledBox[0][0].equals("X") && filledBox[1][1].equals("X") && filledBox[2][2].equals("X")) {
            
            winnerX();
            
        } else if(filledBox[0][2].equals("X") && filledBox[1][1].equals("X") && filledBox[2][0].equals("X")) {
            
            winnerX();
            
        }
        
        if(filledBox[0][0].equals("O") && filledBox[0][1].equals("O") && filledBox[0][2].equals("O")) {
            
            winnerO();
            
        } else if(filledBox[1][0].equals("O") && filledBox[1][1].equals("O") && filledBox[1][2].equals("O")) {
            
            winnerO();
            
        } else if(filledBox[2][0].equals("O") && filledBox[2][1].equals("O") && filledBox[2][2].equals("O")) {
            
            winnerO();
            
        } else if(filledBox[0][0].equals("O") && filledBox[1][0].equals("O") && filledBox[2][0].equals("O")) {
            
            winnerO();
            
        } else if(filledBox[0][1].equals("O") && filledBox[1][1].equals("O") && filledBox[2][1].equals("O")) {
            
            winnerO();
            
        } else if(filledBox[0][2].equals("O") && filledBox[1][2].equals("O") && filledBox[2][2].equals("O")) {
            
            winnerO();
            
        } else if(filledBox[0][2].equals("O") && filledBox[1][2].equals("O") && filledBox[2][2].equals("O")) {
            
            winnerO();
            
        } else if(filledBox[0][0].equals("O") && filledBox[1][1].equals("O") && filledBox[2][2].equals("O")) {
            
            winnerO();
            
        } else if(filledBox[0][2].equals("O") && filledBox[1][1].equals("O") && filledBox[2][0].equals("O")) {
            
            winnerO();
            
        }
         
    }
    
    public void mouseEntered (MouseEvent me) {
        
        
         
    }
    
    public void mouseExited (MouseEvent me) {
        
        
         
    }
    
    public void winnerX() {
        
        xWon++;
        
        topLeftFull = true;
        topCenterFull = true;
        topRightFull = true;
        middleLeftFull = true;
        middleCenterFull = true;
        middleRightFull = true;
        bottomLeftFull = true;
        bottomCenterFull = true;
        bottomRightFull = true;
        
        topLeftPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        topCenterPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        topRightPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        middleLeftPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        middleCenterPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        middleRightPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        bottomLeftPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        bottomCenterPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        bottomRightPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        filledBox[0][0] = " ";
        filledBox[0][1] = " ";
        filledBox[0][2] = " ";
        filledBox[1][0] = " ";
        filledBox[1][1] = " ";
        filledBox[1][2] = " ";
        filledBox[2][0] = " ";
        filledBox[2][1] = " ";
        filledBox[2][2] = " ";
            
        topLeftLabel.setText(filledBox[0][0]);
        topCenterLabel.setText(filledBox[0][1]);
        topRightLabel.setText(filledBox[0][2]);
        middleLeftLabel.setText(filledBox[1][0]);
        middleCenterLabel.setText(filledBox[1][1]);
        middleRightLabel.setText(filledBox[1][2]);
        bottomLeftLabel.setText(filledBox[2][0]);
        bottomCenterLabel.setText(filledBox[2][1]);
        bottomRightLabel.setText(filledBox[2][2]);
        
        topLeftLabel.setText("X");
        topLeftLabel.setForeground((new Color(110,0,0)));
        
        topRightLabel.setText("O");
        topRightLabel.setForeground((new Color(0,0,50)));
        
        middleLeftLabel.setText(String.valueOf(xWon));
        middleLeftLabel.setForeground(Color.BLACK);

        middleCenterLabel.setText(":");
        middleCenterLabel.setForeground(Color.BLACK);
        
        middleRightLabel.setText(String.valueOf(oWon));
        middleRightLabel.setForeground(Color.BLACK);

    }
    
    public void winnerO() {
        
        oWon++;
        
        topLeftFull = true;
        topCenterFull = true;
        topRightFull = true;
        middleLeftFull = true;
        middleCenterFull = true;
        middleRightFull = true;
        bottomLeftFull = true;
        bottomCenterFull = true;
        bottomRightFull = true;
       
        topLeftPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        topCenterPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        topRightPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        middleLeftPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        middleCenterPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        middleRightPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        bottomLeftPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        bottomCenterPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        bottomRightPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        topLeftLabel.setForeground(Color.WHITE);
        topCenterLabel.setForeground(Color.WHITE);
        topRightLabel.setForeground(Color.WHITE);
        
        middleLeftLabel.setForeground(Color.WHITE);
        middleCenterLabel.setForeground(Color.WHITE);
        middleRightLabel.setForeground(Color.WHITE);
        
        bottomLeftLabel.setForeground(Color.WHITE);
        bottomCenterLabel.setForeground(Color.WHITE);
        bottomRightLabel.setForeground(Color.WHITE);
        
        filledBox[0][0] = " ";
        filledBox[0][1] = " ";
        filledBox[0][2] = " ";
        filledBox[1][0] = " ";
        filledBox[1][1] = " ";
        filledBox[1][2] = " ";
        filledBox[2][0] = " ";
        filledBox[2][1] = " ";
        filledBox[2][2] = " ";
            
        topLeftLabel.setText(filledBox[0][0]);
        topCenterLabel.setText(filledBox[0][1]);
        topRightLabel.setText(filledBox[0][2]);
        middleLeftLabel.setText(filledBox[1][0]);
        middleCenterLabel.setText(filledBox[1][1]);
        middleRightLabel.setText(filledBox[1][2]);
        bottomLeftLabel.setText(filledBox[2][0]);
        bottomCenterLabel.setText(filledBox[2][1]);
        bottomRightLabel.setText(filledBox[2][2]);
        
        topLeftLabel.setText("X");
        topLeftLabel.setForeground((new Color(110,0,0)));
        
        topRightLabel.setText("O");
        topRightLabel.setForeground((new Color(0,0,50)));
        
        middleLeftLabel.setText(String.valueOf(xWon));
        middleLeftLabel.setForeground(Color.BLACK);

        middleCenterLabel.setText(":");
        middleCenterLabel.setForeground(Color.BLACK);
        
        middleRightLabel.setText(String.valueOf(oWon));
        middleRightLabel.setForeground(Color.BLACK);

    }
    
    public void checkSaves() {
        
        boolean saveAvailable = false;
        
        try {
            
            saveGame = new File("saveGame.txt");
            saveAvailable = saveGame.exists();
            
            if(saveAvailable == false) {
                
                JDialog loadSavesDialog;
                loadSavesDialog = new JDialog(appFrame, "Spielstand gefunden!", true);
                loadSavesDialog.setLayout(new BorderLayout());
                loadSavesDialog.setSize(300, 150);
                
                
            
            } else if(saveAvailable == false) {
            
            }
            
        } catch(Exception e) {
            
            checkSaves();
            
        }
    
    }
    
}
