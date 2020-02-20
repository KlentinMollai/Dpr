package MyFamilyTree;

/**
 * This program demonstrates MyFamilyTree that is representation of Tree class.
 * My family tree starts with my Great-Great Grandfather who is the root
 * of the tree and so on all the way down to my son the last leaf of the tree.
 * @author Klentin Mollai
 * @version 11/14/2019
 */
public class MyFamilyTree {        


    /** This is the main method for the project */
    public static void main(String[] args)
    {
        System.out.println("\n\tBegin Tree Demo\n");
        
        //Root of the tree which has 4 children
        Tree t1 = new Tree("Shaip");
        System.out.println("My Great-great Grandfather name was:  " + t1.toString());  
        Tree t2 = new Tree("Sadik");
        t1.addSubtree(t2);
        Tree t3 = new Tree("Murat");
        t1.addSubtree(t3);
        Tree t4 = new Tree("Razie");
        t1.addSubtree(t4);
        Tree t5 = new Tree("Ramo");
        t1.addSubtree(t5);
        System.out.println("My Great-great Grandfather had 4 children and his is tree is displayed below:\n");
        System.out.println(t1.toString()); 
        
        //Child t2 becomes the root for his 6 children
        System.out.println("\nMy Great-Grandfather: " + t2.toString());
        Tree t6 = new Tree("Bajame");
        t2.addSubtree(t6);
        Tree t7 = new Tree("Refit");
        t2.addSubtree(t7);
        Tree t8 = new Tree("Like");
        t2.addSubtree(t8);
        Tree t9 = new Tree("Reshat");
        t2.addSubtree(t9);
        Tree t10 = new Tree("Kadri");
        t2.addSubtree(t10);
        Tree t11 = new Tree("Samit");
        t2.addSubtree(t11);
        System.out.println("My Great-Grandfather had 6 children and his is tree is displayed below:");
        System.out.println(t2.toString());
        
        //t7 who is child of t2 is now root for his 6 children
        System.out.println("\nMy Grandfather name was: " + t7.toString());
        Tree t12 = new Tree("Shefki");
        t7.addSubtree(t12);
        Tree t13 = new Tree("Mefa");
        t7.addSubtree(t13);
        Tree t14 = new Tree("Mirjeta");
        t7.addSubtree(t14);
        Tree t15 = new Tree("Reshie");
        t7.addSubtree(t15);
        Tree t16 = new Tree("Nazmi");
        t7.addSubtree(t16);
        Tree t17 = new Tree("Shkelqim");
        t7.addSubtree(t17);
        System.out.println("My Grandfather had 6 children and his is tree is displayed below:");
        System.out.println(t7.toString());
        
        //t15 child of t7 is now root for her 3 children
        System.out.println("\nMy Mother's name is: " + t15.toString());
        Tree t18 = new Tree("Klentin");
        t15.addSubtree(t18);
        Tree t19 = new Tree("Jonida");
        t15.addSubtree(t19);
        Tree t20 = new Tree("Lisjan");
        t15.addSubtree(t20);
        System.out.println("My Mother has 3 children and her is tree is displayed below:");
        System.out.println(t15.toString());
        
        //t18 child of t15 is now root for his child
        System.out.println("\nMy name is: " + t18.toString());
        Tree t21 = new Tree("Noan");
        t18.addSubtree(t21);
        System.out.println("I have 1 child and my is tree is displayed below: ");
        System.out.println(t18.toString());
        
        System.out.println();
        System.out.println("\nMy family tree size is: " + t1.size()); 

        System.out.println("\n\tEnd Tree Demo\n");
    }
}
