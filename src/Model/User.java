package Model;

/**
 * this class represetn th user 
 * @author Yu Liu
 */
public class User {
    private String name;
    private String password;
    private Pet pet;
    private String status;
    private String kind;
    
    /**
     *
     * @param name
     * @param password
     * @param petName
     * @param kind
     */
    public User(String name, String password, String petName, String kind) {
        this.name = name;
        this.password = password;
        this.status="idle";
        this.kind=kind;
        pet=new Pet(petName);
    }

    /**
     * get the user name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the user password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * set the user password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get the status of user
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * set the status of user
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * get the user pet
     * @return
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * se the user pet
     * @param pet
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * get the type of user pet
     * @return
     */
    public String getKind() {
        return kind;
    }

    /**
     * set the type of user pet
     * @param kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + ", pet=" + pet + ", status=" + status + ", kind=" + kind + '}';
    }

}
