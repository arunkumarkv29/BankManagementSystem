package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton sa, fda, ca, rda ;
    JCheckBox c1,c2,c3,c4,c5,c6,c7 ;
    JButton submit, cancel ;
    String formno ;
    SignupThree(String formno){
        this.formno = formno ;
        setLayout(null) ;
        JLabel l1 = new JLabel("Page 3: Additional Details") ;
        l1.setBounds(280,40, 400,40);
        l1.setFont(new Font("Raleway", Font.BOLD , 22)) ;
        add(l1) ;

        JLabel accounttype = new JLabel("Account Type") ;
        accounttype.setBounds(100,140, 200,30);
        accounttype.setFont(new Font("Raleway", Font.BOLD , 22)) ;
        add(accounttype) ;

        sa = new JRadioButton("Saving Account") ;
        sa.setBounds(100, 180, 200, 20);
        sa.setFont(new Font("Raleway", Font.BOLD, 15)) ;
        add(sa) ;

        fda = new JRadioButton("Fixed Deposit Account") ;
        fda.setBounds(350, 180, 300, 20);
        fda.setFont(new Font("Raleway", Font.BOLD, 15)) ;
        add(fda) ;

        ca = new JRadioButton("Current Account") ;
        ca.setBounds(100, 220, 200, 20);
        ca.setFont(new Font("Raleway", Font.BOLD, 15)) ;
        add(ca) ;

        rda = new JRadioButton("Recurring Deposit Account") ;
        rda.setBounds(350, 220, 300, 20);
        rda.setFont(new Font("Raleway", Font.BOLD, 15)) ;
        add(rda) ;

        ButtonGroup accounttypegroup = new ButtonGroup() ;
        accounttypegroup.add(sa) ;
        accounttypegroup.add(fda) ;
        accounttypegroup.add(ca) ;
        accounttypegroup.add(rda) ;

        JLabel cardnumber = new JLabel("Card Number") ;
        cardnumber.setBounds(100,300, 200,30);
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 22)) ;
        add(cardnumber) ;

        JLabel cardnumberdigit = new JLabel("XXXX-XXXX-XXXX-4136") ;
        cardnumberdigit.setBounds(330,300, 300,30);
        cardnumberdigit.setFont(new Font("Raleway", Font.BOLD, 22)) ;
        add(cardnumberdigit) ;

        JLabel belowcardno = new JLabel("Your 16 Digit Card Number") ;
        belowcardno.setBounds(100,330, 200,20);
        belowcardno.setFont(new Font("Raleway", Font.BOLD, 12)) ;
        add(belowcardno) ;

        JLabel pin = new JLabel("PIN") ;
        pin.setBounds(100,370, 200,40);
        pin.setFont(new Font("Raleway", Font.BOLD, 22)) ;
        add(pin) ;

        JLabel belowpin = new JLabel("Your 4 Digit Password") ;
        belowpin.setBounds(100,400, 200,20);
        belowpin.setFont(new Font("Raleway", Font.BOLD, 12)) ;
        add(belowpin) ;

        JLabel pindigit = new JLabel("XXXX") ;
        pindigit.setBounds(330,370, 300,30);
        pindigit.setFont(new Font("Raleway", Font.BOLD, 22)) ;
        add(pindigit) ;

        JLabel servicerequired = new JLabel("Services Required:") ;
        servicerequired.setBounds(100,450, 250,30);
        servicerequired.setFont(new Font("Raleway", Font.BOLD, 22)) ;
        add(servicerequired) ;

        //tickmark wale checkbox hote hai
        c1 = new JCheckBox("ATM CARD") ;
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD, 16)) ;
        c1.setBounds(100,500,200,30);
        add(c1) ;

        c2 = new JCheckBox("Internet Banking") ;
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD, 16)) ;
        c2.setBounds(350,500,200,30);
        add(c2) ;

        c3 = new JCheckBox("Mobile Banking") ;
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD, 16)) ;
        c3.setBounds(100,550,200,30);
        add(c3) ;

        c4 = new JCheckBox("EMAIL & SMS Alert") ;
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD, 16)) ;
        c4.setBounds(350,550,200,30);
        add(c4) ;

        c5 = new JCheckBox("Cheque Book") ;
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD, 16)) ;
        c5.setBounds(100,600,200,30);
        add(c5) ;

        c6 = new JCheckBox("E-Statement") ;
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD, 16)) ;
        c6.setBounds(350,600,200,30);
        add(c6) ;

        c7 = new JCheckBox("I hereby declares that entered details are corrected to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD, 12)) ;
        c7.setBounds(100,680,600,30);
        add(c7) ;

        submit = new JButton("Submit") ;
        submit.setBackground(Color.black);
        submit.setForeground(Color.black);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250,720, 100,30);
        submit.addActionListener(this);   //this-->means is button ke click par mujhe action chahiye
        add(submit) ;

        cancel = new JButton("Cancel") ;
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.black);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,720, 100,30);
        cancel.addActionListener(this);
        add(cancel) ;

        getContentPane().setBackground(Color.WHITE);
        setSize(850,820) ;
        setLocation(350,0) ;
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            //sa, fda, ca, rda
            String accountType = null ;
            if(sa.isSelected()){
                accountType = "Saving Account" ;
            }
            else if(fda.isSelected()){
                accountType = "Fixed Deposit Account" ;
            }
            else if(ca.isSelected()){
                accountType = "Current Account" ;
            }
            else if(rda.isSelected()){
                accountType = "Recurring Deposit Account" ;
            }

            // 16 digit ka card no. generate karenge--> Random class ka use karenge
            Random random = new Random() ;  // java.util.* package me hai
            //long cardnumber = Math.abs((random.nextLong() % 90000000L) + 5040936000000000L) ; //nextLong kyuli 16 digit lamba no. hai
            // + ke baad jo no. hai likha hai isliye ki mujhe chahiye ki starting ke ye digit sabme same rahe last ke 8 zeros hata ke
            // i.e., 50409360

            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L) ;
            String pinnumber = ""+ Math.abs((random.nextLong() % 9000L)+1000L) ;

            String facility = "" ;
            if(c1.isSelected()){
                facility = facility+ " ATM CARD" ;
            }
            else if(c2.isSelected()){
                facility = facility+ " Internet Banking" ;
            }
            else if(c3.isSelected()){
                facility = facility+ " Mibile Banking" ;
            }
            else if(c4.isSelected()){
                facility = facility+ " EMAIL & SMS Alert" ;
            }
            else if(c5.isSelected()){
                facility = facility+ " Cheque Book" ;
            }
            else if(c6.isSelected()){
                facility = facility+ " E-Statement" ;
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required") ;
                }
                else{
                    Conn conn = new Conn() ;
                    String query1 = "INSERT INTO signupthree VALUES('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')" ;
                    String query2 = "INSERT INTO login VALUES('"+formno+"','"+cardnumber+"','"+pinnumber+"')" ;
                    conn.s.executeUpdate(query1) ;
                    conn.s.executeUpdate(query2) ;

                    //sql me table bana di
                    // ab user ko bhi to batana hai ki bhai tera card no. and pin kya hai
                    //uske liye JOptionPane ka use hoga
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);
                    //login table bhi banayenge sql me kyuki main ni chata ki main signupthree table se data pick karu login karwane ke liye
                    // isi liye query2 bhi uper likhenge aur use login table me store karenge

                    /*
                    below line is after Depost frame
                    -jaise hi submit button par click ho Deposit wala frame open ho kyuki 0 account se withdraw
                    nahi hoga ko kuch ammount deposit karna hoga
                    -jaise hi submit par click ho current frame close ho

                     */
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }


        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            //aur login page khulna chahiye
            new Login().setVisible(true); ;
        }
    }

    public static void main(String[] args) {
        new SignupThree("") ;
    }

}
