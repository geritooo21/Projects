/**
 * Created by s168945 on 6-11-2016.
 */
public class Hotel {
    Room[] rooms = new Room[10];

    void printRooms() {
        for (int i = 0; i < rooms.length; i++) {
            System.out.print("Room number " + (i + 1));
            if (rooms[i].getGuest() != null) {
                System.out.print("The guest is " + rooms[i].getGuest().getName());
            }
            System.out.println();
        }
    }

    void moveGuest(Guest g, Room newroom) {
        for(int i = 0; i<rooms.length; i++) {
            if (rooms[i].getGuest() == g) {
                rooms[i].setGuest(null);
                newroom.setGuest(g);
                break;
            }
        }
    }

    void demo() {
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room();
            // rooms[i].getGuest() = new Guest();
        }

        Guest rob = new Guest("Rob");
        Guest peter = new Guest("Peter");
        Guest jing = new Guest("Jing");
        rooms[0].setGuest(rob);
        rooms[1].setGuest(peter);
        rooms[2].setGuest(jing);

        printRooms();

        //moveGuest(rob, rooms[9]);
        moveGuest(peter, rooms[4]);
        moveGuest(rob, rooms[9]);
        moveGuest(jing, rooms[8]);

        printRooms();
    }

    public static void main(String[] args) {
        new Hotel().demo();
    }
}

class Guest {
    String name;

    public String getName() {
        return name;
    }

    Guest(String n) {
        name = n;
    }

    //Guest() {

    //}
}

class Room {
    Guest guest;

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    Room(Guest g) {
        guest = g;
    }

    Room() {

    }


}