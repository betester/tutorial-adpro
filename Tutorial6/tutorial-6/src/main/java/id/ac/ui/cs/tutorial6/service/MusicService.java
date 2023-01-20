package id.ac.ui.cs.tutorial6.service;

import id.ac.ui.cs.tutorial6.model.musicplayer.MusicPlayer;
import id.ac.ui.cs.tutorial6.model.playlist.Playlist;
import id.ac.ui.cs.tutorial6.model.song.Song;

public interface MusicService {

  void setting(Playlist currentPlaylist, Song currentSong);

  void play();

  void pause();

  void stop();

  MusicPlayer getMusicPlayer(String state);
}
