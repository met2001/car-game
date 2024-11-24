package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Player {
    private double score = 0;
    private String playerName;
    private String filename;

    public Player(){
        this.playerName = "none";
        this.score = 0;
    }
    public Player(String playerName){
        this.playerName = playerName;
        this.filename = playerName + ".txt";
        this.score = 0;
    }
    public Player(double score, String playerName){
        this.score = score;
        this.playerName = playerName;
        this.filename = playerName + ".txt";
    }
    public void setScore(double newScore){
        this.score = newScore;
    }
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    public String getFilename(){
        return this.filename;
    }
    public  String getPlayerName(){
        return this.playerName;
    }
    public double getScore(){
        return this.score;
    }
    public void createFile(){
        try{
            File playerFile = new File(this.filename);
            if(playerFile.createNewFile()){
                System.out.println("Player file: " + this.filename);
            }
            else{
                System.out.println("File already exists.");
            }
        } catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public void saveData(){
        try {
            FileWriter fileSaver = new FileWriter(this.filename);
            fileSaver.write(String.valueOf(this.score));
            fileSaver.close();
            System.out.println("Saved data!");
        } catch (IOException e) {
            System.out.println(e);

        }
    }
    public double readData(){
        double score = 0;
        try{
            File playerFile = new File(this.filename);
            Scanner data = new Scanner(playerFile);
            while(data.hasNextLine()){
                score = data.nextDouble();
            }
        }catch (Exception e){
            System.out.print(e);
        }
        return score;
    }
    public double getPlayerData(){
        try{
            String currentDirectory = Paths.get("").toAbsolutePath().toString();
            System.out.println("Current Directory: " + currentDirectory);
            File curDir = new File(".");
            for(File file : curDir.listFiles()){

                if(file.getName().endsWith(".txt")){

                    if(file.getName().equals(this.filename)){
                        File player = new File(file.getName());
                        Scanner data = new Scanner(player);
                        while(data.hasNextLine()){
                            return data.nextDouble();
                        }
                    }

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    @Override
    public String toString(){
        return String.valueOf(this.score);
    }
}
