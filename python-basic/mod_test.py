def add(a,b):
    return a+b

# excute by python -> __name__ equal to __main__
# excute by shell -> __name__ equal to module name

if __name__=="__main__":
    print("Excute by python engine")
    print("__name__ : "+__name__)