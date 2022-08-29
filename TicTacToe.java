import java.util.Scanner;
public class TicTacToe {
    private  int counter;
    private char PositionNew[] = new char[10];
    private  char Player;
    public void NewBord(){
        char positiondefined[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        counter = 0;
        Player = 'X';
        for(int index = 1; index < 10; index++){
            PositionNew[index]=positiondefined[index];
        }
        currentBord();
    }
    public  void currentBord(){
        System.out.println("\t.............." );
        System.out.println("\t" +"| "+PositionNew[1] + " | " + PositionNew[2] + " | " + PositionNew[3] + " | ");
        System.out.println("\t.............." );
        System.out.println("\t" +"| "+ PositionNew[4] + " | " + PositionNew[5] + " | " + PositionNew[6] + " | ");
        System.out.println("\t.............." );
        System.out.println("\t" +"| "+ PositionNew[7] + " | " + PositionNew[8] + " | " + PositionNew[9] + " | ");
        System.out.println("\t.............." );;
        return;
    }

   public  boolean checkPosition( int Number){
           if(PositionNew[Number]=='X' || PositionNew[Number] == '0'){
            System.out.println("THis Position Filled");
            return true;

        }

        return false;
    }
    public  void NextPlayer(){
        if(Player == 'X'){
            Player = '0';
         }
        else{Player = 'X';}
    }

    public char getPlayer(){
        return Player;
     }

    public  void Play(){
        int Number;
        char blank= 'Q';
        System.out.println("Player" +" "+getPlayer() + " will go first and be the letter 'X'");
        do{
            currentBord();
            System.out.println("\n\n" + getPlayer()+" " + "Choice Position");
            boolean posiTake=true;
            while (posiTake){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Number between 1 and 9 :");
                 Number = sc.nextInt();
                posiTake = checkPosition(Number);
                if(posiTake==false){
                    PositionNew[Number] = getPlayer();
                }
            }
            System.out.println("Nice move");
            currentBord();
           NextPlayer();
        }while (checkWinner()==blank);
    }
    public char checkWinner() {
        char Winner = 'Q';
        if (PositionNew[1] == 'X' && PositionNew[2] == 'X' && PositionNew[3] == 'X') {Winner = 'X';}
        if (PositionNew[4] == 'X' && PositionNew[5] == 'X' && PositionNew[6] == 'X') {Winner = 'X';}
        if (PositionNew[7] == 'X' && PositionNew[8] == 'X' && PositionNew[9] == 'X') {Winner = 'X';}
        if (PositionNew[1] == 'X' && PositionNew[4] == 'X' && PositionNew[7] == 'X') {Winner = 'X';}
        if (PositionNew[2] == 'X' && PositionNew[5] == 'X' && PositionNew[8] == 'X') {Winner = 'X';}
        if (PositionNew[3] == 'X' && PositionNew[6] == 'X' && PositionNew[9] == 'X') {Winner = 'X';}
        if (PositionNew[1] == 'X' && PositionNew[5] == 'X' && PositionNew[9] == 'X') {Winner = 'X';}
        if (PositionNew[3] == 'X' && PositionNew[5] == 'X' && PositionNew[7] == 'X') {Winner = 'X';}
        if (Winner == 'X') {
            System.out.println("Player_1 is Winner! ");
            return Winner;
        }
        // Second Condition Check
        if (PositionNew[1] == '0' && PositionNew[2] == '0' && PositionNew[3] == '0') {Winner = 'O';}
        if (PositionNew[4] == '0' && PositionNew[5] == '0' && PositionNew[6] == '0') {Winner = 'O';}
        if (PositionNew[7] == '0' && PositionNew[8] == '0' && PositionNew[9] == '0') {Winner = 'O';}
        if (PositionNew[1] == '0' && PositionNew[4] == '0' && PositionNew[7] == '0') {Winner = 'O';}
        if (PositionNew[2] == '0' && PositionNew[5] == '0' && PositionNew[8] == '0') {Winner = 'O';}
        if (PositionNew[3] == '0' && PositionNew[6] == '0' && PositionNew[9] == '0') {Winner = 'O';}
        if (PositionNew[1] == 'X' && PositionNew[5] == '0' && PositionNew[9] == '0') {Winner = 'O';}
        if (PositionNew[3] == 'X' && PositionNew[5] == '0' && PositionNew[7] == '0') {Winner = 'O';}

        if (Winner == 'O') {
            System.out.println("Player_2 is Winner! ");
            return Winner;
        }

        // Draw check here
        for (int index = 1; index < 10; index++) {
            if (PositionNew[index] == 'X' || PositionNew[index] == '0') {
                if (index == 9) {
                    char draw = 'D';
                    System.out.println("statment is Same ");
                    return draw;
                   }
                continue;
               }
            else {
                break;
            }
        }
        return Winner;
    }
    public static void main(String[] args) {
        System.out.println("\n...........GAME STAR BRO........");
        String ch;
        TicTacToe toe = new TicTacToe();
        do{
            toe.NewBord();
            toe.Play();
            System.out.println("for Play Again(Enter 'y')");
            Scanner sc = new Scanner(System.in);
            ch= sc.nextLine();
        }while (ch.equals("y"));
    }
}
