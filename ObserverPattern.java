package Observer;

class ObserverPattern{
    public static void main (String ... args){
         
        SubjectImpl newsPaper = new SubjectImpl();
        ObserverImpl Jack = new ObserverImpl("Jack", newsPaper);
        ObserverImpl Sparrow = new ObserverImpl("Sparrow", newsPaper);
         
        newsPaper.publish("14 September");
        newsPaper.publish("15 September");
        newsPaper.publish("16 September");
         
        // Jack doesn't want newspaper anymore
        Jack.unsubscribe(newsPaper);
         
        // Only Sparrow will receive newspaper henceforth
        newsPaper.publish("17 September");
         
    }
}