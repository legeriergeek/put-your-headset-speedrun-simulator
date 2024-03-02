package fr.legeriergeek.CQM.coregame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.awt.event.*;


public class Game extends Frame implements KeyListener {
    BufferedImage player;
    BufferedImage EndTrigger;
    int x = 950;
    int y = 560;
    Label won;


    public Game() throws IOException {
        repaint();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        Font font = new Font("SansSerif", Font.PLAIN, 72);

        won = new Label("You won!!!!!");
        won.setBounds(350, 40, 300, 60);
        won.setVisible(false);
        won.setFont(font);
        add(won);

        setSize(1024, 768);
        setResizable(false);
        setLayout(null);
        setTitle("Put Your Headset Speedrun Simulator");
        setVisible(true);

        player = ImageIO.read(Objects.requireNonNull(getClass().getResource("/fr/legeriergeek/CQM/coregame/pictures/player.png")));
        EndTrigger = ImageIO.read(Objects.requireNonNull(getClass().getResource("/fr/legeriergeek/CQM/coregame/pictures/Stop.png")));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); // Ferme l'application lorsque la fenêtre est fermée
            }
        });


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(player, x, y, 60, 200, null);
        g.drawImage(EndTrigger, 69, 69,50,50, null);
        repaint(1);
        if (x == 60 && y == 80){
            won.setVisible(true);
        }else{
            won.setVisible(false);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(x);
        System.out.println(y);
        //setSize(x+60, y+200);
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_S) {
            if (y < 560) {
                y = y + 10;
            }else{
                System.out.println("Can't go down");
            }
        }else if (keyCode == KeyEvent.VK_Z){
            if (y > 30) {
                y = y - 10;
            }else{
                System.out.println("Can't go up");
            }
        }else if (keyCode == KeyEvent.VK_D){
            if (x < 960) {
                x = x + 10;
            }else{
                System.out.println("Can't go right");
            }

        }else if (keyCode == KeyEvent.VK_Q){
            if (x > 10) {
                x = x-10;
            }else{
                System.out.println("Can't go left");
            }

      }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}