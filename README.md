# REST Simple project

## Requirements

- Java JDK 17
- Windows/Linux/MacOS

## Build

To build the REST server, just build the JAR with Maven:

```powershell
.\mvnw clean package
```

Make sure the JAVA_HOME environment variable is set correctly to the JDK 17 path. Then, this will build the application in the `/target` folder.

## Run

To run the server, use the command:

```powershell
java -jar "target/rest_example-0.0.1-SNAPSHOT.jar"
```

Then use a simple REST client to test the API on `localhost` with port `8080`.
