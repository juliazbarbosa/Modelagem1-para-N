package DAO;

import Entity.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AutorDAO {

public Autor[] listar;

 public class AutorDAO {
    private Connection connection;
    public AutorDAO()throws SQLException{
        this.connection = ConexaoBD.getInstance().getConexao();
    }   
    
    public void inserir(Autor autor) {
        String sql = "INSERT INTO Autor (id_autor, nome, nacionalidade) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
           statement.setString(1, autor.getNomeAutor());
            statement.setString(2, autor.getNacionalidade());
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        autor.setIdAutor(generatedKeys.getInt(1));
                    }
                }
            }

        }
    }


    public void atualizar(Autor autor) {
        String sql = "UPDATE Autor SET nome = ?, nacionalidade = ? WHERE id_autor = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, autor.getNome());
            stmt.setString(2, autor.getNacionalidade());
            stmt.setInt(3, autor.getIdAutor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  // Tratamento de erro - imprime o stack trace
        }
    }

    public void excluir(int idAutor) {
        String sql = "DELETE FROM Autor WHERE id_autor = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAutor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  // Tratamento de erro - imprime o stack trace
        }
    }

    public List<Autor> listar() {
        String sql = "SELECT * FROM Autor";
        List<Autor> autores = new ArrayList<>();
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Autor autor = new Autor(rs.getInt("id_autor"), rs.getString("nome"), rs.getString("nacionalidade"));
                autores.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Tratamento de erro - imprime o stack trace
        }
        return autores;
    }
}
