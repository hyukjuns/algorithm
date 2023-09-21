
genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [800, 600, 800, 800, 2500]	

def solution(genres, plays):

    # 노래 별로 아이디 태깅 (0, 'classic'): 800
    songs = {idx: song for idx, song in enumerate(genres)}
    songs = {idx: song for idx, song in zip(songs.items(), plays)}

    # Sorted by genre asc and by hits desc (when hits same -> by tag id asc)
    # 장르 오름차순 정렬, 재생수 내림차순 정렬, 재생수 같을 경우 태그 아이디 오름차순 정렬
    songs = dict(sorted(songs.items(), key=lambda x: (x[0][1], -x[1], x[0][0])))

    # 1. 장르별 재생수 총합 비교 하여 내림차순 정렬
    genres_hit_sum = dict()
    for song in songs.items():
        try:
            genres_hit_sum[song[0][1]] += song[1]
        except:
            genres_hit_sum[song[0][1]] = song[1]    
    genres_hit_sum = dict(sorted(genres_hit_sum.items(), key=lambda x: x[1], reverse=True))

    # 2. 재생수 많은 장르의 곡부터 최대 2개씩 리스트에 추가
    answer = list()
    for target in genres_hit_sum:
        count = 0
        for song in songs.items():
            if song[0][1] == target and count != 2:
                answer.append(song[0][0])
                count += 1
    return answer

if __name__ == "__main__":
    print(solution(genres,plays))