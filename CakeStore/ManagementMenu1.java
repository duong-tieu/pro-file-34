package CakeStore;

import Customer.Customer;
import Customer.ManagerCustomer;
import Product.Cake;
import Product.ManagementCake;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ManagementMenu1 {
    ManagementReceipt managementReceipt = ManagementReceipt.getManagementReceipt;
    ManagementCake managementCake = ManagementCake.getManagementCake();
    ManagerCustomer managerCustomer = ManagerCustomer.getManagerCustomer();

    public void DisplayMenu() {
        System.out.println("----- Hóa đơn cửa hàng -----");
        System.out.println("1. Thêm hóa đơn ");
        System.out.println("2. Tìm tên người mua");
        System.out.println("3. Xóa hóa đơn theo id");
        System.out.println("4. Tìm hóa đơn bằng id");
        System.out.println("5. hiện ra hóa đơn ");
        System.out.println("6. Thoát khỏi chương trình");
    }

    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            DisplayMenu();
            System.out.println("Nhập số :");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addReceipt();
                case 2 -> SearchCustomer();
                case 3 -> RemoveById();
                case 4 -> SearchByIdBill();
                case 5 -> DisplayBill();
                default -> {
                }
            }
        } while (choice != 0);
    }

    private void addReceipt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("danh sach nhung loai banh con trong kho");
        List<Cake> cakeList = ManagementCake.getManagementCake().inStock();
        for (Cake cake : cakeList) {
            System.out.println(cake);
        }
        System.out.println("nhap ten cua nguoi mua:");
        String nameCustomer = scanner.nextLine();
        System.out.println("nhap id cua nguoi mua");
        String idCustomer = scanner.nextLine();
        System.out.println("nhap so dien thoai nguoi mua");
        String phoneCustomer = scanner.nextLine();
        Receipt receipt = new Receipt(nameCustomer, idCustomer, phoneCustomer);
        do {
            System.out.println("nhap san pham");
            System.out.println("Khong nhap them san pham");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("nhap san pham moi bang id ");
                    String idCake = scanner.nextLine();
                    do {
                        System.out.println("nhap vao so luong banh");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        Cake cake = managementCake.SearchById(idCake);
                        if (quantity > cake.getStock()) {
                            System.out.println("so luong banh trong kho khong du");
                            System.out.println("banh " + cake.getNameCake() + "co" + cake.getType() + " va " +
                                    cake.getSize() + "con lai " + cake.getStock());
                            managementReceipt.RemoveByIdReceipt(receipt.getIdBill());
                        } else {
                            receipt.add(idCake, quantity);
                        }
                    } while (true);
            }
            System.out.println("khong nhap bat ki san pham nao");
            break;
        } while (true);
    }


    private void RemoveById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id cua hoa don ");
        UUID billId = UUID.fromString(scanner.nextLine());
        managementReceipt.SearchByIdReceipt(billId);
        System.out.println("van con trong danh sach");
    }

    private void SearchByIdBill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhâpj vào id của hóa đơn");
        UUID idReceipt = UUID.fromString(scanner.nextLine());
        Receipt searchByIdReceipt = managementReceipt.SearchByIdReceipt(idReceipt);
        if (searchByIdReceipt != null) {
            System.out.println(searchByIdReceipt);
        } else {
            System.out.println("khong tim thay id hoa don");
        }
    }

    private void SearchCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap ten cua khach hang");
        String nameCustomer = sc.nextLine();
        List<Receipt> SearchCustomer = managementReceipt.SearchNameCustomer(nameCustomer);
        if (SearchCustomer.size() != 0) {
            for (Receipt r : SearchCustomer) {
                System.out.println(r);
            }
        } else {
            System.out.println("Id khong ton tai");
        }
    }

    private void DisplayBill() {
        System.out.println(managementReceipt.Display());
    }
}