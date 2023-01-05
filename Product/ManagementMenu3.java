package Product;

import java.util.List;
import java.util.Scanner;

public class ManagementMenu3 {
    static ManagementCake managementCake = ManagementCake.getManagementCake();
    public static void DisplayMenu() {
        System.out.println("|--- Danh sách các loại trên hóa đơn---|"+"\n");
        System.out.println("1. hiển thị danh sách --"+"\n");
        System.out.println("2. thêm bánh vào danh sách."+"\n");
        System.out.println("3. Xóa bánh ra khỏi danh sách bằng tên."+"\n");
        System.out.println("4. Tìm kiếm bánh bằng tên."+"\n");
        System.out.println("5. Tìm kiếm bánh bằng id."+"\n");
        System.out.println("6. Loại bánh: "+"\n");
        System.out.println("7. Cập nhập thêm bánh:" +"\n");
        System.out.println("8. Loại bánh còn :");
        System.out.println("9. loại bánh không còn :" +"\n");
        System.out.println("-- Kết thúc --"+"\n");
        System.out.println("***************************************");
    }
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        String choice = "0";
    while (!choice.equals("")){
        DisplayMenu();
        System.out.println("nhập yêu cầu bạn muốn:");
        choice = sc.nextLine();
        sc.nextLine();
    switch (choice){
        case "1" -> add();
        case "2" -> remove();
        case "3" -> SearchName();
        case "4" -> SearchId();
        case "5" -> SearchType();
        case "6" -> UpDate();
        case "7" -> outOfStock();
        case "8" -> inStock();
        case "9" -> show();
        default -> {
          }
        }
      }
    }
    private static void show(){
        List<Cake> pieList = managementCake.DisplayCake();
        for(Cake pie : pieList){
            System.out.println(pie);
        }
        System.out.println("-------------------");
    }

    private static void add() {
        while (managementCake.inStock() == null) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên loại bánh:");
        String name = sc.nextLine();
        System.out.println("nhập id của bánh:");
        String id = sc.nextLine();
        System.out.println("nhập loại bạn muốn:");
        String type = sc.nextLine();
        System.out.println("nhập kích thước của bánh: ");
        String size = sc.nextLine();
        System.out.println("nhập giá tiền của mỗi cái bánh");
        Double price = sc.nextDouble();
        Cake pie = new Cake(name,id,type,size,price);
        managementCake.Add(pie);
        sc.nextLine();
        System.out.println("+++++++++++++++++======");
        }
    }

    private static void remove(){
       Scanner sc = new Scanner(System.in);
        System.out.println("Type the name of the cake:");
        String name = sc.nextLine();
        if(managementCake.Remove(name)){
            System.out.println("Đã xóa loại bánh đó ");
        } else
            System.out.println("Chưa xóa loại bánh đó");
    }

    private static void SearchName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên loại bánh bạn muốn tìm");
        String name = sc.nextLine();
        List<Cake> cakeList = managementCake.SearchCakeName(name);
        if (cakeList.size() != 0) {
            for (Cake cake : cakeList) {
                System.out.println(cake);
            }
        } else {
            System.out.println("Không tìm thấy bánh");
        }
    }


    private static void SearchId(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id của loại bánh muốn tìm:");
        String id = sc.nextLine();
        Cake searchCakeById = managementCake.SearchById(id);
            if(searchCakeById != null){
                System.out.println(id);
            }else {
                System.out.println("khong tim thay");
            }

    }
    private static void SearchType(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap loai banh ban muon:");
        String type = sc.nextLine();
        List<Cake> typeList = managementCake.SearchByType(type);
        if(typeList.size() != 0){
            for(Cake p : typeList){
                System.out.println(p);
            }
        } else {
            System.out.println("loai banh da het");
        }
    }

    private static void UpDate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập tên bánh :");
        String newName = sc.nextLine();
        System.out.println("nhập id mới của bánh:");
        String newId = sc.nextLine();
        System.out.println("nhập loại bánh :");
        String newType = sc.nextLine();
        System.out.println("nhập kích cỡ của bánh:");
        String newSize = sc.nextLine();
        System.out.println("nhập gíá mới cho bánh:");
        Double newPrice = sc.nextDouble();
        Cake newCake = new Cake(newName,newId, newType, newSize, newPrice);
        managementCake.UpdateNewCake(newCake.getNameCake(),newCake);
    }
    
    private static void inStock(){
        List<Cake> typeOfCake = managementCake.inStock();
        for(Cake oldStock : typeOfCake){
            System.out.println(oldStock);
        }
    }

    private static void outOfStock(){
        List<Cake> theCakeIsOut = managementCake.OutOfStock();
        for (Cake stock: theCakeIsOut) {
            System.out.println(stock);
        }
    }
}



