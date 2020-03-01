package fmi;

public class AdapterMain {

	public static void main(String[] args) {
		MediaPlayer player = new MP3();
		player.play("filename.mp3");
		
		player = new FormatAdapter(new MP4());
		player.play("filename.mp4");

		player = new FormatAdapter(new VLC());
		player.play("filename.avi");
		
	}

}
