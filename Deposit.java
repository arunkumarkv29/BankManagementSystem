package System;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.* ;
public class Deposit extends JFrame implements ActionListener {

    JTextField amount ;
    JButton deposit, back ;
    String pinnumber ;

    Deposit(String pinnumber){
        this.pinnumber = pinnumber ;
        setLayout(null);
        //frame ke uper image lagane ke liye
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel image = new JLabel(i3) ;
        image.setBounds(0,0,900,900) ;
        add(image) ;

        JLabel text = new JLabel("Enter the amount you want to deposit") ;
        text.setFont(new Font("Raleway",Font.BOLD, 16)) ;
        text.setForeground(Color.white);
        text.setBounds(180,300,400,20);
        image.add(text) ;

        //textField chahiye jisse pata chalega ki kitna ammount depost karna hai

        amount = new JTextField() ;
        amount.setFont(new Font("Raleway",Font.BOLD, 22)) ;
        amount.setBounds(170, 350, 320,40);
        image.add(amount) ;

        deposit = new JButton("Deposit") ;
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit) ;

        back = new JButton("Back") ;
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back) ;

        setSize(900,900) ;
        setLocation(300,0) ;
        setVisible(true) ;
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            //kahan par deposit karna hai uske liye ek table bhi to banani padegi -->bank name se jisme pin, date,type and amount column hunge
            // us table me hisab rahega ki kitna transaction hua aur kitna deposit hua
            //now ab mujhe amount kitna dala hai to wo hume milega textfield se hi
            String number = amount.getText() ;
            //date bhi chahaiye jo ki Date class se mil jayega jo ki util package me hai
            Date date = new Date() ;
            // ab dekhna hai ki ammount kahi empty to nahi dala
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount");
            }
            else{
                //amount enter kiya hai to connection kholna hai database ke sath
                try{
                    Conn conn = new Conn() ;
                    //query run karenge
                    String query = "INSERT INTO bank VALUES('"+pinnumber+"', '"+date+"', 'Deposit' , '"+number+"')" ;
                    //actual me isko deposit bhi karna padega to uske liye dml command run karni padegi
                    conn.s.executeUpdate(query) ;
                    JOptionPane.showMessageDialog(null,"Rs " + number + " Deposited Successfully");
                    //is frame ko close karenge
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        else if(ae.getSource()==back){
//back button ke click par i want ki transaction page dubara open ho and pinnumber wapas bhejna hai
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
//transaction jo hoga wo pinnunber ke basis par hoga ki kon sa banda perticularly wo payment kar raha hai
    //deposit karte time bhi pinnumber mangenge lekin pin actually me withdraw ke time mangte hai

    //is class ko complete karne ke baad signup me thoda update
    //then Withdrawl class banegi jo same deposit ki tarha hogi to isi ko copy kar lenge
    public static void main(String[] args) {
        new Deposit("") ;
    }
}
