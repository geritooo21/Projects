// Stable Level 1: composition only

import java.util.Scanner;

class Stable {
    Animal[] animal = new Animal[3];

    Scanner sc = new Scanner(System.in);

    Stable() {

    }

    void farm() {
        animal[0] = new Animal();
        animal[1] = new Animal();
        animal[2] = new Animal();

        int fill; // user types in a non negative amount to fill the trough
        int eat; // the amount the animal will eat

        System.out.println("Fill the trough of the first animal");
        fill = sc.nextInt();
        while (fill < 0) {
            System.out.println("Cannot be negative value. Fill it again!");
            fill = sc.nextInt();
        }
        animal[0].getTrough().fill(fill); // fill the first one

        System.out.println("Fill the trough of the second animal");
        fill = sc.nextInt();
        while (fill < 0) {
            System.out.println("Cannot be negative value. Fill it again!");
            fill = sc.nextInt();
        }
        animal[1].getTrough().fill(fill); // fill the second one

        System.out.println("Fill the trough of the third animal");
        fill = sc.nextInt();
        while (fill < 0) {
            System.out.println("Cannot be negative value. Fill it again!");
            fill = sc.nextInt();
        }
        animal[2].getTrough().fill(fill); // fill the third one



        try {
            animal[0].eat(4);
            animal[0].eat();

            animal[2].eat(4);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Stomach 1 is " + animal[0].stomach);
        System.out.println("Stomach 2 is " + animal[1].stomach);
        System.out.println("Stomach 3 is " + animal[2].stomach);
        System.out.println("Content 1 is " + animal[0].getTrough().contents);
        System.out.println("Content 2 is " + animal[1].getTrough().contents);
        System.out.println("Content 3 is " + animal[2].getTrough().contents);
    }

    public static void main(String[] args) {
        try {
            new Stable().farm();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Animal {
    String name = "noname";
    int stomach; // number of meals
    Trough trough;

    // constructor    
    Animal() {
        this.trough = new Trough();
    }

    Trough getTrough() {
        return trough;
    }

    void eat() {
        this.eat(1);
    }

    void eat(int m) {
        //try {
        this.stomach = this.stomach + this.trough.give(m);
        //} catch (IndexOutOfBoundsException e) {
        //    throw e;
        //}

        System.out.println("dasdas");
    }
}

class Trough {
    int contents; // number of meals
    //int sn;       // serial number

    Trough() {
        this.contents = 0;
    }

    void fill(int m) {
        contents = contents + m;
    }

    int give(int m) {
        if (m > this.contents) {
            throw new IndexOutOfBoundsException("No contents.");
        }
        this.contents = this.contents - m;
        return m;
    }
}