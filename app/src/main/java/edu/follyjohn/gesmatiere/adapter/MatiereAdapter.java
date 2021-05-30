package edu.follyjohn.gesmatiere.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

import edu.follyjohn.gesmatiere.R;
import edu.follyjohn.gesmatiere.model.Matiere;

public class MatiereAdapter extends BaseAdapter {

    private Context context;  //activite dans laquelle on vas utiliser l'adapter
    private List<Matiere> listMatiere;

    public MatiereAdapter(Context context, List<Matiere> listMatiere) {
        this.context = context;
        this.listMatiere = listMatiere;
    }

    public MatiereAdapter() {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return listMatiere.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((Matiere) this.getItem(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView =  LayoutInflater.from(context).inflate(R.layout.activity_matiere_list_item,null);

       MatiereHolder matiereHolder = new MatiereHolder();

       matiereHolder.nomProf = convertView.findViewById(R.id.nomProf);
       matiereHolder.nomMatiere = convertView.findViewById(R.id.nomMat);
       matiereHolder.typeMatiere = convertView.findViewById(R.id.typeMat);
       matiereHolder.imgMatiere = convertView.findViewById(R.id.imageMAt);

       matiereHolder.nomProf.setText(((Matiere)getItem(position)).getEnseignant());
       matiereHolder.nomMatiere.setText(((Matiere)getItem(position)).getLibelle());
       matiereHolder.typeMatiere.setText(((Matiere)getItem(position)).getFacultatif() ? "facultatif" : "obligatoire_label");
       matiereHolder.imgMatiere.setImageResource(((Matiere)getItem(position)).getImage().getImg());

       convertView.setTag(matiereHolder);
       return convertView;
    }

    class MatiereHolder {
        private TextView nomProf;
        private TextView nomMatiere;
        private TextView typeMatiere;
        private ImageView imgMatiere;

    }
}
