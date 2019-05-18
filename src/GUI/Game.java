
package GUI;

import DATA.UserData;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * the class represent the pet game start
 * @author Yu Liu
 */
public class Game {

    /**
     * the pet game start
     * 
     * @throws Exception
     */
    public static void start() throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                welcome();
            }

        });
    }

    /**
     * the method represent start game
     */
    public static void welcome() {
        UserData.getInstance();
        GameFrame gameFrame = new GameFrame();
        WelcomeDialog welcomeDialog = new WelcomeDialog(gameFrame, true);
        welcomeDialog.setVisible(true);
        if (welcomeDialog.getReturnStatus() == WelcomeDialog.RET_OK) {
            Timing idleThread = new Timing();
            idleThread.setDaemon(true);
            idleThread.start();
            gameFrame.showPicture();
            gameFrame.showProperty();
            gameFrame.setVisible(true);
        } else {
            System.exit(0);
        }
    }
}
