package com.addresbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 * Created by seoyulim on 2017. 4. 13..
 */
public class MainForm extends JFrame{

    JPanel topPanel = new JPanel();
    JPanel contentPanel = new JPanel();

    public botPanel bp;

    public MainForm() {


        //File path = new File(".");
       //System.out.println(path.getAbsolutePath());

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Address Book");
        setSize(385, 650);
        //this.setResizable(false);

        topPanel.setBackground(Color.pink);
        contentPanel.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));

        botPanel bp = new botPanel(); // 바닥의 세부 메뉴들이 보여질 panel


        JButton[] Top_btn = new JButton[3];

        Top_btn[0] = new JButton("Call History");
        Top_btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                call_menu cm = new call_menu();
                //call history의 세부 메뉴 들이 있는 panel
                bp.removeAll(); // 일단 하단 패널을 비운다
                bp.add(cm);// call history의 메튜 패널을 붙인다
                bp.revalidate();
                bp.repaint();
                */
                callPanel cp = new callPanel();

                contentPanel.removeAll(); // dataPanel이 붙여질 contentPanel을 비운다
                contentPanel.add(cp);// dataPanel을 붙인다
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });


        topPanel.add(Top_btn[0]);


        Top_btn[1] = new JButton("Sms History");
        Top_btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                msgPanel mp = new msgPanel();

                contentPanel.removeAll(); // dataPanel이 붙여질 contentPanel을 비운다
                contentPanel.add(mp);// dataPanel을 붙인다
                contentPanel.revalidate();
                contentPanel.repaint();


            }
        });


        topPanel.add(Top_btn[1]);

        Top_btn[2] = new JButton("Contact");
        topPanel.add(Top_btn[2]);






        this.add(topPanel, BorderLayout.NORTH);
        this.add(contentPanel, BorderLayout.CENTER);
        //this.add(bp, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args){
        MainForm mf = new MainForm();
    }


}
