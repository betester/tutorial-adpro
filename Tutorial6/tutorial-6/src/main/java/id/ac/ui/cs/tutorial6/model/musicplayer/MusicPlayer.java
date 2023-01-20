package id.ac.ui.cs.tutorial6.model.musicplayer;

import id.ac.ui.cs.tutorial6.model.playlist.Playlist;
import id.ac.ui.cs.tutorial6.model.song.Song;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MusicPlayer {

    PlayingState playingState = new PlayingState(this);
    PauseState pauseState = new PauseState(this);
    StopState stopState = new StopState(this);
    MusicPlayerState currentState;
    Playlist currentPlaylist;
    Song currentSong;

    public void play(){
        this.currentState.play();
    }

    public void stop(){
        this.currentState.stop();
    }

    public void pause(){
        this.currentState.pause();
    }
}
