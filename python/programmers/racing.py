def solution(players, callings):
    # dic = {"선수이름": 랭크}
    # enumerate(list) -> (index, value)
    players_map = {player: i for i, player in enumerate(players)}
        
    for name in callings:
        idx = players_map[name]
        players_map[name] -= 1
        players_map[players[idx-1]] += 1
        players[idx], players[idx-1] = players[idx-1], players[idx]
    return players
