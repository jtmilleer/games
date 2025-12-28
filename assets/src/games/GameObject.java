package games;

public abstract class GameObject {
    private String id;
    private String name;

    private static int objectCount;

    public GameObject(){
        this.id = "GameObject_" + ++objectCount;
        this.name = "GameObject";
    }

    public GameObject(final String name){
        this.id = "GameObject_" + ++objectCount;
        this.name = name;
    }

    public GameObject(final String name, final String id){
        this.id = id;
        this.name = name;
        objectCount++;
    }


}
