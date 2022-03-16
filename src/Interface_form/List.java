package Interface_form;

public interface List<E> {
    /**
     * 리스트에 요소를 추가(삽입)하는 경우
     *
     * @param value 리스트에 추가할 요소
     * @return 리스트에서 중복을 허용하지 않을 경우, 리스트에 이미 중복되는 원소가 있다면
     * 			{@code false}를, 중복되는 원소가 없다면 {@code true}를 리턴
     */
    boolean add(E value);

    /**
     * 특정 위치에 추가한다면, 그 이후의 요소들은 한 칸씩 밀려남
     *
     * @param index 요소를 추가할 위치의 인덱스
     * @param value 리스트에 추가할 요소
     */
    void add(int index, E value);

    /**
     * 리스트의 특정 위치의 요소를 삭제하는 경우(index)
     *
     * @param index 리스트에서 삭제할 요소의 위치 인덱스
     * @return 삭제된 요소를 리턴
     */
    E remove(int index);

    /**
     * 리스트에서 특정 요소를 삭제하는 경우(value)
     *
     * @param value 리스트에서 삭제할 요소
     * @return 삭제할 요소가 없거나 삭제하지 못한 경우 {@code false},
     * 			삭제에 성공한 경우 {@code true}를 리턴
     */
    boolean remove(Object value);

    /**
     * 리스트에서 특정 위치의 요소를 검색하는 경우
     *
     * @param index 리스트에 접근할 위치의 인덱스
     * @return 리스트의 index 위치에 있는 요소 리턴
     */
    E get(int index);

    /**
     * 리스트에서 특정 위치의 요소를 새 요소로 대체하는 경우
     *
     * @param index 리스트에 접근할 위치의 인덱스
     * @param value 새로 대체할 요소 값
     */
    void set(int index, E value);

    /**
     * 리스트에 특정 요소의 존재 여부를 확인하는 경우
     *
     * @param value 리스트에서 찾을 특정 요소 값
     * @return 리스트에 특정 요소가 존재할 경우 {@code true}, 존재하지 않을 경우 {@code false}
     */
    boolean contains(Object value);

    /**
     * 리스트의 요소 개수를 구하는 경우
     *
     * @return 리스트에 있는 요소의 총 개수를 리턴
     * @return
     */
    int size();

    /**
     * 리스트에 요소가 없는지(비어있는 상태인지) 확인하는 경우
     *
     * @return 리스트에 요소가 있는 경우 {@code true}, 없는 경우 {@code false} 리턴
     */
    boolean isEmpty();

    /**
     * 리스트의 모든 요소를 삭제하는 경우
     */
    public void clear();
}
