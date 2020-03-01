package com.fmi.adapter;

public class MediaAdapter implements IMediaPlayer {
	private final IAdvancetMediaPlayer player;

	public MediaAdapter(final IAdvancetMediaPlayer playerArg) {
		this.player = playerArg;
	}

	@Override
	public void play() {
		if (player instanceof VlcPlayer) {
			player.playVlc();
		} else {
			player.playMp4();
		}
	}
}
