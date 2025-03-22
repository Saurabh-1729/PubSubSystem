import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    private final String Name;
    Set<Subscriber> subscribers;

    public Topic(String name) {
        Name = name;
        subscribers = new CopyOnWriteArraySet<>();
    }

    public void addSubscriber(Subscriber subs){
        subscribers.add(subs);
    }

    public void removeSubscriber(Subscriber subs){
        subscribers.remove(subs);
    }

    public void publicMessage(Message message){
        for (Subscriber subscriber : subscribers) {
            subscriber.onMessage(message);
        }
    }
}
