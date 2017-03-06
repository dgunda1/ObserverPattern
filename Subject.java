package Observer;
import java.util.ArrayList;

interface Subject{
    public void registerObserver (Observer observer);
    public void removeObserver (Observer observer);
    public void notifyObersevers();
}
 
interface Observer{
    public void update(String message);
}
 
class SubjectImpl implements Subject{
    private ArrayList<Observer> listOfObservers;
    String message;
     
    SubjectImpl(){
        listOfObservers = new ArrayList<Observer>();
    }
     
    public void registerObserver (Observer observer){
        listOfObservers.add (observer);
    }
     
    public void removeObserver (Observer observer){
        listOfObservers.remove (observer);
    }
     
    public void notifyObersevers(){
        int size = listOfObservers.size();
        for (int I=0; I<size; I++){
            Observer aObserver = listOfObservers.get(I);
            aObserver.update(message);
        }
        System.out.println ();
    }
     
    public void publish (String message){
        this.message = message;
        notifyObersevers();
    }
}
 
class ObserverImpl implements Observer{
    Subject subject;
    String name;
     
    ObserverImpl (String name, Subject subject){
        this.subject = subject;
        this.name = name;
        subject.registerObserver(this);
    }
     
    public void update(String message){
        System.out.println (name + " received newspaper of " + message);
    }
     
    public void unsubscribe(Subject subject){
        subject.removeObserver(this);
    }
}
 