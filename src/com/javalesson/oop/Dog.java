package com.javalesson.oop;

public class Dog {

    private static int dogCount;

    public static final int PAWS = 4;
    public static final int TAIL = 1;
    private String name;
    private String breeds;
    private Size size = Size.UNDEFINED;

    public Dog(){
        dogCount++;
        System.out.println("Dogs count is "+ dogCount);
    }

    public static int getDogCount(){
        return dogCount;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
      this.size=size;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }

    public String getName() {
        return name;
    }

    public String getBreeds() {
        return breeds;
    }
    public void bark() {

        switch (size) {
            case BIG:
            case VERY_BIG:
                System.out.println("Wof-wof");
                break;
            case AVERAGE:
                System.out.println("Raf-raf");
                break;
            case SMALL:
            case VERY_SMALL:
                System.out.println("Gaf-gaf");
                break;
                default:
                    System.out.println("Dog's size is undefinded !");
        }

    }

        public void bite () {
            if (dogCount > 2) {
                System.out.println("You are biting dogs");
            } else {
                bark();
            }
        }
    }