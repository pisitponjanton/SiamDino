package Sound;

import java.io.*;
import javax.sound.sampled.*;

public class SoundGame {
    private static Clip clip;

    private static void load() {
        try {
            File soundFile = new File("Sound/wav/game.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void play() {
        load();
        if (clip != null && SoundMusic.p()) {
            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public static void stop() {
        if ((clip != null && clip.isRunning()) || SoundMusic.p()) {
            clip.stop();
        }
    }
}
