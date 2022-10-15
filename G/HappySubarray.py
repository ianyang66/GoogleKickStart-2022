def Solution():
    n = int(input())
    a = list(map(int, input().split()))
    p = [0]*(n+1)
    for i in range(n):
        p[i+1] = p[i]+a[i]
    stk = []
    ans = 0
    cur = 0
    for p1 in p:
        while stk and stk[-1] > p1:
            cur -= stk.pop()
        ans += len(stk)*p1-cur
        cur += p1
        stk.append(p1)
    return ans
    
testcase = int(input())
for case in range(testcase):
    print("Case #" + str(case+1) + ": " + str(Solution()))