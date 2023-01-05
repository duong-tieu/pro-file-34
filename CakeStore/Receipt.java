package CakeStore;

import Product.Cake;
import Product.ManagementCake;

import java.time.LocalDate;
import java.util.TreeMap;
import java.util.UUID;

public class Receipt {
    private UUID ReceiptId;
    private LocalDate DayMade;
    private String IdCustomer;
    private String NameCustomer;
    private String IdCake;
    private String NameCake;
    private int quantity = 0;
    private double subTotal;
    private double total;
    private String PhoneNumber;
    private final TreeMap<String , Integer> treeMap;
    ManagementCake managementCake = ManagementCake.getManagementCake();


    public Receipt(UUID receiptId, LocalDate dayMade, String idCustomer, String nameCustomer, double total, String phoneNumber){
           this.ReceiptId = receiptId;
           this.DayMade = dayMade;
           this.IdCustomer = idCustomer;
           this.NameCustomer = nameCustomer;
           this.total = total;
           PhoneNumber = phoneNumber;
           this.treeMap = new TreeMap<>();
    }

    public Receipt(String idCustomer, String nameCustomer, String phoneNumber){
        this.ReceiptId = UUID.randomUUID();
        this.DayMade =  LocalDate.now();
        this.IdCustomer = idCustomer;
        this.NameCustomer = nameCustomer;
        this.PhoneNumber = phoneNumber;
        this.treeMap = new TreeMap<>();

    }
    public TreeMap<String , Integer> getTreeMap() {
        return treeMap;
    }

    public void add( String idCake, int quantity){
        getTreeMap().put(idCake, quantity);
    }

    public double getSubTotal(String idCake, int quantity){
        double sub = 0;
        Cake cake = managementCake.SearchById(idCake);
        sub += cake.getPrice() * quantity;
        this.subTotal = sub;
        return sub;
    }

    public double getTotal(String idCake, int quantity){
        return total;
    }

    public void setTotal(){
        double total = 0;
        for(String key : treeMap.keySet()){
            total += getSubTotal(key, treeMap.get(key));
        }
         this.total = total;
    }
    public UUID getIdBill() {
        return ReceiptId;
    }

    public void setIdBill(UUID ReceiptId) {
        this.ReceiptId = ReceiptId;
    }

    public LocalDate getDayMade() {
        return DayMade;
    }

    public void setDayMade(LocalDate dayMade) {
        DayMade = dayMade;
    }

    public String getIdCustomer() {
        return IdCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        IdCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return NameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        NameCustomer = nameCustomer;
    }

    public String getIdCake() {
        return IdCake;
    }

    public void setIdCake(String idCake) {
        IdCake = idCake;
    }

    public String getNameCake() {
        return NameCake;
    }

    public void setNameCake(String nameCake) {
        NameCake = nameCake;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public TreeMap<String, Integer> treeMap() {
        return treeMap;
    }
   @Override
    public String toString(){
        return   "Bill :" + "\n" +
                 "Id của hóa đơn :'" + ReceiptId + '\'' +
                 "id của người mua :'" + IdCustomer + " - " + "Tên người mua :" + NameCustomer + '\'' +
                 "Id của loại bánh :' " + IdCake + " - " + " Tên của loại bánh :" + NameCake + '\'' +
                 "tổng giá của mỗi sản phẩm :'" + subTotal + '\'' +
                 "Tổng tiền của hóa đơn :" + total ;
   }
}
