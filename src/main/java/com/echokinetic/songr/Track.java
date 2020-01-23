package com.echokinetic.songr;
import javax.persistence.*;

@Entity
public class Track
{
    @Id  //makes it the primary key of table, generated starts at one and increments
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;
    int length;
    int trackNumber;


    @ManyToOne
    Album album;

    public Track(){}

    public Track(String title, int length, int trackNumber, Album album)
    {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public long getId()
    {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Album getAlbum()
    {
        return album;
    }

    public void setAlbum(Album album)
    {
        this.album = album;
    }
}
