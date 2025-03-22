import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Publisher {
//    private final String Name;
    Set<Topic> topics = new CopyOnWriteArraySet<>();

//    public Publisher(String name) {
//        Name = name;
//    }

//    public String getName() {
//        return Name;
//    }

    public void registerTopic(Topic topic){
        topics.add(topic);
    }

    public void publishMessage(Topic topic, Message message){
        if(!topics.contains(topic)){
            System.out.println("The publisher is not register to the topic: " + topic);
            return;
        }
        topic.publicMessage(message);
    }
}
