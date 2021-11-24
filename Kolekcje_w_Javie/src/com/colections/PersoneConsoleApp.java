package com.colections;

import java.util.*;

public class PersoneConsoleApp
{
    Scanner scanner = new Scanner(System.in);

    // Tworzenie obiektów, które będziemy dodawać do kolekcji
    Person person1 = new Person("Antoni","Antoniewski");
    Person person2 = new Person("Antoni","Antoniewski");
    Person person3 = new Person("Barbara","Barbarska");
    Person person4 = new Person("Barbara","Niebarbarska");
    Person person5 = new Person("Czarek","Czarkowski");

    // Tworzenie obiektów o takich samych parametrach, podklasy klasy Person
    OtherPerson otherPerson1 = new OtherPerson("Antoni","Antoniewski");
    OtherPerson otherPerson2 = new OtherPerson("Antoni","Antoniewski");
    OtherPerson otherPerson3 = new OtherPerson("Barbara","Barbarska");
    OtherPerson otherPerson4 = new OtherPerson("Barbara","Niebarbarska");
    OtherPerson otherPerson5 = new OtherPerson("Czarek","Czarkowski");

    //Deklaracja kolekcji
    Set<Person> hashSet = new HashSet();
    //Poniższa kolekcja używa Comparatora
    Set<Person> treeSet = new TreeSet(Person.comparatorLastName);
    List<Person> arrayList = new ArrayList();
    List<Person> linkedList = new LinkedList();
    Map<Integer,Person> hashMap = new HashMap();
    Map<Integer,Person> treeMap = new TreeMap();

    Set<Person> otherHashSet = new HashSet();
    Set<Person> otherTreeSet = new TreeSet();
    List<Person> otherArrayList = new ArrayList();
    List<Person> otherLinkedList = new LinkedList();
    Map<Integer,Person> otherHashMap = new HashMap();
    Map<Integer,Person> otherTreeMap = new TreeMap();

    private static final String MENU =
            "    M E N U   G Ł Ó W N E   \n" +
                    "    Wybierz co chcesz zrobic:   \n" +
                    "1 - Dodaj osobe do kazdej z  kolekcji \n" +
                    "2 - Usuń osobe ze wszystkich kolekcji \n" +
                    "3 - Wyswietl zawartosc wszystkich kolekcji \n" +
                    "4 - Zakończ program \n";

    private final String  ERROR_MESSAGE = "Wprowadzono nieprawidłowe dane!";



    public static void main(String[] args)
    {
        PersoneConsoleApp app = new PersoneConsoleApp();
        app.runMainLoop();
    }

    public void runMainLoop()
    {
        while (true)
        {
            System.out.println(MENU);
            try {
                switch (scanner.nextInt()){
                    case 1:
                        addPerson();
                        break;
                    case 2:
                        deletePerson();
                        break;
                    case 3:
                        AllCollections();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println(ERROR_MESSAGE);
                }

            }catch (Exception e ){
                System.out.println(e.getMessage());
            }
        }

    }
    public void AllPersons()   //metoda służąca do wyświetlania obiektów
    {
        System.out.println("Osoby do wyboru: ");
        System.out.println("1. " + person1);
        System.out.println("2. " + person2);
        System.out.println("3. " + person3);
        System.out.println("4. " + person4);
        System.out.println("5. " + person5);
    }

    public void AllCollections()  //metoda służąca do wyświetlania zawartości kolekcji
    {
        System.out.println("HashSet: ");
        iterateCollection(hashSet);
        System.out.println("TreeSet: ");
        iterateCollection(treeSet);
        System.out.println("ArrayList: ");
        iterateCollection(arrayList);
        System.out.println("LinkedList: ");
        iterateCollection(linkedList);
        System.out.println("HasMap: ");
        iterateMap(hashMap);
        System.out.println("TreeMap: ");
        iterateMap(treeMap);

        System.out.println("OverrideHashSet");
        iterateCollection(otherHashSet);
        System.out.println("OverrideTreeSet");
        iterateCollection(otherTreeSet);
        System.out.println("OverrideArrayList");
        iterateCollection(otherArrayList);
        System.out.println("OverrideLinkedList");
        iterateCollection(otherLinkedList);
        System.out.println("OverrideHashMap");
        iterateMap(otherHashMap);
        System.out.println("OverrideTreeMap");
        iterateMap(otherTreeMap);
    }


