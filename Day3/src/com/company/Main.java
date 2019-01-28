package com.company;



public class Main {

    public static void main(String[] args) {
        DataBase db = new DataBase();
        Cloud cloud = new Cloud();
        Info info1 = new Info(1, "Boom");
        Info info2 = new Info(2, "Hello");
        Info info3 = new Info(3, "Home");
        Info info4 = new Info(4, "Flow");
        Info info5 = new Info(5, "Wide");
        Info info6 = new Info(6, "Bring");

        save(info1, db);
        save(info2, db);
        save(info3, db);
        save(info4, db);
        save(info5, db);
        save(info6, db);

        findByID(db, 4);
        findByID(db, 1);
        findByWord(db, "Home");
        findByWord(db, "Wi");
    }

    private static void save(Info info, DataBase db){
        db.saveInfo(info);
    }

    private static void findByID(DataBase db, Integer id){
        System.out.println(db.findInfo(id).toString());
    }

    private static void findByWord(DataBase db, String word){
        System.out.println(db.findInfo(word).toString());
    }
}
