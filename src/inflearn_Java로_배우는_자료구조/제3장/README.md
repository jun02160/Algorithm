# 제3-1장: 상속(Inheritance)
## 🔗 개념

### 상속(Inheritance)

기존의 클래스와 매우 밀접한 관계를 가지는 클래스를 새로 만들어야 하는 경우

→ IS-A 관계에 있는 새로운 클래스를 만드는 경우, **상속**을 이용한다.
ex. 노트북은 컴퓨터이다.(O)  컴퓨터는 노트북이다.(X) ⇒ 노트북 클래스가 컴퓨터 클래스를 상속받는다.

눈에 보이지 않아도 상속한 *Super Class(=Base Class, Parent Class*, 컴퓨터*)*의 멤버를 *Sub Class(=Extened Class, Child Class*, 노트북*)*이 모두 가진다.

### 생성자에 대한 기본적인 Rule

1. 생성자가 없을 경우, 자동으로 파라미터가 없는 디폴트 생성자가 만들어지고, 생성자가 하나라도 있을 경우 디폴트 생성자는 만들어지지 않는다.
2. 모든 서브 클래스의 생성자는 먼저 슈퍼 클래스의 생성자를 호출한다.
    1. super(…)를 통해 명시적으로 호출하거나,
    2. 그렇지 않을 경우, 자동으로 디폴트 생성자가 호출된다.

    <aside>
    🚨 **주의 사항**

   슈퍼 클래스에 디폴트 생성자가 없는데, **서브 클래스의 생성자에서 super(…) 호출을 안해주는 경우**

    </aside>


### 다형성(Polymorphism) ⭐🌷

슈퍼클래스 타입의 변수가 서브클래스 타입의 객체를 참조할 수 있다.

```java
Computer com = new Notebook();
```

com는 Computer 타입의 변수이면서, 실제로는 Notebook 개체를 참조하고 있다. 두 클래스에서 같은 메서드가 존재하는 상황이라면, 즉 Notebook 클래스에서 메서드 오버라이딩한 함수가 있는 경우에 참조하고 있는 Notebook 클래스의 메서드가 호출되도록 **동적 바인딩**이 이루어진다.

### 💻 CODE

*기억하면 좋은 코드!

```java
// 부모 클래스에 디폴트 생성자가 아닌 생성자를 명시한 경우
public Notebook(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed, double screenSize, double weight) {

        **super(manufacturer, processor, ramSize, diskSize, processorSpeed);**
        this.screenSize = screenSize;
        this.weight = weight;

}
```

## 📓 메모하기

- 객체지향 프로그램의 꽃은 **‘다형성’**이다.
- 메서드 오버라이딩과 상속을 적절히 사용하면, 필요에 따라 기능 구현을 다르게 하여 새로운 객체 생성 없이 참조만으로 접근이 가능한 유연한 프로그램을 만들 수 있다.



# 제3-2장: Object와 Wrapper 클래스
## 🔗 개념

### Object class

Java에서 모든 클래스의 상위 클래스는 Object 클래스이다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ce44bfba-ef4e-4c97-9439-200516fdb9f4/Untitled.png)

![Java의 모든 클래스는 Object 클래스의 멤버인 위 메서드들을 기본적으로 가지고 있다. *다만 의도대로 모든 것이 작동하지는 않을 수도 있다. ](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/608411b7-070f-4def-9013-382fb5fa73dc/Untitled.png)

Java의 모든 클래스는 Object 클래스의 멤버인 위 메서드들을 기본적으로 가지고 있다. *다만 의도대로 모든 것이 작동하지는 않을 수도 있다.

1. toString()

   toString()을 메소드 오버라이딩 하지 않은 원 상태로 호출하면, `package명.클래스명@객체의 해시코드` 의 형태를 반환한다.

2. equals()

   매개변수로 제공된 객체와 자기 자신의 동일성을 검사하므로, 같은 클래스 타입의 변수 2개를 비교하면 다른 것으로 판단된다. 이 메소드를 의도대로 사용하려면 override해야 한다.


### Wrapper class

> 기본 타입의 데이터를 하나의 객체로 포장해주는 클래스
>

Java에서 원시(primitive)  타입과 클래스(non-primitive) 타입(⇒ 객체)의 데이터는 근본적으로 다르게 처리된다. Object 타입의 배열에는 다형성의 원리에 의해 모든 종류의 객체를 저장할 수 있지만, int, double, char 등의 원시타입 데이터는 저장할 수 없다.

필요에 따라 원시 타입의 데이터를 객체로 만들어야 하는 상황이 생기는데, 이를 위해 Integer, Double, Character 등의 Wrapper Class가 존재하는 것이다.

**FOR 데이터 타입 간의 변환 기능**

- Autoboxing
- Unboxing

### 💻 CODE

*기억하면 좋은 코드!

```java
Object[] theArray = new Object[100];
theArray[0] = 10;   // 정수 10을 자바 컴파일러가 Integer 객체로 변환(autoboxing)해준다. 
int a = (Integer)theArray[0];  // Integer 객체로 저장되어 있는 Object 배열의 요소를 자바 컴파일러가 자동으로 정수로 변환(unboxing)해준다. 
```

> 인프런 권오흠 교수님의 ‘Java로 배우는 자료구조’ 강의의 학습 정리 내용입니다.
>