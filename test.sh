set -e
javac Server.java DocSearchServer.java DocSearchTest.java -cp "lib/*"
java -ea -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore DocSearchTest
