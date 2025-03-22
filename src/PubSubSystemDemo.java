import java.util.concurrent.Flow;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PubSubSystemDemo {
    public static void main(String[] args) {
        Topic topic1 = new Topic("Topic1");
        Topic topic2 = new Topic("Topic2");

        // Create publishers
        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();

        // Create subscribers
        Subscriber subscriber1 = new Subscriber("Subscriber1");
        Subscriber subscriber2 = new Subscriber("Subscriber2");
        Subscriber subscriber3 = new Subscriber("Subscriber3");

        publisher1.registerTopic(topic1);
        publisher2.registerTopic(topic2);

        // Subscribe to topics
        topic1.addSubscriber(subscriber1);
        topic1.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber3);

        // Publish messages
        publisher1.publishMessage(topic1, new Message("Message1 for Topic1"));
        publisher1.publishMessage(topic1, new Message("Message2 for Topic1"));
        publisher2.publishMessage(topic2, new Message("Message1 for Topic2"));


        // Unsubscribe from a topic
        topic1.removeSubscriber(subscriber2);

        // Publish more messages
        publisher1.publishMessage(topic1, new Message("Message3 for Topic1"));
        publisher2.publishMessage(topic2, new Message("Message2 for Topic2"));
    }
}