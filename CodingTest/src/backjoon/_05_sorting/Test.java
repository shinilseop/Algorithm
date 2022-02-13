package backjoon._05_sorting;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {

        // 정렬 되지 않은 배열
        int[] arr = {3,7,4,1,9,2,8,8,6,5};

        /** < maxHeap 만들기 >
         *   - 부모노드의 값이 자식노드의 값들보다 큰 형태
         *   - i의 초기값은 배열의 제일 끝 자식노드의 부모노드부터 시작한다.
         */
        for(int i=arr.length/2-1;i>=0;i--){
            heapify(arr, arr.length, i);
        }


        System.out.print("MAX BUILD FINISH : ");
        IntStream.range(0, arr.length).map(i -> arr[i]).forEach(System.out::print);
        System.out.println();

        // 정렬하기
        for(int i=arr.length-1;i>=0;i--){
            swap(arr, i, 0); // 최상단 노드와 최하단 노드 값을 교환한다.
            heapify(arr, i, 0); // 루트노드를 기준으로 최대힙을 만든다.
        }


        System.out.print("SORT FINISH : ");
        IntStream.range(0, arr.length).map(i -> arr[i]).forEach(System.out::print);
        System.out.println();
    }

    public static void heapify(int[] arr, int size, int pNode){
        int parent = pNode; // 부모노드
        int lNode = pNode * 2 + 1; // 왼쪽 자식노드
        int rNode = pNode * 2 + 2; // 오른쪽 자식노드
        int childNode = 0;

        // 자식 노드 중 가장 큰 노드 찾기
        if(size > lNode && size > rNode){
            childNode = arr[lNode] > arr[rNode] ? lNode : rNode;
        }else if(size > lNode && size <= rNode){
            childNode = lNode;
        }else if(size <= lNode && size > rNode){
            childNode = rNode;
        }else{
            return; // 자식노드가 없으면 교환할 필요가 없다
        }

        // 자식 노드 중 큰 값과 비교
        if(arr[parent] < arr[childNode]){
            parent = childNode;
        }

        // parent에 저장된 값은 자식노드 중 큰 값이 있다면 큰 값의 인덱스 값이 남아있을 것이다.
        // 초기에 설정한 부모노드의 인덱스와 다르다면 교환을 해준다.
        if(parent != pNode){
            swap(arr, pNode, parent);

            /**
             * 노드와 자리를 바꾸면 최대힙 기준에 맞지 않을 수 있기 때문에
             * 바뀐 자식노드 아래 최대힙으로 맞춰주기 위함
             */
            heapify(arr, size, parent);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[j]; arr[j] = arr[i]; arr[i] = tmp;
    }
}
