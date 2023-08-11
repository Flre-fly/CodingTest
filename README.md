# [JAVA] 코딩 테스트 대비 알고리즘 문제 풀이

### 복습할 문제
- BFS
  - 4179
  - 2206(벽부수기) ✅
- 재귀
  - 1629(곱셈)
- 순열
  - 9095
  - 1759(암호 만들기)
  - 15665(n과 m 11)
  - 15666(N과 M (12))
- 투포인터
  - 2003(수들의 합2)
 
### HashSet과 LinkedHashSet의 차이
- HashSet: 원소의 순서를 보장하지 않습니다. 즉, 원소들이 임의의 순서로 저장됩니다.
- TreeSet: 원소들이 자연 순서에 따라 정렬됩니다.
- LinkedHashSet: 원소들이 추가된 순서대로 유지됩니다.
### 넣은대로 순서를 유지해야하고 중복을 없애야하는경우는 list.indexOf vs LinkedHashSet 뭐가 나을까?
- ArrayList의 indexOf() 메서드는 시간 복잡도가 O(n)이기 때문에 이를 반복적으로 호출하면 전체적인 시간 복잡도는 O(n^2)가 됩니다. 
- 한편, LinkedHashSet을 사용할 경우 add() 메서드는 원소가 이미 존재하는지 체크한 후에 없을 경우에만 원소를 추가합니다.
- 이 과정에서의 시간 복잡도는 평균적으로 O(1)이므로, ArrayList와 indexOf()를 사용할 때보다 훨씬 효율적입니다.

### 투포인터 알고리즘
```java
        int result = 0;
        int r = 0;
        int l = 0;
        int sum = 0;
        while(l<=r){
            if(sum >= m) sum -= arr[l++];
            else if(r==n) break;//sum이 m보다 작고 r이 n과 같으면 뭔짓을 해도 안 커지니 끝내버린다
            else sum += arr[r++];

            if(sum==m) result++;
        }
```
### 9095의 문제가 순열/조합이 아닌 이유
```
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
```
- 이 문제를 순열/조합으로 해결하려고 하면, 수열의 순서도 고려되어야 합니다.
- 예를 들어, '1+2'와 '2+1'은 같은 합이지만 서로 다른 경우의 수로 취급됩니다. 이는 기본적인 조합의 원칙에 어긋나며, 이로 인해 순열/조합으로 해결하는 것이 복잡해집니다.
- 또한, 이 문제의 경우 1, 2, 3을 무한번 사용할 수 있다는 점이 순열/조합으로 접근하는 것을 어렵게 합니다.
- 순열/조합은 대체로 원소의 수가 제한적일 때 효과적입니다.
- 순열/조합으로 문제를 해결하려면 모든 가능한 경우의 수를 열거해야 하므로, 그 시간 복잡도는 O(3^n)이 됩니다.
- n이 증가함에 따라 이는 기하급수적으로 증가합니다. 이는 각 수를 만드는 방법이 3개(1, 2, 3)이고, 각 수를 만드는 방법을 모두 고려해야 하기 때문입니다.

