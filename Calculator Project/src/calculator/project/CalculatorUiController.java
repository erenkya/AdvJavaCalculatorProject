/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author ErenK
 */
public class CalculatorUiController implements Initializable {

    @FXML
    private GridPane gridPane;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button times;
    @FXML
    private Button devide;
    @FXML
    private Button reset;
    @FXML
    private Button percent;
    @FXML
    private Button nine;
    @FXML
    private Button six;
    @FXML
    private Button three;
    @FXML
    private Button equal;
    @FXML
    private Button piNum;
    @FXML
    private Button eight;
    @FXML
    private Button five;
    @FXML
    private Button two;
    @FXML
    private Button dot;
    @FXML
    private Button eNum;
    @FXML
    private Button ln;
    @FXML
    private Button seven;
    @FXML
    private Button log;
    @FXML
    private Button four;
    @FXML
    private Button one;
    @FXML
    private Button sqrRoot;
    @FXML
    private Button zero;
    @FXML
    private Button power;
    @FXML
    private Button answer;
    @FXML
    private Button cot;
    @FXML
    private Button tan;
    @FXML
    private Button cos;
    @FXML
    private Button sin;
    @FXML
    private Label resultScreen;
    @FXML
    private Label warnLabel;
    
    
    //Anlık ekranda yazması gereken sayı(Son hali ilk sayı olarak kayıt edilecek)
    Double tmpNumber = 0.0;
    
    //Noktaya basılıp basılmadığını tutacak
    boolean dotClicket = false;
    //Virgülden sonraki basamak sayısını tutacak
    int decimalCounter = 1;
    
    
    String operation = "";
    Double firstNum = 0.0;
    Double secondNum = 0.0;
    Double result = null;
    boolean oneNumberCalc = false;
    Double ansNum = 0.0;
    boolean isResultOnScreen = false;
  
    /*-----------------------------------------------------------------------------------------------------------------*/
    //Calculation yaparken iki tane sayı ve tek sayı gerektiren calculationlara göre ayırmamız lazım
    ArrayList<String> oneCalculation = new ArrayList<>();
    ArrayList<String> twoCalculation = new ArrayList<>();        
    /*-----------------------------------------------------------------------------------------------------------------*/
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.oneCalculation.add("sin");
        this.oneCalculation.add("cos");
        this.oneCalculation.add("tan");
        this.oneCalculation.add("cot");
        this.oneCalculation.add("sqrt");
        this.oneCalculation.add("log");
        this.oneCalculation.add("ln");
        this.oneCalculation.add("fac");
        this.oneCalculation.add("per");
        
