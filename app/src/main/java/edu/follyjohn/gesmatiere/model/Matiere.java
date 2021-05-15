package edu.follyjohn.gesmatiere.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Matiere implements Parcelable {

    private Long id;

    private String libelle;

    private Boolean facultatif;

    private String enseignant;

    private Image image;

    public Matiere(Long id, String libelle, Boolean facultatif, String enseignant, Image image) {
        this.id = id;
        this.libelle = libelle;
        this.facultatif = facultatif;
        this.enseignant = enseignant;
        this.image = image;
    }

    public Matiere() {
    }

    protected Matiere(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        libelle = in.readString();
        byte tmpFacultatif = in.readByte();
        facultatif = tmpFacultatif == 0 ? null : tmpFacultatif == 1;
        enseignant = in.readString();
        image = in.readParcelable(Image.class.getClassLoader());
    }

    public static final Creator<Matiere> CREATOR = new Creator<Matiere>() {
        @Override
        public Matiere createFromParcel(Parcel in) {
            return new Matiere(in);
        }

        @Override
        public Matiere[] newArray(int size) {
            return new Matiere[size];
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getFacultatif() {
        return facultatif;
    }

    public void setFacultatif(Boolean facultatif) {
        this.facultatif = facultatif;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matiere)) return false;
        Matiere matiere = (Matiere) o;
        return id.equals(matiere.id) &&
                libelle.equals(matiere.libelle) &&
                facultatif.equals(matiere.facultatif) &&
                enseignant.equals(matiere.enseignant) &&
                image.equals(matiere.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, facultatif, enseignant, image);
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", facultatif=" + facultatif +
                ", enseignant='" + enseignant + '\'' +
                ", image=" + image +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(libelle);
        dest.writeByte((byte) (facultatif == null ? 0 : facultatif ? 1 : 2));
        dest.writeString(enseignant);
        dest.writeParcelable(image, flags);
    }
}


