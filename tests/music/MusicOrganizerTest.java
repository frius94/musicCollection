package music;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MusicOrganizerTest {
    private MusicOrganizer musicOrganizer = new MusicOrganizer();

    @Test
    public void addFile() {
        musicOrganizer.addFile("filename.mp3");
        assertEquals("filename.mp3", musicOrganizer.getFiles().get(0).getFilename());
    }

    @Test
    public void getNumberOfFiles() {
        assertEquals(0, musicOrganizer.getNumberOfFiles());
    }

    @Test
    public void findFirst() {
        musicOrganizer.addFile("filename.mp3");
        assertEquals(0, musicOrganizer.findFirst("filename"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFile() {
        musicOrganizer.addFile("filename.mp3");
        musicOrganizer.removeFile(0);
        musicOrganizer.getFiles().get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void startPlaying() {
        musicOrganizer.startPlaying(0);
    }

    @Test(expected = NullPointerException.class)
    public void playAllSamples() {
        musicOrganizer.addFile("filename.mp3");
        musicOrganizer.playAllSamples();
    }

    @Test
    public void testEmptyArrayList() {
        assertTrue(musicOrganizer.getFiles().isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testWrongIndexAccess() {
        musicOrganizer.getFiles().get(0);
    }

    @Test(expected = NullPointerException.class)
    public void listMatching() {
        musicOrganizer.addFile("filename.mp3");
        musicOrganizer.listMatching(null);
    }
}