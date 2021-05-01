package br.audio;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
	
	private Clip clip;

	public AudioPlayer(String path) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path));
			
			//RECUPERAR O FORMATO DO AUDIO
			AudioFormat baseFormat = ais.getFormat(); //PEGANDO A BASE DE FORMATO
			//CONVERSAO, DECODIFICACAO DO FORMATO PARA O FORMATO DESEJADO
			AudioFormat decodeFormat = new AudioFormat(
					AudioFormat.Encoding.PCM_SIGNED, //encoding
					baseFormat.getSampleRate(), //sampleSizeInBits
					16, //sampleRate
					baseFormat.getChannels(), //channels
					baseFormat.getChannels() * 2, //frameSize
					baseFormat.getSampleRate(), //FrameRate
					false); //bigEndian
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais); //AUDIO ENTENDIDO PELO SISTEMA
			clip = AudioSystem.getClip();
			clip.open(dais); //ABRIR O NOVO AUDIO DECODIFICADO
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void play() {
		if (clip == null) return;
		stop();
		clip.setFramePosition(0); //VOLTAR PARA O INICIO DA MUSICA
		clip.start();
	}
	
	public void stop() {
		if (clip.isRunning()) {
			clip.stop();
		}
	}
}
