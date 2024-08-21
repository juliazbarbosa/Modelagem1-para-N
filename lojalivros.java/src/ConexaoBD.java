import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static ConexaoBD instancia;
    private Connection conexao;
    private String url = "jdbc:mysql://localhost:3306/teste";
    private String usuario = "adm";
    private String senha = "1235";


    public static ConexaoBD getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexaoBD();
        } else if (instancia.getConexao().isClosed()) {
            instancia = new ConexaoBD();
        }

        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }
}
