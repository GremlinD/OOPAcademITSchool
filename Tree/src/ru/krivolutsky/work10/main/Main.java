package ru.krivolutsky.work10.main;

import ru.krivolutsky.work10.classes.BinaryTree;
import ru.krivolutsky.work10.classes.TreeNode;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (o1, o2) -> (o1 > o2) ? 1 : (Objects.equals(o1, o2)) ? 0 : -1;
        BinaryTree<Integer> firstTree = new BinaryTree<>(comparator);
        System.out.println(firstTree.getCount());
        BinaryTree<Integer> tree = new BinaryTree<>(comparator);
        tree.insert(10);
        tree.insert(5);

        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
        tree.insert(15);
        tree.insert(12);
        tree.insert(11);
        tree.insert(13);
        tree.insert(17);
        tree.insert(16);
        tree.insert(18);
        tree.insert(9);

        TreeNode<Integer> treeNode = tree.searchNode(10);
        System.out.println(treeNode.getData());
        System.out.println(tree.getCount());

        boolean isDelete = tree.deleteByValue(11);
        System.out.println(isDelete);

        Consumer<Integer> consumer = System.out::println;
        tree.walkWide(consumer);

        System.out.println();

        tree.circumventDepthWithRecursion(consumer);

        System.out.println();

        tree.bypassInDepth(consumer);
    }
}
