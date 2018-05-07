package model;

/**
 * Created by ADMIN on 5/6/2018.
 */

public class Transport {
    public int transportId;
    public String transportName;
    public String description;
    public int thumbnail;

    public Transport(String transportName, String description,int thumbnail) {
        this.transportName = transportName;
        this.description = description;
        this.thumbnail=thumbnail;
    }
}
