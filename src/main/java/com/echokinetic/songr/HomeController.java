package com.echokinetic.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class HomeController
{
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
    public String getAlbums(Model m)
    {
        Album[] albums = new Album[] {new Album("TrackOne", "Me", 5, 67, "imageOne"), new Album("TrackTwo", "MeTwo", 7, 73, "imageTwo"), new Album("TrackThree", "MeThree", 9, 88, "imageThree")};
        m.addAttribute("albumsList", albums);

        return "albums";
    }

}
