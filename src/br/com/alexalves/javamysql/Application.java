package br.com.alexalves.javamysql;

import br.com.alexalves.javamysql.Dao.ClienteDAO;
import br.com.alexalves.javamysql.domain.ClienteDomain;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Listar clientes: ");
		ClienteDAO clienteDao = new ClienteDAO();
		
		for(ClienteDomain cli : clienteDao.find()) {
			System.out.println(cli.toString());
		}
	}

}
