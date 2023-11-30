target:clean
	mvn package

run:
	java -cp target/aoc-2023-1.0-SNAPSHOT.jar com.alianza.aoc.app.App

clean:
	mvn clean

.PHONY: clean run
