public class User {
    private String userName;
//    private String passWord;
    private Type preference;

    public User(String userName, Type preference){
        this.userName = userName;
        this.preference = preference;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
//
//    public String getPassWord() {
//        return passWord;
//    }

//    public void setPassWord(String passWord) {
//        this.passWord = passWord;
//    }

    public Type getPreference() {
        return preference;
    }

    public void setPreference(Type preference) {
        this.preference = preference;
    }
}
