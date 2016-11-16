package fabricioferreira.coletaseletivatorres.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import fabricioferreira.coletaseletivatorres.R;

/**
 * Created by usuario on 01/11/2016.
 */
public class FragmentColetaTorres extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.layout_frag_coleta, null);

        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText("ColetaTorres é um gerenciador da coleta seletiva do lixo, " +
                "que traz informações sobre o descarte dos resíduos sólidos recicláveis secos e rejeitos," +
                " onde e como realizar esses processos de forma correta ou que cause menos impacto no meio ambiente." +
                " Coleta seletiva de lixo é um processo que consiste na separação e recolhimento dos resíduos descartados " +
                "por empresas e pessoas. Desta forma, os materiais que podem ser reciclados são separados do lixo orgânico. " +
                "A realização da coleta seletiva do lixo é de suma importância para a sua comunidade, pois ela gera renda para " +
                "muitas pessoas e aquece a economia das empresas que trabalham com esses materiais. Esta coleta é vital para" +
                " o desenvolvimento sustentável do planeta");

        return (view);
    }
}
