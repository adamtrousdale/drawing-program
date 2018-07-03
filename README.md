blank
=====

Blank Scala project for quick&amp;easy setup. Just clone it and you are ready to go!

## Quick Start

```bash
> mkdir my-project
> cd my-project
> git clone git@github.com:adamtrousdale/scala-sbt-blank.git .
> sbt
```

```sbt
sbt> run
```

## Features
* [Scala](http://www.scala-lang.org) 2.12
* [ScalaTest](http://www.scalatest.org) 3.0.5
* .gitignore with the most common settings
  
  

## Prerequisities
* [SBT](http://www.scala-sbt.org) 1.1.6

## Documentation

### Installing SBT
* [Mac OS X](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html#mac)
  * Homebrew is recommended
* [Windows](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html#installing-sbt)
* [Linux - Gentoo](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html#gentoo)


### REPL
SBT contains a nice command `console` which allows firing up a REPL (Scala console) with the **project on classpath**.
That means that you can interactively try your code.

```
> sbt
sbt> console
scala> import com.czechscala.blank._
scala> Hello.sayHello
```
