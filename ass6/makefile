# 211560586
# bokobzm

compile: bin
	find src -name "*.java" > sources.txt 
	javac -cp biuoop-1.4.jar:. -d bin @sources.txt
run:
	java -cp biuoop-1.4.jar:bin Ass6game
    
bin:
	mkdir bin
    
jar:
	jar -cfm ass6game.jar Manifest.txt -C bin .