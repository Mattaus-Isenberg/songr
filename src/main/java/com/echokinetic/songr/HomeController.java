package com.echokinetic.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/albums")
    public String getAllAlbums(Model m) {
        List<Album> albums = album_Repository.findAll();
        m.addAttribute("albums", albums);
        return "albums";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl) {
        Album a = new Album(title, artist, songCount, length, imageUrl);
        album_Repository.save(a);
        return new RedirectView("/albums");
    }

}
