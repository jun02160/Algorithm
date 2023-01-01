package inflearn_Java로_배우는_자료구조.제2장;

// 직교 다각형을 표현하기 위한 클래스
public class OrthoPolygon {
    public int n;
    public MyPoint[] vertices;

    // constructor
    public OrthoPolygon(int k) {
        n = 0;
        vertices = new MyPoint[k];  // 꼭짓점의 개수만 지정
    }

    /**
     * 한 점을 입력받아 다각형의 꼭짓점을 추가하는 메서드
     */
    public void addVertex(int x, int y) {
        vertices[n++] = new MyPoint(x, y);
    }

    public int maxX() {
        int max = vertices[0].x;
        for (int i=0; i<n; i++) {
            if (vertices[i].x > max) {
                max = vertices[i].x;
            }
        }
        return max;
    }

    public boolean contains(MyPoint p) {
        OrthoLine arrow = new OrthoLine(p, new MyPoint(maxX()+1, p.y));
        int count = 0;
        for (int i=0; i<n; i++) {
            OrthoLine edge = new OrthoLine(vertices[i], vertices[(i+1)%n]);
            if (arrow.intersects(edge)) {
                count++;
            }
        }
        return (count % 2 == 1);
    }
}
