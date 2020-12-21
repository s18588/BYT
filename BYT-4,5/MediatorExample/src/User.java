public abstract class User {

    Chatroom chatroom;
    public String name = null;

    public User(Chatroom chatroom, String name) {
        this.chatroom = chatroom;
        this.name = name;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public String getName() {
        return name;
    }

    public abstract void receiveMessage(User user1, String message);

    public abstract void notifySender(User user1);
}
