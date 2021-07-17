# print("\    /\\")
# print(" )  ( ')")
# print("(  /  )")
# print(" \(__)|")
#
# print("|\_/|")
# print("|q p|   /}")
# print("( 0 )\"\"\"\\")
# print("|\"^\"`    |")
# print("||_/=\\\\__|")
#
# a, b = map(int, input().split(" "))
# print(a+b)
# print(a-b)
# print(a*b)
# print(int(a/b))
# print(a%b)

a = int(input())
b = input()
b_list = list(b)

three = a * int(b_list[2])
four = a * int(b_list[1])
five = a * int(b_list[0])
six = three + four*10 + five*100

print(three)
print(four)
print(five)
print(six)



