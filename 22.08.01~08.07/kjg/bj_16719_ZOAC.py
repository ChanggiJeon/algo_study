a = list(input())
b = [''] * len(a)


def recursion(a, start):
    if not a:
        return
    _min = min(a)
    idx = a.index(_min)
    b[start+idx] = _min
    print("".join(b))
    recursion(a[idx + 1:], start + idx + 1)
    recursion(a[:idx], start)
    
    
recursion(a, 0)