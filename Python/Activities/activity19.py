# Import pandas, ExcelFile and ExcelWriter
import pandas
from pandas import ExcelFile
from pandas import ExcelWriter

# Structure our data as a dictionary
data = {
  'FirstName': ["Satvik", "Avinash", "Lahri"],
  'LastName': ["Shah", "Kati", "Rath"],
  'Email': ["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
  'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

# Create a new DataFrame using the data
dataframe = pandas.DataFrame(data)
print(dataframe)

# Create an ExcelWriter object
writer = ExcelWriter("userlist.xlsx")

# Write the DataFrame to the Excel file
dataframe.to_excel(writer, sheet_name='Sheet1', index=False)

# Close the file
writer.close()