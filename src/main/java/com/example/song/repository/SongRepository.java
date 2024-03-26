// Write your code here

package com.example.song.repository;

import java.util.*;

import com.example.song.model.Song;

public interface SongRepository {
    ArrayList<Song> getSong();
    void delSong(int songId);
    Song getSongbyId(int songId);

    Song addSong(Song so);

    Song updateSong(int songId, Song son);
}