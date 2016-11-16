package fabricioferreira.coletaseletivatorres.Model;

/**
 * Created by Fabrício Ferreira on 05/10/2016.
 */
public class Cliente {

    private int _id;
    private String nome;
    private String email;
    private String senha;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
