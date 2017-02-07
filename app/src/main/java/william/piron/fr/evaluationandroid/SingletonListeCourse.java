package william.piron.fr.evaluationandroid;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by wilpiron on 18/01/2017.
 */

public class SingletonListeCourse {
    private ArrayList<ListeDeCourse> ListeDesListes;
    private int nombreDeListes;
    private static final SingletonListeCourse instance = new SingletonListeCourse();


    private SingletonListeCourse(){
        ListeDesListes = new ArrayList<ListeDeCourse>();
        nombreDeListes = 0;
    }

    public static SingletonListeCourse getInstance(){
        return instance;
    }

    private String dateDuJour(){
        //On récupère une instance de Calendar
        //On crée un format de date jj-mm-aaaa
        //On renvoie l'instance une fois formatée
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        return df.format(c.getTime());
    }

    private ListeDeCourse creerItemDeLaListe(ArrayList src){
        // Chaque item de notre "liste de liste" est un object ListeDeCourses
        // On incrémente au passage de compteur donnant le nombre total de listes, pour avoir un nom automatisé
        nombreDeListes += 1;
        ListeDeCourse ldc = new ListeDeCourse("Liste " + nombreDeListes, dateDuJour());

        src.add(ldc);
        return ldc;
    }

    public ListeDeCourse ajouterListe(){
        return creerItemDeLaListe(ListeDesListes);
    }

    public void supprimerListe(){
        //TODO Code supp 1 item de liste
    }

    public void supprimerTout(){
        ListeDesListes.clear();
        nombreDeListes = 0;
    }

    public void modifierListe(){
        //TODO Code modif contenu liste via un intent
    }

    public ArrayList getListe(){
        return ListeDesListes;
    }
}
