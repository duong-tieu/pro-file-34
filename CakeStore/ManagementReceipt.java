package CakeStore;

import Customer.Customer;
import Customer.ManagerCustomer;
import Product.Cake;
import Product.ManagementCake;

import java.io.*;
import java.util.*;

public class ManagementReceipt {
    private static final ManagementReceipt MANAGEMENT_RECEIPT = new ManagementReceipt();
    private static final String File_Bill="bill.csv";
    public static ManagementReceipt getManagementReceipt;
    ManagementCake managementCake = ManagementCake.getManagementCake();
    ManagerCustomer managerCustomer = ManagerCustomer.getManagerCustomer();
    private List<Receipt> receiptList;

    private static ManagementReceipt getManagementReceipt() {
        return MANAGEMENT_RECEIPT;
    }

    private void ManagmentReceipt(){
        receiptList = new ArrayList<>();
        ReadFileReceipt();
    }

    public void add(Receipt newReceipt) throws IOException {
        newReceipt.setTotal();
        receiptList.add(newReceipt);
        updateQuantity(newReceipt);
        updateCustomer(newReceipt);
        SaveFileReceipt();
    }

    public Receipt SearchByIdReceipt(UUID idReceipt){
        for(Receipt receipt : receiptList) {
            if (receipt.getIdBill().equals(idReceipt)) {
                return receipt;
            }
        }
        return null;
    }

    public void updateQuantity(Receipt newReceipt){
        TreeMap<String , Integer> newQuantity = newReceipt.treeMap();
        for(Map.Entry<String , Integer> bill : newQuantity.entrySet()){
            Cake cake = managementCake.SearchById(newReceipt.getIdCake());
            cake.setStock(cake.getStock() - bill.getValue());
            if(cake.getStock() > 0) managementCake.saveFill();
        }
    }

    public void updateCustomer(Receipt newReceipt) throws IOException {
        Customer c = managerCustomer.SearchById(newReceipt.getIdCustomer());
        if(c != null){
            newReceipt.setNameCustomer(c.getName());
            newReceipt.setPhoneNumber(c.getPhone());
            newReceipt.setIdCustomer(c.getId());
        } else {
            Customer newCustomer = new Customer();
            newCustomer.setId(c.getId());
            newCustomer.setName(c.getName());
            newCustomer.setPhone(c.getPhone());
            managerCustomer.AddCustomer(newCustomer);
        }
        managerCustomer.SaveFile();
    }

    private void ReadFileReceipt() {
        receiptList.clear();
        try {
            FileReader fileReaderReceipt = new FileReader(File_Bill);
            BufferedReader bufferedReaderReceipt = new BufferedReader(fileReaderReceipt);
            String i = "";
            if ((i = bufferedReaderReceipt.readLine()) != null) {
                System.out.println(i);
            }
            bufferedReaderReceipt.close();
            fileReaderReceipt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SaveFileReceipt() {
        try {
            FileWriter fileWriterReceipt = new FileWriter(File_Bill);
            BufferedWriter bufferedWriterReceipt = new BufferedWriter(fileWriterReceipt);
            for (Receipt r : receiptList){
                bufferedWriterReceipt.write(r.toString());
                bufferedWriterReceipt.newLine();
            }
            bufferedWriterReceipt.close();
            fileWriterReceipt.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Cake> inStockList(){
        return managementCake.inStock();
    }

    public boolean RemoveByIdReceipt(UUID idReceipt) {
        Receipt receipt = SearchByIdReceipt(idReceipt);
        if (receipt != null) {
            receiptList.remove(receipt);
            SaveFileReceipt();
            System.out.println(receipt);
            return true;
        }
        return false;
    }

    public String Display(){
        String string = "";
        for(Receipt receipt : receiptList){
            string += receipt.toString();
        }
        ReadFileReceipt();
        return string;
    }


    public List<Receipt> SearchNameCustomer(String name) {
        List<Receipt> receipts = new ArrayList<>();
        for (Receipt c : receiptList){
            if (c.getNameCustomer().equals(name)){
                receiptList.add(c);
            }
        }
        return receiptList;
    }
}
