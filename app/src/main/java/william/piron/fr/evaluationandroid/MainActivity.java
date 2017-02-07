package william.piron.fr.evaluationandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by wilpiron on 18/01/2017.
 */


public class MainActivity extends AppCompatActivity {
    // variables déclarées ici afin d'y accéder dans les Listener
    SingletonListeCourse single = SingletonListeCourse.getInstance();
    ListView lv;
    SimpleAdapter simpleAdapter;
    ArrayList listeAAfficher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listeAAfficher = new ArrayList<>();
        String[] from = {"nom", "date"};
        int[] to = {R.id.nomliste, R.id.dateListe};


        simpleAdapter = new SimpleAdapter(this, listeAAfficher,R.layout.liste_courses_items, from, to);
        lv = (ListView) findViewById(R.id.linearLayoutVertical_listeView);
        lv.setAdapter(simpleAdapter);


        Button ajouter = (Button) findViewById(R.id.linearLayoutHorizontal_boutonAjouter);
        Button effacerTout = (Button) findViewById(R.id.linearLayoutHorizontal_boutonToutEffacer);


        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListeDeCourse tmp = single.ajouterListe();
                // On passe par une HashMap pour extraire les noms et dates des listes, pour les afficher par la suite via listeAAfficher
                HashMap<String, String> tmpMap = new HashMap<String, String>();
                tmpMap.put("nom", tmp.getNom());
                tmpMap.put("date", tmp.getDate());
                listeAAfficher.add(tmpMap);
                simpleAdapter.notifyDataSetChanged();
            }
        });


        effacerTout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //La suppression se fait à la fois dans la liste de l'objet single, et sur ce qui est affiché à l'écran
                single.supprimerTout();
                listeAAfficher.clear();
                simpleAdapter.notifyDataSetChanged();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                // NOTE : single.supprimerListe() ne fait rien, la suppression de la liste via le LongClick n'a lieu qu'à l'affichage
                //        , la liste ne disparait pas réellement sans un click sur le bouton "Effacer tout"
                listeAAfficher.remove(position);
                single.supprimerListe();
                simpleAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
