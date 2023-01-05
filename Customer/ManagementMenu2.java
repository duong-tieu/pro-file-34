package Customer;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ManagementMenu2 {
    static ManagerCustomer managerCustomer = ManagerCustomer.getManagerCustomer();
    public static void DisplayMenu(){
        System.out.println("+++ Nhập danh sách người mua +++");
        System.out.println("1. Nhập thông tin của người mua:");
        System.out.println("2. Xóa người mua ra khỏi danh sách:");
        System.out.println("3. Tìm người mua bằng tên");
        System.out.println("4. Tìm người mua bằng id");
        System.out.println("5. Tìm người mua bằng số điện thoại ");
        System.out.println("6. Tìm ngưởi mua bằng địa chỉ ");
        System.out.println("7. Chỉnh sửa thông tin người mua:");
        System.out.println("8. Hiển thị danh sách:");
        System.out.println("_____ Thoát khỏi chương trình_____");
    }
    public static void menu() throws IOException {
        DisplayMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (true){
            choice = scanner.nextInt();
            System.out.println("lua chon cac chuc nang sau:");
            scanner.nextLine();
            switch (choice){
                case 1 -> add();
                case 2 -> remove();
                case 3 -> SearchId();
                case 4 -> SearchName();
                case 5 -> SearchPhone();
                case 6 -> SearchAddress();
                case 7 -> SetInfomation();
                case 8 -> DisplayAll();
                default -> {
                }
            }
        }
    }

    private static void add() throws IOException {
        Scanner sc =new Scanner(System.in);
        System.out.println("nhập tên của khách hàng");
        String name = sc.nextLine();
        System.out.println("nhâp id của khách hàng");
        String id = sc.nextLine();
        System.out.println("nhập địa chỉ của khách hàng");
        String address = sc.nextLine();
        System.out.println("nhập số điện thoại của khách hàng");
        String phone = sc.nextLine();
        Customer customer = new Customer(name,id,address,phone);
        managerCustomer.AddCustomer(customer);
        sc.nextLine();
    }


    private static void remove(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập id của khách hàng");
        String id = sc.nextLine();
        if(managerCustomer.Remove(id)){
            System.out.println("Tim thay");
        }else {
            System.out.println("ko phai nguoi ban muon xoa");
        }
    }

    private static void SearchName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten nguoi mua: ");
        String name = sc.nextLine();
        List<Customer> customerNameList = managerCustomer.SesrchByName(name);
        if(customerNameList.size() != 0){
            System.out.println(name);
        } else {
            System.out.println("khong tim thay");
        }
    }

    private static void SearchId() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap id nguoi mua :");
        String id = sc.nextLine();
        Customer customerIdSearch = managerCustomer.SearchById(id);
        if(customerIdSearch != null){
            System.out.println(id);
        }else {
            System.out.println("khong tim thay");
        }

    }

    private static void SearchPhone(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so dien thoai nguoi mua");
        String phone = sc.nextLine();
        Customer SearchCustomerPhone = managerCustomer.SearchByPhone(phone);
        if(SearchCustomerPhone != null){
            System.out.println(phone);
        } else {
            System.out.println("khong tim thay");
        }
    }

    private static void SearchAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap dia chi cua nguoi mua");
        String address = sc.nextLine();
        if(managerCustomer.SearchByAddress(address)){
            System.out.println(address);
        } else {
            System.out.println("khong tim thay");
        }
    }

    private static void SetInfomation() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten moi:");
        String newName = sc.nextLine();
        System.out.println("nhap so dien thoai moi :");
        String newPhone = sc.nextLine();
        System.out.println("nhap so dia chi moi:");
        String newAddress = sc.nextLine();
        Customer newCustomer = new Customer(nameCustomer, idCustomer, phoneCustomer);
        managerCustomer.SetNewCustomer(newCustomer.getId(),newCustomer);
        sc.nextLine();
    }
    private static void DisplayAll() throws IOException{
        List<Customer> customerList = managerCustomer.DisplayALl();
        for (Customer customer: customerList) {
            System.out.println(customer);
        }
    }
  }

