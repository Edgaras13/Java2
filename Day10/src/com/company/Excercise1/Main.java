package com.company.Excercise1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        JavaStudentGroup javaStudentGroup = new JavaStudentGroup();
        Random random = new Random();
        int[] idArr = new int[21];
        int temp;

        for (int i = 0; i < 21; i ++){
            if (i == 0) {
                idArr[i] = random.nextInt(101);
            }
            else{
                temp = random.nextInt(101);
                for (int j = 0; j < 21; j++){
                    if (idArr[j] == temp){
                        temp = random.nextInt(101);
                        j = 0;
                    }
                }
                idArr[i] = temp;
            }
        }

        javaStudentGroup.addStudent(new Student("John","Cena", idArr[0]));
        javaStudentGroup.addStudent(new Student("Michael","Jordan", idArr[1]));
        javaStudentGroup.addStudent(new Student("Michael","Jackson", idArr[2]));
        javaStudentGroup.addStudent(new Student("Britney","Spears", idArr[3]));
        javaStudentGroup.addStudent(new Student("George","Watsky", idArr[4]));
        javaStudentGroup.addStudent(new Student("Marshall","Mathers", idArr[5]));
        javaStudentGroup.addStudent(new Student("Kendrick","Lamar", idArr[6]));
        javaStudentGroup.addStudent(new Student("Snoop","Dogg", idArr[7]));
        javaStudentGroup.addStudent(new Student("Marilyn","Monroe", idArr[8]));
        javaStudentGroup.addStudent(new Student("Elvis","Presley", idArr[9]));
        javaStudentGroup.addStudent(new Student("Frank","Sinatra", idArr[10]));
        javaStudentGroup.addStudent(new Student("Freddy","Mercury", idArr[11]));
        javaStudentGroup.addStudent(new Student("Donald","Trump", idArr[12]));
        javaStudentGroup.addStudent(new Student("Barrack","Obama", idArr[13]));
        javaStudentGroup.addStudent(new Student("Ethan","Klein", idArr[14]));
        javaStudentGroup.addStudent(new Student("Bill","Gates", idArr[15]));
        javaStudentGroup.addStudent(new Student("Steve","Jobs", idArr[16]));
        javaStudentGroup.addStudent(new Student("Steve","Wozniak", idArr[17]));
        javaStudentGroup.addStudent(new Student("Stevie","Wonder", idArr[18]));
        javaStudentGroup.addStudent(new Student("Adolf","Hitler", idArr[19]));
        javaStudentGroup.addStudent(new Student("Mitt","Romney", idArr[20]));

//        Collections.sort(javaStudentGroup.getList(), Comparator.comparing(Student::getName));
//        System.out.println(javaStudentGroup + "\n");
        Collections.sort(javaStudentGroup.getList(), Comparator.comparing(Student::getId));
//        System.out.println(javaStudentGroup + "\n");
//        Collections.sort(javaStudentGroup.getList(), Comparator.comparing(Student::getSurname));
//        System.out.println(javaStudentGroup + "\n");

        for (List<Student> list: javaStudentGroup.divideIntoGroups(4)){
            for (Student s: list){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
