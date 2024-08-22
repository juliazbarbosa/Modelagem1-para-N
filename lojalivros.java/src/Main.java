import DAO.AutorDAO;
import DAO.LivroDAO;
import Entity.Autor;
import Entity.Livro;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AutorDAO autorDAO = new AutorDAO();
        LivroDAO livroDAO = new LivroDAO();


        Autor autor1 = new Autor("Fulano da Silva");
        Autor autor2 = new Autor("Ciclano Beltrano");

        autorDAO.inserir(autor1);
        autorDAO.inserir(autor2);


        Livro livro1 = new Livro("Diário de um Banana", autor1.getNome());
        Livro livro2 = new Livro("Crepúsculo", autor1.getNome());
        Livro livro3 = new Livro("Percy Jackson", autor2.getNome());

        livroDAO.inserir(livro1);
        livroDAO.inserir(livro2);
        livroDAO.inserir(livro3);


        List<Autor> autores = autorDAO.listarAutores();
            System.out.println("\nAutores:");
            for (Autor a : autores) {
                System.out.println(a.getIdAutor() + ": " + a.getNomeAutor() + " (" + a.getNacionalidade() + ")");
            }

            List<Livro> livros = livroDAO.listarLivros();
            System.out.println("\nTodos os livros:");
            for (Livro l : livros) {
                System.out.println(l.getIdLivro() + ": " + l.getTitulo() + " (" + l.getAnoPublicado() + ") - Autor ID: " + l.getAutor().getIdAutor());
            }

            
            List<Livro> livrosDeAutor1 = livroDAO.listarLivrosDeAutor(autor1.getIdAutor());
            System.out.println("\nLivros do autor " + autor1.getNomeAutor() + ":");
            for (Livro l : livrosDeAutor1) {
                System.out.println(l.getIdLivro() + ": " + l.getTitulo() + " (" + l.getAnoPublicado() + ")");
            }

         
            List<Livro> livrosDeAutor2 = livroDAO.listarLivrosDeAutor(autor2.getIdAutor());
            System.out.println("\nLivros do autor " + autor2.getNomeAutor() + ":");
            for (Livro l : livrosDeAutor2) {
                System.out.println(l.getIdLivro() + ": " + l.getTitulo() + " (" + l.getAnoPublicado() + ")");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
