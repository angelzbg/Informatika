package com.fmi.adapter;

public class AudioPlayer implements IMediaPlayer {
	private final MediaAdapter adapter;

	public AudioPlayer(final String type) {
		if ("vlc".equalsIgnoreCase(type)) {
			final IAdvancetMediaPlayer player = new VlcPlayer();
			this.adapter = new MediaAdapter(player);
		} else if ("mp4".equalsIgnoreCase(type)) {
			final IAdvancetMediaPlayer player = new Mp4Player();
			this.adapter = new MediaAdapter(player);
		}else{
			this.adapter = null;
		}

	}

	@Override
	public void play() {
		if(null != adapter){
			adapter.play();
		}
	}

}
