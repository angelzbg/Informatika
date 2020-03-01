package com.fmi.adapter;

public class AdapterDemo {

	public static void main(String[] args) {
		final AudioPlayer player1 = new AudioPlayer("mp4");
		player1.play();
		final AudioPlayer player2 = new AudioPlayer("VLC");
		player2.play();

	}

}
