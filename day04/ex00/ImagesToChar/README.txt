# delete the directory
rm -rf target

# create target
mkdir target

# set dest directory for class files
javac src/java/edu/school21/printer/*/*.java -d ./target

# specify where to find user class files
java -classpath target edu.school21.printer.app.Program . 0 /Users/sslowpok/it.bmp