package com.addresbook;



import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class msgPanel extends JPanel {

    JButton seeAll = new JButton("See All msg");
    JButton seeSent = new JButton("See Sent");
    JButton seeRece = new JButton("See Received");
    JPanel msgMenu = new JPanel();
    JTextArea midContent = new JTextArea(32, 32);
    JScrollPane midScroll = new JScrollPane(midContent);
    Vector<Sms> smsData = new Vector<Sms>();

    public msgPanel(){

        this.setLayout(new BorderLayout());
        this.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));



        midScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        midScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        midContent.append("  S  |" + "        Time         " +  "|   Phone number " + "   |" + " Text  \t\n" );



        smsData = JRead.readSms();
        Collections.sort(smsData, new TimeDescCompare());
        //System.out.println(smsData.elementAt(0).getNumber_());


        for(int i=0 ; i < smsData.size() ; i++) {

            if((smsData.elementAt(i).getStatus_().equals("0")))
                midContent.append(" ->");
            else if((smsData.elementAt(i).getStatus_().equals("1")))
                midContent.append(" <-");

            midContent.append(" "+smsData.elementAt(i).getTime_() + " | ");
            midContent.append(" "+smsData.elementAt(i).getNumber_() + " | ");
            midContent.append(" " + smsData.elementAt(i).getText_() + "  ");


            midContent.append("\n");
        }



        this.add(midScroll, BorderLayout.CENTER);

        msgMenu.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));

        ButtonListener btnListener = new ButtonListener();


        seeAll.addActionListener(btnListener);
        seeSent.addActionListener(btnListener);
        seeRece.addActionListener(btnListener);

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

            if( e.getActionCommand().equals("See All msg") ) {

                midContent.setText("  S  |" + "        Time         " +  "|   Phone number " + "   |" + " Text  \t\n");

                for(int i=0 ; i < smsData.size() ; i++) {
                    if((smsData.elementAt(i).getStatus_().equals("0")))
                        midContent.append(" ->");
                    else if((smsData.elementAt(i).getStatus_().equals("1")))
                        midContent.append(" <-");

                    midContent.append(" "+smsData.elementAt(i).getTime_() + " | ");
                    midContent.append(" "+smsData.elementAt(i).getNumber_() + " | ");
                    midContent.append(" " + smsData.elementAt(i).getText_() + "  ");
                    midContent.append("\n");
                }


            } else if( e.getActionCommand().equals("See Sent")){
                System.out.println("hi");
                midContent.setText("  S  |" + "        Time         " +  "|   Phone number " + "   |" + " Text  \t\n");

                for(int i=0 ; i < smsData.size() ; i++) {

                    if ((smsData.elementAt(i).getStatus_().equals("0"))) {
                        midContent.append(" ->");
                        midContent.append(" " + smsData.elementAt(i).getTime_() + " | ");
                        midContent.append(" " + smsData.elementAt(i).getNumber_() + " | ");
                        midContent.append(" " + smsData.elementAt(i).getText_() + "  ");
                        midContent.append("\n");
                    }
                }


            } else if( e.getActionCommand().equals("See Received")) {
                midContent.setText("  S  |" + "        Time         " +  "|   Phone number " + "   |" + " Text  \t\n");

                for(int i=0 ; i < smsData.size() ; i++) {

                    if((smsData.elementAt(i).getStatus_().equals("1"))) {
                        midContent.append(" <-");
                        midContent.append(" "+smsData.elementAt(i).getTime_() + " | ");
                        midContent.append(" "+smsData.elementAt(i).getNumber_() + " | ");
                        midContent.append(" " + smsData.elementAt(i).getText_() + "  ");
                        midContent.append("\n");
                    }


                }

            }
        }
    }



}
