	
import pandas
dataframe = pandas.read_csv('usernames.csv')
print("Entire Table Data: ")
print(dataframe)

# Print the values only in the Usernames column
print("User Name List is: ")
print(dataframe["Usernames"])

# Print the username and password of the second row
print("User Name is: ")
print(dataframe["Usernames"] [1])
print("Password is: ")
print(dataframe["Passwords"] [1])

# Sort the Usernames column data in ascending order and print data
print("User Name List is: ")
print(dataframe.sort_values('Usernames'))

# Sort the Passwords column in descending order and print data
print("Password List is: ") 
print(dataframe.sort_values('Passwords', ascending=False))
