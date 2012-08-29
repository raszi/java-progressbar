# ProgressBar

This is a simple console progressbar for java. It can be used in CLI programs
to display progress for long tasks.

### Example output

```
[==================================--------------------------]  57.00% 393ms
```

## Usage

```java
ProgressBar progressBar = ConsoleProgressBar.on(System.out);
progressBar.tickOne();
// do something
progressBar.tick(25); // this will increase the percentage to 26
// do the rest
progerssBar.finish(); // this will finish it
```


## Advanced configuration

```java
ProgressBar progressBar = ConsoleProgressBar.on(System.out)
    .withFormat("[:bar] :percent% :elapsed/:total ETA: :eta")
    .withTotalSteps(500);
```

## Available replacers for format

 - `:bar` the progress bar
 - `:elapsed` the elapsed time since the `start()` or the first `tick()`
 - `:percent` the percentage without the percent sign
 - `:eta` the estimated time to accomplish
 - `:total` the total elapsed time

## TODOs

 - it not checks whether the progressbar has been finished, so don't call `finish()` more than once
