# BackTracking
## Usage Example
- 보통 모든 경우의 순열을 만들어야 할 때 자주 사용했다.
```java
public static void dfs(int index){
        if(index == n){
            int sum=0;
            for(int i=0; i<n-1; i++){
                sum += Math.abs(target[i]-target[i+1]);
            }
            ans = Math.max(ans,sum);
            return;
        }
        for(int i=0; i<n; i++){
            if(!used[i]){
                used[i]=true;
                target[index] = arr[i];
                dfs(index+1);
                used[i]=false;
            }
        }
    }
```