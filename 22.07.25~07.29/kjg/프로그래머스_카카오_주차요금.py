def solution(fees, records):
    pk = {}
    
    # 정보 나열
    for i in records:
        t, n, b = i.split()
        h = int(t[:2]) * 60 + int(t[3:])
        if n not in pk.keys():
            pk[n] = [0 , 1439, 0,'OUT']
        if b == "IN":
            pk[n] = [h,pk[n][1],pk[n][2],'IN']
        elif b == "OUT":
            fh = (h - pk[n][0])
            pk[n] = [0, 1439, pk[n][2] + fh, 'OUT']
    answer = []
    
    # 계산
    for j in sorted(pk.keys()):
        if pk[j][3] == "IN":
            fh = (pk[j][1] - pk[j][0]) + pk[j][2]
        elif pk[j][3] == "OUT":
            fh = pk[j][2]
        if fh <= fees[0]:
            c = fees[1]
        else:
            cnt = (fh - fees[0]) // fees[2]
            if (fh - fees[0]) % fees[2] > 0:
                cnt += 1
            c = fees[1] + (cnt * fees[3])
        answer.append(c)
    return answer

            