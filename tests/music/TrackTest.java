package music;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrackTest {
    private Track track = new Track("filename");

    @Test
    public void getArtist() {
        assertNull(track.getArtist());
    }

    @Test
    public void getTitle() {
        assertNull(track.getTitle());
    }

    @Test
    public void getFilename() {
        assertEquals("filename", track.getFilename());
    }

    @Test
    public void testToString() {
        String tempName = FilenameUtils.getBaseName(track.getFilename());
        assertEquals(tempName + '\n', track.toString());
    }
}