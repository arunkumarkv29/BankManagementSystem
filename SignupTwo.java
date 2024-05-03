package System;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField aadhartextField,pantextField   ;
    JButton next ;
    JRadioButton scyes, scno,  eayes, eano ;
    JComboBox religionbox, categorybox, incomebox , qualificationbox, occupationbox ;
    String formno ;
//    SignupTwo(String formno){   // niche wale constructor me bhi String daal sakte hai but main me bhi fir jab Object
//        this.formno = formno ;   // banaya hai usme bhi fir empty String pass karna hoga
//    }
    String getFormno ;
    SignupTwo(String formno){
        this.formno = formno ;
        setLayout(null) ;
        setTitle("NEW ACCOUNT APPLICATION FORM -- PAGE 2") ;

        JLabel AdditonalDetails = new JLabel("Page 2: Additional Details") ;
        AdditonalDetails.setFont(new Font("Raleway", Font.BOLD,22)) ;
        AdditonalDetails.setBounds(280,80,400,30) ;
        add(AdditonalDetails) ;

        JLabel religion = new JLabel("Religion:") ;
        religion.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        religion.setBounds(100, 140, 100,30);
        add(religion) ;

        // Regilion ke aage Drop Down button chahiye
        // dropdown aata hai combobox class se jiske ander Array of String pass karni hoti hai
        String [] valreligion = {"Hindu", "Muslim", "Sikh" , "Christian", "other"} ;
        religionbox = new JComboBox(valreligion) ;
        religionbox.setBounds(300,140,400,30) ;
        add(religionbox) ;



        JLabel category = new JLabel("Category:") ;
        category.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        category.setBounds(100, 190, 200,30);
        add(category) ;

        String [] valcategory = {"General" , "OBC" , "SC" , "ST" , "other"} ;
        categorybox = new JComboBox(valcategory) ;
        categorybox.setBounds(300,190,400,30) ;
        add(categorybox) ;


        JLabel income = new JLabel("Income:") ;
        income.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        income.setBounds(100, 240, 200,30);
        add(income) ;

        String [] valincome = {"null" , "<1,50,000" , "<2,50,000" , "<5,00,000" , "upto 10,00,000"} ;
        incomebox = new JComboBox(valincome) ;
        incomebox.setBounds(300,240,400,30) ;
        add(incomebox) ;


        JLabel educational = new JLabel("Educational") ;
        educational.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        educational.setBounds(100, 300, 200,30);
        add(educational) ;

        JLabel qualification = new JLabel("Qualification:") ;
        qualification.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        qualification.setBounds(100, 320, 200,30);
        add(qualification) ;

        String [] valqualification = {"Non-Graduation" , "Graduate" , "Post Graduation" , "Doctrate" , "others"} ;
        qualificationbox = new JComboBox(valqualification) ;
        qualificationbox.setBounds(300,320,400,30) ;
        add(qualificationbox) ;


        JLabel occupation = new JLabel("Occupation:") ;
        occupation.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        occupation.setBounds(100, 390, 200,30);
        add(occupation) ;

        String [] valoccupation = {"Salaried" , "Self-Employed" , "Bussiness" , "Student" , "Retired" , "others"} ;
        occupationbox = new JComboBox(valoccupation) ;
        occupationbox.setBounds(300,390,400,30) ;
        add(occupationbox) ;

        JLabel pan = new JLabel("PAN Number:") ;
        pan.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        pan.setBounds(100, 440, 200,30);
        add(pan) ;

        pantextField = new JTextField() ;
        pantextField.setFont(new Font("Raleway", Font.BOLD ,14)) ;
        pantextField.setBounds(300,440,400,30) ;
        add(pantextField) ;

        JLabel aadhar = new JLabel("Aadhar Number:") ;
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        aadhar.setBounds(100, 490, 200,30);
        add(aadhar) ;

        aadhartextField = new JTextField() ;
        aadhartextField.setFont(new Font("Raleway", Font.BOLD ,14)) ;
        aadhartextField.setBounds(300,490,400,30) ;
        add(aadhartextField) ;


        JLabel seniorcitizen = new JLabel("Senior Citizen:") ;
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        seniorcitizen.setBounds(100, 540, 200,30);
        add(seniorcitizen) ;

        scyes = new JRadioButton("Yes") ;
        scyes.setBounds(300, 540, 100,30) ;
        scyes.setBackground(Color.WHITE);
        add(scyes) ;

        scno = new JRadioButton("No") ;
        scno.setBounds(450, 540, 100,30) ;
        scno.setBackground(Color.WHITE);
        add(scno) ;

        ButtonGroup scbuttongroup = new ButtonGroup() ;
        scbuttongroup.add(scyes) ;
        scbuttongroup.add(scno) ;

        JLabel existingaccount = new JLabel("Existing Account:") ;
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        existingaccount.setBounds(100, 590, 200,30);
        add(existingaccount) ;

        eayes = new JRadioButton("Yes") ;
        eayes.setBounds(300, 590, 100,30) ;
        eayes.setBackground(Color.WHITE);
        add(eayes) ;

        eano = new JRadioButton("No") ;
        eano.setBounds(450, 590, 100,30) ;
        eano.setBackground(Color.WHITE);
        add(eano) ;

        ButtonGroup aebuttongroup = new ButtonGroup() ;
        aebuttongroup.add(eayes) ;
        aebuttongroup.add(eano) ;



        next = new JButton("Next") ;
        next.setBackground(Color.BLACK);
        next.setForeground(Color.BLACK);
        next.setBounds(600, 700, 100,30) ;
        next.addActionListener(this);
        add(next) ;

        getContentPane().setBackground(Color.WHITE);
        setSize(850,820) ;
        setLocation(350,0) ;
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        // dropdown button se data extract karne ke liye getSelectedItem() function ka use kar sakte hai
        String sreligion = (String)religionbox.getSelectedItem() ;   // but ye object me retrun karta hai to ise typecast karna hoga string me
        String scategory = (String)categorybox.getSelectedItem() ;
        String sincome = (String)incomebox.getSelectedItem() ;
        String squalification = (String)qualificationbox.getSelectedItem() ;
        String soccupation = (String)occupationbox.getSelectedItem() ;
        String span = pantextField.getText() ;
        String saadhar = aadhartextField.getText() ;

        String scstatus = null ;
        if(scyes.isSelected()){
            scstatus = "Yes" ;
        }
        else if(scno.isSelected()){
            scstatus = "No" ;
        }

        String eastatus = null ;
        if(eayes.isSelected()){
            eastatus = "Yes" ;
        }
        else if(eano.isSelected()){
            eastatus = "No" ;
        }

        try{
            // ab in values ko database me enter karna hai
            if(span.equals("")){
                JOptionPane.showMessageDialog(null,"pan is Required");

            }
            else{
                //perticularly kis user ka data hai wo to bhi pata hona chahiye to uske liye signupOne ka formno yaha
                //primary key ka kaam karega
                //go to signupOne and usko frame ko next par click hote hi close karna hai and formno ko waha se yaha pass karna
                //hai hai object bana ke aur yaha constructor bana ke
                //go to signupOne try block
                Conn c = new Conn() ;
                String query = "INSERT INTO signuptwo VALUES('"+formno+"' , '"+sreligion +"' ,'"+scategory +"' ,'"+sincome +"' ,'"+squalification +"' ,'"+soccupation +"' ,'"+span +"' ,'"+saadhar +"' , '"+scstatus +"' ,'"+eastatus +"' )" ;
                c.s.executeUpdate(query) ;

                //signup3 object
                setVisible(false);  //current class ka frame band ho
                new SignupThree(formno).setVisible(true) ;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new SignupTwo("") ;
    }
}
