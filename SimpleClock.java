//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.TimerTask;
import java.util.Timer;


public class SimpleClock extends JFrame {
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
        String pattern = "hh:mm:ss";

        SimpleDateFormat dayFormat;

        SimpleDateFormat dateFormat;
    
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        JButton twentyfourhourbutton;
        JButton twelvefourhourbutton;
        String time;
        String day;
        String date;

        SimpleClock() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setBackground(Color.BLACK);
            this.setForeground(Color.BLACK);
            this.setSize(400, 200);
            this.setResizable(false);

            twentyfourhourbutton = new JButton("Switch Time Mode");
            twelvefourhourbutton = new JButton("Switch to GMT or Local Time");
            twentyfourhourbutton.setBounds(50,150,100,30);
            twelvefourhourbutton.setBounds(50,150,100,30);
            twentyfourhourbutton.addActionListener(new ActionListener() {
                private int clicked =2;
                                                       @Override
                                                       public void actionPerformed(ActionEvent e) {
                                                           if (clicked%2==0) {
                                                               timeFormat.applyPattern("HH:mm:ss");
                                                               clicked++;
                                                           }
                                                           else if (clicked%2!=0) {
                                                               timeFormat.applyPattern("hh:mm:ss");
                                                               clicked++;
                                                           }
                                                       }
                                                   });

            twelvefourhourbutton.addActionListener(new ActionListener() {

                                                        private int clicked = 2;


                @Override

                                                       public void actionPerformed(ActionEvent e) {
                                                           if(clicked%2==0){
                                                           timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                                                           clicked++;
                                                       } else if (clicked%2!=0) {
                                                            timeFormat.setTimeZone(Calendar.getInstance().getTimeZone());
                                                            clicked++;
                                                           }
                                                       }
                                                   });


            twelvefourhourbutton.setBounds(50,150,100,30);
            twentyfourhourbutton.setBounds(50,150,100,30);
            timeFormat = new SimpleDateFormat(pattern);

            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("MONOSPACED", Font.BOLD, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.GREEN);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("MONOSPACED",Font.ITALIC,30));
            dayLabel.setForeground(Color.RED);
            dayLabel.setBackground(Color.BLACK);
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("MONOSPACED",Font.ITALIC,25));
            dateLabel.setBackground(Color.RED);
            dateLabel.setForeground(Color.RED);
    
    
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            this.add(twentyfourhourbutton);
            this.add(twelvefourhourbutton);
            this.setVisible(true);
    
            setTimer();
        }



        public void setTimer() {

                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);
    
                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);
    
                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
    
                try {
                    Thread.sleep(1000);
                    setTimer();
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }

        public static void main(String[] args) {
            new SimpleClock();
        }
    }
