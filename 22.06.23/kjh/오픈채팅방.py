def solution(record):
    tmp_ans = []
    answer = []
    checker = EventChecker()
    for i in range(len(record)):
        text = record[i]
        if record[i][0] == "E":
            tmp_ans.append(checker.enter_chat(text))
        elif record[i][0] == "L":
            tmp_ans.append(checker.leave_chat(text))
        else:
            checker.change_uid(text)

    for i in range(len(tmp_ans)):
        event, uid = tmp_ans[i].split(" ")
        name = checker.users[uid]
        if event == "e":
            answer.append(f"{name}님이 들어왔습니다.")
        else:
            answer.append(f"{name}님이 나갔습니다.")

    return answer

# OOP 느낌으로 풀어보았다.
class EventChecker:
    users = {}

    def enter_chat(self, text):
        # 너무 오랜만이라 split이 생각이 안나서 하드코딩으로 uid와 nickname을 추출했는데 런타임 에러가 발생했고 수정했다.
        _type, uid, nickname = text.split(" ")
        self.users[uid] = nickname
        return f"e {uid}"

    def leave_chat(self, text):
        _type, uid = text.split(" ")
        return f"l {uid}"

    def change_uid(self, text):
        _type, uid, nickname = text.split(" ")
        self.users[uid] = nickname