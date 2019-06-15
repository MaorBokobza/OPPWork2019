# 211560586 
# bokobzm
compile: bin
	javac -cp biuoop-1.4.jar:src -d bin src/*.java 

run1:
	java -cp biuoop-1.4.jar:bin main
        
bin:
	mkdir bin