import repositories.IOrderRepository;
import repositories.OrderRepository;

public class Main {
    public static void main(String[] args) {
        IOrderRepository iOrderRepository = new OrderRepository();
        Application application = new Application(iOrderRepository);
        application.start();
        System.out.println("Hello");
    }
}
