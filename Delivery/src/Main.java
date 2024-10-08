import java.sql.Connection;
import ConnectionDB.ConexaoDB;
import Customer.Customer;
import Customer.CustomerDAO;
import Estado.Estado;
import Estado.EstadoDAO;

public class Main {
    public static void main(String[] args) {

        EstadoDAO edao = new EstadoDAO();
        CustomerDAO cdao = new CustomerDAO();

        //Adiconar Estado
//        Estado novoEstado = new Estado();
//        novoEstado.setSigla("SP");
//        novoEstado.setdescricao("São Paulo");
//        edao.adicionarEstado(novoEstado);

        //Listar Estados
//        for(Estado estado : edao.listarEstados()){
//            System.out.println(estado.getSigla() + "-" +estado.getdescricao());
//        }

        //Atualizar estados
//        novoEstado.setdescricao("São Paulo - Atualizado");
//        edao.ataulizaEstado(novoEstado);

        //Deletar estado
//        edao.deletarEstado(novoEstado.getSigla());

        //Create Customer
        Customer customer = new Customer();
        customer.setCpf("18643255987");
        customer.setNome("Ana Pereira");
        customer.setEndereco1("Avenida Paulista");
        customer.setEndereco2("Sala 501");
        customer.setBairro("Bela Vista");
        customer.setCidade("São Paulo");
        customer.setEstado(edao.getStadoBySigla("SP"));
        customer.setCep("01310100");
        customer.setIdade(28);
        customer.setPrimeira_compra(true);
        customer.setData_nascimento("1996-07-02");
//
        cdao.createCustomer(customer);

        //Update customer String
//        cdao.editCustomerString("33333333333", "bairro", "Iririú");

        //Delete customer
//        cdao.deleteCustomer("2222222222");

        //Get Customers
        for (Customer getCustomer : cdao.getCustomers()) {
            System.out.println("Clientes: " + getCustomer.getNome());
        }
    }
}