package Estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectionDB.ConexaoDB;

public class EstadoDAO {

    public boolean adicionarEstado(Estado estado){
        String sql = "INSERT INTO estado (sigla, descricao) VALUES (?, ?)";

        try{
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, estado.getSigla());
            stmt.setString(2, estado.getdescricao());

            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch (SQLException e){
            System.out.println("Erro ao adicionar estado: "+e.getMessage());
            return false;
        }

    }

    public List<Estado> listarEstados(){
        List<Estado> estados = new ArrayList<>();
        String sql = "Select * from estado";

        try{
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs  = stmt.executeQuery();

            while(rs.next()){
                Estado estado = new Estado();
                estado.setSigla(rs.getString("sigla"));
                estado.setdescricao(rs.getString("descricao"));
                estados.add(estado);
            }
            return estados;

        } catch (SQLException e) {
            System.out.println("Erro ao adiconar estado: "+e.getMessage());
            return null;
        }
    }

    public boolean ataulizaEstado(Estado estado){
        String sql = "UPDATE estado SET descricao = ? WHERE sigla = ?";

        try{
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, estado.getdescricao());
            stmt.setString(2, estado.getSigla());
            stmt.executeUpdate();

            connection.close();
            stmt.close();
            return true;
        }catch(SQLException e){
            System.out.println("Erro ao atualizar estado: "+ e.getMessage());
        }

        return false;
    }

    public void deletarEstado(String sigla){
        String sql = "DELETE FROM estado WHERE sigla = ?";

        try{
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, sigla);
            stmt.executeUpdate();
            connection.close();
            stmt.close();
            System.out.println("Estado deletado com sucesso");
        }catch (SQLException e){
            System.out.println("Erro ao conectar com o banco de dados!");
        }
    }
}
