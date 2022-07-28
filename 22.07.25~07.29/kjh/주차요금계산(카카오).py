import math


# 시간 계산(분 단위)
def cal_time(h_in, m_in, h_out, m_out):
    time_h = (h_out - h_in) * 60
    time_m = m_out - m_in
    time = time_h + time_m
    return time


def solution(fees, records):
    # 초기값 설정
    car_nums = [0] * 10000
    car_check = set()
    in_check = dict()
    base_time = int(fees[0])
    base_fee = int(fees[1])
    unit_time = int(fees[2])
    unit_fee = int(fees[3])
    for i in range(len(records)):
        # 입출차 시간, 차번호, 내역 확인
        HH = int(records[i][:2])
        MM = int(records[i][3:5])
        car_num = int(records[i][6:10])
        # 방문 체크
        car_check.add(car_num)
        in_out = records[i][11:13]
        # 입차이면 딕셔너리에 추가 {차번호 : [시, 분]}
        if in_out == 'IN':
            in_check[car_num] = [HH, MM]
        # 출차이면 시간 계산
        else:
            # 시간 계산(분 단위로 계산 후 누적)
            time = cal_time(in_check[car_num][0], in_check[car_num][1], HH, MM)
            car_nums[car_num] += time
            del in_check[car_num]
    # 딕셔너리에 남은 차량 = 23:59까지 계산
    for car_num in in_check.keys():
        time = cal_time(in_check[car_num][0], in_check[car_num][1], 23, 59)
        car_nums[car_num] += time
        print(car_num, car_nums[car_num] - 180)

    # 결과반환
    answer = []
    for car_num in sorted(list(car_check)):
        # 기본시간 이하로 주차한 경우
        if car_nums[car_num] <= base_time:
            answer.append(base_fee)
        # 기본시간 초과인 경우
        else:
            tmp_fee = base_fee
            time = car_nums[car_num]
            time -= base_time
            # 남는 시간 있으면 단위비용 추가
            if math.ceil(time % unit_time):
                tmp_fee += (time // unit_time + 1) * unit_fee
            else:
                tmp_fee += time // unit_time * unit_fee
            answer.append(tmp_fee)
    return answer