package id.ac.ui.cs.tutorial6.service;

import id.ac.ui.cs.tutorial6.model.song.Song;
import id.ac.ui.cs.tutorial6.model.song.SongGenre;
import id.ac.ui.cs.tutorial6.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

  @Autowired
  SongRepository songRepository;

  @Override
  public Song createSong(String name, SongGenre genre) {
    var song = Song.builder()
                .name(name)
                .genre(genre)
                .build();
    return songRepository.save(song);
  }

  @Override
  public List<Song> getSongs() {
    return songRepository.findAll();
  }

  @Override
  public void deleteSong(String id) {
    songRepository.deleteById(id);
  }
}
