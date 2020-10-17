import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<MusicInfo> files;
    //favorite musics
    private ArrayList<MusicInfo> favFiles;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * this method is for adding a new favourite file to the favourite list
     * @param fileAddress address file of the favourite music
     */
    public void addingFavouriteMusic(String fileAddress){
        for(MusicInfo mi: files){
            if(mi.getFileAddress().equals(fileAddress)){
                favFiles.add(mi);
                break;
            }
        }
    }

    /**
     * this method can remove songs from favourite music list
     * @param fileAddress address of file
     */

    public void removeFavouriteFile(String fileAddress){
        Iterator<MusicInfo> it = files.iterator();
        while(it.hasNext()){
            if(it.next().getFileAddress().equals(fileAddress)){
                it.remove();
            }
        }
    }
    /**
     * this method will print a list of favourite musics
     */
    public void printFavouriteMusics(){
        for(MusicInfo mi:favFiles){
            mi.printMusicInfo();
        }
    }

    /**
     * this method will get a string to search in music files list
     * the input String can be both singer name or file address
     * this method will search in the files and print the information of the song
     * @param singerOrFileAddress singer name or file address
     */
    public void searchMusic(String singerOrFileAddress){
        for(MusicInfo mi:files){
            if(mi.getFileAddress().equals(singerOrFileAddress) || mi.getSingerName().equals(singerOrFileAddress) ){
                mi.printMusicInfo();
            }
        }
    }
    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        files = new ArrayList<MusicInfo>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param newMusic The file to be added.
     */
    public void addFile(MusicInfo newMusic)
    {
        files.add(newMusic);
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
        if(validIndex(index)){
            files.get(index).printMusicInfo();
        }

    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(MusicInfo mi : files){
            mi.printMusicInfo();
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(validIndex(index)){
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        if(validIndex(index)){
            player.stop();
            player.startPlaying(files.get(index).getFileAddress());
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        if(index > files.size() - 1){
            System.out.println("Error");
            return false;
        }
        else{
            return true;
        }
        // The return value.
        // Set according to whether the index is valid or not.
    }

}


