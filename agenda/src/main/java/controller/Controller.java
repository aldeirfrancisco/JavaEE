package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = {"/main","/insert", "/select", "/update", "/delete", "/report"})
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
    
    /** The main 0. */
    private final String MAIN_0 = "/main"; //usando no switch
    
    /** The main 1. */
    private final String MAIN_1 = "main"; //usando no redirecionamento.
    
    /** The insert. */
    private final String INSERT = "/insert";
    
    /** The select 0. */
    private final String SELECT_0 = "/select";
    
    /** The delete. */
    private final String DELETE = "/delete";
    
    /** The up date. */
    private final String UP_DATE = "/update";
    
    /** The url agenda. */
    private final String URL_AGENDA = "agenda.jsp";
    
    /** The url editar. */
    private final String URL_EDITAR = "editar.jsp"; 
    
    /** The url index. */
    private final String URL_INDEX = "index.html"; 
    
    /** The nome. */
    private final String NOME = "nome";
    
    /** The fone. */
    private final String FONE = "fone"; 
    
    /** The e mail. */
    private final String E_MAIL = "email"; 
    
    /** The contatos. */
    private final String CONTATOS = "contatos";
    
    /** The id com. */
    private final String ID_COM = "idcom";
    
    /** The report. */
    private final String REPORT = "/report";
    
	/** The dao. */
	DAO dao =  new DAO();
	
	/** The contato. */
	JavaBeans contato = new JavaBeans();
   
    /**
     * Instantiates a new controller.
     */
    public Controller() {
        super();
       
    }

	
	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		System.out.println(action);

		switch (action) {
		
			case MAIN_0:
				contatos(request,response);
				break;
				
			case INSERT:
				adicionarContato(request, response);
				break;
				
			case SELECT_0:
				listarContatos(request, response);
				break;
				
			case UP_DATE:
				atualizarContatos(request, response);
				break;
				
			case DELETE:
				deletarContatos(request, response);
				break;
				
			case REPORT:
				gerarRelatorioDeContatos(request, response);
				break;
				
			default:
				response.sendRedirect(URL_INDEX);
				break;
		}
	}
	


	/**
	 * Adicionar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//novo  contato
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		setObjetoContato(request);
		dao.inserirContato(this.contato);
		response.sendRedirect(MAIN_1);
	}


	/**
	 * Contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//listar  contatos
	protected void contatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<JavaBeans> agendas = dao.listarContatos();
		request.setAttribute(CONTATOS, agendas);
		RequestDispatcher rd =  request.getRequestDispatcher(URL_AGENDA);// faz o dispacho
	    rd.forward(request, response); // encaminha a lista ao arquivo url_agenda
	}
    
	
	/**
	 * Listar contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//editar contato
	protected void listarContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       this.contato.setIdcom(request.getParameter(ID_COM));
       dao.selecionarContato(this.contato);
       // setando o atributos do formulario com conteúdo JavaBeans
       
       request.setAttribute(ID_COM, this.contato.getIdcom());
       request.setAttribute(NOME, this.contato.getNome());
       request.setAttribute(FONE, this.contato.getFone());
       request.setAttribute(E_MAIL, this.contato.getEmail());
   
       RequestDispatcher rd =  request.getRequestDispatcher(URL_EDITAR);
       rd.forward(request, response); // encaminha a lista ao arquivo url_agenda
       //encaminhar ao documento tela de editar
	}
	
	/**
	 * Atualizar contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void atualizarContatos(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		
		setObjetoContato(request);
        
		System.out.println("aqui ==> "+ this.contato.toString());
		dao.atualizarContato(this.contato);
		response.sendRedirect(MAIN_1);
		
	}

	/**
	 * Deletar contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void deletarContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		this.contato.setIdcom(request.getParameter(ID_COM));
	       dao.deletarContato(contato);
	       response.sendRedirect(MAIN_1);
	}
	
	/**
	 * Gerar relatorio de contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void gerarRelatorioDeContatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		Document documento = new Document();
		try {
			//tipo conteúdo
			response.setContentType("apllication/pdf");
			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename=contatos.pdf");
			//criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			//abrir o documento para gera o conteúdo
			documento.open();
			
			documento.add(new Paragraph("Lista de contatos"));
			documento.add(new Paragraph(" "));
			//criar uma tabela
			PdfPTable tabela = new PdfPTable(3);
			//cabeçalho
			PdfPCell col_1 = new PdfPCell( new Paragraph("Nome"));
			PdfPCell col_2 = new PdfPCell( new Paragraph("Fone"));
			PdfPCell col_3 = new PdfPCell( new Paragraph("E-mail"));
			
			tabela.addCell(col_1);
			tabela.addCell(col_2);
			tabela.addCell(col_3);
			
			//popular a tabela com os contatos
			ArrayList<JavaBeans> agendas = dao.listarContatos();
			for (int i = 0; i < agendas.size(); i++) {
				tabela.addCell(agendas.get(i).getNome());
				tabela.addCell(agendas.get(i).getFone());
				tabela.addCell(agendas.get(i).getEmail());
			}
			
			documento.add(tabela);
			
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
		
	}

	
	/**
	 * Sets the objeto contato.
	 *
	 * @param request the new objeto contato
	 */
	private void setObjetoContato(HttpServletRequest request) {
		this.contato.setNome(request.getParameter(NOME));
        this.contato.setFone(request.getParameter(FONE));
        this.contato.setEmail(request.getParameter(E_MAIL));
	}
}

