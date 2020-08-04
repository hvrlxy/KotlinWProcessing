def phanTichSo(m,v):
    #phan tich so v thanh tong cac so <= m
    if m == 0 and v == 0:
        return 1
    if m == 0 and v >0:
        return 0
    else:
        return phanTichSo(m-1,v) + phanTichSo(m, v-m)
