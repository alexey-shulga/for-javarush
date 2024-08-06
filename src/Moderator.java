public class Moderator extends User{
    private String access;

    public void setAccess(String access) {
        this.access = access;
    }
    public String getAccess() {
        return this.access;
    }

    @Override
    public String toString() {
        return (String.format("Name: %s. ID: %d", this.getUserName(), this.getUserId()));
    }

}
