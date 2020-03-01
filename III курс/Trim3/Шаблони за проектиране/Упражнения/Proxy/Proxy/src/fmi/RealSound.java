package fmi;

public class RealSound implements Sound{
	private String fileName;
	
	public RealSound(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}
	
	@Override
	public void play() {
		System.out.println("Playing: " + fileName);
	}

	private void loadFromDisk(String fileName){
		System.out.println("Loading file from disk: " + fileName);
	}
}
