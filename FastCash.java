package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date ;
public class FastCash extends JFrame implements ActionListener {
    JButton deposit,ministatement,withdrawl,fastcash,balanceenquiry,pinchange,exit ;  //sabhi buttons ke name change hunge withdraw ke hisab se
    // abhi Transaction wale names hi use kar rahe hai
    String pinnumber ;
    FastCash(String pinnumber){
        this.pinnumber  = pinnumber ;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT) ;//image class AWT package ke ander hoti hai
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,900,900) ;
        add(image) ;

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT") ;
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD,16)) ;  //Raleway bhi le sakte hai
        text.setBounds(210,300,700,35);
        //add(text) aagr likhenge to frame par to add kar dega but image ke uper add karna hai to image.add(text) ;
        image.add(text) ;

        deposit = new JButton("Rs 100") ;
        //deposit.setFont(new Font("Raleway", Font.BOLD, 16));
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit) ;

        withdrawl = new JButton("Rs 500") ;
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl) ;

        fastcash = new JButton("Rs 1000") ;
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash) ;

        ministatement = new JButton("Rs 2000") ;
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement) ;

        pinchange = new JButton("Rs 5000") ;
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange) ;

        balanceenquiry = new JButton("Rs 10000") ;
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry) ;

        exit = new JButton("Back") ;
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
            // Back jana hai
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        // else if na leke else hi lenge aur jo bhi button click hua hai uska text nikal ke
        // usme se Rs hata ke bas number leke usko bas withdraw me dikha denge
        else {
            //konsa button click hua hai wo ae.getSource() se pata chalta hai jo ki object return karta hai
            // to isko type cast karna padega JButton me--> JButton(ae.getSource())
            // or fir iska text uthana hai --> (JButton(ae.getSource())).getText()
            //but ye jo text ayega wo ayega Rs 500 ke form me , hume RS nahi chahiye sath me to iski substring nikalni hogi
            //--> (JButton(ae.getSource())).getText().substring(3) --> starting ke 3 letters(R,s, space) ko
            // minus karna hai--> 3 wo index hai jahan se String begum hogi
            String amount = ((JButton)ae.getSource()).getText().substring(3) ;
            //iske baad connection banayenge
            Conn conn  = new Conn() ;
            try{
                // sabse pehle ye check karna hai ki apke account me paise hai bhi ya nahi
                //to iske liye balance nikalna padega kitna hai account me
                // uske liye query marni padegi jo ResultSet return karti hai
                ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'") ;
                // ResultSet error dega kyuki ye sql package me hota hai to use import karna hoga
                // ab humare pass puri row aagayi jiska pin ye hoga
                //ab isme mujhe balance chahaiye to loop lagana hoga puri row par
                // loop lagane ke liye use hota hai rs.next()
                int balance = 0 ;
                while(rs.next()){
                    // us pinnumber ki jitni bhi rows ya transaction hai usme loop karenge aur
                    //deposit ya withdrawl ke type se balance find kar lenge
                    //ex - 6199 time deposit 1000
                    //     6199 time withdrwa 200
                    // balance = 800
                    // rs.next() ek ek row ko loop karne me madad karta hai
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount")) ;
                        //rs.getString("amount") --> ye ek String hai aur balance Integer to typecast karna hoga
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount")) ;
                    }
                }
                // ab balance aagaya, ab check karna hai ki balance amount se jyada hai ya kum
                //uske sath ye bhi check karna hoga ki kahi exit button to click nahi ho gaya
                if((ae.getSource() != exit && balance<Integer.parseInt(amount))){
                    JOptionPane.showMessageDialog(null, "Insufficient balance") ;
                    return ;  // yahi se return kar jayenge aur bas bhai ab aap transaction nahi kar sakte
                }
                // ab Date class ka object banayenge aur amount is transaction ko bank table me daal denge
                Date date = new Date() ;
                //Date class sql package me bhi hai aur util package me bhi to upper perticularly import karma hoga
                //import java.util.Date ;
                //kyuki import java.sql.* and import java.util.* me ambiquity ayegi ki konsa
                String query = "INSERT INTO bank VALUES('"+pinnumber+"', '"+date+"', 'Withdrawl' , '"+amount+"')" ;
                conn.s.executeUpdate(query) ;

                //iske baad message display karenge
                JOptionPane.showMessageDialog(null, "RS " + amount + " Debited Sucessfully") ;
                setVisible(false) ;
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    //move to login class taki signin par click karte hi ye wala page khule

    public static void main(String[] args) {
        new FastCash("") ;   //uper constructor me isliye code likhte hai kyuki class ka object banate hi constructor call hota hai
    }
}
