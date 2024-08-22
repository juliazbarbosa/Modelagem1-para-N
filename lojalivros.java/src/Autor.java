public class Autor {
        private int idAutor;
        private String nome;
        private String nacionalidade;

        public Autor(int idAutor, String nome, String nacionalidade) {
            this.idAutor = idAutor;
            this.nome = nome;
            this.nacionalidade = nacionalidade;
        }

        public int getIdAutor() {
            return idAutor;
        }

        public void setIdAutor(int idAutor) {
            this.idAutor = idAutor;
        }

         public String getNomeAutor() {
        return nomeAutor;
        }

        public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
         }

        public String getNacionalidade() {
        return nacionalidade;
        }

        public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
        }

        public List<Livro> getLivros() {
        return livros;
        }

        public void setLivros(List<Livro> livros) {
        this.livros = livros;
        }

        @Override
        public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", livros=" + livros +
                '}';
    }
}
