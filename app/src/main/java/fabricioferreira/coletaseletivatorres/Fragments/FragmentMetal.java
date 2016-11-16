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
public class FragmentMetal extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.layout_frag_metal, null);

        TextView tv = (TextView) view.findViewById(R.id.textViewMet);
        tv.setText("O metal é um dos produtos mais utilizados nas tarefas do dia-a-dia. Encontramos embalagens de metais," +
                " fios e outros produtos metálicos em diversos produtos. Ao ser descartado por pessoas e empresas, " +
                "pode passar por um processo de reciclagem que garante seu reaproveitamento na produção do metal reciclado." +
                " O metal reciclado tem praticamente todas as características do metal comum. Ele pode ser reciclado muitas" +
                " vezes sem perder suas características e qualidade. O alumínio, por exemplo, pode ser usado sem limites. " +
                "O aço após ser reciclado volta para a cadeia produtiva para ser transformado em latas e peças automotivas," +
                " por exemplo. A reciclagem do metal é de extrema importância para o meio ambiente. Quando reciclamos o metal ou" +
                " compramos metal reciclado estamos contribuindo com o meio ambiente, pois este material deixa de ir para os aterros" +
                " sanitários ou para a natureza (rios, lagos, solo, matas). " +
                "Separação no processo de reciclagem\n" +
                "\n" +
                "Na primeira fase do processo de reciclagem de metal, os mesmos são separados por tipos e características. " +
                "Desta forma, alumínio, cobre, aço e ferro passam por processos de reciclagem diferentes." +
                "Tipos de metais recicláveis\n" +
                "\n" +
                "- Latas de alumínio (refrigerante, cerveja, etc.) e aço (latas de sardinha, molhos, óleo, etc.).\n" +
                "- Arames, pregos e parafusos.\n" +
                "- Fios de metal\n" +
                "- Tampas de metal\n" +
                "- Tubos de pasta\n" +
                "- Panelas sem cabo\n" +
                "- Arames\n" +
                "- Chapas de metal\n" +
                "- Objetos de alumínio (janelas, portas, portões, etc.).\n" +
                "- Fios e objetos de cobre\n" +
                "- Ferragens\n" +
                "- Canos de metal\n" +
                "- Molduras de quadros\n" +
                "- Tampinhas de garrafa\n" +
                "- Ferramentas de metal\n" +
                "- Retalhos de folhas de flandres\n" +
                "- Tampas metálicas de potes de iogurtes, margarinas, queijos, etc.\n" +
                "- Papel alumínio\n" +
                " \n" +
                "Você sabia?\n" +
                " \n" +
                "- No Brasil, 48% das latas de aço são recicladas, voltando para a cadeia produtiva (dado relativo ao ano de 2015).");
        return (view);
    }
}
