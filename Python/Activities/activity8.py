#User List
numlist = input("Enter list items separated by spaces: ")
# Convert the input string to a list of integers
numlist = [int(x) for x in numlist.split()]
print(numlist)


firstnumber=numlist[0]
lastnumber=numlist[-1]

#Compare firstnumber and lastnumber in the list
if firstnumber==lastnumber:
    print(True)
else:
    print(False)