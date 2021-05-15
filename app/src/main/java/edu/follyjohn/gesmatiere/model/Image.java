package edu.follyjohn.gesmatiere.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Image implements Parcelable {
    private String libelle;

    private int img;

    public Image(String libelle, int img) {
        this.libelle = libelle;
        this.img = img;
    }

    public Image() {
    }

    protected Image(Parcel in) {
        libelle = in.readString();
        img = in.readInt();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Image : "+ libelle +
                "";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(libelle);
        dest.writeInt(img);
    }
}
