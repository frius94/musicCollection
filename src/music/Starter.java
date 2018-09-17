package music;

import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {

        MusicOrganizer musicOrganizer = new MusicOrganizer();

        //TODO: how can we start playing the music?
        Scanner scanner = new Scanner(System.in);
        String input = "";



        while (!input.equals("x")) {

            System.out.println("1) Play all tracks\n2) List all tracks\n3) Add track\n4) Remove track\n5) Get number of tracks\n6) Search for track\n7) Play one track\n8) Stop current playing music\nx) Exit");
            input = scanner.nextLine();

            switch (input) {

                case "1":
                    if (musicOrganizer.getFiles().isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        musicOrganizer.playAllSamples();
                    }
                    break;
                case "2":
                    if (musicOrganizer.getFiles().isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        musicOrganizer.listAllFiles();
                    }
                    break;

                case "3":
                    String filename = musicOrganizer.listDirFiles();
                    musicOrganizer.addFile(System.getProperty("user.dir") + "\\tracks\\" + filename);
                    System.out.println("File added successfully");
                    break;

                case "4":
                    if (musicOrganizer.getFiles().isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        musicOrganizer.listAllFiles();
                        System.out.println("Enter ID: ");
                        int id = scanner.nextInt();
                        musicOrganizer.removeFile(id);
                        System.out.println("File removed successfully");
                    }
                    break;

                case "5":
                    if (musicOrganizer.getFiles().isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        System.out.println("Number of tracks: " + musicOrganizer.getNumberOfFiles());
                    }
                    break;

                case "6":
                    if (musicOrganizer.getFiles().isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        System.out.print("Search keyword: ");
                        String keyword = scanner.nextLine();
                        int foundID = musicOrganizer.findFirst(keyword);
                        if (foundID == -1) {
                            System.out.println("No tracks found");
                        } else {
                            System.out.println("Track found: ");
                            System.out.println(musicOrganizer.getFiles().get(foundID).toString());
                        }
                    }
                    break;

                case "7":
                    if (musicOrganizer.getFiles().isEmpty()) {
                        System.out.println("List is empty");
                    } else {
                        musicOrganizer.listAllFiles();
                        System.out.print("Which Track to play? ID: ");
                        int playID = scanner.nextInt();
                        try {
                            musicOrganizer.startPlaying(playID);
                        } catch (IndexOutOfBoundsException e) {
                            System.err.println("Track not found");
                        }
                    }
                    break;

                case "8":
                    musicOrganizer.stopPlaying();
                    break;

                case "x":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unknown input");
            }
        }
    }
} 
