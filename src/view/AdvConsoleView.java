package view;

import controller.GameController;

/**
 * Created by Dashenka Struts on 24.05.2015.
 */
public class AdvConsoleView  extends ConsoleView {

   public AdvConsoleView(final GameController gameController) {
        super(gameController);
    }

    @Override
    public void showGameName() {
        printLine();
        System.out.println(gameController.getGameName());

    }

    private void printLine() {

        System.out.println("***");

    }

}
