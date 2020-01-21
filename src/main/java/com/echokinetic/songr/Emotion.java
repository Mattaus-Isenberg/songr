package com.echokinetic.songr;

public class Emotion
{
    public String emotionName;
    private int strength;
    String reason;


    public Emotion(String emotionName, int strength, String reason)
    {
        this.emotionName = emotionName;
        this.strength = strength;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Emotion{" +
                "emotionName='" + emotionName + '\'' +
                ", strength=" + strength +
                ", reason='" + reason + '\'' +
                '}';
    }

    public int getStrength()
    {
        return this.strength;
    }

    public String getEmotionName()
    {
        return this.emotionName;
    }

    public String getReason()
    {
        return this.reason;
    }
}
