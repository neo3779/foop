/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dv003874
 */
public class TestIterator {
    public static void main(String[] args) {
        PetShop thePetShop = new PetShop("Stafford Octagons");

        Cat c = new Cat("Alex", false, "01/29/1987",true);
        Dog d = new Dog("Dainie", false, "07/07/1990","Lab");
        Hamster h = new Hamster("Ed", false, "07/07/1990",1.5);
        Parrot p = new Parrot("Ed", false, "07/07/1990","Yellow");

        thePetShop.addPet(c);
        thePetShop.addPet(d);
        thePetShop.addPet(h);
        thePetShop.addPet(p);
        thePetShop.outputPetShopPets();
        thePetShop.previousPet();
        System.out.println(thePetShop.getCurrentPet());
        thePetShop.previousPet();
        System.out.println(thePetShop.getCurrentPet());
        thePetShop.previousPet();
        System.out.println(thePetShop.getCurrentPet());
        thePetShop.previousPet();
        System.out.println(thePetShop.getCurrentPet());


    }

}
