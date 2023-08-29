
# dp알고리즘
# 계획 1. 제곱수로 이루어진 수 들을 저장하며 해결
# 계획 2. 제곱수 자체를 저장하여 사용하며 해결
# 계획 - 각자의 배열에 적용할 수 있는 라그랑주 수를 기억
# 저장하면서, 제곱수만큼 줄이는 식 dplist[n]=1+dplist[n-i*i] 범위는 i=1에서부터 i*i<n 일때 까지 돌리며 가장 작은 값을 적용, 안되는 경우 -> 이외의 경우 dplist[n] = 1 + dplist[i]
# 근데, 어쩔 때 저 조건을 사용할 수 있을까... 




n = int(input())

dplist = [0]*(n+1)

dplist[1] = 1

for i in range(2,n+1):
    dplist[i] = 1+dplist[i-1]
    k = 1
    while k*k <= i:
        dplist[i] = min(1+dplist[i-(k*k)], dplist[i])
        k= k+1

       

print(dplist[n])



# for i in range(1, ):
#     waylist.append(dplist[n-i*i] + 1)
# dplist[n] = min(waylist)


# while i*i <= n:
#     if i*i < n:
#         waylist.append(dplist[n-(i*i)] + 1)
#         i = i+1
#     elif i*i == n:
#         waylist.append(1)
# dplist[n] = min(waylist)

# print(dplist[n])
















