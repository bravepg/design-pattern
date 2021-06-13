package behavior.observer.pubsub;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

interface Ipublisher<M> {
    public void publish(PubSub<M> pubSub, M message, boolean isInstantMsg);
}

class ConcretePublisher<M> implements Ipublisher<M> {
    private String name;
    public ConcretePublisher(String name) {
        this.name = name;
    }
    @Override
    public void publish(PubSub<M> pubSub, M message, boolean isInstantMsg) {
      pubSub.publish(this.name, message, isInstantMsg);
    }
}

class PubSub<M> {
    private BlockingQueue<Msg<M>> queue = new ArrayBlockingQueue<Msg<M>>(2);
    private ArrayList<ISubscriber<M>> subscribers = new ArrayList<ISubscriber<M>>();
    public void subscribe(ISubscriber<M> subscriber){
        subscribers.add(subscriber);
    }
    public void unsubscribe(ISubscriber<M> subscriber) {
        subscribers.remove(subscriber);
    }
    public void publish(String publisher, M message, boolean isInstantMsg) {
        if (isInstantMsg) {
            this.update(publisher, message);
            return;
        }
        Msg<M> m = new Msg<M>(publisher, message);

        System.out.println("queue.offer(m)" + queue.offer(m));

        if (!queue.offer(m)) {
            this.update();
        }
    }
    public void update() {
        Msg<M> m = null;
        while((m = queue.poll()) != null) {
            this.update(m.getPublisher(), (M)m.getM());
        }
    }
    public void update(String publisher, M message) {
        for (ISubscriber<M> subscriber: subscribers) {
            subscriber.update(publisher, message);
        }
    }
}

interface ISubscriber<M> {
    public void subscribe(PubSub<M> pubSub);
    public void unsubscribe(PubSub<M> pubSub);
    public void update(String publisher, M message);
}

class ConcreateSubscriber<M> implements ISubscriber<M> {
    private String name;
    public ConcreateSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void subscribe(PubSub<M> pubSub) {
        pubSub.subscribe(this);
    }
    @Override
    public void unsubscribe(PubSub<M> pubSub) {
        pubSub.unsubscribe(this);
    }
    @Override
    public void update(String publisher, M message) {
        System.out.println(this.name + "收到" + publisher + "发来的消息:" + message.toString());
    }
}

class Msg<M> {
    private String publisher;
    private M m;

    public Msg(String publisher, M m) {
        this.publisher = publisher;
        this.m = m;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public M getM() {
        return this.m;
    }

    public void setM(M m) {
        this.m = m;
    }
}

public class Main {
    public static void main(String[] args) {
        PubSub<String> pubSub = new PubSub<String>();
        Ipublisher<String> publisher1 = new ConcretePublisher<String>("发布者1");
        ISubscriber<String> subscriber1 = new ConcreateSubscriber<String>("订阅者1");
        ISubscriber<String> subscriber2 = new ConcreateSubscriber<String>("订阅者2");
        subscriber1.subscribe(pubSub);
        subscriber2.subscribe(pubSub);
        publisher1.publish(pubSub, "welcome", true);
        publisher1.publish(pubSub, "to", true);
        publisher1.publish(pubSub, "yy", false);   
        publisher1.publish(pubSub, "yy1", false); 
    }
}
