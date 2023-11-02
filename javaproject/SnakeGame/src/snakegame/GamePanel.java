/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author thanh
 */
public class GamePanel extends JPanel implements ActionListener {

    //thiet lap ung dung game 
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    //kich thuoc cua vat the 
    static final int UNIT_SIZE = 25;
    //tinh bao nhieu doi tuong trong man hinh 
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    //do tri hoan cua game 
    static final int DELAY = 75;
    //tao body , head cua  ran 
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    // tao body ban dau
    int bodyPart = 6;
    //tao appleEaten
    int appleEaten;
    //toa do ma tao se xuat hien 

    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer t;
    Random random;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        StartGame();

    }

    public void StartGame() {
        newApple();
        running = true;
        t = new Timer(DELAY, this);
        t.start();

    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Draw(g);
        System.out.println("day ");
    }

    public void Draw(Graphics g) {
        
        if(running){
           for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
        for (int i = 0; i < bodyPart; i++) {
            if (i == 0) {
                g.setColor(Color.GREEN);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                g.setColor(new Color(45, 180, 0));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

            }
        } 
        }else{
            gameOver(g);
        }
        
    }

    public void move() {
        for (int i = bodyPart; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;

            default:
                throw new AssertionError();
        }
    }

    public void checkApple() {
            if(x[0]==appleX && y[0]==appleY){
                bodyPart++;
                appleEaten++;
                newApple();
            }
    }

    public void checkCollisions() {
        for (int i = bodyPart; i > 0; i--) {
            if (x[0] == x[i] && (y[0] == y[i])) {
                running = false;
            }
        }
        if (x[0] < 0) {
            running = false;
        }

        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }

        if (y[0] < 0) {
            running = false;
        }

        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }
        if(!running){
            t.stop();
        }

    }

    public void gameOver(Graphics g) {
            g.setColor(Color.red);
            g.setFont(new Font("Ink tree",Font.BOLD,75));
            FontMetrics me=getFontMetrics(g.getFont());
            g.drawString("game over", (SCREEN_WIDTH- me.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction !='R'){
                        direction='L';                    
                    }
                    break;
                 case KeyEvent.VK_RIGHT:
                    if(direction !='L'){
                        direction='R';                    
                    }
                    break;
                     case KeyEvent.VK_UP:
                    if(direction !='D'){
                        direction='U';                    
                    }
                    break;
                     case KeyEvent.VK_DOWN:
                    if(direction !='U'){
                        direction='D';                    
                    }
                    break;
                    
                    
                default:
                    throw new AssertionError();
            }
        }
    }

}
