enroll=["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
referral = ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
seller = ["young", "john", "tod", "emily", "mary"]
amount = [12, 4, 2, 5, 10]

def solution(enroll, referral, seller, amount):
    answer = [0]*len(enroll)
    sellerDict = {}  # {'john': '-', 'mary': '-', 'edward': 'mary', 'sam': 'edward', 'emily': 'mary', 'jaimie': 'mary', 'tod': 'jaimie', 'young': 'edward'}
    order = {} # {'john': 0, 'mary': 1, 'edward': 2, 'sam': 3, 'emily': 4, 'jaimie': 5, 'tod': 6, 'young': 7}
    for i in range(len(enroll)):
        sellerDict[enroll[i]] = referral[i]
        order[enroll[i]] = i

    for i in range(len(seller)):
        person = seller[i]
        money = amount[i]*100
        while person != '-':
            num = order[person]
            answer[num] += money-(money // 10)
            money = money // 10
            person = referral[num]
            if money == 0:
                break
    return answer


print(solution(enroll, referral, seller, amount))

