package music;

import org.apache.commons.io.FilenameUtils;

public class Track {
    private String artist;
    private String title;
    private String filename;

    public Track(String filename) {
        this.filename = filename;
    }

    public String getArtist() {
        return artist;
    }


    public String getTitle() {
        return title;
    }


    public String getFilename() {
        return filename;
    }


    @Override
    public String toString() {
        String tempName = FilenameUtils.getBaseName(filename);
        return  tempName + '\n';
    }
}
