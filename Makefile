run:target
	java -cp target/aoc-2023-1.0-SNAPSHOT.jar com.alianza.aoc.app.App

target:clean
	mvn package

compile:
	mvn compile

clean:
	mvn clean

.PHONY: clean run compile
