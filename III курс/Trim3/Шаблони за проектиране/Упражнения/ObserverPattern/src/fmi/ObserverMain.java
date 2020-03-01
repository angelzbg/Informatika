package fmi;

public class ObserverMain {

	public static void main(String[] args) {
		
		Topic topic = new Topic();
		
		Observer obs1 = new TopicSubscriber("Subscriber_01");
		Observer obs2 = new TopicSubscriber("Subscriber_02");
		Observer obs3 = new TopicSubscriber("Subscriber_03");

		topic.register(obs1);
		topic.register(obs2);
		topic.register(obs3);
		
		obs1.setTopic(topic);
		obs2.setTopic(topic);
		//obs3.setTopic(topic);
		
		//obs1.update();
		//topic.notifyObservers();
		topic.postMessage("Breaking news!");
		topic.postMessage("Casual day");
		
		topic.notifyObservers();
	}

}
