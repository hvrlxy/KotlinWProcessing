def f(s,t):
    if s == t:
        return s
    else:
        pos1 = s + f(s+1,t)
        pos2 = s - f(s+1,t)

    print(pos1)
    print(pos2)


        
