# ord(문자) : 아스키코드 반환
# chr(숫자) : 숫자에 맞는 아스키 코드 반환

import sys

sys.stdout.write(str(ord(sys.stdin.readline().rstrip())))
