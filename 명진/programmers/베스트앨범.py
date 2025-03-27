def solution(genres, plays):
    playlist = []
    song_by_genre = {g:[] for g in set(genres)}
    play_by_genre = {g:0 for g in set(genres)}
    for i in range(len(genres)):
        song_by_genre[genres[i]] += [[plays[i], i]]
        play_by_genre[genres[i]] += plays[i]

    songCompareKey = lambda x: (-x[0], x[1])

    for [g, p] in sorted(play_by_genre.items(), key=lambda x:-x[1]):
        for [_, i] in sorted(song_by_genre[g], key=songCompareKey)[:2]:
            playlist += [i]
    return playlist