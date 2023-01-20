package id.ac.ui.cs.tutorial6.model.musicplayer;

public class StopState extends MusicPlayerState {

    public StopState(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void play() {
        musicPlayer.setCurrentState(musicPlayer.playingState);
    }

    @Override
    public void pause() {
        musicPlayer.setCurrentState(musicPlayer.pauseState);
    }

    @Override
    public void stop() {
        //do nothing
    }

    @Override
    public String toString() {
        return "Stopped";
    }
}
