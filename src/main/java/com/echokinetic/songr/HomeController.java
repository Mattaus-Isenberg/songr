package com.echokinetic.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller

public class HomeController
{
    @Autowired
    AlbumRepository album_Repository;

    @Autowired
    TrackRepository track_Repository;



    @GetMapping("/")
    public String getHome(String input, Model m)
    {
        m.addAttribute("username", input);

        return "home";
    }

    @GetMapping("/hello")
    public String getHello(String input, Model m)
    {
        return "Hello";
    }

    @GetMapping("/emotions")
    public String getEmotions(Model m)
    {
        Emotion[] emotions = new Emotion[] {new Emotion("Stress", 15, "LinkedLists"), new Emotion("Sleep Depravation", 10, "Multiple reasons")};
        m.addAttribute("emotionsList", emotions);

        return "emotions";
    }


    @GetMapping("/capitalize/{text}")
    public String capitalizeIt(@PathVariable String text, Model m)
    {
        text = text.toUpperCase();
        m.addAttribute("text", text);

        return "capitalize";
    }

   @PostMapping("/album/delete/{id}")
   public RedirectView deleteEntry(@PathVariable long id)
   {
       album_Repository.deleteById(id);

       return new RedirectView("/albums");
   }

    @PostMapping("/tracks/delete/{id}")
    public RedirectView deleteTrack(@PathVariable long id)
    {
        Track track = track_Repository.getOne(id);
        track_Repository.deleteById(id);

        return new RedirectView("/albums/" + track.album.id);
    }

    @GetMapping("/albums")
    public String getEveryAlbums(Model m)
    {
        List<Album> albums = album_Repository.findAll();
        m.addAttribute("albums", albums);
        return "everyAlbum";
    }

    @GetMapping("/album/{id}")
    public String getSingleAlbum(@PathVariable long id, Model m)
    {
        Album album = album_Repository.findById(id).get();
        m.addAttribute("album", album);
        List<Track> tracks = track_Repository.findByAlbum(album);
        m.addAttribute("tracks", tracks);
        return "singleAlbum";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl)
    {
        Album a = new Album(title, artist, songCount, length, imageUrl);
        album_Repository.save(a);
        return new RedirectView("/albums");
    }

    @GetMapping("/tracks")
    public String getTracks(Model m)
    {
        List<Track> tracks = track_Repository.findAll();
        m.addAttribute("tracks", tracks);
        return "tracks";
    }

    @PostMapping("/album/{id}/tracks")
    public RedirectView addTrack(String title, int length, int trackNumber, @PathVariable long id)
    {
        Album album = album_Repository.getOne(id);
        Track track = new Track(title, length, trackNumber, album);
        track_Repository.save(track);
        return new RedirectView("/album/" + id);
    }
}
