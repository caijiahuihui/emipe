package com.caicai.emipe.use;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author caicai
 * @create 2021/4/2
 */
public class CollectionDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4});
        Iterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            if (it.next() == 1) {
                System.out.println("---------------------");
                it.remove();
                it = list.listIterator();
                System.out.println("ssssssssssssssss");
            }
        }
//        while (it.hasNext()) if (it.next() == 2) {
//            System.out.println("---------------------");
//            it.remove();
//            System.out.println("ssssssssssssssss");
//        }
    }

    private void testCollection() {
        ArrayList<Object> sss = new ArrayList<>();
        sss.add(12);
        sss.add(24);
    }


}
