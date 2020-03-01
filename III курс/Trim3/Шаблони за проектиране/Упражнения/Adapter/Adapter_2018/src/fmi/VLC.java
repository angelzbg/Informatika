package fmi;

public class VLC implements MediaPackage {

	@Override
	public void playFile(String filename) {
		System.out.println("Playing VLC file " + filename);

	}

}
