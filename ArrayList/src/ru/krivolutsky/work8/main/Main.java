package ru.krivolutsky.work8.main;

import ru.krivolutsky.work8.classes.MyArrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            MyArrayList<Object> arrayList = new MyArrayList<>();
            System.out.println();
            arrayList.add(12);
            System.out.println(arrayList.isEmpty());
            arrayList.add("prevSecond");
            arrayList.add((char) 20);
            arrayList.add(12);
            arrayList.add(null);
            arrayList.add(1, "second");
            System.out.println(arrayList);
            System.out.println();
            System.out.println(arrayList.lastIndexOf(12));
            System.out.println();
            System.out.println(arrayList.indexOf(12));
            System.out.println();
            arrayList.remove(2);
            System.out.println(arrayList);
            System.out.println();
            arrayList.set(2, "new");
            System.out.println(arrayList);
            System.out.println();
            System.out.println(arrayList.get(2));
            System.out.println();

            List<Object> objects = new ArrayList<>();
            objects.add(12);
            objects.add("second");
            objects.add(2);
            arrayList.retainAll(objects);
            System.out.println(arrayList);
            System.out.println();
            arrayList.add(3);
            arrayList.removeAll(objects);
            System.out.println(arrayList);
            System.out.println();
            arrayList.addAll(objects);
            System.out.println(arrayList);
            System.out.println();
            arrayList.addAll(2, objects);
            System.out.println(arrayList);
            System.out.println();
            System.out.println(arrayList.containsAll(objects));
            objects.add(135);
            System.out.println(arrayList.containsAll(objects));
            System.out.println();
            arrayList.remove(null);
            System.out.println(arrayList);
            System.out.println();
            Object[] objects1;
            objects1 = arrayList.toArray();
            for (Object o : objects1) {
                System.out.println(o);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
