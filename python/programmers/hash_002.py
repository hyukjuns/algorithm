def solution(phone_book):
    phone_book_dict = {}
    for phone in phone_book:
        phone_book_dict[phone] = 1
    
    for phone in phone_book: # string in list
        prefix = ''
        for number in phone: # char in string
            prefix += number # Adding char
            if prefix in phone_book_dict and prefix != phone:
                return False
    return True