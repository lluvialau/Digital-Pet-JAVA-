package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

/**
 * this class represent the size of interface
 * @author Yu Liu
 */
public class WindowUtil {
     /**
     * adjust the size of interface
     * @param window
     */
    public static void center(Window window) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = window.getSize();
		window.setLocation(
				(int) (screenSize.getWidth() - windowSize.getWidth()) / 2,
				(int) (screenSize.getHeight() - windowSize.getHeight()) / 2);
	}
}
