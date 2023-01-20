package id.ac.ui.cs.tutorial6.service;

import id.ac.ui.cs.tutorial6.model.musicplayer.MusicPlayer;
import id.ac.ui.cs.tutorial6.model.playlist.Playlist;
import id.ac.ui.cs.tutorial6.model.song.Song;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl implements MusicService {

  private static MusicPlayer musicPlayer = new MusicPlayer();

  @Override
  public void setting(Playlist playlist, Song song) {
    musicPlayer.setCurrentPlaylist(playlist);
    musicPlayer.setCurrentSong(song);
    musicPlayer.setCurrentState(musicPlayer.getStopState());
  }

  @Override
  public void play() {
    musicPlayer.play();
  }

  @Override
  public void pause() {
    musicPlayer.pause();
  }

  @Override
  public void stop() {
    musicPlayer.stop();
  }

  @Override
  public MusicPlayer getMusicPlayer(String state) {
    if (state.equalsIgnoreCase("play")){
      play();
    }else if (state.equalsIgnoreCase("pause")){
      pause();
    }else if (state.equalsIgnoreCase("stop")){
      stop();
    }
    return musicPlayer;
  }
}
