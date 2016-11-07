class Stable {
    Animal[] animals;
    Trough[] troughs;

    void farm() {
        animals = new Animal[3];
        troughs = new Trough[2];

        for (int i = 0; i < animals.length; i++) {
            animals[i] = new Animal();
        }

        for (int i = 0; i < troughs.length; i++) {
            troughs[i] = new Trough();
        }

        animals[0].setTrough(troughs[0]);
        animals[1].setTrough(troughs[0]);
        animals[2].setTrough(troughs[1]);

        fillAll(10);
        eatAll();
        //animals[1].eat();
        //animals[2].eat();
        //animals[2].getTrough().fill(5);

        System.out.println(animals[0].getStomach());
        System.out.println(animals[1].getStomach());
        System.out.println(animals[2].getStomach());
        System.out.println(animals[0].getTrough().getContents());
        System.out.println(animals[1].getTrough().getContents());
        System.out.println(animals[2].getTrough().getContents());
    }

    void fillAll(int n) {
        for (int i = 0; i < troughs.length; i++) {
            troughs[i].fill(n);
        }
    }

    void eatAll() {
        for (int i = 0; i < animals.length; i++) {
            animals[i].eat();
        }
    }

    public static void main(String[] args) {
        new Stable().farm();
    }
}

class Animal {
    private String name;
    private int stomach = 0; // number of meals
    private Trough trough;

    public int getStomach() {
        return stomach;
    }
//    Animal() {
//        name = "noname";
//        stomach = 0;
//        trough = new Trough();
//    } removing constructor

    Trough getTrough() {
        return trough;
    }

    void setTrough(Trough t) {
        this.trough = t;
    }

    void eat() {
        int meal = trough.give();
        stomach = stomach + meal;
    }
}

class Trough {
    private int contents; // number of meals

    public int getContents() {
        return contents;
    }

    public void setContents(int contents) {
        this.contents = contents;
    }

    void fill(int m) {
        contents = contents + m;
    }

    int give() {
        if (contents > 0) {
            contents = contents - 1;
            return 1;
        } else {
            return 0;
        }
    }
}

  
    
