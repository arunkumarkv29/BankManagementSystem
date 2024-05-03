package System;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber ;
    JButton back ;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber ;

        setLayout(null) ;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,900,900);
        add(image) ;

        back = new JButton("Back") ;
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back) ;


        Conn conn = new Conn() ;
        int balance = 0 ;
        try{
            String query = "SELECT * FROM bank where pin = '"+pinnumber+"'" ;  //ye sari rows de dega jiska pin ye hoga
            ResultSet rs = conn.s.executeQuery(query) ;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount")) ;
                }
                else if(rs.getString("type").equals("Withdrawl")){
                    balance -= Integer.parseInt(rs.getString("amount")) ;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your current Account balance is Rs "+ balance) ;
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        image.add(text) ;

        setSize(900,900) ;
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        //ek hi button hai to koi dikkat ni
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("") ;
    }
}
