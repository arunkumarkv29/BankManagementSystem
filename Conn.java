package System;

import java.sql.* ;
//is class ka object banake isko use karenge
public class Conn {
    /*
    JDBC connectivity me 5 steps hote hai apne pass
    1. Register the Drivers
    2. Create Connection
    3. Create Statement
    4. Execute Query
    5. Close Connection
     */
    // Creating the connection
    // make Conn Constructor--> Object banate hi constructor call hota hai
    Connection c ;   //global object banaya hai Connection Class ka
    Statement s ;
    public Conn(){
        //try or catch lagana padega means yaha exception handling karni padegi kyuki MYSQL ek external entity hai
        // to error aane ke chances rehte hai-->matlab compile time pe error nahi ayenge wo runtime par ayenge
        //to run time ke error ko handle karne ke liye try catch use karna padega
        try{
            //1.ab sabse pehle Driver ko Register karna hai
            // 1.1 Driver ko register karne ke liye class hoti hai 'Class' naam se hi jiske ander method hota hai 'forName' se
            //1.2 jiske ander apne Driver ka naam likh sakte hai

            /*
            Class.forName(com.mysql.cj.jdbc.Driver) ;
             ; --> 4. pehle hum Driver ko Register kar rahe the explicitly but ab
            4.1 humne jarfile me mysql-connector-java daal diya hai to register karne ki jarurat nahi hai
             */

            //1.3 error show kar raha hai to iske liye library ko import karna hoga jo ki hai sql library
            //1.4 i.e., import java.sql.*
            //1.5 error abhi bhi aaraha hai but aage dekhenge
            //2. iske baad second step me connection ko Create karna hai
            // iske liye class hoti hai 'Connection' ke naam se uska object create karenge Constructor ke uper(kind of global)
            // yaha par ek class hoti hai 'DriverManager' ke naam se jiske ander ek function hota hai getConnection() jiske ander
            // ek url ko pass karna hota hai
            // url ek String hoti hai --> connection String banate hai

            //C = DriverManager.getConnection("jdbc:mysql://localhost:3306"); //jdbc ko mysql se connect kar rahe hai
            // jo ki localhost par chalta hai jiska port no. hai 3306

            //bydefault mysql jo hai wo localhost par hi chalta hai jiska port no. 3306 hota hai to localhost:3306 likhne ki jarurat nahi hai

              //C = DriverManager.getConnection(jdbc:mysql:///"Database ka naam");

            //yaha ab database create karenge mysql workbench me bcoz Database hi nahi hogi to yaha mention kya karenge

            //C = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem");

            // iske baad mysql ka username & password dalna hota hai-->jo ki root hota hai bydefault

            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root", "root") ;

            //ye hoti hai puri connection String--> "jdbc:mysql:///bankmanagementsystem","root", "as1994007"
            //3. 3rd step hota hai create statement--> create karne se pehle 'Statement' ko declare karna padega globally
            // 3.1 connection ki help se ek method hota hai createStatement() usko call kar denge

            s = c.createStatement() ;

            // 3.2 ab yaha ek library ko import karna hoga --> mysql connector java ke naam se, uper jo error tha
            //3.3 usme Driver jo hai wo is library me hota hai

            //5 ab data ko nikal ke dataBase me save karna hai--> signupOne ka data save karna hai-->move to signupOne class
        }
        catch(Exception e){
            System.out.println(e) ;  // jo bhi error ayega wo yaha print hoga
        }

    }
}
