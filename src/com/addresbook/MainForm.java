package com.addresbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by seoyulim on 2017. 4. 13..
 */
public class MainForm extends JFrame{

    // 메인 실행 창의 위쪽 메뉴들을 디스플레이 할 jpanel
    JPanel topPanel = new JPanel();
    // 가운데 내용들이 채워질 메인 jpanel
    JPanel contentPanel = new JPanel();


    public MainForm() {


        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // X 버튼을 누르면 실행이 끝나도록 설정
        setTitle("Address Book By, yurim and junghoon :-)");
        setSize(385, 675);
        // 실행 폼 크기 설정
        this.setResizable(false);
        // 실행 폼의 크기를 임의로 바꿀 수 없도록 설정

        topPanel.setBackground(Color.pink);
        contentPanel.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));

        // 메인 메뉴
        JButton[] Top_btn = new JButton[3];

        Top_btn[0] = new JButton("Call History");
        Top_btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

        Top_btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                contactPanel cp = new contactPanel();

                contentPanel.removeAll(); // dataPanel이 붙여질 contentPanel을 비운다
                contentPanel.add(cp);// dataPanel을 붙인다
                contentPanel.revalidate();
                contentPanel.repaint();


            }
        });






        this.add(topPanel, BorderLayout.NORTH);
        this.add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args){
        MainForm mf = new MainForm();
    }


}
