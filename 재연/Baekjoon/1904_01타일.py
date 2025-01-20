n=int(input())
# (n+1)곱해도 충분한 거 아닌지 왜 인덱스 에러나는지
arr=[0]*1000001
arr[1]=1
arr[2]=2

for i in range(3,n+1):
    # 미리 나누기를 안해주면 수가 너무 커져서 메모리가 부족해짐
    arr[i]=(arr[i-2]+arr[i-1])%15746
    
print(arr[n])