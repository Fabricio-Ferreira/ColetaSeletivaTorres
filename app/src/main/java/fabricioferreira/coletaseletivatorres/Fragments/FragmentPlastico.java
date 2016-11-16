package fabricioferreira.coletaseletivatorres.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import fabricioferreira.coletaseletivatorres.R;

/**
 * Created by usuario on 03/11/2016.
 */
public class FragmentPlastico extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.layout_frag_plastico, null);

        TextView tv = (TextView) view.findViewById(R.id.textViewPlast);
        tv.setText("O plástico é um dos produtos mais utilizados na sociedade atual. Ao ser descartado por pessoas" +
                " e empresas, pode passar por um processo de reciclagem que garante seu reaproveitamento na produção" +
                " do plástico reciclado. O plástico reciclado tem praticamente todas as características do plástico comum." +
                "A reciclagem do plástico é de extrema importância para o meio ambiente. Quando reciclamos o plástico ou compramos" +
                " plástico reciclado estamos contribuindo com o meio ambiente, pois este material deixa de ir para os " +
                "aterros sanitários ou para a natureza, poluindo rios, lagos, solo e matas. " +
                "Reciclagem de embalagens PET (politereftalato de etileno)\n" +
                "\n" +
                "Nas últimas décadas as indústrias, principalmente de bebidas e alimentos, estão substituindo as embalagens " +
                "de vidro e latas pelas de plástico PET. Por serem mais resistentes e econômicas, o PET já está presente nas " +
                "embalagens de sucos, águas, óleos e refrigerantes. Quando começou a ser usado, o PET não era reciclado e " +
                "seu descarte na natureza provocava muita sujeira e poluição ambiental. Atualmente, a reciclagem de PET é " +
                "praticada em larga escala por cooperativas e empresas de reciclagem. O processo de reciclagem do PET passa " +
                "pelas seguintes etapas: " +
                "1º) As embalagens PET são lavadas e passam por um processo de prensagem; " +
                "2º) Os fardos de PET são triturados, gerando os flocos; " +
                "3º) Os flocos passam por um processo de extrusão, gerando os grãos; " +
                "4º) Os grãos são transformados em fios de poliéster ou outros produtos plásticos." +
                "Tipos de plásticos recicláveis (exemplos)\n" +
                "\n" +
                "- Garrafas PET\n" +
                "- Potes Plásticos diversos\n" +
                "- Tampas de embalagens\n" +
                "- Sacos plásticos diversos\n" +
                "- Canos de PVC\n" +
                "- Componentes plásticos usados em eletrodomésticos\n" +
                "- Engradados de bebida\n" +
                "- Para-choques de carros\n" +
                "- Copos descartáveis\n" +
                "- Plásticos de brinquedos\n" +
                "- Embalagens de produtos de limpeza\n");
        return (view);
    }
}
