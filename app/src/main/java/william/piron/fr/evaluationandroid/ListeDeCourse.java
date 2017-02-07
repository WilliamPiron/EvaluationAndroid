package william.piron.fr.evaluationandroid;

import java.util.ArrayList;

/**
 * Created by wilpiron on 18/01/2017.
 */

public class ListeDeCourse {
    private String nom;
    private String date;
    private ArrayList listeDItems;

    public ListeDeCourse(String nom, String date){
        this.nom = nom;
        this.date = date;
        listeDItems = new ArrayList<>();
    }

    public ArrayList getListeDItems(){
        return listeDItems;
    }

    public String getNom(){
        return nom;
    }

    public String getDate(){
        return date;
    }
}
