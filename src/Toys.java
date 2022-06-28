import java.util.*;
import java.io.*;
class Toys implements Serializable {
    int nr;
    String name;
    int price;
    int cantitatea;
    String categoria;
    int id;

    Toys(String name, int price, int cantitatea, String categoria, int id){
        this.name = name;
        this.price = price;
        this.cantitatea = cantitatea;
        this.categoria = categoria;
        this.id = id;
        this.nr = nr;
    }



    public String toString(){
        return "Nr: " + nr + ", Name: " + name + ", Price: " + price + ", Cantitatea: " + cantitatea + ", Categoria: " + categoria + ", Id: " + id;
    }
}
class Company implements Serializable {
    int nr;
    int id;
    String name_company;
    String tara;

    Company(int nr, int id, String name_company, String tara){
        this.nr = nr;
        this.id = id;
        this.name_company = name_company;
        this.tara = tara;
    }

    public Company(String name, int id, String country, int empno) {
        this.name_company = name;
        this.id = id;
        this.tara = country;
        this.nr = empno;
    }

    public String toString(){
        return "Nr: " + nr + ", Name: " + name_company + ", Id: " + id + ", Tara: " + tara;
    }
}
class ToyStory {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int choice = -1;
        File file = new File("./Toys.txt");
        File file2 = new File("./Company.txt");
        List<Toys> al = new ArrayList<Toys>();
        ArrayList<Company> al1 = new ArrayList<Company>();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (List<Toys>)ois.readObject();
            ois.close();

        }
        if(file2.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file2));
            al1 = (ArrayList<Company>)ois.readObject();
            ois.close();
        }





        do {
            System.out.println("1. Adauga jucarie");
            System.out.println("2. Adauga Companie");
            System.out.println("3. Afiseaza jucarii");
            System.out.println("4. Afiseaza companiile");
            System.out.println("5. sterge jucarie");
            System.out.println("6. sterge companie");
            System.out.println("7. Updateaza jucarie");
            System.out.println("8. Updateaza companie");
            System.out.println("0.Alege o optiune: ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Introduceti denumirea jucariei: ");
                    String denumire = s.next();
                    System.out.println("Introduceti pretul jucariei: ");
                    int pret = s.nextInt();
                    System.out.println("Introduceti cantitatea de jucarii: ");
                    int cantitatea = s.nextInt();
                    System.out.println("Introduceti categoria jucariei: ");
                    String categoria = s.next();
                    System.out.println("Introduceti id-ul producatorului: ");
                    int id_producator = s.nextInt();
                    al.add(new Toys(denumire, pret, cantitatea, categoria, id_producator));
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    oos.writeObject(al);
                    oos.close();
                    System.out.println("Jucarie adaugata cu succes!");
                    break;

                case 2:
                    System.out.println("Introduceti numarul companiei: ");
                    int nr2 = s.nextInt();
                    System.out.println("Introduceti numele companiei: ");
                    String name2 = s.next();
                    System.out.println("Introduceti id-ul companiei: ");
                    int id2 = s.nextInt();
                    System.out.println("Introduceti tara companiei: ");
                    String tara = s.next();
                    al1.add(new Company(nr2, id2, name2, tara));
                    oos = new ObjectOutputStream(new FileOutputStream(file2));
                    oos.writeObject(al);
                    oos.close();
                    break;
                    case 3:
                        System.out.println("---------------------------------------");
                        li = al.listIterator();
                        while(li.hasNext()){
                            System.out.println(li.next());
                        }
                        System.out.println("---------------------------------------");
                        break;

                case 4:
                    System.out.println("---------------------------------------");
                    li = al1.listIterator();
                    while(li.hasNext()){
                        System.out.println(li.next());
                    }
                    System.out.println("---------------------------------------");

                    break;
                case 5:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (List<Toys>)ois.readObject();
                        ois.close();
                        Boolean found = false;
                        System.out.println("Enter Toy id to delete: ");
                        int empno = s.nextInt();
                        System.out.println("------------------------------");
                        li = al.listIterator();
                        while(li.hasNext()){
                            Toys e = (Toys)li.next();
                            if(e.id == empno){
                                li.remove();
                                found = true;
                            }

                        }
                        if(found){
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("Toys deleted successfully");
                        }else{
                            System.out.println("Toys not found");
                        }

                        System.out.println("------------------------------");
                    }else{
                        System.out.println("File not found");
                    }

                    break;
                case 6:
                    if(file2.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file2));
                        al1 = (ArrayList<Company>)ois.readObject();
                        ois.close();
                        Boolean found = false;
                        System.out.println("Enter Company nr to delete: ");
                        int empno = s.nextInt();
                        System.out.println("------------------------------");
                        li = al.listIterator();
                        while(li.hasNext()){
                            Toys e = (Toys)li.next();
                            if(e.nr == empno){
                                li.remove();
                                found = true;
                            }

                        }
                        if(found){
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("Company deleted successfully");
                        }else{
                            System.out.println("Company not found");
                        }

                        System.out.println("------------------------------");
                    }else{
                        System.out.println("File not found");
                    }

                    break;
                case 7:
                    if(file.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Toys>)ois.readObject();
                        ois.close();
                        Boolean found = false;
                        System.out.print("Enter Toys is to Update");
                        int empno = s.nextInt();
                        System.out.println("------------------------------");
                        li = al.listIterator();
                        while(li.hasNext()){
                            Toys e = (Toys)li.next();
                            if(e.id == empno){
                                System.out.print("Enter new Toy name");
                                String name = s1.nextLine();
                                System.out.print("Enter new Toy price");
                                int price = s1.nextInt();
                                System.out.print("Enter new Toy quantity");
                                int cantitate = s1.nextInt();
                                System.out.print("Enter new Toy category");
                                String ecategoria = s1.next();

                              li.set(new Toys(name, price, cantitate, ecategoria, empno));
                                found = true;
                            }

                        }
                        if(found){
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(al);
                            oos.close();
                            System.out.println("Employee updated");
                        }else{
                            System.out.println("Employee not found");


                        }

                        System.out.println("------------------------------");
                    }else{
                        System.out.println("File not found");
                    }

                    break;
                case 8:
                    if(file2.isFile()){
                        ois = new ObjectInputStream(new FileInputStream(file2));
                        al1 = (ArrayList<Company>)ois.readObject();
                        ois.close();
                        Boolean found = false;
                        System.out.print("Enter employee number to Update");
                        int empno = s.nextInt();
                        System.out.println("------------------------------");
                        li = al.listIterator();
                        while(li.hasNext()){
                            Company e = (Company)li.next();
                            if(e.nr == empno){
                                System.out.print("Enter new Company name");
                                String name = s1.nextLine();
                                System.out.print("Enter new Company id");
                                int id = s1.nextInt();
                                System.out.print("Enter new Company country");
                                String country = s1.next();
                                li.set(new Company(name, id, country, empno));
                                found = true;
                            }

                        }
                        if(found){
                            oos = new ObjectOutputStream(new FileOutputStream(file2));
                            oos.writeObject(al1);
                            oos.close();
                            System.out.println("Company updated");
                        }else{
                            System.out.println("Company not found");


                        }

                        System.out.println("------------------------------");
                    }else{
                        System.out.println("File not found");
                    }

                    break;






            }

        } while (choice != 0) ;
    }
}
