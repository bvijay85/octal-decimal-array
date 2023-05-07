# octal-decimal-array

This is simple java program/project to decode a octal string to a number in array of bytes. Each byte
element in the array represented in its decimal form. 

### Problem statement

Write a function to decode an octal string to a number in an array of bytes. Each byte
element in the array needs to be represented in its decimal form. For example,

Octal String `31646541` should produce `[103, 77, 97].`

The solution should work for long input. Try:
`2277114742311135167021343424004141432061264036716605455
35070012425145143366515462107042711115720106717127670062
71704657770433346073017047360217626325467150763006577133
54152655466766041402716542311111131505761476052650004524
21616177052165224543311447543654741617367042213645643631
33346575330621635642541636644326535501666004333326756424
47003252221104064117622317044717471111`


#### Pre-Setup
1) Install Java 11+ & Maven.

#### How to Run in local.

1. Download the source code in local folder.
2. Import a project into your favourite IDE. (Optional)
3. In terminal or command prompt, change to project directory.
4. Run a maven command as `mvn clean install`
5. The above command also runs the test cases available in a project. 
6. In case if you wish to run the test case individually, please open the test case and `Run As Test case` from IDE or you can run a via terminal as maven command `mvn test -Dtest=OctalToDecimalArrayTest`.
