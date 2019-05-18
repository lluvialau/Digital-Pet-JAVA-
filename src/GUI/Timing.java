package GUI;

import DATA.UserData;
import Model.Pet;
import Model.User;


/**
 *
 * The class represent count down for pet game
 * 
 * @author Yu Liu
 */
public class Timing extends Thread {

    
    public Timing() {
    }

    /**
     * caculate the time of game
     */
    @Override
    public void run() {
        UserData userDao = UserData.getInstance();
        User user;
        long lastTime = System.currentTimeMillis();
        while ((user= userDao.getLoginUser())!=null) {
            try {
                Pet pet = user.getPet();
                long currentTime = System.currentTimeMillis();
                if (Math.abs(currentTime - lastTime) > 5000) {
                    if (user.getStatus().equals("idle")) {
                        // reduce happiness with time
                        if (pet.getHappiness() > 0) {
                            userDao.setHappiness(user, pet.getHappiness() - 1);
                        }
                    }
                    lastTime = currentTime;
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
