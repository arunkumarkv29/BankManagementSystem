package System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pinnumber ;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber ;
        setLayout(null) ;
        JLabel mini = new JLabel() ;    // isme abhi value nahi add kar rahe, baad me add karenge setText() ki help se jab baad me data milega
        add(mini) ;

        JLabel bankName = new JLabel("Indian Bank") ;
        bankName.setBounds(150,20,100,20);
        add(bankName) ;

        JLabel card = new JLabel() ;    //isme bhi value baad me dynamically add hogi abhi ni
        card.setBounds(20,80,300,20);
        add(card) ;

        JLabel balance  = new JLabel() ;    //value balance me baad me enter karwayenge uper try block me hi bal naam se
        balance.setBounds(20,400,300,20);
        add(balance) ;

        //card no. ko fetch karna hoga
        //cad no. nikalna hai to database me ek hit marni padegi
        try{
            Conn conn = new Conn() ;
            String query = "SELECT * FROM login WHERE pin = '"+pinnumber+"'" ;    //in place of '"+pinnumber+"' if we write '1234' then card no. print ho jayega pura
            ResultSet rs = conn.s.executeQuery(query) ;
            while(rs.next()){
                //setText() methos is used to set text in JLabel
                //card.setText("Card Number: " + rs.getString("CardNumber"));  // yaha pura card number print hoga
                //but apun ko chahiye ki pehle ke 4 digit print ho aur fir XXXX... and the last ke 4 Digit
                card.setText("Card Number: " + rs.getString("CardNumber").substring(0,4) + "XXXXXXXX" + rs.getString("CardNumber").substring(12,16));

            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        //ab mujhe sari transaction ko dikhana hai ki kitni hui hai
        // ab mujhe bank table me query marni hai

        try{
            Conn conn = new Conn( );
            int bal = 0 ;
            String query = "SELECT * FROM bank WHERE pin = '"+pinnumber+"'" ;
            ResultSet rs = conn.s.executeQuery(query) ;
            while(rs.next()){
                // mini me append karna hai over Write ni karna or setText(0 jo hai overwrite karta hai naki append
                // beech me text ke space ke liye html ke tags use kar sakte hai jaise ek to "<html>" or "&nbsp;"
                mini.setText(mini.getText() + "<html>" + rs.getString("date") +  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                //mini.getText() se jo bhi text mini me hai wo milega fir usme add karte rahenge
                // 5 bar &nbsp; ka matlab hai 5 spaces
                //isme mistakes ye hai <html> tag ko open kiya hua hai but close ni kiya or dusra br tag ni lagaya ko isko next line me break karega
                //<br> likhne se pehle jo print ho raha hau mini wo properly nahi likha hua hai

                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount")) ;
                    //rs.getString("amount") --> ye ek String hai aur balance Integer to typecast karna hoga
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

        //ek aur label lenge jo balance ko display karega--> card ke niche define kar diya hai





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
