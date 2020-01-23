package com.echokinetic.songr;

import javax.persistence.*;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
public class Album
{
    @Id  //makes it the primary key of table, generated starts at one and increments
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;


    @OneToMany(mappedBy = "album")
    public List<Track> tracks;

    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;


    public Album(String title, String artist, int songCount, int length, String imageUrl){
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public Album() {}

    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public int getSongCount()
    {
        return songCount;
    }

    public int getLength()
    {
        return length;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public void setSongCount(int songCount)
    {
        this.songCount = songCount;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }
}
