/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.math.BigDecimal;
import java.sql.*;

/**
 *
 * @author lenono
 */
public class DBinOut {
    
    private Connection connection;
    private Statement statement;
    private String usrname; 
    private double operand_a, operand_b, reslt;
    private String optChr;
    private int optNbr;
    
    public DBinOut(){
        connection = null;
	 statement = null;
    }
    
    public void saveHist(){
        try{
            String insertStr="";
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
        }
        catch(Exception e){
            System.out.println("Error occurred in inserting data"+e.toString());
        }
    }

    public void getHist() {
       //TODO if you can think of a way to bring it here from Calc
    }
    
    private String quotate(String content){
    
        return "'"+content+"'";
    }
    
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
    
    public void setUsrnm(String usrnm){
        usrname = usrnm;
    }
    public void setOprdA(double oprnda){
        operand_a = oprnda;
    }
    public void setOprdB(double oprndb){
        operand_b = oprndb;
    }
    public void setRslt(double rslt){
        reslt = rslt;
    }
    public void setOpt(int opt){
        optNbr = opt;
    }
    
}
