import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static ConexaoBD instancia;
    private Connection conexao;
    private String url = "jdbc:mysql://localhost:3306/lojalivros";
    private String usuario = "adm";
    private String senha = "1235";


    private ConexaoBD() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao conectar com o banco", e);
        }
    }


    public static synchronized ConexaoBD getInstance() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }


    public Connection getConexao() {
        return conexao;
    }

    public void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
