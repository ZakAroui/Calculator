
package calculator;

import java.math.BigDecimal;
import java.sql.*;

/*
* this class handles the DB operation of save and show
*/

// TODO this class should run in a second thread
// TODO the show data table method should be implemented within this class
public class DBinOut {
    
    //variables declaration
    private Connection connection;
    private Statement statement;
    private String usrname; 
    private double operand_a, operand_b, reslt;
    private String optChr;
    private int optNbr;
    
    //contructor initialization
    public DBinOut(){
        connection = null;
	statement = null;
    }
    
    //save the history of the latest complete operation to DB
    public void saveHist(){
        try{
            String insertStr;
            //connect to the DB, build an update statement and execute it
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zakidb", "root", "hello");
            System.out.println("connected to database");
            statement = connection.createStatement();
            optToChar();
            insertStr="insert into calculator_record values ("
                    +quotate((new BigDecimal(operand_a)).toString())+","
                    +quotate((new BigDecimal(operand_b)).toString())+","
                    +quotate(optChr)+","
                    +quotate((new BigDecimal(reslt)).toString())+","
                    +quotate(usrname)
                    +")";
            System.out.println(insertStr);
            int done = statement.executeUpdate(insertStr);
            System.out.println("1 row inserted");
            //close the connection and statement
            connection.close();
            statement.close();
        }
        catch(Exception e){
            System.out.println("Error occurred in inserting data! "+e.toString());
        }
    }
    
    //get the saved history of operations from the DB
    public void getHist() {
       //TODO bring it here from Calc
    }
    
    //add single quotes to the statement variable
    private String quotate(String content){
        //return a quoted string
        return "'"+content+"'";
    }
    
    //traslate the received operation code to operation character
    private void optToChar() {
         switch(optNbr){
             case 1:
                 optChr = "%";
                 break;
             case 2:
                 optChr = "/";
                 break;
             case 3:
                 optChr = "+";
                 break;
             case 4:
                 optChr = "-";
                 break;
             case 5:
                 optChr = "x";
                 break;
             default: 
                 System.out.println("no operand found!");
                 break;
         }
    }
    
    //set the local username's value
    public void setUsrnm(String usrnm){
        usrname = usrnm;
    }
    
    //set the local operand A value
    public void setOprdA(double oprnda){
        operand_a = oprnda;
    }
    
    //set the local operand B value
    public void setOprdB(double oprndb){
        operand_b = oprndb;
    }
    
    //set the local result's value
    public void setRslt(double rslt){
        reslt = rslt;
    }
    
    //set the local operation's code value
    public void setOpt(int opt){
        optNbr = opt;
    }
}
