package com.addresbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class callPanel extends JPanel {

    // call History 옵션 메뉴
    JButton seeAll = new JButton("All"); // 모든 전화 기록
    JButton seeSent = new JButton("Sent"); // 내가 건 전화 기록
    JButton seeRece = new JButton("Received"); // 내가 받은 메시지 기록
    JButton seeMiss = new JButton("Missed"); // 부재중 전화 기록


    JPanel callMenu = new JPanel(); // 옵션 메뉴들을 붙여줄 callMenu, jpanel로 만듦
    JTextArea midContent = new JTextArea(32, 30); // 현재 패널에 삽입될 text area, 전화 기록들이 표시될 공간
    JScrollPane midScroll = new JScrollPane(midContent); // midContent에 생길 scroll bar

    Vector<Call> callData = new Vector<Call>(); // json 파일에서 데이터를 읽어올 callHistory를 저장할 vector


    public callPanel(){

        this.setLayout(new BorderLayout());
        this.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));



        midScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        midScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        midContent.append("   S  |" + "          Time         " +  "|   Phone number " + "   |" + " During\n" );



        callData = JRead.readCall();// json파일로부터 데이터를 읽어온다

        Collections.sort(callData, new TimeDescCompare());
        // 시간 순 정렬 ( 내림차순 정렬 )


        // status가 0이면 내가 건 전화 이므로 -> 표시
        // status가 1이면 내가 받은 전화 이므로 <- 표시
        // status가 2이면 부재중 전화 이므로 ??? 표시
        for(int i=0 ; i < callData.size() ; i++) {

            if((callData.elementAt(i).getStatus_().equals("0")))
                midContent.append(" -> |");
            else if((callData.elementAt(i).getStatus_().equals("1")))
                midContent.append(" <- |");
            else if((callData.elementAt(i).getStatus_().equals("2")))
                midContent.append(" ?? |");

            midContent.append(String.format(" %-14s |", callData.elementAt(i).getTime_()));
            String number = callData.elementAt(i).getNumber_();
            Person p = contactPanel.contactMap.get(number);
            if(p==null)
                midContent.append(String.format(" %-15s |", callData.elementAt(i).getNumber_()));
            else {
                midContent.append(String.format(" %-15s |", p.getName_()));
            }
            midContent.append(String.format(" %-5s ", callData.elementAt(i).getDuration_()));
            //append 메소드를 통해 textArea에 내용을 추가 한다

            midContent.append("\n");
        }

        this.add(midScroll, BorderLayout.CENTER);

        callMenu.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));

        ButtonListener btnListener = new ButtonListener();


        seeAll.addActionListener(btnListener);
        seeSent.addActionListener(btnListener);
        seeRece.addActionListener(btnListener);
        seeMiss.addActionListener(btnListener);

        // callHistory 옵션 메뉴의 버튼들에 각각 button listener를 달아준다.

        callMenu.add(seeAll);
        callMenu.add(seeSent);
        callMenu.add(seeRece);
        callMenu.add(seeMiss);

        this.add(callMenu, BorderLayout.SOUTH);

    }



    static class TimeDescCompare implements Comparator<Call> {

        // 내림차순
        public int compare(Call arg0, Call arg1) {
            return arg1.getTime_().compareTo(arg0.getTime_());
        }

    }



// 버튼 리스너!
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            // All 버튼 누를 때
            if( e.getActionCommand().equals("All") ) {

                midContent.setText("   S  |" + "        Time         " +  "|   Phone number " + "   |" + " During\n" );

                for(int i=0 ; i < callData.size() ; i++) {
                    if((callData.elementAt(i).getStatus_().equals("0")))
                        midContent.append(" -> ");
                    else if((callData.elementAt(i).getStatus_().equals("1")))
                        midContent.append(" <- ");
                    else if((callData.elementAt(i).getStatus_().equals("2")))
                        midContent.append("  ??? ");

                    midContent.append(" "+callData.elementAt(i).getTime_() + " | ");

                    String number = callData.elementAt(i).getNumber_();
                    Person p = contactPanel.contactMap.get(number);
                    if(p==null)
                        midContent.append(" "+callData.elementAt(i).getNumber_() + " | ");
                    else {
                        midContent.append(" "+ p.getName_() + "\t | ");
                    }

                    midContent.append(" " + callData.elementAt(i).getDuration_() + "  ");
                    midContent.append("\n");
                }



            } // Sent 버튼 누를 때
            else if( e.getActionCommand().equals("Sent")){

                midContent.setText("   S  |" + "        Time         " +  "|   Phone number " + "   |" + " During\n" );

                for(int i=0 ; i < callData.size() ; i++) {

                    if ((callData.elementAt(i).getStatus_().equals("0"))) {
                        midContent.append(" -> ");
                        midContent.append(" "+callData.elementAt(i).getTime_() + " | ");

                        String number = callData.elementAt(i).getNumber_();
                        Person p = contactPanel.contactMap.get(number);
                        if(p==null)
                            midContent.append(" "+callData.elementAt(i).getNumber_() + " | ");
                        else {
                            midContent.append(" "+ p.getName_() + "\t | ");
                        }

                        midContent.append(" " + callData.elementAt(i).getDuration_() + "  ");
                        midContent.append("\n");
                    }
                }


            } // Received 버튼 누를 때
            else if( e.getActionCommand().equals("Received")) {
                midContent.setText("   S  |" + "        Time         " +  "|   Phone number " + "   |" + " During\n" );

                for(int i=0 ; i < callData.size() ; i++) {

                    if((callData.elementAt(i).getStatus_().equals("1"))) {
                        midContent.append(" <- ");
                        midContent.append(" "+callData.elementAt(i).getTime_() + " | ");

                        String number = callData.elementAt(i).getNumber_();
                        Person p = contactPanel.contactMap.get(number);
                        if(p==null)
                            midContent.append(" "+callData.elementAt(i).getNumber_() + " | ");
                        else {
                            midContent.append(" "+ p.getName_() + "\t | ");
                        }

                        midContent.append(" " + callData.elementAt(i).getDuration_() + "  ");
                        midContent.append("\n");
                    }


                }

            }  // Missed 버튼 누를 때
            else if( e.getActionCommand().equals("Missed")) {
                midContent.setText("   S  |" + "        Time         " +  "|   Phone number " + "   |" + " During\n" );

                for(int i=0 ; i < callData.size() ; i++) {

                    if((callData.elementAt(i).getStatus_().equals("2"))) {
                        midContent.append("  ??? ");
                        midContent.append(" "+callData.elementAt(i).getTime_() + " | ");

                        String number = callData.elementAt(i).getNumber_();
                        Person p = contactPanel.contactMap.get(number);
                        if(p==null)
                            midContent.append(" "+callData.elementAt(i).getNumber_() + " | ");
                        else {
                            midContent.append(" "+ p.getName_() + "\t | ");
                        }

                        midContent.append(" " + callData.elementAt(i).getDuration_() + "  ");
                        midContent.append("\n");
                    }


                }

            }


        }
    }
}
