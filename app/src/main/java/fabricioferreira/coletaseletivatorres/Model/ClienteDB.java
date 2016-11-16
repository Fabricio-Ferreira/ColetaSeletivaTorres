package fabricioferreira.coletaseletivatorres.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import fabricioferreira.coletaseletivatorres.BancoDados.DataBase;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Fabrício Ferreira on 05/10/2016.
 */
public class ClienteDB {

    private SQLiteDatabase sqLite;

    public ClienteDB(Context context) {
        sqLite = new DataBase(context).getWritableDatabase();
    }

    public void inserir(Cliente cliente) {

        try {
            ContentValues valores = new ContentValues();

            valores.put("NOME", cliente.getNome());
            valores.put("EMAIL", cliente.getEmail());
            valores.put("SENHA", cliente.getSenha());


            sqLite.insert("CLIENTE", null, valores);


        } finally {
            sqLite.close();
        }

    }

    public void deletar(Cliente cliente) {

        try {
            String where = "_id=?";
            String[] argumentos = new String[]{""+ cliente.get_id()};
            sqLite.delete("CLIENTES",where,argumentos);
        } finally {
            sqLite.close();
        }
    }

    public void atualizar (Cliente cliente){

        String where = "_id=?" ;
        String[] argumentos = new String[]{""+ cliente.get_id()};

        ContentValues valores = new ContentValues();
        valores.put("NOME", cliente.getNome());
        valores.put("EMAIL", cliente.getEmail());
        valores.put("SENHA", cliente.getSenha());

        sqLite.update("CLIENTES", valores, where, argumentos);

    }

    public List<Cliente> listarCliente(){

        List <Cliente> list = new ArrayList<>();

        String[] colunas = new String[]{"_id","NOME","EMAIL","SENHA"};

        Cursor cursor = sqLite.query("CLIENTES", colunas, null,null,null,null,null, "NOME ASC");

        if (cursor.getCount()>0){
            cursor.moveToFirst();

            do {

                Cliente cliente = new Cliente();

                cliente.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                cliente.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
                cliente.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));
                cliente.setSenha(cursor.getString(cursor.getColumnIndex("SENHA")));

                list.add(cliente);

            }while (cursor.moveToNext());
        }
        return list;
    }

    public List<Cliente> buscarCliente(String email){

        List<Cliente> list = new ArrayList<>();

        String[] colunas = new String[]{"_id", "NOME", "EMAIL", "SENHA"};
        String where = "EMAIL=?";
        String[] arguementos = new String[]{email};

        Cursor cursor = sqLite.query("CLIENTES", colunas, where, arguementos, null,null,null, "EMAIL ASC");

        if (cursor.getCount()>0){
            cursor.moveToFirst();

            do {

                Cliente cliente = new Cliente();
                cliente.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                cliente.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
                cliente.setEmail(cursor.getString(cursor.getColumnIndex("EMAIl")));
                cliente.setSenha(cursor.getString(cursor.getColumnIndex("SENHA")));

                list.add(cliente);

            }while (cursor.moveToNext());
        }
        return list;
    }



}



