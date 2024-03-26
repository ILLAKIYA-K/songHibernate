/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.repository.SongJpaRepository;
import com.example.song.repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class SongJpaService implements SongRepository {

    @Autowired
    private SongJpaRepository serv;

    @Override
    public Song updateSong(int songId, Song son) {
        try {
            Song f = serv.findById(songId).get();
            if (son.getSongName() != null) {
                f.setSongName(son.getSongName());
            }
            if (son.getLyricist() != null) {
                f.setLyricist(son.getLyricist());
            }
            if (son.getSinger() != null) {
                f.setSinger(son.getSinger());
            }
            if (son.getMusicDirector() != null) {
                f.setMusicDirector(son.getMusicDirector());
            }
            serv.save(f);
            return f;
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ArrayList<Song> getSong() {
        List<Song> songColl = serv.findAll();
        ArrayList<Song> arr = new ArrayList<>(songColl);

        return arr;
    }

    @Override
    public Song addSong(Song so) {
        serv.save(so);
        return so;
    }

    @Override
    public Song getSongbyId(int songId) {
        try {
            Song ks = serv.findById(songId).get();
            return ks;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delSong(int songId) {
        try {

            serv.deleteById(songId);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}
