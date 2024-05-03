package System;

import javax.swing.*;  // since java ke extended package se aata hai to javax
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    //50. defining JButton globally ;
    JButton login, clear, signup ;
    JTextField cardTextField ;  //, pinTextField ;
    JPasswordField pinTextField ;
    Login(){
        // 7.setTitle se frame ke title ko set kar sakte hai
        setTitle("Automated Teller Machine") ;
        //8.ab icon ko paste karne ke liye file(icon) ko mac ke project wale folder me paste kar denge
        //9.icon ka package automatically create ho jayega
        //10.image lagane ke liye class use hoti hai--> ImageIcon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")) ;
        //11.icon ko directly frame ke uper nahi daal sakte to use JLabel ke ander dalna hoga

        //16. image ko scale karne ke liye image class ka object banana padega
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT)  ;
        // i1 me se image get karke uska scale set
        //17.Image class swing ke package me nahi hoti, awt ke package me hoti hai
        //18. ImageIcon(i1) ko JLabel ke ander daal sakte hai but Image(i2) ko nahi
        //19.iska solution ye hai ki Image ko wapas se ImageIcon me change karna padega
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel label = new JLabel(i3) ;
        //20.but image mujhe center me nahi chahiye
        //21. frame ke uper image ki location change karni hai to uske liye function hota hai setBound()
        //22.kis ki location ko change karna hai--> "label" ki
        //23. setBounds() takes 4 input-->(a)distance from left, (b) top, (c) jis image ko set kar rahe hai
        // 24. uski height , (d) and uski width( jo humne 100,100 uper bhi set ki hai)
        label.setBounds(70,10,100,100);
        //25.but abhi bhi left me shift nahi hua hai, bcoz java me by default layout hote hai jinhe hume null karna hoga
        //26.setBounds() lagane ke baad bhi default layout to lagayega hi java to null karna padega
        setLayout(null);  // isko sapse pehli line me likhna better hoga, baki JLabel ke liye bhi null hi rahega
        //27.ab frame ka color chnage karne ke liye pure frame ko uthana padega getContentPane() ki madad se
        //28.aur iske ander hota hai setBackground() method
        getContentPane().setBackground(Color.white);
        //29.ab logo ke aage welcome to the ATM label lagana hai
        //30.frame ke uper agar kuch bhi likhna hai to uske likh sakte hai JLabel ki help se
        JLabel text = new JLabel("Welcome To ATM")  ;
        text.setBounds(200,40,400,40);   // image ke just aage se chahiye
        //32. font change karne ke liye text par setFont() method ke ander Font class ka object banana padta hai
        text.setFont(new Font("Osward",  Font.BOLD, 38)) ;
        // 33.uper setBouunds me label ki length 100 se 400 karni padegi
        add(text) ;
        //31. isko dikhane ke liye setBounds() karna padega above add(text)

        //34. same above label ki tarha e label aur banane hai
        JLabel cardno = new JLabel("Card No:") ;
        cardno.setBounds(120,150, 150,30);   // uper se 40+40 ho chuka hai to 80 se jyada hoga y(top distance)
        cardno.setFont(new Font("Raleway", Font.BOLD, 28)) ;
        add(cardno) ;

        JLabel pin = new JLabel("PIN:") ;
        pin.setBounds(120,220, 250,30);
        pin.setFont(new Font("Raleway", Font.BOLD, 28)) ;
        add(pin) ;
        //35.cardno and PIN ke aage box Chahiye jahan user entry kar sakta hai
        //36. wo hum daal sakte hai JTextField ki help se
        //JTextField cardTextField = new JTextField() ;  // define globally
        cardTextField = new JTextField() ;
        cardTextField.setBounds(300,150,230,30) ;
        // to change the text size and type
        cardTextField.setFont(new Font("Ariel", Font.BOLD, 14));
        add(cardTextField) ;

        //JTextField pinTextField = new JTextField() ;
        //pinTextField = new JTextField() ;
        pinTextField = new JPasswordField() ;
        pinTextField.setBounds(300,220,230,30) ;
        pinTextField.setFont(new Font("Ariel", Font.BOLD, 14));
        add(pinTextField) ;

        //37. 3 button bhi banane hai, signup, clear, signin ke jiske liye JButton class hoti hai
        //JButton login = new JButton("SIGN IN") ;
        login = new JButton("SIGN IN") ;
        login.setBounds(300,300,100,30);
        //38.  to change the background color of button
        login.setBackground(Color.BLACK) ;
        login.setForeground(Color.BLACK) ; // black ke uper white text
        //44. adding addActionlistner() function
        login.addActionListener(this);
        add(login) ;

        //JButton clear = new JButton("CLEAR") ;
        clear = new JButton("CLEAR") ;
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK) ;
        clear.setForeground(Color.BLACK) ;
        //45. adding addActionlistner() function
        clear.addActionListener(this);
        add(clear) ;

        //JButton signup = new JButton("SIGN UP") ;
        signup = new JButton("SIGN UP") ;
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK) ;
        signup.setForeground(Color.BLACK) ;
        //46. adding addActionlistner() function
        signup.addActionListener(this);  // 47. ab agar button par click karunga to mujhe bata dega ki button par click hua hai
        add(signup) ;

        //39. in buttons ke piche actions add karne ke liye "ActionListener" class ko implement karna padega
        //40. ActionListener class java.awt.event. package me hota hai wo import karna padega java.awt.event


        //11(a)--> JLabel label = new JLabel(i1) ;
        //12.jab bhi kisi component ko frame ke uper paste karna hota hai "add()" function ka use karna hota hai
        //14.add(.....) ke ander label ke object ko pass kar denge
        add(label) ;
        //15. but i want ki icon itna bada na aaye to image to scale karna padega


        //1. sabse pehle frame banana hai to function use hoga setSize()
        setSize(800,480) ;
        //2. frame bangaya hai but abhi dikhega nahi kyuki frame
        // 3. user ki visibility se hidden hota hai to ise hume setVisibile true karna hota hai
        setVisible(true) ;
        // 4.but abhi left top corner par ayenga frame
        // 5.setLocation(left se distance,top se distance) use center ya kisi
        // 6.aur jagha se kholne ke liye
        setLocation(350,200) ;
    }
    // button ke piche action Listener lagana hai
    public void actionPerformed(ActionEvent ae) {  //ActionListener ko overide
        //41. button par action lagane ke liye ek function lagana padega --> addActionlistener() button ke event ko catch karne ke liye
        //42. ye function batayega ki button par click hua hai
        //43. addActionListener uper sabhi JButton me lagana padega
        //48. button click ke baad kya action perform hoga wo yaha likhna hau
        //49.  button chahiye ki konse button(signin,signup,clear) par click hua hai bht ye sari locally define hai to
        // inhe globally define karna hoga ;
        //51. ab dekhna hai ki konsa button click hua hai--> iske liye use hoga ActionEvent class ka
        //52. ActionEvent ke under hoga hai getSource() jo batata hai ki jo button click hua hai konsa hai, source konsa hai uska
        if(ae.getSource()==clear){
            // text field empty hojani chahiye
            // text field bhi locally define hai to globally define karna hoga
            cardTextField.setText("") ;  // "" ke ander jo text likhenge wo un JtextFielf me print hoga jaise hi clear par click hoga
            pinTextField.setText("") ;
            //53. agar chahiye ki password dikhayi na de to JTextField ki jagha JPasswordField use karna hai

        }
        else if(ae.getSource()==login){
            //after signupThree class
            Conn conn = new Conn() ;
            String cardnumber = cardTextField.getText() ;
            String pinnumber = pinTextField.getText() ;

            // ab hum data ko SQL table se nikal ke layenge
            //pehle insert wali query chalai thi ab SELECT wali query chalayenge
            String query = " SELECT * FROM login WHERE CardNumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
            //pehla CardNumber table ka column hai and dusra cardnumber above String
            //abhi bas query banayi hai execute ke liye command hoti hai executeQuery() ;  naki executeUpdate() kyuki
            //executeQuery() DDL command hai and executeUpdate() DML command

            try{
                ResultSet rs =  conn.s.executeQuery(query) ;    //ye execute hogi to kuch data return hoga aur us data ko store kara sakte hai
                // ResultSet ke object me
                //basically ye ek ResultSet ko return karta hai, i.e., type of data iska ResultSet hota hai
                //ResultSet class sql package ke ander hoti hai
                if(rs.next()){   //matlab kya data nikal ke aaya hai
                    setVisible(false);  //current frame ko close karenge
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    //agar data match nahi hua hai to dialogbox ayega
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin ");

                    //ab mujhe aage pin nahi chahiye to pinnumber ko aage forward kar raha hu
                    //to transaction class ke ander pinnumber daal diya
                }

            }
            catch(Exception e){
                System.out.println(e);
            }


        }
        else if(ae.getSource()==signup){
            // 54. iske liye nayi class banayenge jisme click karte hi alg alg pages khulenge
            // 3 page hai signup click ke baad to pehli class signipOne ke naam se create hogi and so on...
            //current frame close hona chahiye aur signup wala frame khulna chahiye
            // current frame ko close karne ke liye setVisibile for false kardenge
            setVisible(false);
            // signup frame kholna hai--> Signup class ka object banayenge
            new SignupOne().setVisible(true);  // object banate hi constructor call hoga

        }
    }
    //55. SignupTwo class banayenge, signupOne me next par click karne ke baad jo page khulega

    public static void main(String[] args) {
        new Login() ;
        // object banate hi constructor call hota hai to sara code constructor ke ander
        // hoga uper login ke
    }

}
