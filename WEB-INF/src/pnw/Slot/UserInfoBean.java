package pnw.Slot;

public class UserInfoBean {

    private int userID;
    private int score;

    public UserInfoBean(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }

    // public void setUserID(String userID) {
    //     this.userID = userID;
    // }

    // public String getPassword() {
    //     return password;
    // }

    // public void setPassword(String password) {
    //     this.password = password;
    // }

    /**
     * @return String return the ID
     */
    // public int getID() {
    //     return ID;
    // }

    /**
     * @param ID the ID to set
     */
    // public void setID(int ID) {
    //     this.ID = ID;
    // }

}