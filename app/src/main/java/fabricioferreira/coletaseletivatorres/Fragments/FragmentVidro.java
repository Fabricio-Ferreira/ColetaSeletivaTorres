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
public class FragmentVidro extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.layout_frag_vidro, null);

        TextView tv = (TextView) view.findViewById(R.id.textViewVidro);
        tv.setText("O vidro é um dos produtos mais utilizados nas tarefas do dia-a-dia. Ao ser descartado por pessoas " +
                "e empresas, pode passar por um processo de reciclagem que garante seu reaproveitamento na produção do " +
                "vidro reciclado.O vidro reciclado tem praticamente todas as características do vidro comum. Ele pode ser " +
                "reciclado muitas vezes sem perder sua características e qualidade. A reciclagem do vidro é de extrema importância" +
                " para o meio ambiente. Quando reciclamos o vidro ou compramos vidro reciclado estamos contribuindo com o meio " +
                "ambiente, pois este material deixa de ir para os aterros sanitários ou para a natureza (rios, lagos, solo, matas)." +
                "Separação no processo de reciclagem\n" +
                "\n" +
                "Uma das primeiras etapas no processo de reciclagem do vidro é sua separação por cores (âmbar, verde, translúcido e azul) e" +
                "tipos (lisos, ondulados, vidros de janelas, de copos, etc). Esta separação é de extrema importância para a fabricação de" +
                " novos objetos de vidro, pois garante suas características e qualidades.\n" +
                "\n" +
                "Tipos de vidros recicláveis\n" +
                "\n" +
                "- Garrafas de sucos, refrigerantes, cervejas e outros tipos de bebidas;\n" +
                "- Potes de alimentos\n" +
                "- Cacos de vidros\n" +
                "- Frascos de remédios\n" +
                "- Frascos de perfumes\n" +
                "- Vidros planos e lisos\n" +
                "- Pára-brisas\n" +
                "- Vidros de janelas\n" +
                "- Pratos, tigelas e copos (desde que não sejam de acrílico, cerâmica ou porcelana)\n" +
                " \n" +
                "Curiosidades:\n" +
                "\n" +
                "- A principal matéria-prima usada na produção de todos os tipos de vidro é a sílica (dióxido de silício).\n" +
                " \n" +
                "- No Brasil, 47% do vidro é reciclado e volta para a cadeia produtiva (dado relativo ao ano de 2012).\n");
        return (view);
    }
}
