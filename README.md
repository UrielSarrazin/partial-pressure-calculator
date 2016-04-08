# Partial Pressure Calculator [![Build Status](https://travis-ci.org/urielsarrazin/partial-pressure-calculator.svg?branch=master)](https://travis-ci.org/urielsarrazin/partial-pressure-calculator)

This command-line application calculates partial pressures of the most popular breathing mixes used for diving:
* Air
* Nitrox 32/68
* Nitrox 36/64
* Nitrox 40/60
* Oxygen
* Trimix 20/25

These breathing mixes are composed of the following gases : O2, N2 and He.

This calculation is based on Dalton's Law of Partial Pressures that states:
* each gas in a mixture of gases exerts a pressure, known as its partial pressure, that is equal to the pressure the gas would exert if it were the only gas present
* the total pressure of the mixture is the sum of the partial pressures of all the gases present.

A mathematical expression of the Law of Partial Pressures is:

> Ptotal = P1 + P2 + P3 + · · ·

## Build and Run

### Using Maven and classic Command-line

This application uses Spring Shell. To build it, issue this command in the project's root directory :

```bash
mvn clean install
```

As it's built and packaged using the Maven AppAsembler plugin, to run the application, run the `partial-pressure-calculator` script (`partial-pressure-calculator.bat` on Windows), located in the `target/appassembler/bin/` repository.
Then, issue this sample command:

```bash
partial-pressure --breathingMix AIR
```
### Using Hotshell

Hotshell is a productivity enhancer command-line tool. Using this tool will simplify a lot the work load to build an run the application. For more details on this tools, please refer to [Hotshell web site](http://www.moumne.com/hotshell). This open-source is hosted [here](https://github.com/julienmoumne/hotshell) on GitHub. Installation is detailed in the project's documentation.

Placed at the project's root directory, there's the `hs.js` Hotshell's javascript file :

```javascript
item({desc: 'partial-pressure-calculator'}, function() {

    github = 'https://github.com/urielsarrazin/partial-pressure-calculator'
    linux = exec('uname').indexOf('Linux') > -1
    browser = linux ? 'sensible-browser' : 'open'

    item({key: 'b', desc: 'build', cmd: 'mvn clean install'})
    item({key: 'r', desc: 'run', cmd: './target/appassembler/bin/partial-pressure-calculator'})
    item({key: 'd', desc: 'documentation', cmd: browser + ' ' + github})
    item({key: 'f', desc: 'file bug report', cmd: browser + ' ' + github + '/issues/new'})
})
```
To use this file with Hotshell, issue the following command in the project's root directory :

```bash
hs
```
No parameters are needed as `hs.js` is the only one javascript file in the project's root directory.

The following content will appears on the console :

```bash
partial-pressure-calculator

b build mvn clean install
r run ./target/appassembler/bin/partial-pressure-calculator
d documentation sensible-browser https://github.com/srielsarrazin/partial-pressure-calculator
f file bug report sensible-browser https://github.com/urielsarrazin/partial-pressure-calculator/issues/new

spacebar back, tabulation bash, return repeat, backspace reload, ^d or ^c quit

? _
```
To build the application, stroke the `b` key, to run it stroke the `r` key, and so on...

## License

Partial Pressure Calculator is an Open Source software released under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).