public class PlayerDriver{

    public static void main(String[] args){
        Player newPlayer = new Player("player1");
        newPlayer.createFile();
        newPlayer.saveData();
    }
}
