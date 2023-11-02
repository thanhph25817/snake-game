/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javax.swing.JFrame;

/**
 *
 * @author thanh
 */
public class GameFrame extends JFrame{
    GameFrame(){
        GamePanel panel=new GamePanel();
        this.add(panel);
        this.setTitle("Snake");
        //đóng cửa sổ bằng nút đóng (X) ở góc trên cùng của cửa sổ.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Dòng này không cho phép cửa sổ thay đổi kích thước bằng cách kéo giữa các cạnh
        this.setResizable(false);
        // thực hiện điều chỉnh kích thước cửa sổ để vừa với nội dung bên trong
        this.pack();
        //dung de hien chuong trinh 
        this.setVisible(true);
        //đặt vị trí của cửa sổ so với màn hình
        this.setLocationRelativeTo(null);
    }
}
