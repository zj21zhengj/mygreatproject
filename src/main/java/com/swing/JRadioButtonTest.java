package com.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JRadioButtonTest {
    JFrame f = null;

    JRadioButtonTest() {
        f = new JFrame("单选框示例");//创建一个JFrame对象
        Container contentPane = f.getContentPane();//创建一个内容面板容器
        contentPane.setLayout(new FlowLayout()); //设置该窗口的布局
        JPanel p1 = new JPanel(); //创建一个面板对象
        p1.setLayout(new GridLayout(1, 3)); //设置布局管理器的格式
        p1.setBorder(BorderFactory.createTitledBorder("选择你喜欢的城市"));
        //定义三个JRadioButton单选按钮
        JRadioButton r1 = new JRadioButton("北京");
        JRadioButton r2 = new JRadioButton("上海");
        JRadioButton r3 = new JRadioButton("青岛");
        p1.add(r1);
        p1.add(r2);
        p1.add(r3);
        r1.setSelected(true);
        contentPane.add(p1);
        f.pack();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new JRadioButtonTest();
    }
}
