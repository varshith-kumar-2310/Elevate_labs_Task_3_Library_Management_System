public class User {
    private String user_id;//should be of 6 characters.
    private String user_name;
    private long user_phno;

    //constructor
    User(String user_id, String user_name, long user_phno)
    {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_phno = user_phno;
    }

    //getters
    public String getUserId()
    {
        return this.user_id;
    }
    public String getUserName()
    {
        return this.user_name;
    }
    public long getUserPhno()
    {
        return this.user_phno;
    }

    //setters
    public void setUserId(String user_id)
    {
        this.user_id = user_id;
    }
    public void setUserName(String user_name)
    {
        this.user_name = user_name;
    }
    public void setUserPhno(int user_phno)
    {
        this.user_phno = user_phno;
    }


    @Override
    public String toString() {
        return "User [user_id= " + user_id + ", user_name= " + user_name + ", user_phno= " + user_phno + "]";
    }

    
    

}