따라서, 이 문제는 순열/조합을 이용한 접근보다 동적 프로그래밍을 이용한 접근이 더 효율적입니다. 동적 프로그래밍은 이미 계산된 결과를 재사용하여 중복 계산을 피하므로, 이 문제를 O(n)의 시간 복잡도로 해결할 수 있습니다
### 순열
- N 개 중에서 M 개를 중복없이 뽑는다.
- 시간 복잡도: O(N!) - 이 함수는 1에서 N까지의 모든 순열을 생성합니다. N! N 숫자에 대한 순열.
- 각 재귀 호출에서 함수는 N개의 옵션을 탐색하고 N 수준의 재귀가 있습니다. 따라서 재귀 호출의 총 횟수는 N * N * ... * N(N회)이며, 즉 N!입니다.
- 공간 복잡도: O(N) - 공간 복잡도는 결과와 방문한 배열에 의해 결정되며 둘 다 크기가 N+1입니다. 재귀 깊이도 최대 N입니다.
```java
//필요한 변수
        arr = new int[9];//그냥 숫자대상으로 순열/조합 쓰는 경우 따로 필요 없음 (nPc인 경우 n를 위한 배열)
        result = new int[7];//출력할 숫자를 저장할 배열 (nPc인 경우 c를 위한 배열)

	// 순열
    private static void permutation(int cnt) {
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    // 중복 순열 - 중복 제거하는 visited를 쓰지 않음
    private static void repeatedPermutation(int cnt) {
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[cnt] = i;
            permutation(cnt + 1);
        }
    }
```
### 조합
- 시간복잡도는 O(n^m)입니다.
- 여기서 n은 가능한 선택지의 수, m은 선택해야 하는 원소의 수입니다. 이 알고리즘은 모든 가능한 m개의 원소를 가진 조합을 방문하기 때문에 이러한 시간 복잡도를 가집니다.
- 각 단계에서 n번의 반복문을 실행하고, 이것이 m단계까지 진행되기 때문에 O(n^m)의 시간 복잡도를 가집니다.
```java
//필요한 변수
        arr = new int[9];//그냥 숫자대상으로 순열/조합 쓰는 경우 따로 필요 없음 (nPc인 경우 n를 위한 배열)
        result = new int[7];//출력할 숫자를 저장할 배열 (nPc인 경우 c를 위한 배열)
	cnt: 조합의 현재 수를 나타낸다
	start: 조합이 시작되는 인덱스를 나타낸다. 조합의 중복을 방지하기 위해 사용한다. 시작부터 세게 되면 중복이 없어진다
// 조합
    private static void combination(int cnt, int start) {
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            combination(cnt + 1, i + 1); // 오름차순으로 구하면 중복 체크하지 않아도 됨
        }
    }
//조합(들어오는 숫자로 조합을 수행해야하는 경우)
    public static void combination(int cnt, int start){
        if(cnt == 7){
            for(int i=0;i< result.length;i++){
                System.out.println(result[i]);
            }
            return;
        }

        for (int i=start;i<arr.length;i++){
            result[cnt] = arr[i];//이부분 주의
            combination(cnt+1, i+1);
        }
    }

    // 중복 조합
    private static void repeatedCombination(int cnt, int start) {
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            combination(cnt + 1, i); // 중복 허용하니까 비내림차순
        }
    }
```
### 테케 만드는법
1. 최솟값
2. 최댓값
3. 정렬된값 or 정렬되지 않은 값
### ArrayList에 중복없이 넣는 방법
```java
If( list.indexOf(value) < 0 ) list.add(value);
```
- indexOf을 사용한다
### 배열과 List
```java
//arr to list
List list = Arrays.asList(arr);//X
//arr to list
List<String> list = new ArrayList<>(Arrays.asList(arr)); //이런식으로 새로 생성해야 변경전파가 안됨
//list to arr
ArrayList<Integer> list = new ArrayList<>();
Integer arr[] = list.toArray(new Integer[2]);

```
### 정렬을 위한 Comparator 함수를 람다로 대체하자
```java
Collections.sort(arr, (a, b) -> b.cost - a.cost);
PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2) -> o2 - o1);
```
### BFS의 시간복잡도, 공간복잡도 확인
- BFS는 1번씩만 방문하므로 예를들어 rxcxh의 배열에 대해 BFS를 수행하면 시간복잡도, 공간복잡도 모두 RxCxH입니다 (공간복잡도 에서는 저만큼을 저장할 배열이 필요하기때문)
- BFS에서는 1번씩만 방문하도록 큐에 잘 집어넣는것이 중요(중복된 값이 여러번 들어가면 시간초과와 같은 다양한 문제가 생김)
- [벽부수고방문, 벽안부수고방문을 구분하여 방문체크해야하는 이유](https://www.acmicpc.net/board/view/67446)
### 2206 벽부수기에서 visited하나만 있으면 안되는이유
- 일단 BFS는 방문ㄴ처리가 필요하다. 그래야 메모리초과나 시간초과가 나지않는다
- 예를 들어 벽을 일찍 부수고 이전에 방문하지 않은 셀을 통과하면 더 빨리 도착하는 경로가 있을 수 있고,
  일부 셀을 먼저 방문한 다음 벽을 부수면 더 빨리 도착하는 경로가 있을 수 있다.
- 하나의 visit[][]만 사용한 경우 상태를 덮어쓰고 하나의 잠재적 경로를 잃을 수 있다.

### 큰수의 나머지를 입력하세요
- 알고리즘 문제를 푸는 과정에서 결과 값이 매우 큰 경우, 결과 값의 나머지를 구하라는 문제가 자주 등장한다.
- 단순히 결과 값에 모듈러 연산을 수행할 시 이미 결과 값은 너무 커져서 오버플로우가 발생한 경우가 대부분이기 때문에, 연산 과정 도중에 모듈러 연산을 적용해야 한다.
- 연산 과정 도중에 모듈러 연산을 적용하려면 모듈러 연산의 분배법칙에 대해 알아야 한다.
- 각 피연산자에 모듈러 연산을 취한 후, 계산 결과에 대해 다시한번 모듈러 연산을 취하면 된다. 또한, 뺄셈의 경우 음수가 나오는 것을 방지하기 위해 divisor를 한번 더해준다.
```
(A + B) % p = ((A % p) + (B % p)) % p
(A * B) % p = ((A % p) * (B % p)) % p
(A - B) % p = ((A % p) - (B % p) + p) % p
```
### 입출력 시간 비교
- with 2448
1. BufferedWriter사용하여 o(n^2)의 출력 수행하기
```java
        for (int i = n-1; i >= 0; i--) {
            for (int j = 2*n-2; j >= 0; j--) {
                bw.write(result[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
```
2. StringBuilder + System.out.println() 사용해서 출력 수행하기
```java
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            for (int j = 2*n-2; j >= 0; j--) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
```
- 메모리와 시간 비교(출력부분만 변경한것임)
- ![image](https://github.com/CommitOrDie/PS-JAVA/assets/66842566/13631ad6-26af-47a3-a8ee-21c80f456990)


---
참고
https://velog.io/@yul_00/AlgorithmJava-%EC%88%9C%EC%97%B4%EA%B3%BC-%EC%A1%B0%ED%95%A9



