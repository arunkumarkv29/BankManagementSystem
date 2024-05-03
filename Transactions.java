package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit,ministatement,withdrawl,fastcash,balanceenquiry,pinchange,exit ;
    String pinnumber ;
    Transactions(String pinnumber){
        this.pinnumber  = pinnumber ;
        setLayout(null);
        //sabse pehle ATM ki image load karenge
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        //ab is image ko scale karna hoga
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT) ;//image class AWT package ke ander hoti hai
        // i2 ko wapas se ImageIcon me convert karna hoga
        ImageIcon i3 = new ImageIcon(i2) ;
        // i3 ko ab JLabel ke ander dalna hoga
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,900,900) ;
        add(image) ;

        JLabel text = new JLabel("Please select your Transaction") ;
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD,16)) ;  //Raleway bhi le sakte hai
        text.setBounds(210,300,700,35);
        //add(text) aagr likhenge to frame par to add kar dega but image ke uper add karna hai to image.add(text) ;
        image.add(text) ;

        deposit = new JButton("Deposit") ;
        //deposit.setFont(new Font("Raleway", Font.BOLD, 16));
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit) ;

        withdrawl = new JButton("Cash Withdrawl") ;
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl) ;

        fastcash = new JButton("Fast Cash") ;
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash) ;

        ministatement = new JButton("Mini Statement") ;
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement) ;

        pinchange = new JButton("Pin Change") ;
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange) ;

        balanceenquiry = new JButton("Balance Enquiry") ;
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry) ;

        exit = new JButton("Exit") ;
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit) ;

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);   // frame ke top par to white strip hoti hai wo hat jayegi,jisme frame cut wala option hota hai
        setVisible(true);  //setVisible last me hi likhna hota hai kyuki jo bhi iske baad change karenge ko visible nahi hunge
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            System.exit(0) ;  //frame band ho jayega
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            //setVisible(false);  yaha par hum atm wala page band ni karna chate but side me ministatement ka page aajaye
            new MiniStatement(pinnumber).setVisible(true); ;
        }
    }

    //move to login class taki signin par click karte hi ye wala page khule

    public static void main(String[] args) {
        new Transactions("") ;   //uper constructor me isliye code likhte hai kyuki class ka object banate hi constructor call hota hai
    }
}
