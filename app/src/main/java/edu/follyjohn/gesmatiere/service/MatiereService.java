package edu.follyjohn.gesmatiere.service;

import java.util.Vector;

import edu.follyjohn.gesmatiere.model.Matiere;

public class MatiereService {

    public static Vector<Matiere> listMatire = new Vector<Matiere>();

    public static void ajouterMatiere(Matiere matiere){
        listMatire.add(matiere);
    }

    public static boolean checkIntegrity(Matiere m){
        if(m.getId() == null){
            return false;
        }
        if(m.getImage() == null){
            return false;
        }if(m.getEnseignant() == null){
            return false;
        }if(m.getLibelle() == null){
            return false;
        }

        Long id = m.getId();

        for (Matiere ma : listMatire) {
            if(ma.getId() == id){
                return false;
            }
        }
        return true;
    }

    public static boolean rechercherParId(Long id){
        for (Matiere m : listMatire) {
            if(m.getId() == id) {
                return true;
            }

    }
        return false;
    }

    public static Matiere selectParId(Long id) {
        Matiere ma = null;
        for (Matiere m : listMatire) {
            if (m.getId() == id) {
                ma = m;
            }
        }
        return ma;
    }



}
