package com.company.Excercise1;

import java.util.ArrayList;
import java.util.List;

public class JavaStudentGroup {
    private List<Student> list = new ArrayList<>();

    public void addStudent(Student student){
        list.add(student);
    }

    public List<List<Student>> divideIntoGroups(int groupCount){
        List<List<Student>> res = new ArrayList<>();
        List<Student> tempList = new ArrayList<>();
        int rem, tempSize, count = 0;
        if (list.size() % groupCount == 0){
            for (int i = 0; i < groupCount; i++){
                res.add( new ArrayList<Student>());
                for (int j = 0; j < list.size() / groupCount; j++){
                    if (i == 0){
                        res.get(i).add(list.get(j));
                    }
                    else{
                        res.get(i).add(list.get(i * (list.size() / groupCount) + j));
                    }
                }
            }
        }
        else{
            rem = list.size() % groupCount;
            tempSize = list.size() - rem;
            for (int i = 0; i < groupCount; i++){
                res.add( new ArrayList<Student>());
                for (int j = 0; j < tempSize / groupCount; j++){
                    if (i == 0){
                        res.get(i).add(list.get(j));
                        if (j == tempSize / groupCount - 1 ){
                            res.get(i).add(list.get(j + 1));
                            count++;
                        }
                    }
                    else{
                        res.get(i).add(list.get(i * (tempSize / groupCount) + j + count));
                        if (j == tempSize / groupCount - 1 && count < rem){
                            res.get(i).add(list.get(i * (tempSize / groupCount) + j + count));
                            count++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<Student> getList() {
        return list;
    }

    @Override
    public String toString() {
        String res = "";
        for (Student s: list){
            res += s.toString() + "\n";
        }
        return res;
    }
}
