package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The idcom. */
	private String idcom;
	
	/** The nome. */
	private String nome;
	
	/** The fone. */
	private String fone;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() { 
		super();
	}
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param idcom the idcom
	 */
	public JavaBeans(String idcom) { 
		super();
		this.idcom = idcom;
	}
	
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param idcom the idcom
	 * @param nome the nome
	 * @param fone the fone
	 * @param email the email
	 */
	public JavaBeans(String idcom, String nome, String fone, String email) {
		super();
		this.idcom = idcom;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param nome the nome
	 * @param fone the fone
	 * @param email the email
	 */
	public JavaBeans(String nome, String fone, String email) {
		super();
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}


	/**
	 * Gets the idcom.
	 *
	 * @return the idcom
	 */
	public String getIdcom() {
		return idcom;
	}
	
	/**
	 * Sets the idcom.
	 *
	 * @param idcom the new idcom
	 */
	public void setIdcom(String idcom) {
		this.idcom = idcom;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the fone.
	 *
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}
	
	/**
	 * Sets the fone.
	 *
	 * @param fone the new fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "JavaBeans [idcom=" + idcom + ", nome=" + nome + ", fone=" + fone + ", email=" + email + "]";
	}
	
	
}
