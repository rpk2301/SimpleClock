//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;
import java.util.Timer;


public class SimpleClock extends JFrame {
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
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
            twentyfourhourbutton = new JButton("Switch to 24 Hour Mode");
            twelvefourhourbutton = new JButton("Switch to 12 Hour Mode");
            twentyfourhourbutton.setBounds(50,150,100,30);
            twelvefourhourbutton.setBounds(50,150,100,30);
            twentyfourhourbutton.addActionListener(new ActionListener() {
                                                       @Override
                                                       public void actionPerformed(ActionEvent e) {
                                                           System.out.println("I was clicked!");
                                                           timeFormat = new SimpleDateFormat("HH:mm:ss");
                                                       }
                                                   });

            twelvefourhourbutton.addActionListener(new ActionListener() {
                                                       @Override
                                                       public void actionPerformed(ActionEvent e) {
                                                           System.out.println("I was clicked!");
                                                           timeFormat = new SimpleDateFormat("hh:mm:ss");
                                                       }
                                                   });


            twelvefourhourbutton.setBounds(50,150,100,30);
            twentyfourhourbutton.setBounds(50,150,100,30);

            timeFormat = new SimpleDateFormat("hh:mm:ss a");
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
