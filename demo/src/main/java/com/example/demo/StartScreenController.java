package com.example.demo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StartScreenController {
    public Label playerOneData;
    public Label playerTwoData;
    public Label playerThreeData;
    public Label playerFourData;

    public Label playerOneLabel;
    public Label playerTwoLabel;
    public Label playerThreeLabel;
    public Label playerFourLabel;
    public TextField saveSelect;

    boolean validName = false;

    @FXML
    public void startGame(ActionEvent event) {
        try{
            if(saveSelect.getText().toLowerCase().equals("save 1") || saveSelect.getText().toLowerCase().equals("save 2")
                    || saveSelect.getText().toLowerCase().equals("save 3") || saveSelect.getText().toLowerCase().equals("save 4")){
                validName = true;
                System.out.println("Correct option given");

            }
            else{
                System.out.println("Not an option");
                validName = false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void initialize(){

        Player playerOne = new Player("Save 1");
        Player playerTwo = new Player("Save 2");
        Player playerThree = new Player("Save 3");
        Player playerFour = new Player("Save 4");

        //Saves all player data
        try{
            playerOne.createFile();
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            playerOne.saveData();
        }
        try{
            playerTwo.createFile();
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            playerTwo.saveData();
        }
        try{
            playerThree.createFile();
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            playerThree.saveData();
        }
        try{
            playerFour.createFile();
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            playerFour.saveData();
        }




        playerOneLabel.setText(playerOne.getPlayerName());
        playerTwoLabel.setText(playerTwo.getPlayerName());
        playerThreeLabel.setText(playerThree.getPlayerName());
        playerFourLabel.setText(playerFour.getPlayerName());
        playerOneData.setText(playerOne.toString());
        playerTwoData.setText(playerTwo.toString());
        playerThreeData.setText(playerThree.toString());
        playerFourData.setText(playerFour.toString());
    }


}
