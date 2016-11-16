package fabricioferreira.coletaseletivatorres.BancoDados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fabrício Ferreira on 05/10/2016.
 */
public class DataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ColetaTorres";
    private static final int DATABASE_VERSION = 1;
    private static String TABLE_CLIENTE = "CREATE TABLE CLIENTES \" +\n" +
            "            \"(_id INTEGER PRIMARY KEY AUTOINCREMENT, NOME TEXT, EMAIL TEXT, SENHA TEXT);";


    public DataBase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CLIENTE);
    }

    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2){
        db.execSQL("DROP TABLE_CLIENTE;");
    }

    public boolean exists(String nome) {
        SQLiteDatabase db = getReadableDatabase();
        try {
            // select * from cliente
            Cursor c = db.query("cliente", null, "nome=?", new String[]{nome}, null, null, null, null);
            boolean exists = c.getCount() > 0;
            return exists;
        } finally {
            db.close();
        }
    }

    // Executa um SQL
    public void execSQL(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql);
        } finally {
            db.close();
        }
    }

    // Executa um SQL
    public void execSQL(String sql, Object[] args) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL(sql, args);
        } finally {
            db.close();
        }
    }


}
