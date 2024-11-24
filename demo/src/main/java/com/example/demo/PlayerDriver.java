package com.example.demo;

public class PlayerDriver {

    public static void main(String[] args){

        // creating a player object
        // score is defaulted to 0
        Player playerOne = new Player(10,"player1");
        Player playerTwo = new Player(9,"player2");
        Player playerThree = new Player(1,"player3");
        Player playerFour = new Player(6,"player4");
        Player[] playerArr = {playerOne, playerTwo, playerThree, playerFour};

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

        Player[] sortedArr = sortPlayers(playerArr);
        System.out.println("Sorted Players");
        for(int i = 0; i < sortedArr.length; i++){
            System.out.println(sortedArr[i].getPlayerName() +": " +  sortedArr[i].getScore());
        }
        double playerOneData = playerOne.getPlayerData();
        double playerTwoData = playerTwo.getPlayerData();
        double playerThreeData = playerThree.getPlayerData();
        double playerFourData = playerFour.getPlayerData();
        System.out.printf("%-10s%10.2f\n",playerOne.getPlayerName(), playerOneData);
        System.out.printf("%-10s%10.2f\n",playerTwo.getPlayerName(), playerTwoData);
        System.out.printf("%-10s%10.2f\n",playerThree.getPlayerName(), playerThreeData);
        System.out.printf("%-10s%10.2f\n",playerFour.getPlayerName(), playerFourData);
    }
    // Uses bubblesort to sort in descending order
    public static Player[] sortPlayers(Player[] playerArr){
        for(int i = 0; i < playerArr.length - 1; i++){
            boolean swapped = false;
            for(int x = 0; x < playerArr.length - 1 - i; x ++){
                if(playerArr[x].getScore() < playerArr[x + 1].getScore()){

                    Player placeholder = playerArr[x];
                    playerArr[x] = playerArr[x + 1];
                    playerArr[x + 1] = placeholder;
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
        return playerArr;
    }
}
