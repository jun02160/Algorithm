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



# 제3-3장: Object와 Wrapper 클래스
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

# 제3-3장: 클래스 Objectd와  Wrapper 클래스
## 🔗 개념

### 추상 클래스 (abstract class)

추상 메서드란? 선언만 있고 구현이 없는 메서드

→ 추상 메서드를 포함하는 클래스를 추상 클래스라고 한다. 추상 메서드와 추상 클래스는 모두 키워드 ********abstract********로 표시한다.

- 추상 클래스는 객체를 만들 수 없다.
- 추상 클래스는 서브 클래스를 만드는 용도로만 사용된다. 추상 클래스를 확장하여 실제로는 서브 클래스가 이를 구현하게 된다.

  → 추상 클래스의 메서드 중에서도 추상 메서드에 대해서는, 해당 클래스 사용 시 모두 필요한 대로 직접 구현이 필요하다.


### 인터페이스 (interface)

추상 메서드를 하나라도 가지고 있으면 추상 클래스라고 했다. 즉, 추상 메서드가 아닌 메서드도 존재가 가능한 것이다. 기본 메서드가 아닌, 추상 메서드만을 가진 순수한 추상 클래스를 **인터페이스**라고 한다.

- static final 데이터 멤버(⇒ 상수)를 가질 수 있다.
- *abstract* 키워드 無
- 극단적인 클래스로, 그냥 이름만 인터페이스지 추상 클래스로 봐도 무방하다.
   - 차이점 : 클래스에서는 *extends*, 인터페이스는 *implements* 키워드를 사용하여 사용하고자 하는 곳에서 상속받아 실제 구현을 해준다.

### 💻 CODE

*기억하면 좋은 코드!

```java
private void handleShow(boolean detailed) {
    // showDetail -> true, show -> false
    for (int i=0; i<n; i++) {
        System.out.println((i+1) + ", " + shapes[i].toString());
        if (detailed) {
            System.out.println("    The area is " + shapes[i].computerArea());
            System.out.println("    The perimeter is " + shapes[i].computerPerimeter());
        }
    }
}
```

shapes 배열에 있는 Rectangle, Circle 객체에 대해 메소드를 호출할 때, 각 클래스에서 오버라이딩한 메소드가 호출된다.

```java
private void handleSort() {
    for (int i=n-1; i>0; i--) {
        for (int j=0; j<i; j++) {
            if (shapes[j].computerArea() > shapes[j+1].computerArea()) {
                Shape tmp = shapes[j];
                shapes[j] = shapes[j+1];
                shapes[j+1] = tmp;
            }
        }
    }
}
```

위 정렬은 버블 정렬을 이용한 방식이다. 하지만 이 메서드는 오직 Shape 데이터들을 정렬하는 용도로만 사용가능하다. ***즉, generic 하지 않다.***

→ 하나의 generic한 Sort 메서드를 구현해서 어떤 클래스 타입에 상관 없이 모두 동일하게 정렬 기능을 사용할 수 있도록 구현하는 것이 좋다! 👉🏻  `Comparable` 인터페이스 (Java API에 정의되어 있음)

generic하게 구현하자!

```java
// MyComparable Interface를 implements한 Shape 클래스의 compareTo() 메서드
public int compareTo(Object o) {
    double myArea = computeArea();
    double yourArea = ((Shape)o).computeArea();
    if (myArea < yourArea) return -1;
    else if (myArea == yourArea) return 0;
    else return 1;
}

// ShapeApplication.java
private void handlerSort(MyComparable[] data, int size) {
    for (int i=size-1; i>0; i--) {
        for (int j=0; j<i; j++) {
            if (data[j].compareTo(data[j+1]) > 0) {
                MyComparable tmp = data[j];
                data[j] = data[j+1];
                data[j+1] = tmp;
            }
        }
    }
}
```

## 📓 메모하기

- 인터페이스를 implements하는 추상 클래스에서 꼭 내부를 구현하지 않아도 된다. 실제 이 추상 클래스를 상속받아 사용하는 곳에서 구현해주면 된다.
- 추상 메서드로만 구성된 추상 클래스는 인터페이스와 완전히 동일한가? 본질적으로 같긴 하지만, 완전히 같지는 않다!

  → Java에서의 중요한 문제 중 하나인 다중 상속 측면에서 다르게 다루어진다.

   - Java에서는 다중 상속을 허용하지 않는다.

     여러 개의 extends는 불가능하지만, implements는 가능하다.



# 제3-5장: Generic 프로그래밍과 Generics


> 인프런 권오흠 교수님의 ‘Java로 배우는 자료구조’ 강의의 학습 정리 내용입니다.
>