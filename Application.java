import controllers.ControlOrder;
import entities.Customer;
import entities.Products;
import repositories.IOrderRepository;
import repositories.OrderRepository;

import java.util.Scanner;

public class Application {
    private final ControlOrder controlOrder;
    private final Scanner scanner;

    public Application(IOrderRepository repo) {
        controlOrder= new ControlOrder(repo);
        scanner=new Scanner(System.in);
    }
    public void start(){
        char out='N';
        String in;
        int choice;
        Scanner sc=new Scanner(System.in);
        while (out!='Y'){
            System.out.println("Avialable options: ");
            System.out.println("Purchase products-1");
            System.out.println("See my order-2");
            System.out.println("Show all customers-3");
            System.out.println("Find customer by id-4");
            System.out.println("Authorise new customer-5");
            System.out.println("Create new product - 6");
            System.out.println("Exit-7");
            choice=sc.nextInt();
            try {
                switch (choice){
                    case 1: {
                        buy();
                        break;
                    }
                    case 2: {
                        order();
                        break;
                    }
                    case 3: {
                        allCustomers();
                        break;
                    }
                    case 4: {
                        getCustomerID();
                        break;
                    }
                    case 5: {
                        create();
                        break;
                        }
                    case 6: {
                        createProduct();
                        break;
                    }
                    default: System.exit(0);
                }
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void buy(){
        System.out.println("Input your number of phone:");
        String phone=scanner.next();
        OrderRepository repository=new OrderRepository();
        Customer customer=repository.getCustomerPhone(phone);
        if(customer==null){
            System.out.println("This customer does not exist in the base!");
            return;
        }

        char out='N';
        String in;
        int choice;
        Scanner scanner=new Scanner(System.in);

        while(out!='Y'){
            controlOrder.getAllProductList();
            choice=scanner.nextInt();
            Products products=repository.getProductsByUsingID(choice);
            repository.orderCreating(customer,products);
            System.out.println("Y/N");
            in=scanner.next().toUpperCase();
            out=in.charAt(0);
        }
    }
    private void order(){
        System.out.println("Input your phone number:");
        String phone=scanner.nextLine();
        String response=controlOrder.getCustomerPhone(phone);
        System.out.println(response);
    }
    public void allCustomers(){
        String response=controlOrder.getAllCustomerList();
        System.out.println(response);
    }
    public void getCustomerID(){
        System.out.println("Input id of customer:");
        int id=scanner.nextInt();
        String response=controlOrder.getCustomer(id);
        System.out.println(response);
    }
    public void create(){
        System.out.println("Input your name:");
        String name=scanner.nextLine();
        System.out.println("Input your phone number:");
        String phoneNumb=scanner.nextLine();

        String response=controlOrder.mintNewCustomers(name,phoneNumb);
        System.out.println(response);
    }
    public void createProduct(){
        System.out.println("Input your product name: ");
        String pname=scanner.nextLine();
        System.out.println("Input your price: ");
        String price=scanner.nextLine();

        String response=controlOrder.mintNewProduct(pname,price);
        System.out.println(response);
    }
}
