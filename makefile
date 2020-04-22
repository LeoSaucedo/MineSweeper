build:
	# Compile project.
	javac -d bin src/minesweeper/*.java
	# Create jar file.
	jar cfm MineSweeper.jar MANIFEST.MF res/* src/* bin/* LICENSE.md README.md
	
clean:
	# Remove class files and java package.
	rm -rf *.class *.jar