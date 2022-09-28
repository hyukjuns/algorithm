h, m = map(int, input().split())
cooking_time = int(input())

target_hour = int(h + (m+cooking_time) / 60)
target_minute = int((m+cooking_time) % 60)

if (m+cooking_time) > 60:
    if target_hour >= 24:
        print(target_hour-24, target_minute)
    else:
        print(target_hour, target_minute)
elif (m+cooking_time) < 60:
    print(target_hour, target_minute)
elif (m+cooking_time) == 60:
    if target_hour >= 24:
        print(target_hour-24, target_minute)
    else:
        print(target_hour, target_minute)

