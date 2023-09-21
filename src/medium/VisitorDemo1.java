package medium;

interface Animal {
    void accept(AnimalVisitor visitor);
}
interface AnimalVisitor{
    void visitMonkey(Monkey monkey);
    void visitLion(Lion lion);
    void visitDolphin(Dolphin dolphin);
}

class Monkey implements Animal{
    public void shout(){
        System.out.println("Ooh oo aa aa");
    }
    public void accept(AnimalVisitor visitor){
        visitor.visitMonkey(this);
    }
}
class Lion implements Animal{
    public void roar(){
        System.out.println("Roaaar!");
    }
    public void accept(AnimalVisitor visitor){
        visitor.visitLion(this);
    }
}

class Dolphin implements Animal{
    public void speak(){
        System.out.println("Tuut tuttu tuutt!");
    }
    public void accept(AnimalVisitor visitor){
        visitor.visitDolphin(this);
    }
}

class Speak implements AnimalVisitor {

    @Override
    public void visitMonkey(Monkey monkey) {
        monkey.shout();
    }

    @Override
    public void visitLion(Lion lion) {
        lion.roar();
    }

    @Override
    public void visitDolphin(Dolphin dolphin) {
        dolphin.speak();
    }
}
public class VisitorDemo1 {
    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        Lion lion = new Lion();
        Dolphin dolphin = new Dolphin();

        Speak speak = new Speak();

        monkey.accept(speak);
        lion.accept(speak);
        dolphin.accept(speak);
    }
}
