package com.echokinetic.songr;

public class Capitalize
{
    String capitalize;

    public Capitalize(String string)
    {
        this.capitalize = string.toUpperCase();
    }

    @Override
    public String toString()
    {
        return capitalize.toUpperCase();
    }
}
