package controller;


import controller.exceptions.FieldNotEmptyException;
import controller.exceptions.InvalideCoordinateException;
import helpers.CoordinateHelper;
import model.Board;
import model.Figure;
import model.Player;

import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameController {

    private static final String DEFAULT_GAME_NAME = "XO";

    private final String gameName;

    private final Board board;

    private final Player[] players;


    public GameController(final String gameName,
                          final Player[] players,
                          final Board board) {
        this.players = players;
        this.board = board;
        if (gameName == null || gameName.isEmpty()) {
            this.gameName = DEFAULT_GAME_NAME;
        } else {
            this.gameName = gameName;
        }
    }

    public String getGameName() {
        return gameName;
    }

    public Player currentPlayer() {
        // BEGIN

/*
        final Function<String, Integer> countCalculator = (figure) -> IntStream.range(0, 3).map(row ->
                        (int) IntStream.range(0, 3).filter(column ->
                                        board.getFigure(row, column) != null &&
                                                board.getFigure(row, column).getFigure().equals(figure)
                        ).count()
        ).sum();
        final int countX = countCalculator.apply("X");
        final int countO = countCalculator.apply("O");
        final boolean xMove = countX == countO;
        if (players[0].getFigure().getFigure().equals("X")) {
            if (xMove)
                return players[0];
            else
                return players[1];
        } else {
            if (xMove)

                return players[1];
            else
                return players[0];
        }
*/




        int XNumber = 0;
        int ONumber = 0;
           for (int i = 0; i <= 2; i++){
            
            for (int j = 0; j <=2; j++){
                Figure figure = board.getFigure(i, j);
                if (figure != null){
                    if (figure.getFigure().equals("X")) {
                        XNumber = XNumber + 1;
                    } else if (figure.getFigure().equals("O")) {
                        ONumber = ONumber + 1;
                    }
                }
            }
        }

        if (XNumber <= ONumber){
            if (players[0].getFigure().getFigure().equals("X"))
                return players[0];
            return  players[1];

        } else {
            if (players[0].getFigure().getFigure().equals("O"))
                return players[0];
            return  players[1];
        }

        // END

    }

    public Player winner() {


/*
        for (int i=0; i<3; i++) {
            if (board.getFigure(i, 0) == board.getFigure(i, 1) &&
                    board.getFigure(i, 0) == board.getFigure(i, 2)) {
                if (players[0].getFigure() == board.getFigure(i, 0)) return players[0];
                return players[1];
            }
        }
        for (int i=0; i<3; i++) {
            if (board.getFigure(0, i) == board.getFigure(1, i) &&
                    board.getFigure(0, i) == board.getFigure(2, i)) {
                if (players[0].getFigure() == board.getFigure(0, i)) return players[0];
                return players[1];
            }
        }
        if (board.getFigure(0, 0) == board.getFigure(1, 1) &&
                board.getFigure(0, 0) == board.getFigure(2, 2)) {
            if (players[0].getFigure() == board.getFigure(1, 1)) return players[0];
            return players[1];
        }
        if (board.getFigure(0, 2) == board.getFigure(1, 1) &&
                board.getFigure(0, 2) == board.getFigure(2, 0)) {
            if (players[0].getFigure() == board.getFigure(1, 1)) return players[0];
            return players[1];
        }
        return null;



*/






        // BEGIN
        int rowNumber;
        int columnNumber;

        Player playerX;
        Player playerO;
        if (players[0].getFigure().toString() == "X"){
            playerX = players[0];
            playerO = players[1];

        } else {
            playerX = players[1];
            playerO = players[0];
        }
        int boardSize = Board.SIZE_FIELD;

        int diag1Sum = 0;
        int diag2Sum = 0;
        for (int i = 0; i < boardSize; i++){
            rowNumber = 0;
            columnNumber = 0;
            Figure figureInDiag1 = board.getFigure(i,i);
            Figure figureInDiag2 = board.getFigure(i, boardSize - 1 - i);


            if (figureInDiag1 == playerX.getFigure()){
                diag1Sum = diag1Sum + 1;
            } else if (figureInDiag1 == playerO.getFigure()){
                diag1Sum = diag1Sum - 1;
            }


            if (diag1Sum == boardSize){
                return playerX;
            } else if (diag1Sum == (-1)*boardSize){
                return playerO;
            }


            if (figureInDiag2 == playerX.getFigure()){
                diag2Sum = diag2Sum + 1;
            } else if (figureInDiag2 == playerO.getFigure()){
                diag2Sum = diag2Sum - 1;
            }


            if (diag2Sum == boardSize){
                return playerX;
            } else if (diag2Sum == (-1)*boardSize){
                return playerO;
            }

            for (int j = 0; j < boardSize; j++){

                Figure figureInRow = board.getFigure(i, j);
                Figure figureInColumn = board.getFigure(j, i);


                if (figureInRow == playerX.getFigure()){
                    rowNumber = rowNumber + 1;
                } else if (figureInRow == playerO.getFigure()){
                    rowNumber = rowNumber - 1;
                }


                if (rowNumber == boardSize){
                    return playerX;
                } else if (rowNumber == (-1)*boardSize){
                    return playerO;
                }

                if (figureInColumn == playerX.getFigure()){
                    columnNumber = columnNumber + 1;
                } else if (figureInColumn == playerO.getFigure()){
                    columnNumber = columnNumber - 1;
                }


                if (columnNumber == boardSize){
                    return playerX;
                } else if (columnNumber == (-1)*boardSize){
                    return playerO;
                }
            }
        }
        return null;
        // END
    }
    private int getX(){return 0;}
    private int getY(){return 1;}
    public Board getBoard() {
        return board;
    }
    public void makeMove(){
        final int x = getX();
        final int y = getY();
        final Board board = getBoard();
        try{
            move(x, y, board, Figure.O);
        }catch (InvalideCoordinateException | FieldNotEmptyException e){
            e.printStackTrace();
        }


    }

    public static void move(final int x, final int y, final Board board, final Figure figure)
        throws InvalideCoordinateException, FieldNotEmptyException {

        assert x >= 0;
        assert y >= 0;

        if (!CoordinateHelper.checkCoordinate(x) || !CoordinateHelper.checkCoordinate(y)) {
            throw new InvalideCoordinateException();
        }

        if (board.getFigure(x,y) != null){
            throw new FieldNotEmptyException();
        }
        board.setFigure(x,y,figure);
    }

    public Player[] getPlayers() {
        return players;
    }

}
