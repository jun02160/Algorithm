package inflearn_Java로_배우는_자료구조.제3장;

public class Notebook extends Computer {

    // Computer 의 멤버 필드를 그대로 가지면서 아래 속성이 추가됨
    // => Notebook 클래스는 기존의 Computer 클래스의 기능을 확장한 개념

    public double screenSize;
    public double weight;


    public Notebook(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed, double screenSize, double weight) {
        super(manufacturer, processor, ramSize, diskSize, processorSpeed);
        this.screenSize = screenSize;
        this.weight = weight;
    }


}
