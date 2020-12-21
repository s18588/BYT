import java.util.HashMap;
import java.util.Map;

public class ChatroomImpl implements Chatroom {

    private HashMap<String, User> userList = new HashMap<String, User>();


    @Override
    public void newUser(User user) {
        if(!userList.containsKey(user.getName())) {
            user = userList.get(user.getName());
        }
        user.chatroom = this;
    }

    @Override
    public void message(User user1, User user2, String message) {
        User receiver = userList.get(user2);
        if(receiver != null) {
            receiver.receiveMessage(user1, message);
            receiver.notifySender(user1);
        }
    }
}
