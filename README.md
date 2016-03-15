# Partial Pressure Calculator

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

This application uses Spring Shell. To build it, use the Maven pom file :

> mvn clean install

As it's built and packaged using the Maven AppAsembler plugin, to run the application, run the `partial-pressure-calculator` script (`partial-pressure-calculator.bat` on Windows), located in the `target/appassembler/bin/` repository.
Then, run this sample command:

> partial-pressure --breathingMix AIR

## License

Partial Pressure Calculator is an Open Source software released under the [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).