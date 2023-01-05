package Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerCustomer {
    private final List<Customer> customersList;
    private static final String File_Customer = "customer.csv";
    private final static ManagerCustomer managerCustomer = new ManagerCustomer();

    public ManagerCustomer() {
        customersList = new ArrayList<>();
    }

    public static ManagerCustomer getManagerCustomer() {
        return managerCustomer;
    }

    public void AddCustomer(Customer newCustomer) throws IOException {
        this.customersList.add(newCustomer);
        managerCustomer.SaveFile();
    }

    public Customer SearchById(String id) throws IOException {
        for (Customer customer : customersList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public boolean Remove(String id) {
        for (Customer customer : customersList) {
            if (customer.getId().equals(id)) {
                this.customersList.remove(id);
            }
        }
        return false;
    }

    public void SetNewCustomer(String id,Customer newCustomer) throws IOException {
        Customer c =  SearchById(id);
            if (c != null) {
                c.setName(newCustomer.getName());
                c.setAddress(newCustomer.getAddress());
                c.setPhone(newCustomer.getPhone());
            }
        }

   public List<Customer> SesrchByName(String name){
        List<Customer> nameList = new ArrayList<>();
        for(Customer customer : customersList){
            if(customer.getName().contains(name)){
                nameList.add(customer);
            }
        }
        return nameList;
   }

   public Customer SearchByPhone(String phone){
       for (Customer customer: customersList) {
           if(customer.getPhone().equals(phone)){
              return customer;
           }
       }
       return null;
   }

   public boolean SearchByAddress(String address){
        List<Customer> addressList = new ArrayList<>();
        for(Customer customer: addressList){
            if(customer.getAddress().contains(address)){
                addressList.add(customer);
            }
        }
        return false;
   }

   public List<Customer> DisplayALl(){
     return new ArrayList<>(customersList);
   }

   public void SaveFile() throws IOException {
       FileOutputStream File_Customer = null;
       BufferedOutputStream Four = null;
   try {
       File_Customer = new FileOutputStream("D:\\Visual Studio 2022\\Code Snippets\\JAVA\\Quản lí cửa hàng bánh kem\\customer.csv");
       Four = new BufferedOutputStream(Four);
   }catch (IOException e){
       e.printStackTrace();
   } finally {
     File_Customer.close();
     Four.close();
   }
       System.out.println("Successs");
   }

   public void ReadFile(){

   }
}
