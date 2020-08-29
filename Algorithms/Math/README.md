## Algorithms
- 소수 판별
    - 에라토스테네스의 체
      ```java
      1. 주어진 수,범위(n)만큼 배열 생성 후 인덱스를 값으로 초기화 int[] arr = new int[n];
      2. 주어진 수의 제곱근까지만 반복문을 돌리며 0 인지 체크
      2-1. 0 이 아니면 그 수의 모든 배수에 0 으로 체크
      2-2. 0 이라면 continue
      3. 제곱근까지 체크가 끝나면 주어진 범위 만큼 반복문을 돌리면서 0이 아닌(체크가 안된) 수 들이 소수 인 걸 확인 가능
```     