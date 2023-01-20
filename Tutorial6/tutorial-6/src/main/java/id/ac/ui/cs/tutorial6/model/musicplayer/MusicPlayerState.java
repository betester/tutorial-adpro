package id.ac.ui.cs.tutorial6.model.musicplayer;

public abstract class MusicPlayerState {
    protected MusicPlayer musicPlayer;

    protected MusicPlayerState(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public abstract void play();
    public abstract void stop();
    public abstract void pause();
    public abstract String toString();
}
