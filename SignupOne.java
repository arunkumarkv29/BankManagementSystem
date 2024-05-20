package System;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.* ;
import com.toedter.calendar.JDateChooser ;
public class SignupOne extends JFrame implements ActionListener {
    long Random ;
    JTextField nametextField, fnametextField,emailtextField,addresstextField,citytextField, statetextField, pincodetextField ;
    JButton next ;
    JRadioButton male, female, others, married, unmarried ;
    JDateChooser dateChooser ;
    Long random ;
    SignupOne(){
        setLayout(null) ;
        Random ran = new Random() ;

        random = Math.abs(ran.nextLong()%9000L + 1000L) ;
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random) ;
        formno.setFont(new Font("Raleway", Font.BOLD,38)) ;
        formno.setBounds(140,20,600,40) ;
        add(formno) ;

        JLabel PersonalDetails = new JLabel("Page 1: Personal Details") ;
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD,22)) ;
        PersonalDetails.setBounds(280,80,400,30) ;
        add(PersonalDetails) ;

        JLabel name = new JLabel("Name:") ;
        name.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        name.setBounds(100, 140, 100,30);  //140+30--> 20 20 ka gap rakhenge
        add(name) ;

        nametextField = new JTextField() ;
        nametextField.setFont(new Font("Raleway", Font.BOLD ,14)) ;
        nametextField.setBounds(300,140,400,30) ;
        add(nametextField) ;

        JLabel fname = new JLabel("Father's Name:") ;
        fname.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        fname.setBounds(100, 190, 200,30);
        add(fname) ;

        fnametextField = new JTextField() ;
        fnametextField.setFont(new Font("Raleway", Font.BOLD ,14)) ;
        fnametextField.setBounds(300,190,400,30) ;
        add(fnametextField) ;

        JLabel dob = new JLabel("Date of Birth:") ;
        dob.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        dob.setBounds(100, 240, 200,30);
        add(dob) ;
        //import com.toedter.calendar.JDateChooser
        dateChooser = new JDateChooser() ;
        dateChooser.setBounds(300, 240,400,30) ;
        // to change the text color for DOB in box
        //dateChooser.setForeground(Color.BLUE);
        add(dateChooser) ;

        JLabel gender = new JLabel("Gender:") ;
        gender.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        gender.setBounds(100, 290, 200,30);add(gender) ;
        male = new JRadioButton("Male") ;
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male) ;

        female = new JRadioButton("Female") ;
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female) ;

        ButtonGroup gendergroup = new ButtonGroup() ;
        gendergroup.add(male) ;
        gendergroup.add(female) ;

        JLabel email = new JLabel("Email Address:") ;
        email.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        email.setBounds(100, 340, 200,30);
        add(email) ;

        emailtextField = new JTextField() ;
        emailtextField.setFont(new Font("Raleway", Font.BOLD ,14)) ;
        emailtextField.setBounds(300,340,400,30) ;
        add(emailtextField) ;

        JLabel MaritalStatus = new JLabel("Marital Status:") ;
        MaritalStatus.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        MaritalStatus.setBounds(100, 390, 200,30);
        add(MaritalStatus) ;

        married = new JRadioButton("Married") ;
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married) ;

        unmarried = new JRadioButton("Unmarried") ;
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried) ;

        others = new JRadioButton("other") ;
        others.setBounds(600,390,100,30);
        others.setBackground(Color.WHITE);
        add(others) ;

        ButtonGroup maritalgroup = new ButtonGroup() ;
        maritalgroup.add(married) ;
        maritalgroup.add(unmarried) ;
        maritalgroup.add(others) ;

        JLabel address = new JLabel("Address:") ;
        address.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        address.setBounds(100, 440, 200,30);
        add(address) ;

        addresstextField = new JTextField() ;
        addresstextField.setFont(new Font("Raleway", Font.BOLD ,14)) ;
        addresstextField.setBounds(300,440,400,30) ;
        add(addresstextField) ;

        JLabel city = new JLabel("City:") ;
        city.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        city.setBounds(100, 490, 200,30);
        add(city) ;

        citytextField = new JTextField() ;
        citytextField.setFont(new Font("Raleway", Font.BOLD ,14)) ;
        citytextField.setBounds(300,490,400,30) ;
        add(citytextField) ;

        JLabel state = new JLabel("State:") ;
        state.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        state.setBounds(100, 540, 200,30);
        add(state) ;

        statetextField = new JTextField() ;
        statetextField.setFont(new Font("Raleway", Font.BOLD ,14)) ;
        statetextField.setBounds(300,540,400,30) ;
        add(statetextField) ;

        JLabel pincode = new JLabel("Pin Code:") ;
        pincode.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        pincode.setBounds(100, 590, 200,30);
        add(pincode) ;

        pincodetextField = new JTextField() ;
        pincodetextField.setFont(new Font("Raleway", Font.BOLD ,14)) ;
        pincodetextField.setBounds(300,590,400,30) ;
        add(pincodetextField) ;

        next = new JButton("Next") ;
        next.setBackground(Color.BLACK);
        next.setForeground(Color.black);
        next.setBounds(600, 650, 100,30) ;

        next.addActionListener(this);
        add(next) ;


        getContentPane().setBackground(Color.WHITE);

        setSize(850,800) ;

        setLocation(350,10) ;

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {


        String formno = "" + random ;
        String name = nametextField.getText() ;
        String fname = fnametextField.getText() ;

        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()) .getText() ;

        String gender = null ;
        if(male.isSelected()){
            gender = "Male" ;
        }
        else if(female.isSelected()){
            gender = "Female" ;
        }

        String email = emailtextField.getText() ;
        String marital = null ;
        if(married.isSelected()){
            marital = "Married" ;
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried" ;
        }
        else if(others.isSelected()){
            marital = "others" ;
        }

        String address = addresstextField.getText() ;
        String state = statetextField.getText() ;
        String city = citytextField.getText() ;
        String pin = pincodetextField.getText() ;

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else{
                Conn c = new Conn() ;
                String query = "INSERT INTO signup VALUES('"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' ,' "+gender+"' , '"+email+"', '"+marital+"' , '"+address+"' , '"+city+"' , '"+pin+"' , '"+state+"')" ;

                c.s.executeUpdate(query) ;

                setVisible(false);
                new SignupTwo(formno).setVisible(true) ;

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new SignupOne() ;
    }
}
