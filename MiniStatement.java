package System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinnumber ;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber ;
        setLayout(null) ;
        JLabel mini = new JLabel() ;
        add(mini) ;

        JLabel bankName = new JLabel("Indian Bank") ;
        bankName.setBounds(150,20,100,20);
        add(bankName) ;

        JLabel card = new JLabel() ;
        card.setBounds(20,80,300,20);
        add(card) ;

        JLabel balance  = new JLabel() ;
        balance.setBounds(20,400,300,20);
        add(balance) ;


        try{
            Conn conn = new Conn() ;
            String query = "SELECT * FROM login WHERE pin = '"+pinnumber+"'" ;    //in place of '"+pinnumber+"' if we write '1234' then card no. print ho jayega pura
            ResultSet rs = conn.s.executeQuery(query) ;
            while(rs.next()){

                card.setText("Card Number: " + rs.getString("CardNumber").substring(0,4) + "XXXXXXXX" + rs.getString("CardNumber").substring(12,16));

            }
        }
        catch(Exception e){
            System.out.println(e);
        }


        try{
            Conn conn = new Conn( );
            int bal = 0 ;
            String query = "SELECT * FROM bank WHERE pin = '"+pinnumber+"'" ;
            ResultSet rs = conn.s.executeQuery(query) ;
            while(rs.next()){

                mini.setText(mini.getText() + "<html>" + rs.getString("date") +  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount")) ;
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount")) ;
                }
            }
            balance.setText("Your current account balance is Rs: " + bal);
        }
        catch(Exception e){
            System.out.println(e);
        }

        mini.setBounds(20,140,400,200);

        setTitle("Mini Statement");

        setSize(400,600) ;
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("") ;
    }
}
