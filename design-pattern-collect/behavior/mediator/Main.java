import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void operation();
    void resigter(Colleague colleague);
}

class ConcreateMediator implements Mediator {
    List<Colleague> arrColleagues = new ArrayList<>();

    public void resigter(Colleague colleague) {
        this.arrColleagues.add(colleague);
    }

    @Override
    public void operation() {
        for (Colleague colleague: arrColleagues) {
            colleague.recieveMsg("2");
        }
    }
}

abstract class Colleague {
    abstract void recieveMsg(String messag);
    abstract void sendMsg();
    abstract void setMediator(Mediator mediator);
}

class ConcreateColleagueA extends Colleague {
    Mediator mediator;

    @Override
    void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    void sendMsg() {
        mediator.operation();
    }

    @Override
    void recieveMsg(String message) {
        System.out.println(message);
    }
}

class ConcreateColleagueB extends Colleague {
    Mediator mediator;

    @Override
    void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    void sendMsg() {
        mediator.operation();
    }

    @Override
    void recieveMsg(String message) {
        System.out.println(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new ConcreateMediator();
        Colleague colleagueA = new ConcreateColleagueA();
        Colleague colleagueB = new ConcreateColleagueB();
        mediator.resigter(colleagueA);
        mediator.resigter(colleagueB);
        colleagueA.setMediator(mediator);
        colleagueB.setMediator(mediator);
        colleagueA.sendMsg();
    }
}