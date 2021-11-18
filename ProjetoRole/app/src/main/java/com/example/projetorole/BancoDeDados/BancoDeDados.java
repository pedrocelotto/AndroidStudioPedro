package com.example.projetorole.BancoDeDados;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BancoDeDados extends SQLiteOpenHelper {
    //nome da base de dados
    public static final String NOME_BANCO_DADOS = "projeto.db";
    //verionamento do banco
    public static final int VERSAO = 17;

    //Dados tabela usuario
    public static final String TABELA_USUARIO = "usuario";
    public static final String ID_USUARIO = "id_usuario";
    public static final String NOME_USUARIO = "nome_usuario";
    public static final String CPF_USUARIO = "cpf_usuario";
    public static final String SENHA_USUARIO = "senha_usuario";
    public static final String DATA_USUARIO = "data_usuario";

    //Dados tabela estabelecimento
    public static final String TABELA_ESTABELECIMENTO = "estabelecimento";
    public static final String ID_ESTABELECIMENTO = "id_estabelecimento";
    public static final String NOME_ESTABELECIMENTO = "nome_estabelecimento";
    public static final String CNPJ_ESTABELECIMENTO = "cnpj_estabelecimento";
    public static final String STATUS_ESTABELECIMENTO = "status_estabelecimento";
    public static final String ENDERECO_ESTABELECIMENTO = "endereco_estabelecimento";
    public static final String CATEGORIA_ESTABELECIMENTO = "categoria_estabelecimento";
    public static final String ATRACAO_ESTABELECIMENTO = "atracao_estabelecimento";
    public static final String NUM_USUARIOS_ESTABELECIMENTO = "num_usuarios_estabelecimento";

    public BancoDeDados(Context context) {
        super(context, NOME_BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_CRIA_TABELA_PESSOA = "CREATE TABLE " + TABELA_USUARIO + " ("
                + ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME_USUARIO + " TEXT, " +
                CPF_USUARIO + " TEXT UNIQUE, " +
                SENHA_USUARIO + " TEXT, " +
                DATA_USUARIO + " TEXT" + ")";
        db.execSQL(QUERY_CRIA_TABELA_PESSOA);

        String QUERY_CRIA_TABELA_ESTABELECIMENTO = "CREATE TABLE " + TABELA_ESTABELECIMENTO + " ("
                + ID_ESTABELECIMENTO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME_ESTABELECIMENTO + " TEXT, " +
                CNPJ_ESTABELECIMENTO + " TEXT UNIQUE, " +
                STATUS_ESTABELECIMENTO + " INTEGER, " +
                ENDERECO_ESTABELECIMENTO + " TEXT, " +
                CATEGORIA_ESTABELECIMENTO + " TEXT, " +
                ATRACAO_ESTABELECIMENTO + " TEXT, " +
                NUM_USUARIOS_ESTABELECIMENTO + " INTEGER" + ")";
        db.execSQL(QUERY_CRIA_TABELA_ESTABELECIMENTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_USUARIO;
        String sql2 = "DROP TABLE IF EXISTS " + TABELA_ESTABELECIMENTO;
        db.execSQL(sql);
        db.execSQL(sql2);
        onCreate(db);
    }
}
