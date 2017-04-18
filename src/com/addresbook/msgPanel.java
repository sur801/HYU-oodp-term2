package com.addresbook;



import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class msgPanel extends JPanel {

    JButton seeAll = new JButton("See All msg"); //모든 문자 기록
    JButton seeSent = new JButton("See Sent"); // 보낸 문자 기록
    JButton seeRece = new JButton("See Received"); // 받은 문자 기록

    JPanel msgMenu = new JPanel();// 옵션 메뉴들을 붙여줄 msgMenu, jpanel로 만듦
    JTextArea midContent = new JTextArea(32, 30); // 현재 패널에 삽입될 text area, 문자 기록들이 표시될 공간
    JScrollPane midScroll = new JScrollPane(midContent);  // midContent에 생길 scroll bar

    Vector<Sms> smsData = new Vector<Sms>(); // json 파일에서 데이터를 읽어올 msgHistory를 저장할 vector

    public msgPanel(){

        this.setLayout(new BorderLayout());
        this.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));



        midScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        midScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        midContent.append("  S  |" + "        Time         " +  "|   Phone number " + "   |" + " Text  \t\n" );



        smsData = JRead.readSms(); // json파일로부터 데이터를 읽어온다
        Collections.sort(smsData, new TimeDescCompare());
        // 시간 순 정렬 ( 내림차순 정렬 )


        // status가 0이면 내가 보낸 문자 이므로 -> 표시
        // status가 1이면 내가 받은 문자 이므로 <- 표시


        for(int i=0 ; i < smsData.size() ; i++) {

            if((smsData.elementAt(i).getStatus_().equals("0")))
                midContent.append(" ->");
            else if((smsData.elementAt(i).getStatus_().equals("1")))
                midContent.append(" <-");

            midContent.append(" "+smsData.elementAt(i).getTime_() + " | ");

            String number = smsData.elementAt(i).getNumber_();
            Person p = contactPanel.contactMap.get(number);
            if(p==null)
                midContent.append(" "+smsData.elementAt(i).getNumber_() + " | ");
            else {
                midContent.append(p.getName_() + "\t | ");
            }

            midContent.append(" " + smsData.elementAt(i).getText_() + "  ");


            midContent.append("\n");
        }



        this.add(midScroll, BorderLayout.CENTER);

        msgMenu.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));

        ButtonListener btnListener = new ButtonListener();


        seeAll.addActionListener(btnListener);
        seeSent.addActionListener(btnListener);
        seeRece.addActionListener(btnListener);

        // msgHistory 옵션 메뉴의 버튼들에 각각 button listener를 달아준다.


        msgMenu.add(seeAll);
        msgMenu.add(seeSent);
        msgMenu.add(seeRece);

        this.add(msgMenu, BorderLayout.SOUTH);

    }

    static class TimeDescCompare implements Comparator<Sms> {

        // 내림차순
        public int compare(Sms arg0, Sms arg1) {
            return arg1.getTime_().compareTo(arg0.getTime_());
        }

    }


    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // See All msg 버튼 누를 때
            if( e.getActionCommand().equals("See All msg") ) {

                midContent.setText("  S  |" + "        Time         " +  "|   Phone number " + "   |" + " Text  \t\n");

                for(int i=0 ; i < smsData.size() ; i++) {
                    if((smsData.elementAt(i).getStatus_().equals("0")))
                        midContent.append(" ->");
                    else if((smsData.elementAt(i).getStatus_().equals("1")))
                        midContent.append(" <-");

                    midContent.append(" "+smsData.elementAt(i).getTime_() + " | ");


                    String number = smsData.elementAt(i).getNumber_();
                    Person p = contactPanel.contactMap.get(number);
                    if(p==null)
                        midContent.append(" "+smsData.elementAt(i).getNumber_() + " | ");
                    else {
                        midContent.append(p.getName_() + "\t | ");
                    }

                    midContent.append(" " + smsData.elementAt(i).getText_() + "  ");
                    midContent.append("\n");
                }


            } // See sent 버튼 누를 때
            else if( e.getActionCommand().equals("See Sent")){
                System.out.println("hi");
                midContent.setText("  S  |" + "        Time         " +  "|   Phone number " + "   |" + " Text  \t\n");

                for(int i=0 ; i < smsData.size() ; i++) {

                    if ((smsData.elementAt(i).getStatus_().equals("0"))) {
                        midContent.append(" ->");
                        midContent.append(" " + smsData.elementAt(i).getTime_() + " | ");


                        String number = smsData.elementAt(i).getNumber_();
                        Person p = contactPanel.contactMap.get(number);
                        if(p==null)
                            midContent.append(" "+smsData.elementAt(i).getNumber_() + " | ");
                        else {
                            midContent.append(p.getName_() + "\t | ");
                        }

                        midContent.append(" " + smsData.elementAt(i).getText_() + "  ");
                        midContent.append("\n");
                    }
                }


            } // See Received 버튼 누를 때
            else if( e.getActionCommand().equals("See Received")) {
                midContent.setText("  S  |" + "        Time         " +  "|   Phone number " + "   |" + " Text  \t\n");

                for(int i=0 ; i < smsData.size() ; i++) {

                    if((smsData.elementAt(i).getStatus_().equals("1"))) {
                        midContent.append(" <-");
                        midContent.append(" "+smsData.elementAt(i).getTime_() + " | ");

                        String number = smsData.elementAt(i).getNumber_();
                        Person p = contactPanel.contactMap.get(number);
                        if(p==null)
                            midContent.append(" "+smsData.elementAt(i).getNumber_() + " | ");
                        else {
                            midContent.append(p.getName_() + "\t | ");
                        }

                        midContent.append(" " + smsData.elementAt(i).getText_() + "  ");
                        midContent.append("\n");
                    }


                }

            }
        }
    }



}
