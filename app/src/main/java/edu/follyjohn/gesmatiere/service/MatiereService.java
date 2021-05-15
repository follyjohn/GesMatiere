package edu.follyjohn.gesmatiere.service;

import java.util.Vector;

import edu.follyjohn.gesmatiere.model.Matiere;

public class MatiereService {

    public static Vector<Matiere> listMatire = new Vector<Matiere>();

    public static void ajouterMatiere(Matiere matiere){
        listMatire.add(matiere);
    }


}
