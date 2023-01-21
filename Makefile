run:
	mvn compile exec:java -Dexec.mainClass="com.ernestmicklei.SimonUI"

buildone:
	mvn clean compile assembly:single
	cp target/simon-java-ui-1.0-SNAPSHOT-jar-with-dependencies.jar target/simone.jar

one: buildone
	java -jar target/simon-java-ui-1.0-SNAPSHOT-jar-with-dependencies.jar