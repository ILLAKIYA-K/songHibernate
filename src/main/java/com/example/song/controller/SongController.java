/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.model.Song;
import com.example.song.service.SongJpaService;

@RestController

public class SongController {
    @Autowired
    public SongJpaService ser;

    @DeleteMapping("/songs/{songId}")
    public void delSong(@PathVariable("songId") int songId)
    {
        ser.delSong(songId);
    }

    @GetMapping("/songs/{songId}")
    public Song getSongbyId(@PathVariable("songId") int songId) {
        return ser.getSongbyId(songId);
    }

    @GetMapping("/songs")
    public ArrayList<Song> getSong() {
        return ser.getSong();
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song so) {
        return ser.addSong(so);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable int songId, @RequestBody Song son) {
        return ser.updateSong(songId, son);
    }

}
