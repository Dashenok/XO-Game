package view;

import controller.GameController;
import model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Dashenka Struts on 24.05.2015.
 */
public class ConsoleView {

    private static final String LINE_CHAR = "-";
    private static final int LINE_SIZE = 12;
    protected final GameController gameController;



    public ConsoleView(final GameController gameController) {
        assert gameController != null;
        this.gameController = gameController;
    }

    public void start() {
        System.out.println("Please input coordinates");
        int x = getCoordinate("X");
        int y = getCoordinate("Y");
    }

    public void showGameName() {
        System.out.println(gameController.getGameName());
    }

    public void showPlayersName() {
        System.out.println(gameController.getPlayers());
    }

    public void showPlayers(){
       for (Player player : gameController.getPlayers()){
            System.out.println(player.getName());
        }
    }

    public void showBoard(){
        for (int i = 0; i < 3; i = i + 1) {
            showBoardLine(i);
        }
    }

    private void showBoardLine(final int row){
        for (int i = 0; i < 3; i = i + 1) {
            System.out.print(gameController.getBoard().getFigure(row, i));
        }
        System.out.println();
        showLine(LINE_SIZE);
    }

    private void showLine(int size) {
        //while (int i < size; i = i + 1){
        for (int i = 0; i < size; i = i + 1){
            System.out.print(LINE_CHAR);
        }
        System.out.println();
    }


    private int getCoordinate(final String coordinateName) {
        int couter = 0;
        do {

            System.out.println(String.format("Input the coordinate %s: ", coordinateName));
            try {
                final Scanner IN = new Scanner(System.in);
                return IN.nextInt();
            } catch (final InputMismatchException e) {
                System.out.println("Coordinate is incorrect");
                couter +=1;
            }
        } while (couter < 3);
        return -1;

    }
}
