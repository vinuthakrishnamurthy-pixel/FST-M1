--Activity 4

-- New Column
ALTER TABLE salesman ADD grade int;

-- Set the value in the grade column for everyone to 100.
UPDATE salesman SET grade=100;

-- Use SELECT command to display the results.
SELECT * FROM salesman;

