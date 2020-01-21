package com.echokinetic.songr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest
{

    @Test
    void constructorTest()
    {
        Album expected = new Album("Title", "Artist", 5, 77, "url");
        assertTrue(expected.getClass() == Album.class);
    }

    @Test
    void getTitle()
    {
        Album expected = new Album("Title", "Artist", 5, 77, "url");
        assertEquals("Title", expected.title);
    }

    @Test
    void getArtist()
    {
        Album expected = new Album("Title", "Artist", 5, 77, "url");
        assertEquals("Artist", expected.artist);
    }

    @Test
    void getSongCount()
    {
        Album expected = new Album("Title", "Artist", 5, 77, "url");
        assertEquals(5, expected.songCount);
    }

    @Test
    void getLength()
    {
        Album expected = new Album("Title", "Artist", 5, 77, "url");
        assertEquals(77, expected.length);
    }

    @Test
    void getImageUrl()
    {
        Album expected = new Album("Title", "Artist", 5, 77, "url");
        assertEquals("url", expected.imageUrl);
    }

    @Test
    void setterTest()
    {
        Album expected = new Album("Title", "Artist", 5, 77, "url");
        expected.setTitle("New Title");
        expected.setArtist("New Artist");
        expected.setSongCount(11);
        expected.setLength(99);
        expected.setImageUrl("url2");

        assertTrue("New Title" == expected.title);
        assertTrue("New Artist" == expected.artist);
        assertTrue(11 == expected.songCount);
        assertTrue(99 == expected.length);
        assertTrue("url2" == expected.imageUrl);
    }
}