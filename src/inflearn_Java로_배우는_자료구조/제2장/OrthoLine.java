package inflearn_Java로_배우는_자료구조.제2장;

public class OrthoLine {
    public MyPoint u;
    public MyPoint v;

    public OrthoLine(MyPoint p, MyPoint q) {
        u = p;
        v = q;
        if (p.x>q.x || p.x==q.x && p.y>q.y) {  // 항상 u가 v보다 좌측 상단에 위치하도록
            swap();
        }
    }

    public OrthoLine(int x1, int y1, int x2, int y2) {
        u = new MyPoint(x1, y1);
        v = new MyPoint(x2, y2);
    }

    private void swap() {
        MyPoint tmp = u;
        u = v;
        v = tmp;
    }

    public boolean isVertical() {
        return (u.x == v.x);
    }

    public boolean intersects(OrthoLine other) {
        if (isVertical() && !other.isVertical()) {
            return  (other.u.x<u.x && other.v.x>u.x && u.y<other.u.y && v.y>other.u.y);
        } else if (!isVertical() && other.isVertical()) {
            return (other.u.y < u.y && other.v.y > u.y && u.x<other.u.x && other.u.x<v.x);
        } else {
            return false;
        }
    }
}
