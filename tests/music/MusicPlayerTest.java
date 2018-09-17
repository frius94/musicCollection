package music;

import org.junit.Test;

public class MusicPlayerTest {
    private MusicPlayer musicPlayer = new MusicPlayer();

    @Test(expected = NullPointerException.class)
    public void playSample() {
        musicPlayer.playSample("filename.mp3");
    }
}