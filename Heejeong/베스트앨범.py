def solution(genres, plays):
    answer = []
    musics = [Music(i, plays[i]) for i in range(len(genres))]

    # Genre를 key로 Grouping
    genre = {g: Genre(g) for g in set(genres)}
    for i in range(len(genres)):
        g = genre[genres[i]]
        g.plays += plays[i]
        g.music_list.append(musics[i])

    # 수록 곡이 많은 순으로 정렬
    stack = sorted(genre.keys(), key=lambda x:genre[x].plays)

    while stack:
        g = stack.pop()
        # music list를 play 수가 높고 고유번호가 낮은 순으로 정렬
        music_list = sorted(genre[g].music_list, key=lambda x: (x.play, -x.no))
        for i in range(2):
            if not music_list: break
            answer.append(music_list.pop().no)

    return answer

class Genre:
    def __init__(self, genre):
        self.genre = genre
        self.plays = 0
        self.music_list = []

    def __str__(self):
        return "Genre(genre: {}, plays: {}, music_list: {})".format(self.genre, self.plays, self.music_list)

class Music:
    def __init__(self, no, play):
        self.no = no
        self.play = play

    def __str__(self):
        return "Music(no: {}, play: {})".format(self.no, self.play)


if __name__ == "__main__":
    test_case = [[["classic", "pop", "classic", "classic", "pop"],
                 [500, 600, 150, 800, 2500]]]
    test_result = [[4, 1, 3, 0]]
    for i in range(len(test_case)):
        result = solution(test_case[i][0], test_case[i][1])
        if result == test_result[i]: print("맞았습니다!")
        else: print("틀렸습니다!")
