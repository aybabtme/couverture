# Couverture
Automagically improve the test coverage of your projects!

## Status
It's not quite complete.  The sample is not working.

## Usage
It's trivial!

```java
// Run this then look at the coverage report!
@Test
public void coverAllTheThings() {
  String packageName = MyPojoWithCoverage.class.getPackage().getName();
  try {
    Couverture couverture = new Couverture(packageName);
    couverture.bumpThatCoverage();
  } catch (VictimlessPackageException e) {
    // Oh noes!! That's not a package, or perhaps it's empty!
  }
}
```

And now, sit back and enjoy the improvement in code coverage!

##Sample
Look at the `sample` folder.  Use Ant to build the sample and generate the Cobertura reports.

```bash
ant ./sample/
```

## Development

```bash
mvn clean compile assembly:single     // to build the jar with its dependencies
```
