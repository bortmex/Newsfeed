call mvn -B -DskipTests=true clean package
call java -DDATABASE_URL="postgres://user:password@localhost:5432/newsfeed" -jar target/dependency/webapp-runner.jar target/*.war