package music;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Track> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<Track>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(new Track(filename));
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            Track track = files.get(index);
            System.out.println(track.toString());
        }
    }
    
    
    //TODO: implement a listAllFiles method (task 2) use a for-each loop or lambda

    public void listAllFiles() {
        int id = 0;
        for (Track t: files) {
            System.out.println("ID: "+ id + "\n" + t.toString());
            id++;
        }
    }
    
    //TODO: implement a listMatching method (task 3)

    public void listMatching(String input) {
        for (Track t: files) {
            if (t.getArtist().contains(input))
                System.out.println(t.getArtist());
            if (t.getTitle().contains(input))
                System.out.println(t.getTitle());
            if (t.getFilename().contains(input))
                System.out.println(t.getFilename());
        }
    }
    
    

    /**
     * Find the index of the first file matching the given
     * search string.
     * @param searchString The string to match.
     * @return The index of the first occurrence, or -1 if
     *         no match is found.
     */
    public int findFirst(String searchString)
    {
        int index = 0;
        // Record that we will be searching until a match is found.
        boolean searching = true;
    
        while(searching && index < files.size()) {
            String filename = files.get(index).getFilename();
            if(filename.toLowerCase().contains(searchString.toLowerCase())) {
                // A match. We can stop searching.
                searching = false;
            }
            else {
                // Move on.
                index++;
            }
        }
        if(searching) {
            // We didn�t find it.
            return -1;
        }
        else {
            // Return where it was found.
            return index;
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        } else {
            System.out.println("Track not found");
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index).getFilename();
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Play all available Samples
     */
    public void playAllSamples() {
        for (Track t: this.files) {
            this.player.playSample(t.getFilename());

        }
    }

    public ArrayList<Track> getFiles() {
        return files;
    }

    public String listDirFiles() {
        Scanner scanner = new Scanner(System.in);
        File folder = new File(System.getProperty("user.dir") + "\\tracks");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println(i + ") " + listOfFiles[i].getName());
            }
        }
        System.out.print("Enter ID: ");
        return listOfFiles[scanner.nextInt()].getName();
    }
}
