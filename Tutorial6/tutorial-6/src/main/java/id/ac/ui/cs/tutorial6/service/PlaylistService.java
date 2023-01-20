package id.ac.ui.cs.tutorial6.service;

import id.ac.ui.cs.tutorial6.model.playlist.Playlist;
import id.ac.ui.cs.tutorial6.model.song.Song;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PlaylistService {

  Playlist createPlaylist(String name);

  List<Playlist> getPlaylists();

  Playlist getPlaylistById(String id);

  Song getSongInPlaylist(Playlist playlist, String songId);

  Playlist addSongsToPlaylist(String idPlaylist, String[] idSongs);

  Playlist deleteSongFromPlaylist(String playlistId, String[] songId);

  Playlist updatePlaylist(String id, Optional<String> nameOpt, Optional<Set<Song>> songsSetOpt);

  void deletePlaylist(String id);
}
