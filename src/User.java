public sealed class User permits AdminUser{
    protected String userId;
    public User(String userId){
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

}
