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
public class FragmentOrganico extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.layout_frag_org, null);

        TextView tv = (TextView) view.findViewById(R.id.textViewOrg);
        tv.setText("Lixo orgânico é todo resíduo de origem vegetal ou animal, ou seja, todo lixo originário de um ser vivo." +
                " Este tipo de lixo é produzido nas residências, escolas, empresas e pela natureza. Podemos citar como exemplos de lixo orgânico: " +
                "restos de alimentos orgânicos (carnes, vegetais, frutos, cascas de ovos), papel, madeira, ossos, sementes, etc. " +
                "Este tipo de lixo precisa ser tratado com todo cuidado, pois pode gerar conseqüências indesejadas para os seres humanos como," +
                "por exemplo, mau cheiro, desenvolvimento de bactérias e fungos, aparecimento de ratos e insetos. Nestes casos, várias doenças podem surgir," +
                " através da contaminação do solo e da água. " +
                "Chorume \n" +
                "No processo de decomposição (apodrecimento) do lixo orgânico é produzido o chorume, que é um líquido viscoso" +
                " e de cheiro forte e desagradável. O chorume também é um elemento que pode provocar a contaminação do solo e" +
                " das águas (rios, lagos, lençóis freáticos).\n" +
                "\n" +
                "Aterros sanitários \n" +
                " \n" +
                "O lixo orgânico deve ser depositado em aterros sanitários, seguindo todas as normas de saneamento básico e tratamento de lixo. " +
                "A população também pode contribuir para o tratamento deste lixo, favorecendo a coleta seletiva do lixo e a reciclagem.\n" +
                " \n" +
                "Lixo como fonte de energia \n" +
                " \n" +
                "Este tipo de lixo também pode ser usado para a produção de energia (biogás), pois em seu processo de decomposição é gerado o gás metano." +
                " Outra utilidade do lixo orgânico é a produção de adubo orgânico, muito usado na agricultura, através do processo de compostagem.");
        return (view);
    }
}
