import csv

FILE_NAME = "test_001.csv"

# Write
f = open(FILE_NAME,'w',newline='')
csv_writer = csv.writer(f)
csv_writer.writerow(["No","Name","Number"])
csv_writer.writerow(["1","hyukjun","1234"])
f.close()

# Read
f = open(FILE_NAME, 'r', newline='')
csv_reader = csv.reader(f)

for row in csv_reader:
    print(', '.join(row))
f.close()

# Append
f = open(FILE_NAME, 'a', newline='')
csv_writer = csv.writer(f)
csv_writer.writerow(["2","nam","4567"])
f.close()

# Read
f = open(FILE_NAME, 'r', newline='')
csv_reader = csv.reader(f)

for row in csv_reader:
    print(', '.join(row))
f.close()
