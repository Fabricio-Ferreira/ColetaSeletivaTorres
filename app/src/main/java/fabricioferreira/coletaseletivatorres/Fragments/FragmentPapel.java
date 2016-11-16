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
public class FragmentPapel extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.layout_frag_papel, null);

        TextView tv = (TextView) view.findViewById(R.id.textView3);
        tv.setText("O papel é um dos produtos mais utilizados nas tarefas do cotidiano. " +
                "Quando não está sendo mais utilizado, pode passar por um processo de reciclagem que garante" +
                " seu reaproveitamento na produção do papel reciclado. O papel reciclado tem praticamente todas" +
                " as características do papel comum, porém sua cor pode variar de acordo com o papel utilizado" +
                " no processo de reciclagem.A reciclagem do papel é de extrema importância para o meio ambiente. " +
                "Como sabemos, o papel é produzido através da celulose de determinados tipos de árvores. Quando reciclamos" +
                " o papel ou compramos papel reciclado estamos contribuindo com o meio ambiente, pois árvores deixaram de " +
                "ser cortadas. " +
                "Como fazer papel reciclado em casa (reciclagem caseira)\n" +
                "\n" +
                "\n" +
                "1º - Separe o papel que não está mais sendo utilizado, recorte em pequenos pedaços e coloque num recipiente com água." +
                " Deixe assim durante um dia completo.\n" +
                "\n" +
                "2º - Pegue este papel molhado e bata num liquidificador ou mexa bastante até dissolver e virar uma espécie de massa.\n" +
                "\n" +
                "3º - Coloque essa massa espalhada (no formato fino) numa espécie de rede fina e cubra com um peso " +
                "que terá a função de prensar.\n" +
                "\n" +
                "4º - Depois de 24 horas, retire o peso e deixe o papel secar, de preferência em ambiente seco ou ao sol.  \n" +
                " \n" +
                "Você sabia?\n" +
                " \n" +
                "- Cerca de 46,3% do papel, produzido e comercializado no Brasil, é reciclado e volta para a cadeia produtiva " +
                "(dado relativo ao ano de 2015).");

        return (view);

    }
}
