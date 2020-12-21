public interface Chatroom {

    public abstract void newUser(User user);
    public abstract void message(User user1, User user2, String message);


}
