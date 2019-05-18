package DATA;

import GUI.INotify;
import Model.Item;
import Model.Pet;
import Model.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * this class represent the data of users
 * @author Yu Liu
 */
public class UserData {

    private static UserData userDaota = null;
    private List<User> users = new ArrayList<User>();
    private User loginUser = null;
    private INotify notify;

    /**
     * this method load the user data
     */
    public UserData() {
        loadUser();
    }

    /**
     * this method set the notify
     * @param notify
     */
    public void setNotify(INotify notify) {
        this.notify = notify;
    }

    /**
     * this method get the details about log in user.
     * @return the log in user data
     */
    public User getLoginUser() {
        return loginUser;
    }

    /**
     * this method set the log in user data
     * @param loginUser represent log in user data
     */
    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
        if (loginUser != null) {
            loginUser.setStatus("idle");
        }
    }

    /**
     * 
     * @return the user daota 
     */
    public static UserData getInstance() {
        if (userDaota == null) {
            userDaota = new UserData();
        }
        return userDaota;
    }

    /**
     * load the new user
     */
    private void loadUser() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Connection conn = Database.getInstance().getConnection();
            pstmt = conn.prepareStatement("select * from tuser");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String password = rs.getString(2);
                String petName = rs.getString(3);
                String kind=rs.getString(9).trim();
                User user = new User(name, password, petName,kind);
                Pet pet = user.getPet();
                pet.setStrength(rs.getInt(4));
                pet.setAgility(rs.getInt(5));
                pet.setStamina(rs.getInt(6));
                pet.setHappiness(rs.getInt(7));
                pet.setMoney(rs.getInt(8));
                users.add(user);
            }
            pstmt = conn.prepareStatement("select * from tgoods where fpetname=?");
            for (User user : users) {
                Pet pet = user.getPet();
                pstmt.setString(1, pet.getName());
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    String name = rs.getString(2);
                    int qty = rs.getInt(3);
                    Item goods = ItemsData.getInstance().get(name);
                    pet.addGoods(goods, qty);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Database.close(pstmt);
            Database.close(rs);
        }
    }

    /**
     * get user name
     * @param name represent user name
     * @return
     */
    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * check the user exist or not
     * @param name represent the user name
     * @return true if user exist
     *         else not
     */
    public boolean isExist(String name) {
        User user = getUser(name);
        return user != null;
    }

    /**
     * add a new user to database
     * @param name is user name
     * @param password is user password
     * @param petName is pet name
     * @param kind is the type of pet
     * @return
     */
    public User addUser(String name, String password, String petName, String kind) {
        User user = new User(name, password, petName,kind);
        PreparedStatement pstmt = null;
        try {
            Connection conn = Database.getInstance().getConnection();
            Pet pet = user.getPet();
            pstmt = conn.prepareStatement("insert into tuser values (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, pet.getName());
            pstmt.setInt(4, pet.getStrength());
            pstmt.setInt(5, pet.getAgility());
            pstmt.setInt(6, pet.getStamina());
            pstmt.setInt(7, pet.getHappiness());
            pstmt.setInt(8, pet.getMoney());
            pstmt.setString(9, user.getKind());
            pstmt.executeUpdate();
            users.add(user);
            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Database.close(pstmt);
        }
        return null;
    }

    /**
     * this method is used to save new user
     * @param user
     * @return true if user saved
     *         false if not
     */
    public boolean saveUser(User user) {
        PreparedStatement pstmt = null;
        try {
            if (notify != null) {
                notify.dataChange();
            }
            Connection conn = Database.getInstance().getConnection();
            Pet pet = user.getPet();
            String sql = "update tuser set fpassword=?,fpetname=?,strength=?,agility=?,";
            sql += "stamina=?,happiness=?,money=? where fname=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, pet.getName());
            pstmt.setInt(3, pet.getStrength());
            pstmt.setInt(4, pet.getAgility());
            pstmt.setInt(5, pet.getStamina());
            pstmt.setInt(6, pet.getHappiness());
            pstmt.setInt(7, pet.getMoney());
            pstmt.setString(8, user.getName());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Database.close(pstmt);
        }
        return false;
    }

    /**
     * save the user goods
     * @param user 
     */
    public void saveGoods(User user) {
        PreparedStatement pstmt = null;
        try {
            Connection conn = Database.getInstance().getConnection();
            Pet pet = user.getPet();
            pstmt = conn.prepareStatement("delete from tgoods where fpetname=?");
            pstmt.setString(1, pet.getName());
            pstmt.executeUpdate();
            pstmt = conn.prepareStatement("insert into tgoods values (?,?,?)");
            List<Item> goodsList = pet.listGoods();
            for (Item goods : goodsList) {
                pstmt.setString(1, pet.getName());
                pstmt.setString(2, goods.getName());
                pstmt.setInt(3, pet.getGoodsQty(goods));
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Database.close(pstmt);
        }
    }

    /**
     * delect the user data
     * @param user
     */
    public void delete(User user) {
        PreparedStatement pstmt = null;
        try {
            Connection conn = Database.getInstance().getConnection();
            Pet pet = user.getPet();
            pstmt = conn.prepareStatement("delete from tgoods where fpetname=?");
            pstmt.setString(1, pet.getName());
            pstmt.executeUpdate();
            pstmt = conn.prepareStatement("delete from tuser where fname=?");
            pstmt.setString(1, user.getName());
            pstmt.executeUpdate();
            users.remove(user);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Database.close(pstmt);
        }
    }

    /**
     * delete all of users' data
     */
    public void deleteAll() {
        PreparedStatement pstmt = null;
        try {
            Connection conn = Database.getInstance().getConnection();


            pstmt = conn.prepareStatement("delete from tuser ");
            //   pstmt.setString(1, user.getName());
            pstmt.execute();
            //    users.remove(user);
            pstmt = conn.prepareStatement("delete from tgoods ");
            //   pstmt.setString(1, user.getName());
            pstmt.execute();
            users.clear();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Database.close(pstmt);

        }
    }

    /**
     * user add new item
     * @param user
     * @param goods
     */
    public void buy(User user, Item goods) {
        user.getPet().buyGoods(goods);
        playCoinAudio();
        saveGoods(user);
    }

    /**
     * play the sound of game
     */
    public static void playAudio() {
        try {
            AudioStream audioStream;
            audioStream = new AudioStream(ClassLoader.getSystemResourceAsStream("Files/wo.wav"));
            AudioPlayer.player.start(audioStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * play the coin cound
     */
    public static void playCoinAudio() {
        try {
            AudioStream audioStream;
            audioStream = new AudioStream(ClassLoader.getSystemResourceAsStream("Files/coin.wav"));
            AudioPlayer.player.start(audioStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * this method represent user eat items.
     * @param user
     * @param goods
     */
    public void eat(User user, Item goods) {
        playAudio();
        user.getPet().eatGoods(goods);
        saveUser(user);
        saveGoods(user);
    }

    /**
     * the user add money
     * @param user
     * @param money
     */
    public void addMoney(User user, int money) {
        user.getPet().setMoney(user.getPet().getMoney() + money);
        saveUser(user);
    }

    /**
     * set the happiness of the user
     * @param user
     * @param happiness
     */
    public void setHappiness(User user, int happiness) {
        Pet pet = user.getPet();
        pet.setHappiness(happiness);
        saveUser(user);
    }
}
