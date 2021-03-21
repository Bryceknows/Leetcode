import re

list = []
matchPattern = re.compile(r'-->')
file = open('/Users/lzc/Desktop/a.txt', 'r')
while 1:
    line = file.readline()
    if not line:
        print("Read file End or Error")
        break
    elif matchPattern.search(line):
        pass
    else:
         list.append(line)
file.close()
file = open(r'/Users/lzc/Desktop/b.txt', 'w')
for i in list:
     file.write(i)
file.close()




