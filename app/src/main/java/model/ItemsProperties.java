package model;

public class ItemsProperties {

   private String tvItemName;
    private int itemImage;
    private String tvItemPrice;
     private String tvItemDescription;

    public ItemsProperties(String tvItemName, int itemImage, String tvItemPrice, String tvItemDescription) {
        this.tvItemName = tvItemName;
        this.itemImage = itemImage;
        this.tvItemPrice = tvItemPrice;
        this.tvItemDescription = tvItemDescription;
    }

    public String getTvItemName() {
        return tvItemName;
    }

    public void setTvItemName(String tvItemName) {
        this.tvItemName = tvItemName;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getTvItemPrice() {
        return tvItemPrice;
    }

    public void setTvItemPrice(String tvItemPrice) {
        this.tvItemPrice = tvItemPrice;
    }

    public String getTvItemDescription() {
        return tvItemDescription;
    }

    public void setTvItemDescription(String tvItemDescription) {
        this.tvItemDescription = tvItemDescription;
    }
}
