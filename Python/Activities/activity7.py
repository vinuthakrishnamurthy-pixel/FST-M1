#User input list
numlist = input("Enter list items separated by spaces: ")
# Convert the input string to a list of integers
numlist = [int(x) for x in numlist.split()]
print(numlist)

# sum
total = sum(numlist)
print("Sum of Numbers is: " + str(total))