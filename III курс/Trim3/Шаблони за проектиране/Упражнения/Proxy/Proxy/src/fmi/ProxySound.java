package fmi;

public class ProxySound implements Sound{
	
	private RealSound realSound;
	private String fileName;

	public ProxySound(String fileName){
		this.fileName = fileName;
	}

	@Override
	public void play() {
		if(realSound == null){
			realSound = new RealSound(fileName);
		}
		realSound.play();
	}
}
