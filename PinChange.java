package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    //JTextField pin, repin ;  ye sab user ko visible nahi honi chahiye to JPasswordField use karenge
    JPasswordField pin,repin ;
    JButton change, back ;
    String pinnumber ;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber ;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,900,900);
        add(image) ;

        JLabel text = new JLabel("CHANGE YOUR PIN") ;
        text.setBounds(250,280,500,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16)) ;
        image.add(text) ;

        JLabel pintext = new JLabel("New Pin: ");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD,16)) ;
        pintext.setBounds(165,320,180,25);
        image.add(pintext) ;

        pin = new JPasswordField() ;
        pin.setBounds(330,320,180,25);
        image.add(pin) ;

        JLabel repintext = new JLabel("Re-Enter New Pin:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD,16)) ;
        repintext.setBounds(165,360,180,25);
        image.add(repintext) ;

        repin = new JPasswordField() ;
        repin.setBounds(330,360,180,25);
        image.add(repin) ;

        change = new JButton("Change") ;
        change.setBounds(355,485, 150,30);
        //change.setFont(new Font("Raleway", Font.BOLD, 16));
        change.addActionListener(this);
        image.add(change) ;

        back = new JButton("Back") ;
        back.setBounds(355,520, 150,30);
        //back.setFont(new Font("Raleway", Font.BOLD, 16)) ;
        back.addActionListener(this);
        image.add(back) ;

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                //dono text filed se text nikal lenge
                String npin = pin.getText() ;
                String rpin = repin.getText() ;
                //check ki dono me same text dala hai ki nahi
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered pin does not match");
                    return ;
                }
                //check ki kahi empty to nahi hai dono textField
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new pin");
                    return ;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-enter new pin");
                    return ;
                }
                //dono check ke baad database ke sath connection khol sakte hai aur pin ko database me update kar sakte hai

                Conn conn = new Conn() ;
                //pin ka iuse 3 table me ho raha hai database me-->login, signupthree, and bank table me
                //to teeno jagha update karna hoga to 3 query banegi
                //String query1 = "UPDATE bank SET pin = '"+rpin+"' " ; //agar sirf itni command chalai to har jagha change kar dega
                String query1 = "UPDATE bank SET pin = '"+rpin+"' WHERE pin = '"+pinnumber+"' " ;
                //jahan pin pinnunber se match karta hai usko rpin se update kardo
                String query2 = "UPDATE login SET pin = '"+rpin+"' WHERE pin = '"+pinnumber+"' " ;
                String query3 = "UPDATE signupthree SET pin = '"+rpin+"' WHERE pin = '"+pinnumber+"' " ;

                //teeno query ko execute karna hoga

                conn.s.executeUpdate(query1) ;   //DML command hai
                conn.s.executeUpdate(query2) ;
                conn.s.executeUpdate(query3) ;

                JOptionPane.showMessageDialog(null,"PIN changed sucessfully");

                setVisible(false) ;
                new Transactions(rpin).setVisible(true) ;

            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("") ;
    }
}

