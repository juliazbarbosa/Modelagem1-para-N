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


        System.out.println("Autores:");
        for (Autor autor : autorDAO.listar
