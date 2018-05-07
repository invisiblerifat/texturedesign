package model;

public class Item {
    public int itemId;
    public String itemCode;
    public String itemDesc;
    public int thumbnail;

    public Item() {
    }

    public Item(int itemId, String itemCode, String itemDesc, int thumbnail) {
        this.itemId = itemId;
        this.itemCode = itemCode;
        this.itemDesc = itemDesc;
        this.thumbnail = thumbnail;
    }
}
