# Exception Hierarchy Lab

A Java learning project exploring exception handling patterns.

## Concepts
- Custom checked exceptions per pipeline layer
- Exception chaining — preserving the full failure story
- try-with-resources — guaranteed resource cleanup
- Resource leak simulation (before/after)
- Fail fast, recover, and propagate strategies

## Running
Compile:
```bash
javac -d out src/exceptions/*.java src/pipeline/*.java src/Main.java
```
Run:
```bash
java -cp out Main
```
