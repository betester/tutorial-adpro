package id.ac.ui.cs.tutorial6.model.musicplayer;

public class PauseState extends MusicPlayerState {

    public PauseState(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void play() {
        musicPlayer.setCurrentState(musicPlayer.playingState);
    }

    @Override
    public void pause() {
        //do nothing
    }

    @Override
    public void stop() {
        musicPlayer.setCurrentState(musicPlayer.stopState);
    }

    @Override
    public String toString() {
        return "Paused";
    }
}
