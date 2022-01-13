package utils;


import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

    // user / admin
    User user = new User("user", "1234");
    User admin = new User("admin", "12345");
    User both = new User("user_admin", "1234");

    // drivers
    Driver driver1 = new Driver(1, "Yuki Tsundo", 2000, "male");
    Driver driver2 = new Driver(2, "Lando Norris", 1999, "male");
    Driver driver3 = new Driver(3, "Mick Schumacher", 1999, "male");
    Driver driver4 = new Driver(4, "Nikita Mazepin", 1999, "male");
    Driver driver5 = new Driver(5, "Lance Stroll", 1998, "male");
    Driver driver6 = new Driver(6, "George Russell", 1998, "male");
    Driver driver7 = new Driver(7, "Charles Leclerc", 1997, "male");
    Driver driver8 = new Driver(8, "Max Verstappen", 1997, "male");
    Driver driver9 = new Driver(9, "Daniel Ricciardo", 1989, "male");
    Driver driver10 = new Driver(10, "Lewis Hamilton", 1985, "male");

    // cars
    Car car1 = new Car(1, "Yuki Tsundo", "Alpha Tauri", "Alpha Tauri", 200);
    Car car2 = new Car(2, "Lando Norris", "Boston Whaler", "Montauk", 1999);
    Car car3 = new Car(3, "Mick Schumacher", "Chapparal", "SSX", 1999);
    Car car4 = new Car(4, "Nikita Mazepin", "Grady White", "The Canyon 336", 1999);
    Car car5 = new Car(5, "Lance Stroll", "Lund", "PRO-V BASS XS", 1998);
    Car car6 = new Car(6, "George Russell", "Mastercraft", "NXT", 1998);
    Car car7 = new Car(7, "Charles Leclerc", "Sea Ray", "SUN SPORT 230", 1997);
    Car car8 = new Car(8, "Max Verstappen", "Tracker", "DEEP V", 1997);
    Car car9 = new Car(9, "Daniel Ricciardo", "Viking Yacths", "92EB", 1989);
    Car car10 = new Car(10, "Lewis Hamilton", "Yamaha", "19 FT", 1985);

    // races
    Race race1 = new Race(1,"Monaco Grand Prix", "Thursday, 18 November", "15:00 - 17:00", "Monaco");
    Race race2 = new Race(2,"Singapore Grand Prix", "Sunday, 2 October", "20:10 - 22:10", "Singapore");
    Race race3 = new Race(3,"Abu Dhabi Grand Prix", "Thursday, 17 November", "14.10 - 16.10", "Abu Dhabi");
    Race race4 = new Race(4,"Bahrain Grand Prix", "Sunday, 20 March", "18:00 - 20:00", "Bahrain");
    Race race5 = new Race(5,"British Grand Prix", "Sunday, 3 July", "10:00 - 12:00", "United Kingdom");
    Race race6 = new Race(6,"Indian Grand Prix", "Saturday, 11 December", "6:30 - 8:30", "India");
    Race race7 = new Race(7,"Korean Grand Prix", "Thursday, 11 October", "22:00 - 00:00", "South Korea");
    Race race8 = new Race(8,"Malaysian Grand Prix", "Friday, 21 October", "15:00 - 17:00", "Malaysia");
    Race race9 = new Race(9,"Qatar Grand Prix", "Thursday, 18 November", "14:00 - 16:00", "Qatar");
    Race race10 = new Race(10,"United States Grand Prix", "Sunday, 23 October", "9:30 - 11:30", "Turkey");


    // check if you can get username and password
    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");


    em.getTransaction().begin();

    // drivers
    em.persist(driver1);
    em.persist(driver2);
    em.persist(driver3);
    em.persist(driver4);
    em.persist(driver5);
    em.persist(driver6);
    em.persist(driver7);
    em.persist(driver8);
    em.persist(driver9);
    em.persist(driver10);

    // cars
    em.persist(car1);
    em.persist(car2);
    em.persist(car3);
    em.persist(car4);
    em.persist(car5);
    em.persist(car6);
    em.persist(car7);
    em.persist(car8);
    em.persist(car9);
    em.persist(car10);

    // races
    em.persist(race1);
    em.persist(race2);
    em.persist(race3);
    em.persist(race4);
    em.persist(race5);
    em.persist(race6);
    em.persist(race7);
    em.persist(race8);
    em.persist(race9);
    em.persist(race10);



    // adding user / admin roles
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);

    // commit multiple transactions
    em.getTransaction().commit();

    // print to console
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    System.out.println("Created 4 movies in database for test");


  }

}
