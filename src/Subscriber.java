public class Subscriber {
    private final String Name;

    public Subscriber(String name) {
        Name = name;
    }

    public void onMessage(Message message){
        System.out.println(Name + " Has received a message: " + message.getContent());
    }
}
