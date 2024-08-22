package DAO;

import Entity.Autor;
import Entity.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LivroDAO {
    
    private Connection connection;
    public LivroDAO()throws SQLException {
        this.connection = ConexaoBD.getInstance().getConexao();
    }

    public void inserir(Livro livro) {
        String sql = "INSERT INTO Livro (id_livro, titulo, ano_publicacao, id_autor) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, livro.getIdLivro());
            stmt.setString(2, livro.getTitulo());
            stmt.setInt(3, livro.getAnoPublicacao());
            stmt.setInt(4, livro.getIdAutor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public void atualizar(Livro livro) {
        String sql = "UPDATE Livro SET titulo = ?, ano_publicacao = ?, id_autor = ? WHERE id_livro = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setInt(2, livro.getAnoPublicacao());
            stmt.setInt(3, livro.getIdAutor());
            stmt.setInt(4, livro.getIdLivro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public void excluir(int idLivro) {
        String sql = "DELETE FROM Livro WHERE id_livro = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLivro);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();  // Tratamento de erro - imprime o stack trace
        }
    }

    public List<Livro> listar() {
        String sql = "SELECT * FROM Livro";
        List<Livro> livros = new ArrayList<>();
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("id_livro"), rs.getString("titulo"),
                        rs.getInt("ano_publicacao"), rs.getInt("id_autor"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return livros;
    }

    public List<Livro> listarPorAutor(int idAutor) {
        String sql = "SELECT * FROM Livro WHERE id_autor = ?";
        List<Livro> livros = new ArrayList<>();
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAutor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("id_livro"), rs.getString("titulo"),
                        rs.getInt("ano_publicacao"), rs.getInt("id_autor"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Tratamento de erro - imprime o stack trace
        }
        return livros;
    }
}
