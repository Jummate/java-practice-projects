import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AudioPlayer {
    static ArrayList<String> songList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static String songToPlay;
    static int songChoice;
    static File file;
    static AudioInputStream audioInputStream;
    static Clip clip = null;

    public static void main(String[] args) {
        songList.add("Maple - Dyalla.wav");
        songList.add("Regulate - Dyalla.wav");

        printSong();

        String response = "";
        String currentSong = "";

        while (!response.equals("Q")) {
            if (clip == null || !songToPlay.equals(currentSong)) {
                songChoice = getUserSongChoice();
                songToPlay = songList.get(songChoice);
                file = new File(songToPlay);
                currentSong = songToPlay;

                try {
                    if (clip != null) {
                        clip.stop();
                        clip.close();
                    }
                    audioInputStream = AudioSystem.getAudioInputStream(file);
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                } catch (UnsupportedAudioFileException e) {
                    System.out.println("Unsupported audio file");
                    continue;
                } catch (LineUnavailableException e) {
                    System.out.println("Audio line unavailable");
                    continue;
                } catch (IOException e) {
                    System.out.println("IO error occurred");
                    continue;
                }
            }

            printAudioPlayerOptions();
            System.out.print("Select an option: ");
            response = input.next().toUpperCase();

            switch (response) {
                case "P" -> clip.start();
                case "S" -> clip.stop();
                case "R" -> clip.setMicrosecondPosition(0);
                case "N" -> {
                    clip.stop();
                    clip.close();
                    clip = null;
                }
                case "Q" -> {
                    clip.stop();
                    clip.close();
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    static void printSong() {
        System.out.println("======== Available Songs =======");
        System.out.println("Please enter the corresponding number to select a song to play");
        for (int i = 0; i < songList.size(); i++) {
            System.out.println(i + 1 + ". " + formatSong(songList.get(i)));

        }
    }

    static void printAudioPlayerOptions() {
        System.out.println("P to Play");
        System.out.println("S to Stop");
        System.out.println("R to Reset");
        System.out.println("N to New Song");
        System.out.println("Q to Quit");
    }

    static String formatSong(String song) {
        String[] splitString = song.split("-");
        String songName = splitString[0].trim();
        String artiste = splitString[1].replace(".wav", "");
        return songName + ".wav" + "\tby " + artiste;
    }

    static int getUserSongChoice() {
        System.out.print("Select a song: ");
        int songChoice = input.nextInt();
        if (songChoice <= 0 || songChoice > songList.size()) {
            System.out.println("Invalid choice. Terminating program...");
            System.exit(0);
        }
        input.nextLine();

        return songChoice - 1;
    }
}
