package br.com.alexalves.javamysql.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.alexalves.javamysql.Factory.ConnectionFactory;
import br.com.alexalves.javamysql.domain.ClienteDomain;

public class ClienteDAO {
	public List<ClienteDomain> find() {
		String query = "SELECT * FROM cliente;";
		List<ClienteDomain> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			 conn = ConnectionFactory.createConnectionToMySQL();
			 pstm = (PreparedStatement)conn.prepareStatement(query);
			 
			 rset = pstm.executeQuery();
			 
			 while(rset.next()) {
				 ClienteDomain cli = new ClienteDomain();
				 
				 cli.setId(rset.getInt("idCliente"));
				 cli.setNome(rset.getString("nomeCliente"));
				 cli.setEmail(rset.getString("email"));
				 cli.setCpf(rset.getString("cpf"));
				 
				 list.add(cli);
				 
			 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 
		return list;
	}
}
