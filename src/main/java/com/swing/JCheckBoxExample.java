package com.swing;

import javax.swing.*;
import java.awt.*;

public class JCheckBoxExample extends JFrame {
    public JCheckBoxExample(){
        super("复选框");
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        Favorite f = new Favorite();
        container.add(f);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        JCheckBoxExample jcbe = new JCheckBoxExample();
        jcbe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class Favorite extends JPanel{
    JCheckBox sport,computer,music,read;
    Favorite(){
        sport = new JCheckBox("运动");
        computer = new JCheckBox("电脑");
        music = new JCheckBox("音乐");
        read = new JCheckBox("读书");
        add(new JLabel("爱好"));
        add(sport);
        add(computer);
        add(music);
        add(read);
        sport.setSelected(false);
        computer.setSelected(false);
        music.setSelected(false);
        read.setSelected(false);
    }
}
