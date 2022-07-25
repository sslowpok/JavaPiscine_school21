# delete the directory
rm -rf target

# create target
mkdir target

# set dest directory for class files
javac src/java/edu/school21/printer/*/*.java -d target

# specify where to find user class files
# java -classpath target edu.school21.printer.app.Program . 0 /Users/sslowpok/day04/ex01/ImagesToChar/src/resources/it.bmp

# cp resources
cp -R src/resources target/.

jar -cfm ./target/images-to-chars-printer.jar src/manifest.txt -C ./target .
chmod u+x target/images-to-chars-printer.jar

java -jar target/images-to-chars-printer.jar . 0 /Users/sslowpok/day04/ex01/ImagesToChar/src/resources/it.bmp