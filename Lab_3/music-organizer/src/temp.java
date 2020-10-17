import java.util.ArrayList;

public class MusicOrganizer {
    private ArrayList<String> tracks = new ArrayList<String>();

    public void removeTrack(String nameLike){
        for(int i =  tracks.size() - 1; i >= 0; i-- ){
            if(tracks.get(i).contains(nameLike)){
                tracks.remove(i);
            }
        }
    }
}

