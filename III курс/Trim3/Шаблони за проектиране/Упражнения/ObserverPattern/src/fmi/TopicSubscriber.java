package fmi;

public class TopicSubscriber implements Observer{
	private String name;
	private Subject topic;
	
	public TopicSubscriber(String name){
		this.name = name;
	}

	public void update() {
		if(topic == null){
			log("has no topic set");
			return;
		}
		String msg = topic.getUpdate();
		if(msg == null){
			log("No message");
		}else{
			log("reads topic > " + msg);
		}
	}

	public void setTopic(Subject sub){
		this.topic = sub;
	}
	private void log(String msg){
		System.out.println(name + " > " + msg);
	}
}
