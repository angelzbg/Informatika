package fmi;

public class FormatAdapter implements MediaPlayer {

	private MediaPackage media;
	
	public FormatAdapter(MediaPackage media) {
		this.media = media;
	}
	
	@Override
	public void play(String filename) {
		System.out.println("Using Adapter: ");
		media.playFile(filename);

	}

}
