import java.util.ArrayList;

public class Box {
    Boolean emptyBox;
    ArrayList<Fruit> boxFruit;

    public Box() {
        this.emptyBox = true;
        this.boxFruit = new ArrayList<Fruit>();
    }

    public <T extends Fruit> void putFruit(T fruit) {
        if (emptyBox) {
            emptyBox = false;
            boxFruit.add(fruit);
        } else {
            if (fruit.name != boxFruit.get(0).name) {
                System.out.println("В этой коробке уже лежат другие фрукты, нельзя положить " + fruit.name);
            } else {
                boxFruit.add(fruit);
            }
        }
    }

    public float getWeight() {
        if (emptyBox) {
            return 0f;
        } else {
            float result = boxFruit.get(0).weight() * boxFruit.size();
            return result;
        }
    }

    public void replaceFruit (Box another) {
        if (this.emptyBox) {
            System.out.println("Коробка пустая, нечего перекладывать");
        } else {
            if(another.emptyBox || this.boxFruit.get(0).name == this.boxFruit.get(0).name) {

                for (int i = 0; i < this.boxFruit.size(); i++) {
                    another.boxFruit.add(this.boxFruit.get(i));
                }
                another.emptyBox = false;

                this.boxFruit.clear();
                this.emptyBox = true;
            } else {
                System.out.println("Нельзя переложить в другую коробку, так как там лежит другой сорт фрукта");
            }
        }


    }

    public boolean compare(Box another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001f;
    }
}
