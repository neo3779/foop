/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dv003874
 */
public class TestExtendClasses {
    public static void main(String[] args) {
        PetShop thePetShop = new PetShop("Stafford Octagons");

        Cat c1 = new Cat("Dave",false, "12/01/1990",true);
        Dog d1 = new Dog("Murphy",true, "08/12/2006","Lab");
        Hamster h1 = new Hamster("Fluffy",false,"09/25/2009",29.0);
        Parrot p1 = new Parrot("Sam",false,"12/12/2006","Red");

        thePetShop.addPet(c1);
        thePetShop.addPet(d1);
        thePetShop.addPet(h1);
        thePetShop.addPet(p1);

        thePetShop.outputPetShopPets();

    }

}
