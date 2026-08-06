import pandas
dataframe = pandas.read_excel("userlist.xlsx", sheet_name="Sheet1")
print(dataframe)

#Print the number of rows and columns
print("Number of rows and columns:", dataframe.shape)

#Print the data in the emails column only
print("Emails column data:")
print(dataframe['Email'])

#Sort the data based on FirstName in ascending order and print the data	
print("FirstName in ascending order:")
print(dataframe.sort_values('FirstName'))