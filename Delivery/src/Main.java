import java.sql.Connection;
import ConnectionDB.ConexaoDB;
import Customer.Customer;
import Customer.CustomerDAO;

public class Main {
    public static void main(String[] args) {

        CustomerDAO cdao = new CustomerDAO();

        //Create Customer
//        Customer customer = new Customer();
//        customer.setCpf("12345678901");
//        customer.setNome("Rafaela");
//        customer.setEndereco1("Rua Lisandra Beitz");
//        customer.setEndereco2(null);
//        customer.setBairro("Itaum");
//        customer.setCidade("Joinville");
//        customer.setEstado("SC");
//        customer.setCep("1111111");
//        customer.setIdade(25);
//        customer.setPrimeira_compra(false);
//        customer.setData_nascimento("1999-06-05");
//
//        cdao.createCustomer(customer);
//    }

        //Update customer String
        cdao.editCustomerString("11111111111", "nome", "UpdateTest");

        //Delete customer
        cdao.deleteCustomer("2222222222");

        //Get Customers
        for (Customer customer : cdao.getCustomers()) {
            System.out.println("Clientes: " + customer.getNome());
        }
    }
}