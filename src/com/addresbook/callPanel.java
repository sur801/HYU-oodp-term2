package com.addresbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class callPanel extends JPanel {

    JButton seeAll = new JButton("All");
    JButton seeSent = new JButton("Sent");
    JButton seeRece = new JButton("Received");
    JButton seeMiss = new JButton("Missed");


    JPanel msgMenu = new JPanel();
    JTextArea midContent = new JTextArea(32, 32);
    JScrollPane midScroll = new JScrollPane(midContent);
    Vector<Call> callData = new Vector<Call>();

    public callPanel(){

        this.setLayout(new BorderLayout());
        this.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));



        midScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        midScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        midContent.append("   S  |" + "        Time         " +  "|   Phone number " + "   |" + " During\n" );



        callData = JRead.readCall();
        //System.out.println(smsData.elementAt(0).getNumber_());


        for(int i=0 ; i < callData.size() ; i++) {

            if((callData.elementAt(i).getStatus_().equals("0")))
                midContent.append(" -> ");
            else if((callData.elementAt(i).getStatus_().equals("1")))
                midContent.append(" <- ");
            else if((callData.elementAt(i).getStatus_().equals("2")))
                midContent.append("  ??? ");

            midContent.append(" "+callData.elementAt(i).getTime_() + " | ");
            midContent.append(" "+callData.elementAt(i).getNumber_() + " | ");
            midContent.append(" " + callData.elementAt(i).getDuration_() + "  ");


            midContent.append("\n");
        }



        this.add(midScroll, BorderLayout.CENTER);

        msgMenu.setBackground(Color.getHSBColor((float)2.00,(float)0.15, (float)1.0));

        ButtonListener btnListener = new ButtonListener();


        seeAll.addActionListener(btnListener);
        seeSent.addActionListener(btnListener);
        seeRece.addActionListener(btnListener);
        seeMiss.addActionListener(btnListener);

        msgMenu.add(seeAll);
        msgMenu.add(seeSent);
        msgMenu.add(seeRece);
        msgMenu.add(seeMiss);

        this.add(msgMenu, BorderLayout.SOUTH);

    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

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
                    midContent.append(" "+callData.elementAt(i).getNumber_() + " | ");
                    midContent.append(" " + callData.elementAt(i).getDuration_() + "  ");
                    midContent.append("\n");
                }


            } else if( e.getActionCommand().equals("Sent")){

                midContent.setText("   S  |" + "        Time         " +  "|   Phone number " + "   |" + " During\n" );

                for(int i=0 ; i < callData.size() ; i++) {

                    if ((callData.elementAt(i).getStatus_().equals("0"))) {
                        midContent.append(" -> ");
                        midContent.append(" "+callData.elementAt(i).getTime_() + " | ");
                        midContent.append(" "+callData.elementAt(i).getNumber_() + " | ");
                        midContent.append(" " + callData.elementAt(i).getDuration_() + "  ");
                        midContent.append("\n");
                    }
                }


            } else if( e.getActionCommand().equals("Received")) {
                midContent.setText("   S  |" + "        Time         " +  "|   Phone number " + "   |" + " During\n" );

                for(int i=0 ; i < callData.size() ; i++) {

                    if((callData.elementAt(i).getStatus_().equals("1"))) {
                        midContent.append(" <- ");
                        midContent.append(" "+callData.elementAt(i).getTime_() + " | ");
                        midContent.append(" "+callData.elementAt(i).getNumber_() + " | ");
                        midContent.append(" " + callData.elementAt(i).getDuration_() + "  ");
                        midContent.append("\n");
                    }


                }

            }  else if( e.getActionCommand().equals("Missed")) {
                midContent.setText("   S  |" + "        Time         " +  "|   Phone number " + "   |" + " During\n" );

                for(int i=0 ; i < callData.size() ; i++) {

                    if((callData.elementAt(i).getStatus_().equals("2"))) {
                        midContent.append("  ??? ");
                        midContent.append(" "+callData.elementAt(i).getTime_() + " | ");
                        midContent.append(" "+callData.elementAt(i).getNumber_() + " | ");
                        midContent.append(" " + callData.elementAt(i).getDuration_() + "  ");
                        midContent.append("\n");
                    }


                }

            }


        }
    }
}
