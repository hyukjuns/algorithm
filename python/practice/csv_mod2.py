import csv

FILE_NAME = "test_002.csv"

# Write
with open(FILE_NAME,'w',newline='') as csvfile:
    csv_writer = csv.writer(csvfile, delimiter=',')
    csv_writer.writerow(['No','Name','Number'])
    csv_writer.writerow(['001','Hyukjun','1234'])

# Read
with open(FILE_NAME, 'r', newline='') as csvfile:
    csv_reader = csv.reader(csvfile, delimiter=',')
    for row in csv_reader:
        print(', '.join(row))

# Append
with open(FILE_NAME, 'a', newline='') as csvfile:
    csv_writer = csv.writer(csvfile, delimiter=',')
    csv_writer.writerow(['002','Nam','4567'])

# Read
with open(FILE_NAME, 'r', newline='') as csvfile:
    csv_reader = csv.reader(csvfile, delimiter=',')
    for row in csv_reader:
        print(', '.join(row))
