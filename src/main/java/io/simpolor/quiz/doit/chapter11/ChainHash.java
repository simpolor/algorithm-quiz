package io.simpolor.quiz.doit.chapter11;

public class ChainHash<K, V> {

    // 해시를 구성하는 노드
    class Node<K, V> {
        private K key; // 키 값
        private V data; // 데이터
        private Node<K, V> next; // 다음 노드에 대한 참조

        public Node(K key, V data, Node<K,V> next){
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey(){
            return key;
        }

        V getData(){
            return data;
        }

        public int hashCode(){
            return key.hashCode();
        }
    }

    private int size;
    private Node<K, V>[] table;

    public ChainHash(int capacity){
        try{
            table = new Node[capacity];
            this.size = capacity;
        }catch (OutOfMemoryError e){
            this.size = 0;
        }
    }

    public int hasValue(Object key){
        return key.hashCode() % size;
    }

    public V search(K key){
        int hash = hasValue(key);
        Node<K, V> p = table[hash];

        while (p != null){
            if(p.getKey().equals(key)){
                return p.getData();
            }
            p = p.next;
        }

        return null;
    }

    public int add(K key, V data){
        int hash = hasValue(key); // 추가할 데이터의 해시 값
        Node<K, V> p = table[hash]; // 선택 노드

        while (p != null){
            if(p.getKey().equals(key)){ // 이 키 값은 이미 등록 됨
                return 1;
            }
            p = p.next; // 다음 노드에 주목
        }

        Node<K, V> temp = new Node<K,V>(key, data, table[hash]);
        table[hash] = temp; // 노드를 삽입

        return 0;
    }

    public int remove(K key){
        int hash = hasValue(key);
        Node<K,V> p = table[hash];
        Node<K,V> pp = null;

        while (p != null){
            if(p.getKey().equals(key)){
                if(pp == null){
                    table[hash] = p.next;
                }else{
                    pp.next = p.next;
                }
                return 0;
            }
            pp = p;
            p = p.next;
        }
        return 1;
    }

    public void dump(){
        for(int i = 0; i < size; i++){
            Node<K,V> p = table[i];

            System.out.printf("%02d ", i);

            while (p != null){
                System.out.printf("-> %s (%s) ", p.getKey(), p.getData());
                p = p.next;
            }
            System.out.println();
        }
    }
}
