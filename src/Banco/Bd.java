/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Codigo.Conta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author vinicius
 */
public class Bd {
    private final String SELECT_ALLCONTA = "SELECT * FROM conta order by data";
    private final String SELECT_POR_DATA = "SELECT * FROM conta where data = (?)";
    private final String DELETE = "DELETE FROM conta where id = (?)";
    private final String INSERT = "INSERT INTO conta(data,descricao,valor) VALUES (?,?,?)";
    private final String UPDATE_DATA = "UPDATE conta set data = (?) where id = (?)";
    private final String UPDATE_DESC = "UPDATE conta set descricao = (?) where id = (?)";
    private final String UPDATE_VALOR = "UPDATE conta set valor = (?) where id = (?)";
    private boolean retorno = false;
    
    public Connection getConnection()
    { 
        Connection con = null;
        try{
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/vinicius","vinicius","12345678");
        }catch(SQLException e){
        }
        return con;
    }
    public void closeConnnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) { 
        } 
    }
    public ArrayList<Conta> select_allconta()throws SQLException{
        Connection con = null;
        ArrayList<Conta> lista = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try{
            con = this.getConnection();
            PreparedStatement prepare = con.prepareStatement(SELECT_ALLCONTA);
            ResultSet resultset = prepare.executeQuery();
            while(resultset.next()){
                Conta conta = new Conta();
                conta.setId(resultset.getInt("id"));
                conta.setData(format.format(resultset.getDate("data")));
                conta.setDescricao(resultset.getString("descricao"));
                conta.setValor(resultset.getFloat("valor"));
                lista.add(conta);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeConnnection(con);
        }
        return lista;
    }
    public ArrayList<Conta> select_data(String data)throws SQLException, ParseException{
        Connection con = null;
        ArrayList<Conta> lista = new ArrayList();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date date;
        try {
            date = new java.sql.Date(format.parse(data).getTime());
            con = this.getConnection();
            PreparedStatement prepare = con.prepareStatement(SELECT_POR_DATA);
            prepare.setDate(1,date);
            ResultSet resultset = prepare.executeQuery();
            while(resultset.next()){
                Conta conta = new Conta();
                conta.setId(resultset.getInt("id"));
                conta.setData(format.format(resultset.getDate("data")).toString());
                conta.setDescricao(resultset.getString("descricao"));
                conta.setValor(resultset.getFloat("valor"));
                lista.add(conta);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeConnnection(con);
        }
        return lista;
    }
    public void deleta(int posicao) throws SQLException{
        ArrayList<Conta> contas;
        contas = this.select_allconta();
        Connection con = null;
        try{
            con = this.getConnection();
            PreparedStatement prepare = con.prepareStatement(DELETE);
            prepare.setInt(1,contas.get(posicao).getId());
            prepare.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.closeConnnection(con);
        }
    }
    public void inserir(Conta conta) throws ParseException{
        Connection con = null;
        Bd bd = new Bd();
        try{
            con = bd.getConnection();
            PreparedStatement prepare = con.prepareStatement(INSERT);
            prepare.setDate(1,java.sql.Date.valueOf(arruma_data(conta.getData())));
            prepare.setString(2,conta.getDescricao());
            prepare.setFloat(3,conta.getValor());
            prepare.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            bd.closeConnnection(con);
        }
    }
    public String arruma_data(String data){
        StringTokenizer st = null;
        String dia = null;
        String mes = null;
        String ano = null;
        st = new StringTokenizer(data, "/");
        while (st.hasMoreTokens()) {
            dia = st.nextToken();  
            mes = st.nextToken();
            ano = st.nextToken();
        }
        return ano+"-"+mes+"-"+dia;
    }
    public void atualizar(Conta conta) throws SQLException{
        Connection con = null;
        Bd bd = new Bd();
        PreparedStatement prepare = null;
        ArrayList<Conta> contas = null;
        contas = this.select_allconta();
        try{
            con = bd.getConnection();
            prepare = con.prepareStatement(UPDATE_DATA);
            prepare.setDate(1,java.sql.Date.valueOf(arruma_data(conta.getData())));
            prepare.setInt(2,contas.get(conta.getId()).getId());
            prepare.executeUpdate();
            
            prepare = con.prepareStatement(UPDATE_DESC);
            prepare.setString(1,conta.getDescricao());
            prepare.setInt(2,contas.get(conta.getId()).getId());
            prepare.executeUpdate();
            
            prepare = con.prepareStatement(UPDATE_VALOR);
            prepare.setFloat(1,conta.getValor());
            prepare.setInt(2,contas.get(conta.getId()).getId());
            prepare.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            bd.closeConnnection(con);
        }
    }
}
             
