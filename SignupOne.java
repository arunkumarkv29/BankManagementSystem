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
        setLayout(null) ;  // setLayout by default bordor Layout hota hai to ise null karna hota hai
        //5. 4 digit ka unique form no. hoga to Random class ka use karenge
        //Random class util package ke andr hoti hai
        Random ran = new Random() ;
        //System.out.println(ran);  // isme issue ayega ki ran actual no. nahi print hoga
        //System.out.println(ran.nextLong());  // ye bht bada no. dega but hume 4 digit ka chahiye
        //System.out.println(ran.nextLong()%9000L +1000L);  // negative no. bhi dega to Math.abs use karenge
        //System.out.println(Math.abs(ran.nextLong()%9000L +1000L));
        random = Math.abs(ran.nextLong()%9000L + 1000L) ;
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random) ; //
        formno.setFont(new Font("Raleway", Font.BOLD,38)) ;  //setFont(Font font)

        // 6. Frame ke uper set karne ke liye setBounds()
        formno.setBounds(140,20,600,40) ;  //set bound kaam hi tab karta hai jab setLayout null ho
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

        //dob ke aage calender lagana hai to ek class use hoti hai--> JDateChooser lekin uske liye
        //jar file ko import karna padega is wale project ke ander
        // bocz JDateChooser class jCalenger jar file ke ander hoti hai
        // BMS ke ander ek or package banaya aur usme jcalender jar file ko paste kar diya
        // and then imported import com.toedter.calendar.JDateChooser
        dateChooser = new JDateChooser() ;
        dateChooser.setBounds(300, 240,400,30) ;
        // to change the text color for DOB in box
        //dateChooser.setForeground(Color.BLUE);
        add(dateChooser) ;

        JLabel gender = new JLabel("Gender:") ;
        gender.setFont(new Font("Raleway", Font.BOLD, 20)) ;
        gender.setBounds(100, 290, 200,30);add(gender) ;
        //radio button lagega
        male = new JRadioButton("Male") ;
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male) ;

        female = new JRadioButton("Female") ;
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female) ;

        //abhi dono par click karenge to dono select ho rahe hai to hume isko solve karne ke liye ButtonGroup class
        //ka object banana padega
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
        //10.3 adding actionListener to next button
        next.addActionListener(this);
        add(next) ;

        /*7. ab mujhe chahiye ki jo bhi data main above text field me dalu wo database m store ho
             uske liye dJDBC connectivity ka use karenge--> java project ko database ke sath coonect karenge
             a. Bank.Management.System ke ander ek class banayenge conn --> conn stands for coonection jo humara connection
             banayega Database ke sath
             b. move to Conn class

        */
        /*
        back from Conn class
        8. jitne bhi local variable liye hai unko global define karna hoga
        8.1 even Random bhi hume global chahiye, aur JTextField etc...
        8.2 next button ke click se sab data save chahiye action dalna padega isme, to ActionListener ko import karna hoga
        and also import java.awt.event.* ;
         */

        //4. getContentPane() frame lake dega
        getContentPane().setBackground(Color.WHITE);
        //1
        setSize(850,800) ;
        //2
        setLocation(350,10) ;
        //3
        setVisible(true);
    }
    //9 overide actionPerformed method
    public void actionPerformed(ActionEvent ae) {

        //9.1 ek hi button hai to check karne ki koi need nahi hai
        //9.2 ab sari values nikalni hai jo bhi fill hui hai
        //9.3 kon kon si wali database me enter karni hai wo likhenge
        // setText() ki madad se TextField me value set kar sakte hai aur getText() se value get kar sakte hai

        String formno = "" + random ; //but Random long me hai to ise String me change karna hoga--> long ya kisi no. se pehle "" +
        String name = nametextField.getText() ;  //TextField se value nikalne ke liye getText() method use hoga
        String fname = fnametextField.getText() ;
        //dob ke liye ek class hoti hai dateChooser uske ander method hota hai getDateEditor() and iske ander
        // method hota hai getUIComponent() ab hume text field the access mil hai to now getText()

        //String dob = dateChooser.getDateEditor().getUiComponent().getText() ;

        //but getUiComponent() textField return karta hai to iske type cast karna hoga JTextField() me or
        //function getText() kaam karta hai JtextField par

        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()) .getText() ;

        //ab radioButton se value nikalni hai-->isSelected() se pata chalta hai konsa button choose hua hai
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

        // 10. ab mujhe database me hit marna hai aur database ek external entity hai to try catch bhi use hoga
        try{
            if(name.equals("")){   //agar name empty hai to JOptionPane ki help se dialog box pop up karwa sakte hai
                JOptionPane.showMessageDialog(null,"Name is Required");
                // 10.1 root ko null and uske baad message jo print karwana hai
                //10.2 ye popup tab aaye jab next par click ho to next button par ActionListener lagana padega
                //10.4 same dialog box bakio paar bhi laga sakte hai but abhi filhal bas name par
            }
            else{
                //10.5 ab mujhe database me call marni hai aur usse pehle mysql ke sath connection establish karna hai
                //connection establish karne ke baad mysql ki queries ko run kar sakta hu
                // connection establish karne ki jimmedari hai Conn class ki
                Conn c = new Conn() ;
                String query = "INSERT INTO signup VALUES('"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' ,' "+gender+"' , '"+email+"', '"+marital+"' , '"+address+"' , '"+city+"' , '"+pin+"' , '"+state+"')" ;
                // signup naam se table abhi create nahi ki workbench
                // above variables iske ander dalenge
                // agar aage se Stirng aarahi hai aur piche sze bhi to beech me agar variable to concat karna hai to  '"+variable+"'  se karte hai
                //"String'" + variables + "'String" --> variable bhi String rahe to single quotes me bhi dalenge*
                //inshort '"+ +"'   --> single quote, uske ander double quote uske ander  ++ aur uske beech me variable

                // ab query ko execute karna hai to Comm class ki help se Execute karenge
                // Comm ke ander s naam se statement hai usse query execute ka renge
                //Comm class ka object bana ke is s ko access karenge aur DML command chalayenge executeUpdate() se
                c.s.executeUpdate(query) ;  // itna likhne se query sql me run kar jayegi

                //agar sara data sahi fill hua hai to is frame ko close karna hai aur signupTwo khulna chahiye
                setVisible(false);  //current frame band ho jayega
                new SignupTwo(formno).setVisible(true) ;

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
//11. now i want ki jaise hi main Login class me signup wale button par click karu to ye signup wala page khule
    // Login class me jake setvisible(false) kar denge and signup ka object waha bana denge
    // baclk to Login class
    public static void main(String[] args) {
        new SignupOne() ;
    }
}
