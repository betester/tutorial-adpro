package id.ac.ui.cs.tutorial6.model.musicplayer;

public class PlayingState extends MusicPlayerState {

    public PlayingState(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void play() {
        //do nothing
    }

    @Override
    public void pause() {
        musicPlayer.setCurrentState(musicPlayer.pauseState);
    }

    @Override
    public void stop() {
        musicPlayer.setCurrentState(musicPlayer.stopState);
    }

    @Override
    public String toString() {
        return "Now playing";
    }
}
