package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The insert. */
	private final String INSERT ="insert into contatos (nome, fone, email) values(?,?,?);";
	
	/** The select. */
	private final String SELECT ="select * from contatos";
	
	/** The select com id. */
	private final String SELECT_COM_ID ="select * from contatos where idcom= ?";
	
	/** The up date. */
	private final String UP_DATE = "update contatos set nome=?,fone=?,email=? where idcom=?";
	
	/** The delete. */
	private final String DELETE = "delete  from contatos where idcom= ?";
   
   /** The driver. */
   //parâmentros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&useTimezone=UTC";
	
	/** The user. */
	private String user="root";
	
	/** The password. */
	private String password ="dider5050";
	
  /**
   * Método de conexão.
   *
   * @return the connection
   */
	private Connection conectar() {
		Connection con = null;
		
		 try {
			 
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
			
		} catch (Exception e) {
			
			System.out.println(e);
			return null;
			
		}
	}
	
	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> agendas = new ArrayList<JavaBeans>();
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst= con.prepareStatement(SELECT);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
             String idcon = String.valueOf(rs.getInt(1));
             String nome = rs.getString(2);
             String fone = rs.getString(3);
             String email = rs.getString(4);
             agendas.add( new JavaBeans(idcon, rs.getString(2), fone, email));
			}
			con.close();
			return agendas;
			
		} catch (Exception e) {
			
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * CRUD INSET parte 1.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		try {
			//abrir a conexão
			Connection con = conectar();
			//Preparar a query par a execução no banco de dados
			PreparedStatement pst= con.prepareStatement(INSERT);
			//Subtituir os parâmetros  (?) pelo conteúdo do objeto contato
	        pst.setString(1, contato.getNome());
	        pst.setString(2, contato.getFone());
	        pst.setString(3, contato.getEmail());
	        //Executar a query
	        pst.executeUpdate();
	        con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * CRUD UPDATE parte 3.
	 *
	 * @param contato selecionar o contato
	 */
	public void selecionarContato(JavaBeans contato) {
		try {
			//abrir a conexão
			Connection con = conectar();
			//Preparar a query par a execução no banco de dados
			PreparedStatement pst= con.prepareStatement(SELECT_COM_ID);
			pst.setInt(1,Integer.parseInt(contato.getIdcom()));
	        //Executar a query
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	             contato.setIdcom( String.valueOf(rs.getInt(1)));
	             contato.setNome(rs.getString(2));
	             contato.setFone( rs.getString(3));
	             contato.setEmail(rs.getNString(4));
	             
				}
	        con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * CRUD UDPDATE parte 4.
	 *
	 * @param contato atualizando o contato
	 */
	
		public void atualizarContato(JavaBeans contato) {
			try {
				
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(UP_DATE);
				pst.setString(1, contato.getNome());
				pst.setString(2, contato.getFone());
				pst.setString(3, contato.getEmail());
				pst.setString(4, contato.getIdcom());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/**
		 * CRUD DELETE parte 3.
		 *
		 * @param contato selecionar o contato
		 */
		public void deletarContato(JavaBeans contato) {
			try {
				
				Connection con = conectar();
	
				PreparedStatement pst= con.prepareStatement(DELETE);
				
				pst.setInt(1,Integer.parseInt(contato.getIdcom()));
				pst.executeUpdate();
		       
		        con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}
