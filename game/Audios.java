package game;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Audios {
	
	static boolean mute = false;
	
	
    // function name: playSoundEffect()
    // description: plays sound effect upon clicking on an option
    // parameters: none
    // return: none
	public static void playSoundEffect() throws UnsupportedAudioFileException, IOException, LineUnavailableException  {
		
		File file = new File("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\audio\\Video Game Beep - Sound Effect.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}
	
    // function name: playMusic()
    // description: plays game music
    // parameters: none
    // return: none
	public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// to-do
	}
	
	
    // function name: ballOnPaddle()
    // description: plays sound effect upon ball touching paddle
    // parameters: none
    // return: none
	public static void ballOnPaddle() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		File file = new File("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\audio\\paddleBall.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		if(mute == false) {
		    clip.start();
		}
		else {
			clip.stop();
		}
	}
	
    // function name: wallCollision()
    // description: plays sound effect upon ball touching walls/barriers of frame
    // parameters: none
    // return: none
	public static void wallCollision() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		File file = new File("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\audio\\wallCollision.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		if(mute == false) {
		    clip.start();
		}
		else {
			clip.stop();
		}
	}
	
    // function name: ballOnBrick()
    // description: plays sound effect upon ball hitting bricks
    // parameters: none
    // return: none
	public static void ballOnBrick() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		File file = new File("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\audio\\ballOnBrick.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		if(mute == false) {
		    clip.start();
		}
		else {
			clip.stop();
		}
	}
	
    // function name: onDeath()
    // description: plays sound effect losing lives
    // parameters: none
    // return: none
	public static void onDeath() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		File file = new File("C:\\Users\\mahi1\\eclipse-workspace\\Breakout\\src\\audio\\AUUGHHH Sound Effect.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		if(mute == false) {
		    clip.start();
		}
		else {
			clip.stop();
		}
	}
	
	
	

}