        this.twoCalculation.add("+");
        this.twoCalculation.add("-");
        this.twoCalculation.add("x");
        this.twoCalculation.add("/");
        this.twoCalculation.add("x^y");
        
    }    

    @FXML
    private void plusOnClick(ActionEvent event) {
        if(this.operation.equals("")){
           this.operation = "+";
           this.firstNum = this.tmpNumber;
           this.tmpNumber = 0.0;
           this.dotClicket = false;
           this.decimalCounter = 1;
           this.warnLabel.setText("");
           
        }
        else{
            this.warnLabel.setText("You are on " + this.operation + " operation riht now. For make another operation click reset.");
        }
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
        
    }

    @FXML
    private void minusOnClick(ActionEvent event) {
        if(this.operation.equals("")){
           this.operation = "-";
           this.firstNum = this.tmpNumber;
           this.tmpNumber = 0.0;       
           this.dotClicket = false;
           this.decimalCounter = 1;
           this.warnLabel.setText("");
        }
        else{
            this.warnLabel.setText("You are on " + this.operation + " operation riht now. For make another operation click reset.");
        }
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
    }

    @FXML
    private void timesOnClick(ActionEvent event) {
        if(this.operation.equals("")){
           this.operation = "x";
           this.firstNum = this.tmpNumber;
           this.tmpNumber = 0.0;
           this.dotClicket = false;
           this.decimalCounter = 1;
           this.warnLabel.setText("");
           
        }
        else{
            this.warnLabel.setText("You are on " + this.operation + " operation riht now. For make another operation click reset.");
        }
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
        
    }

    @FXML
    private void devideOnClick(ActionEvent event) {
        if(this.operation.equals("")){
           this.operation = "/";
           this.firstNum = this.tmpNumber;
           this.tmpNumber = 0.0;
           this.dotClicket = false;
           this.decimalCounter = 1;
           this.warnLabel.setText("");
          
        }
        else{
            this.warnLabel.setText("You are on " + this.operation + " operation riht now. For make another operation click reset.");
        }
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
    }
    
    @FXML
    private void powerOnClick(ActionEvent event) {
        if(this.operation.equals("")){
           this.operation = "x^y";
           this.firstNum = this.tmpNumber;
           this.tmpNumber = 0.0;
           this.dotClicket = false;
           this.decimalCounter = 1;
           this.warnLabel.setText("");
          
        }
        else{
            this.warnLabel.setText("You are on " + this.operation + " operation riht now. For make another operation click reset.");
        }
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
    }

    @FXML
    private void resetOnClick(ActionEvent event) {
        
                this.firstNum = 0.0;
                this.secondNum = 0.0;
                this.operation = "";
                this.dotClicket = false;
                this.decimalCounter = 1;
                this.tmpNumber = 0.0;
                this.warnLabel.setText("");
                this.resultScreen.setText(this.firstNum.toString());
                this.isResultOnScreen = false;
    }

    @FXML
    private void percentOnClick(ActionEvent event) {
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
        //----------------------------DEVAM-------------------------------------------------
    }

    @FXML
    private void nineOnClick(ActionEvent event) {
        if(this.dotClicket){
            this.tmpNumber = this.tmpNumber + (9.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());
        }
        else{
        this.tmpNumber = this.tmpNumber*10 +9;
        this.resultScreen.setText(this.tmpNumber.toString());}
        
        this.isResultOnScreen = false;
    }

    @FXML
    private void sixOnClick(ActionEvent event) {
        if(this.dotClicket){
        this.tmpNumber = this.tmpNumber + (6.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());}
        else{
        this.tmpNumber = this.tmpNumber*10 + 6;
        this.resultScreen.setText(this.tmpNumber.toString());}
        this.isResultOnScreen = false;
    }

    @FXML
    private void threeOnAction(ActionEvent event) {
        if(this.dotClicket){
        this.tmpNumber = this.tmpNumber + (3.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());}
        else{
        this.tmpNumber = this.tmpNumber*10 +3;
        this.resultScreen.setText(this.tmpNumber.toString());}
        this.isResultOnScreen = false;
    }

    @FXML
    private void equalOnAction(ActionEvent event) {
        if(this.twoCalculation.contains(this.operation) ){
            this.secondNum = this.tmpNumber;
            System.out.println(this.firstNum +" " + this.operation + " " +this.secondNum);
            if(this.operation.equals("+")){
                this.result = this.firstNum + this.secondNum;
                this.resultScreen.setText(this.result.toString());
                this.firstNum = 0.0;
                this.secondNum = 0.0;
                this.operation = "";
                this.dotClicket = false;
                this.decimalCounter = 1;
                this.tmpNumber = 0.0;
                this.warnLabel.setText("");
                this.ansNum = this.result;
                this.isResultOnScreen = true;
                
                
                
                
                
                
            }
            else if(this.operation.equals("-")){
                this.result = this.firstNum - this.secondNum;
                this.resultScreen.setText(this.result.toString());
                this.firstNum = 0.0;
                this.secondNum = 0.0;
                this.operation = "";
                this.dotClicket = false;
                this.decimalCounter = 1;
                this.tmpNumber = 0.0;
                this.warnLabel.setText("");
                this.ansNum = this.result;
                this.isResultOnScreen = true;
                
            
            }
            
            else if(this.operation.equals("x")){
                this.result = this.firstNum * this.secondNum;
                this.resultScreen.setText(this.result.toString());
                this.firstNum = 0.0;
                this.secondNum = 0.0;
                this.operation = "";
                this.dotClicket = false;
                this.decimalCounter = 1;
                this.tmpNumber = 0.0;
                this.warnLabel.setText("");
                this.ansNum = this.result;
                this.isResultOnScreen = true;
                
            
            }
            else if(this.operation.equals("/")){
                this.result = this.firstNum / this.secondNum;
                this.resultScreen.setText(this.result.toString());
                this.firstNum = 0.0;
                this.secondNum = 0.0;
                this.operation = "";
                this.dotClicket = false;
                this.decimalCounter = 1;
                this.tmpNumber = 0.0;
                this.warnLabel.setText("");
                this.isResultOnScreen = true;
            
            }
            
            else if(this.operation.equals("x^y")){
                this.result = Math.pow( this.firstNum , this.secondNum);
                this.resultScreen.setText(this.result.toString());
                this.firstNum = 0.0;
                this.secondNum = 0.0;
                this.operation = "";
                this.dotClicket = false;
                this.decimalCounter = 1;
                this.tmpNumber = 0.0;
                this.warnLabel.setText("");
                this.ansNum = this.result;
                this.isResultOnScreen = true;
            
            }
            else{
                this.warnLabel.setText("Enter an operation!!");
            
            }
            
        }else if(this.oneCalculation.contains(this.operation)){
            //---------------------------------------------------------Tek sayılı işlemler ile tamamlanacak-----------------------------------------------------------
        
        }else{
            this.warnLabel.setText("Enter an operation!!");
        }
    }

    @FXML
    private void piNumOnClick(ActionEvent event) {
        this.tmpNumber += Math.PI;
        this.resultScreen.setText(this.tmpNumber.toString());
        this.isResultOnScreen = false;
    }

    @FXML
    private void eightOnAction(ActionEvent event) {
        if(this.dotClicket){
        this.tmpNumber = this.tmpNumber + (8.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());}
        else{
        this.tmpNumber = this.tmpNumber*10 +8;
        
        this.resultScreen.setText(this.tmpNumber.toString());}
        this.isResultOnScreen = false;
    }

    @FXML
    private void fiveOnAction(ActionEvent event) {
        if(this.dotClicket){
        this.tmpNumber = this.tmpNumber + (5.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());}
        else{
        this.tmpNumber = this.tmpNumber*10 +5;
        this.resultScreen.setText(this.tmpNumber.toString());}
        this.isResultOnScreen = false;
    }

    @FXML
    private void twoOnAction(ActionEvent event) {
        if(this.dotClicket){
            this.tmpNumber = this.tmpNumber + (2.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());
        }
        else{
        this.tmpNumber = this.tmpNumber*10 +2;
        this.resultScreen.setText(this.tmpNumber.toString());}
        this.isResultOnScreen = false;
    }

    @FXML
    private void dotOnClick(ActionEvent event) {
        this.dotClicket = true;
    }

    @FXML
    private void eNumOnClick(ActionEvent event) {
        this.tmpNumber += Math.E;
        this.resultScreen.setText(this.tmpNumber.toString());
        this.isResultOnScreen = false;
    }

    @FXML
    private void lnOnClick(ActionEvent event) {
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
        //------------------------------------------------DEVAM------------------------------------
    }

    @FXML
    private void sevenOnClick(ActionEvent event) {
        if(this.dotClicket){
        this.tmpNumber = this.tmpNumber + (7.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());}
        else{
        this.tmpNumber = this.tmpNumber*10 +7;
        this.resultScreen.setText(this.tmpNumber.toString());}
    }

    @FXML
    private void logOnClick(ActionEvent event) {
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
        //------------------------------------------------------------DEVAM----------------------------------------------
        
    }

    @FXML
    private void fourOnClick(ActionEvent event) {
        if(this.dotClicket){
        this.tmpNumber = this.tmpNumber + (4.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());}
        else{
        this.tmpNumber = this.tmpNumber*10 +4;
        this.resultScreen.setText(this.tmpNumber.toString());}
    }

    @FXML
    private void oneOnClick(ActionEvent event) {
        if(this.dotClicket){
        this.tmpNumber = this.tmpNumber + (1.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());}
        else{
        this.tmpNumber = this.tmpNumber*10 +1;
        this.resultScreen.setText(this.tmpNumber.toString());}
    }

    @FXML
    private void sqrRootOnClick(ActionEvent event) {
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
        //--------------------------------------------DEVAM--------------------------------
    }

    @FXML
    private void zeroOnClick(ActionEvent event) {
        if(this.dotClicket){
        this.tmpNumber = this.tmpNumber + (0.0/Math.pow(10, this.decimalCounter));
            this.decimalCounter += 1;
            this.resultScreen.setText(this.tmpNumber.toString());}
        else{
        this.tmpNumber = this.tmpNumber*10 ;
        this.resultScreen.setText(this.tmpNumber.toString());}
    }

    

    @FXML
    private void answerOnClick(ActionEvent event) {
        
        if(this.operation.equals("") && this.result == null){
            this.warnLabel.setText("There was no answer");
        }
        
        if(!this.operation.equals("") && this.result != null){
            this.tmpNumber += this.ansNum;
             this.resultScreen.setText(this.tmpNumber.toString());
            
            System.out.println(this.firstNum+" "+this.secondNum + " ans number" + this.ansNum);
        }
        if(!this.operation.equals("") && this.result == null){
             this.warnLabel.setText("There was no answer");
        }
        if(this.operation.equals("") && this.result != null){
            this.tmpNumber += this.ansNum;
            
            this.resultScreen.setText(this.tmpNumber.toString());
            
            System.out.println(this.firstNum+" "+this.secondNum + " ans number" + this.ansNum);
            
        }
        
    }

    @FXML
    private void cotOnClick(ActionEvent event) {
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
     //--------------------------------------------DEVAM-------------------------------------
    }

    @FXML
    private void tanOnClick(ActionEvent event) {
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
        //--------------------------------------------DEVAM-------------------------------------
    }

    @FXML
    private void cosOnClick(ActionEvent event) {
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
        //--------------------------------------------DEVAM-------------------------------------
    }

    @FXML
    private void sinOnClick(ActionEvent event) {
        if(this.isResultOnScreen){
            this.warnLabel.setText("Please enter a number before click an operation");
        }
        //--------------------------------------------DEVAM-------------------------------------
    }
    
}
