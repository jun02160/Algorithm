package Interface_form;

public interface List<E> {
    /**
     * ����Ʈ�� ��Ҹ� �߰�(����)�ϴ� ���
     *
     * @param value ����Ʈ�� �߰��� ���
     * @return ����Ʈ���� �ߺ��� ������� ���� ���, ����Ʈ�� �̹� �ߺ��Ǵ� ���Ұ� �ִٸ�
     * 			{@code false}��, �ߺ��Ǵ� ���Ұ� ���ٸ� {@code true}�� ����
     */
    boolean add(E value);

    /**
     * Ư�� ��ġ�� �߰��Ѵٸ�, �� ������ ��ҵ��� �� ĭ�� �з���
     *
     * @param index ��Ҹ� �߰��� ��ġ�� �ε���
     * @param value ����Ʈ�� �߰��� ���
     */
    void add(int index, E value);

    /**
     * ����Ʈ�� Ư�� ��ġ�� ��Ҹ� �����ϴ� ���(index)
     *
     * @param index ����Ʈ���� ������ ����� ��ġ �ε���
     * @return ������ ��Ҹ� ����
     */
    E remove(int index);

    /**
     * ����Ʈ���� Ư�� ��Ҹ� �����ϴ� ���(value)
     *
     * @param value ����Ʈ���� ������ ���
     * @return ������ ��Ұ� ���ų� �������� ���� ��� {@code false},
     * 			������ ������ ��� {@code true}�� ����
     */
    boolean remove(Object value);

    /**
     * ����Ʈ���� Ư�� ��ġ�� ��Ҹ� �˻��ϴ� ���
     *
     * @param index ����Ʈ�� ������ ��ġ�� �ε���
     * @return ����Ʈ�� index ��ġ�� �ִ� ��� ����
     */
    E get(int index);

    /**
     * ����Ʈ���� Ư�� ��ġ�� ��Ҹ� �� ��ҷ� ��ü�ϴ� ���
     *
     * @param index ����Ʈ�� ������ ��ġ�� �ε���
     * @param value ���� ��ü�� ��� ��
     */
    void set(int index, E value);

    /**
     * ����Ʈ�� Ư�� ����� ���� ���θ� Ȯ���ϴ� ���
     *
     * @param value ����Ʈ���� ã�� Ư�� ��� ��
     * @return ����Ʈ�� Ư�� ��Ұ� ������ ��� {@code true}, �������� ���� ��� {@code false}
     */
    boolean contains(Object value);

    /**
     * ����Ʈ�� ��� ������ ���ϴ� ���
     *
     * @return ����Ʈ�� �ִ� ����� �� ������ ����
     * @return
     */
    int size();

    /**
     * ����Ʈ�� ��Ұ� ������(����ִ� ��������) Ȯ���ϴ� ���
     *
     * @return ����Ʈ�� ��Ұ� �ִ� ��� {@code true}, ���� ��� {@code false} ����
     */
    boolean isEmpty();

    /**
     * ����Ʈ�� ��� ��Ҹ� �����ϴ� ���
     */
    public void clear();
}
