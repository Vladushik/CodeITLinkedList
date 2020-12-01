package com.company;

public class Main {

    public static void main(String[] args) {





        MyLinkedClass<String> list = new MyLinkedClass<>();

        list.add(0, "5");
        list.add(1, "10");
        list.add(2, "15");
        list.add(3, "20");
        list.add(4, "20");

        System.out.println("Size " + list.size);



        System.out.println("IndexOf " + list.indexOf("20"));

        list.remove(2);

        System.out.println(list);

        list.clear();
        System.out.println("After clear " + list);


    }


}
