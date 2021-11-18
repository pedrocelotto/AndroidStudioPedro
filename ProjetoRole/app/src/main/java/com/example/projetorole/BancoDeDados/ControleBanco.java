package com.example.projetorole.BancoDeDados;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.projetorole.model.Estabelecimento;
import com.example.projetorole.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControleBanco {
    private SQLiteDatabase db;
    private BancoDeDados banco;

    public ControleBanco(Context context){
        banco = new BancoDeDados(context);
    }

    public Boolean insereDadoUsuario(Usuario user){
        db = banco.getWritableDatabase();
        ContentValues campos;
        long resultado;
        campos = new ContentValues();

        campos.put(BancoDeDados.NOME_USUARIO, user.getNome_usuario());
        campos.put(BancoDeDados.CPF_USUARIO, user.getCpf_usuario());
        campos.put(BancoDeDados.SENHA_USUARIO, user.getSenha_usuario());
        campos.put(BancoDeDados.DATA_USUARIO, user.getData_usuario());

        resultado = db.insert(BancoDeDados.TABELA_USUARIO, null, campos);

        if (resultado == -1){
            //Log.d("teste aqui", "Passamos");
            return false;
        }else {
            //Log.d("teste aqui", "Passamos 2");
            return true;
        }
    }

    public Boolean insereDadoEstabelecimento(Estabelecimento estabelecimento){
        db = banco.getWritableDatabase();
        ContentValues campos = new ContentValues();
        long resultado;

        campos.put(BancoDeDados.NOME_ESTABELECIMENTO, estabelecimento.getNome());
        campos.put(BancoDeDados.CNPJ_ESTABELECIMENTO, estabelecimento.getCnpj());
        campos.put(BancoDeDados.STATUS_ESTABELECIMENTO, estabelecimento.getStatus());
        campos.put(BancoDeDados.ENDERECO_ESTABELECIMENTO, estabelecimento.getEndereco());
        campos.put(BancoDeDados.CATEGORIA_ESTABELECIMENTO, estabelecimento.getCategoria());
        campos.put(BancoDeDados.ATRACAO_ESTABELECIMENTO, estabelecimento.getAtracao());

        resultado = db.insert(BancoDeDados.TABELA_ESTABELECIMENTO, null, campos);

        if (resultado == -1){
            //Log.d("teste aqui", "Passamos");
            return false;
        }else {
            //Log.d("teste aqui", "Passamos 2");
            return true;
        }
    }

    public Boolean autenticaUsuario(String cpf, String senha){
        db = banco.getReadableDatabase();
        String sql_busca_usuario = "SELECT * FROM usuario WHERE cpf_usuario " + " LIKE '%" + cpf + "%'";
        Cursor c = db.rawQuery(sql_busca_usuario, null);
        while (c.moveToNext()){
            //Log.d("logwhile", c.getString(2));
            if(Objects.equals(senha, c.getString(2))){
                return true;
            }else{
                return false;
            }
        }

        return false;
    }

    public ArrayList<Estabelecimento> retornaDados(
    ){
        ArrayList<Estabelecimento> listaEstabelecimentos = new ArrayList<>();
        db = banco.getReadableDatabase();
        String sql_busca_dados = " SELECT * FROM " + BancoDeDados.TABELA_ESTABELECIMENTO;
        Cursor c = db.rawQuery(sql_busca_dados, null);
        while(c.moveToNext()){
            Estabelecimento estabelecimento_temp = new Estabelecimento(c.getString(1),
                    c.getString(2),
                    c.getInt(3),
                    c.getString(4),
                    c.getString(5),
                    c.getString(6),
                    c.getString(7));
            estabelecimento_temp.setId_estabelecimento(c.getInt(0));

            listaEstabelecimentos.add(estabelecimento_temp);
        }

        return listaEstabelecimentos;
    }

}
