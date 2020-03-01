package fmi;

public interface Observer {
	public void update();
	public void setTopic(Subject sub);
}
