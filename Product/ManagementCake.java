package Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ManagementCake {
    private final List<Cake> CakeList;
    private static final ManagementCake managementCake = new ManagementCake();
    private static final String File_Cake = "cake.csv";
    private static final String File_Receipt = "Bill.csv";

    public static ManagementCake getManagementCake() {
        return managementCake;
    }

    private ManagementCake() {
        CakeList = new ArrayList<>();
        ReadFill();
    }

    private void ReadFill() {
        CakeList.clear();
        try {
            FileReader fileReader = new FileReader(File_Cake);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i;
            while ((i = bufferedReader.read()) != -1) {
                System.out.println(i);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void SaveFill() {
        try {
            FileWriter fileWriter = new FileWriter(File_Cake);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cake c : CakeList) {
                bufferedWriter.write(c.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Add(Cake newcake) {
        CakeList.add(newcake);
        SaveFill();
    }


    public boolean Remove(String name) {
        //Cake cake = this.CakeList.stream().filter(p->p.getNameCake().equals(name)).findFirst().orElse(null);
        Cake cake = (Cake) SearchCakeName(name);
        if (cake == null) {
            return false;
        }
        CakeList.remove(cake);
        return true;
    }

    public List<Cake> SearchCakeName(String name) {
        List<Cake> nameList = new ArrayList<>();
//        return this.CakeList.stream().filter(p -> p.getNameCake().equals(name)).findFirst().orElse(null);
        for (Cake cake : nameList) {
            if (cake.getNameCake().contains(name)) {
                nameList.add(cake);
            }
        }
        return nameList;
    }

    public Cake SearchById(String id) {
        for (Cake cake : CakeList) {
            if (cake.getIdCake().equals(id)) {
                return cake;
            }
        }
        return null;
    }

    public List<Cake> SearchByType(String type) {
        List<Cake> typeList = new ArrayList<>();
        for (Cake cake : typeList) {
            if (cake.getType().contains(type)) {
                typeList.add(cake);
            }
        }
        return typeList;
    }

    public List<Cake> DisplayCake() {
        return new ArrayList<>(CakeList);
    }

    public void UpdateNewCake(String name, Cake newCake) {
        Cake cake = (Cake) SearchCakeName(name);
        if (cake != null) {
            cake.setType(newCake.getType());
            cake.setPrice(newCake.getPrice());
            cake.setSize(newCake.getSize());
        }
    }

    public List<Cake> OutOfStock() {
        List<Cake> outOfstock = new ArrayList<>();
        for (Cake cake : outOfstock) {
            if (!cake.isStock) {
                outOfstock.add(cake);
            }
        }
        return outOfstock;
    }

    public List<Cake> inStock() {
        List<Cake> inStock = new ArrayList<>();
        for (Cake cake : CakeList) {
            if (cake.isStock()) {
                inStock.add(cake);
            }
        }
        return inStock;
    }


    public void saveFill() {
        try {
            FileWriter fileWriter = new FileWriter(File_Receipt);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Cake c : CakeList) {
                bufferedWriter.write(c.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