    public void addPerson()     //metoda służąca do dodawania Obiektu do kolekcji
    {
        Person person=null;
        OtherPerson otherPerson=null;
        int key=0;
        boolean check;

        do {
            check=true;
            System.out.println("Podaj klucz potrzebny do Map: ");
            key= scanner.nextInt();
            for(Map.Entry<Integer,Person> entry: hashMap.entrySet())
            {
                if(key== entry.getKey())
                {
                    System.out.println("Podany klucz juz istnieje w " + entry.getValue());
                    check=false;
                }
            }

        }while(!check);
        System.out.println("Podano prawidlowy klucz");
        AllPersons();
        System.out.println("6. Przerwij");

        try{
            switch (scanner.nextInt()){
                case 1:
                    person=person1;
                    otherPerson=otherPerson1;
                    break;
                case 2:
                    person=person2;
                    otherPerson=otherPerson2;
                    break;
                case 3:
                    person=person3;
                    otherPerson=otherPerson3;
                    break;
                case 4:
                    person=person4;
                    otherPerson=otherPerson4;
                    break;
                case 5:
                    person=person5;
                    otherPerson=otherPerson5;
                    break;
                case 6:
                    check=false;
                    break;
                default:
                    System.out.println(ERROR_MESSAGE);
                    check=false;
            }
            if(check)
            {
                hashSet.add(person);
                treeSet.add(person);
                arrayList.add(person);
                linkedList.add(person);
                hashMap.put(key,person);
                treeMap.put(key,person);

                otherHashSet.add(otherPerson);
                otherTreeSet.add(otherPerson);
                otherArrayList.add(otherPerson);
                otherLinkedList.add(otherPerson);
                otherHashMap.put(key,otherPerson);
                otherTreeMap.put(key,otherPerson);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }






    public void deletePerson()   //metoda służąca do usuwania obiektów z kolekcji
    {
        Person person=null;
        OtherPerson otherPerson=null;
        int key=0;
        boolean check;

        do {
            check=false;
            System.out.println("Podaj klucz potrzebny do Map: ");
            key= scanner.nextInt();
            for(Map.Entry<Integer,Person> entry: hashMap.entrySet())
            {
                if(key== entry.getKey())
                {
                    check=true;
                }
            }
            if(check)
            {
                System.out.println("Podano prawidlowy klucz");
            }
            else
            {
                System.out.println("Podano nieprawidlowy klucz");
            }

        }while(!check);

        System.out.println("Podano prawidlowy klucz");
        AllPersons();
        System.out.println("6. Przerwij");

        try{
            switch (scanner.nextInt()){
                case 1:
                    person=person1;
                    otherPerson=otherPerson1;
                    break;
                case 2:
                    person=person2;
                    otherPerson=otherPerson2;
                    break;
                case 3:
                    person=person3;
                    otherPerson=otherPerson3;
                    break;
                case 4:
                    person=person4;
                    otherPerson=otherPerson4;
                    break;
                case 5:
                    person=person5;
                    otherPerson=otherPerson5;
                    break;
                case 6:
                    check=false;
                    break;
                default:
                    System.out.println(ERROR_MESSAGE);
                    check=false;
            }
            if(check)
            {
                hashSet.remove(person);
                treeSet.remove(person);
                arrayList.remove(person);
                linkedList.remove(person);
                hashMap.remove(key);
                treeMap.remove(key);

                otherHashSet.remove(otherPerson);
                otherTreeSet.remove(otherPerson);
                otherArrayList.remove(otherPerson);
                otherLinkedList.remove(otherPerson);
                otherHashMap.remove(key);
                otherTreeMap.remove(key);
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void iterateCollection (Collection<Person> personCollection)   //metoda do iterowania po kolekcjach, z wyjątkiem map
    {
        for(Person collections: personCollection)
        {
            System.out.println(collections);
        }
    }

    public void iterateMap (Map<Integer, Person> map)  //metoda służąca do iterowania po mapach
    {
        for (Map.Entry<Integer, Person> m : map.entrySet()){
            System.out.println(m);
        }
    }
}
