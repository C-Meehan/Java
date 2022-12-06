import java.util.HashMap;
import java.util.Set;

public class TrackList {
    public static void main(String[] args) {
    HashMap<String, String> trackList = new HashMap<String, String>();
    trackList.put("Say it Ain't So", "Flip on the telly");
    trackList.put("Beverly Hills", "That's where I want to be");
    trackList.put("Buddy Holly", "I look just like Buddy Holly");
    trackList.put("Undone", "If you want to destroy my sweater");

    String name = trackList.get("Say it Ain't So");

    Set<String> keys = trackList.keySet();

    for (String key : keys) {
        System.out.println(key);
        System.out.println(trackList.get(key));
    }

    // Soultion Video VVVVV
    // for (String key : trackList.keySet()){
    //     System.out.println(String.format("Track: %s: Lyrics: %s", key, trackList.get(key)));
    // }

    }
}