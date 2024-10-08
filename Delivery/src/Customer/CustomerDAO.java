package Customer;

import ConnectionDB.ConexaoDB;
import Estado.Estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {

    public void createCustomer(Customer customer){
        String sql = "INSERT INTO tbcliente(cpf, nome, endereco1, endereco2, bairro, cidade, estado, cep, idade, primeira_compra, data_nascimento)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getCpf());
            ps.setString(2, customer.getNome());
            ps.setString(3, customer.getEndereco1());
            ps.setString(4, customer.getEndereco2());
            ps.setString(5, customer.getBairro());
            ps.setString(6, customer.getCidade());
            ps.setString(7, customer.getEstado().getSigla());
            ps.setString(8, customer.getCep());
            ps.setInt(9, customer.getIdade());
            ps.setBoolean(10, customer.getPrimeira_compra());
            ps.setString(11, customer.getData_nascimento());

            ps.executeUpdate();
            connection.close();
            ps.close();
            System.out.println("Usuário cadastrado com sucesso!");

        }catch (SQLException e){
            System.out.println("Error to connect with the db creating a customer: "+e.getMessage());
        }
    }

    public List<Customer> getCustomers(){
        List<Customer> listCustomer = new ArrayList<Customer>();

        String sql = "SELECT * FROM tbcliente";

        try{
            Connection connection = ConexaoDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while(rs.next()){
                Customer customer = new Customer();
                customer.setCpf(rs.getString(1));
                customer.setNome(rs.getString(2));
                customer.setEndereco1(rs.getString(3));
                customer.setEndereco2(rs.getString(4));
                customer.setBairro(rs.getString(5));
                customer.setCidade(rs.getString(6));
                customer.setCep(rs.getString(8));
                customer.setIdade(rs.getInt(9));
                customer.setPrimeira_compra(rs.getBoolean(10));
                customer.setData_nascimento(rs.getString(11));

                Estado estado = new Estado();
                estado.setSigla(rs.getString(7));

                customer.setEstado(estado);

                listCustomer.add(customer);
            }

            return listCustomer;

        }catch (SQLException e){
            System.out.println("Error to connect with the DB reading the customers: "+e.getMessage());
            return null;
        }
    }

    public void editCustomerString(String cpf, String option, String updatedValue){

        if(!getCustomerByCpf(cpf)){
            System.out.println("Customer doesn't exists");
        }else{
            Connection connection = ConexaoDB.getConnection();

            try {
                String sql = "UPDATE tbcliente SET "+option+" = ? WHERE cpf = ?";

                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, updatedValue);
                ps.setString(2, cpf);
                ps.executeUpdate();

                connection.close();
                ps.close();

            }catch (SQLException e){
                System.out.println("Erro to connect to the DB while customer is being updated: "+e.getMessage());
            }
        }
    }

    public void editCustomerInt(String cpf, String option, int updatedValue){

        if(!getCustomerByCpf(cpf)){
            System.out.println("Customer doesn't exists");
        }else{
            Connection connection = ConexaoDB.getConnection();

            try {
                String sql = "UPDATE tbcliente SET "+option+" = ? WHERE cpf = ?";

                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, updatedValue);
                ps.setString(2, cpf);
                ps.executeUpdate();

                connection.close();
                ps.close();

            }catch (SQLException e){
                System.out.println("Erro to connect to the DB while customer is being updated: "+e.getMessage());
            }
        }
    }

    public boolean getCustomerByCpf(String cpf){
        Connection connection = ConexaoDB.getConnection();

        try{
            String sql = "SELECT nome FROM tbcliente WHERE cpf = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){return true;}

            connection.close();
            ps.close();
            rs.close();
            return false;
        }catch (SQLException e){
            System.out.println("Error to connect to the DB getting the cpf's customer: "+e.getMessage());
            return false;
        }
    }

    public void deleteCustomer(String cpf){
        if(!getCustomerByCpf(cpf)){
            System.out.println("Customer doesn't exist");
        }else{

            Connection connection = ConexaoDB.getConnection();
            String sql = "DELETE FROM tbcliente WHERE cpf = ?";

            try{
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, cpf);

                ps.executeUpdate();
                connection.close();
                ps.close();
            }catch (SQLException e){
                System.out.println("Erro to connect to the DB while customer is being deleted: "+e.getMessage());
            }
        }
    }

}