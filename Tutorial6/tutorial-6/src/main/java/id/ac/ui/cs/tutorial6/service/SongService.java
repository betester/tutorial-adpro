package id.ac.ui.cs.tutorial6.service;

import id.ac.ui.cs.tutorial6.model.song.Song;
import id.ac.ui.cs.tutorial6.model.song.SongGenre;

import java.util.List;

public interface SongService {

  Song createSong(String name, SongGenre genre);

  List<Song> getSongs();

  void deleteSong(String name);
}
