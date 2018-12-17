package sonu.finds.happynewyear2019.Models;

public class NewyearModel {
    int image;
    String text;

    public NewyearModel(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public NewyearModel(int image) {
        this.image = image;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
